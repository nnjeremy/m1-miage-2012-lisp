package types.fonctions.subr;

import types.donnees.*;

public class Eq extends Subr {

        public SExpr eq(SExpr s1, SExpr s2){
                if (s1 instanceof SCons && s2 instanceof SCons){
                        if (s1 == s2){
                                return new Symbole("t");
                        }
                }
                else if (s1 instanceof Atome && s2 instanceof Atome){
                        if ((((Symbole)s1).symbole()).equals(((Symbole)s2).symbole())){
                                return new Symbole("t");
                        }
                }
                return Nil.NIL;
        }

		@Override
		public String eval() {
			// TODO Auto-generated method stub
			return null;
		}
        
}