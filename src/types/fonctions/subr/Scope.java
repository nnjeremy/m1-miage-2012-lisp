package types.fonctions.subr;

import contexte.Contexte;

public class Scope extends Subr {

    public String scope() {
        return Contexte.CONTEXTE.print();
    }

    @Override
    public String eval() {
        // TODO Auto-generated method stub
        return null;
    }
}
