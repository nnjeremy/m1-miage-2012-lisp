package contexte;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import types.donnees.*;

public class Contexte {

    public static final Contexte CONTEXTE = new Contexte();
    
    private HashMap<String, SExpr> contexte;
    private Stack<Couple> pile;

    private Contexte() {
        contexte = new HashMap<String, SExpr>();
        pile = new Stack<Couple>();
    }

    /**
     * Parcours la SExpr variables et ajoute une variable dans le contexte a chaque Symbole rencontré
     * 
     * @param variables
     * @param valeurs 
     */
    public void ajouter(SExpr variables, SExpr valeurs) {
        if (variables instanceof Symbole) {
            ajouter((Symbole) variables, valeurs);
        } else {
            while (variables != Nil.NIL) {
                //appel recursif avec les car()
                ajouter(((SCons) variables).car(), ((SCons) valeurs).car());
                //cas des paires pointées
                if (((SCons) variables).cdr() instanceof Symbole) {
                    ajouter(((SCons) variables).cdr(), ((SCons) valeurs).cdr());
                }
                //on passe au suivant dans les 2 arbres
                variables = ((SCons) variables).cdr();
                valeurs = ((SCons) valeurs).cdr();
            }
        }
    }

    /**
     * ajoute une association variable/valeur au contexte.
     * Si la variable existe deja, on stock l'association dans la pile
     * 
     * @param variable
     * @param valeur 
     */
    public void ajouter(Symbole variable, SExpr valeur) {
        if (contexte.containsKey(variable.toString())) {
            Couple cp = new Couple(variable, contexte.get(variable));
            pile.push(cp);
        }
        contexte.put(variable.symbole(), valeur);
    }

    /**
     * Supprime la variable du contexte.
     * Si cette variable avait été savegardé on restitue sa valeur d'origine.
     * 
     * @param nomVariable 
     */
    public void supprimer(Symbole nomVariable) {
        if (nomVariable.equals(pile.peek().getVariable())) {
            Couple var = pile.pop();
            contexte.put(var.getVariable().symbole(), var.getValeur());
        } else {
            contexte.remove(nomVariable);
        }
    }

    /**
     * Renvoi la valeur associée ou null si il n'y a pas de correspondance
     * 
     * @param nomVariable
     * @return La valeur associée a la variable nomVariable ou null
     */
    public SExpr acceder(Symbole nomVariable) {
        return contexte.get(nomVariable);
    }

    /**
     * Permet de reinitialiser le contexte, la table et la pile sont vidées
     */
    public void clear() {
        contexte.clear();
        pile.clear();
    }
    
    public String print(){
        String strcont = "Contexte:\n";
        for(Map.Entry entry: contexte.entrySet()){
            strcont += entry.getKey().toString()+" => "+entry.getValue().toString()+"\n";
        }
        return strcont;
    }
}
