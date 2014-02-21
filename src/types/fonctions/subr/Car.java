package types.fonctions.subr;

import exceptions.CarAtomeException;
import exceptions.LispException;
import types.donnees.*;

public class Car extends Subr {

    /**
     * 
     * @param sexpr l'expression a evaluer
     * @return premier element de sexpr
     * @throws CarAtomeException 
     * @require sexpr != null
     */
    public SExpr car(SExpr sexpr)throws CarAtomeException{
        try{
        sexpr = Reader.read(sexpr.eval());
        }catch(LispException l){
            l.printStackTrace();
        }
        if (sexpr instanceof SCons)
            return ((SCons)sexpr).car();
        else if(sexpr instanceof Nil)
            return sexpr;//?
        else
            throw new CarAtomeException();
        
    }

	@Override
	public String eval() {
		// TODO Auto-generated method stub
		return null;
	}
}