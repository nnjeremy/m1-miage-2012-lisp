package types.fonctions.subr;

import types.donnees.*;

public class Implode extends Subr {

    public Atome implode(SExpr s) {
        String str = "";
        str = ch(str, s);
        return new Symbole(str);
    }

    private String ch(String str, SExpr s) {

        if (s instanceof Symbole) {
            str = str.concat(((Symbole) s).symbole());
        } else {
            while (s != Nil.NIL) {
                str = ch(str, ((SCons) s).car());
                if (((SCons) s).cdr() instanceof Symbole) {
                    str = str.concat(ch(str, ((SCons) s).car()));
                }
                s = ((SCons) s).cdr();
            }
        }
        //System.out.println(str);
        return str;

    }

    @Override
    public String eval() {
        // TODO Auto-generated method stub
        return null;
    }
}
