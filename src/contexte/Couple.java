/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contexte;

import types.donnees.*;

/**
 *
 * @author Home
 */
public class Couple {
    
    private Symbole variable;
    private SExpr valeur;
    
    public Couple(Symbole var, SExpr val){
        this.variable = var;
        this.valeur = val;
    }

    public SExpr getValeur() {
        return valeur;
    }

    public Symbole getVariable() {
        return variable;
    }
    
    
}
