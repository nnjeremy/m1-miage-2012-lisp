package types.fonctions.subr;

import exceptions.LispException;
import types.donnees.*;

public class Atom extends Subr {

    /**
     * 
     * @param sexpr l'expression a evaluer
     * @return
     * @require sexpr != null
     */
    public Atome atom(SExpr sexpr){
        try{
        sexpr = Reader.read(sexpr.eval());
        }catch(LispException l){
            l.printStackTrace();
        }
        if (sexpr instanceof Atome)
            return new Symbole("t");
        else return Nil.NIL;
    }

	@Override
	public String eval() {
		// TODO Auto-generated method stub
		return null;
	}
}