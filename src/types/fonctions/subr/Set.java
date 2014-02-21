package types.fonctions.subr;

import contexte.Contexte;
import types.donnees.SExpr;
public class Set extends Subr {

    public SExpr set(SExpr nomvar, SExpr val){
        Contexte.CONTEXTE.ajouter(nomvar, val);
        
        return val;
    }
    @Override
    public String eval() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
