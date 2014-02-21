package types.fonctions.subr;

import types.donnees.*;

public class Cons extends Subr {
        
        public SExpr cons(SExpr s1, SExpr s2) {
                
                if(s2 instanceof Nil)
                        return new SCons(s1);
                else
                        return new SCons(s1, new SCons(s2));
        }

		@Override
		public String eval() {
			// TODO Auto-generated method stub
			return null;
		}

}