package types.fonctions.subr;

import types.donnees.*;
import exceptions.CdrAtomeException;
import exceptions.LispException;

public class Cdr extends Subr {

    public SExpr cdr(SExpr s) throws CdrAtomeException {
        try {
            s = Reader.read(s.eval());
        }
        catch(LispException l){
            l.printStackTrace();
        }
        if (s instanceof Nil) {
            return Nil.NIL;
        } else if (s instanceof SCons) {
            return ((SCons) s).cdr();
        } else {
            throw new CdrAtomeException();
        }

    }

    @Override
    public String eval() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
