package types.fonctions.subr;

import types.donnees.*;

public class Explode extends Subr {

    public SExpr explode(Symbole sym){
        String str = sym.symbole().replace("|", "");
        SExpr exploded = new SCons(new Symbole(String.valueOf(str.charAt(0))));
        SCons lastCell = (SCons)exploded;
        for (int i=1; i < str.length(); i++){
            lastCell.setCdr(new SCons(new Symbole(String.valueOf(str.charAt(i)))));
            lastCell = (SCons)lastCell.cdr();
        }
        
        return exploded;
    }

	@Override
	public String eval() {
		// TODO Auto-generated method stub
		return null;
	}
}