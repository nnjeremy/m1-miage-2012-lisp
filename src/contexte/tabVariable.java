package contexte;
import java.util.HashMap;
import types.donnees.*;

public class tabVariable{
	
	private static HashMap<Symbole, SExpr> tabVariable = new HashMap<Symbole, SExpr>();

	public static void ajouter(Symbole nomVariable, SExpr val){
		tabVariable.put(nomVariable, val);
	}
	
	public static void supprimer(Symbole nomVariable){
		tabVariable.remove(nomVariable);
	}
	
	public static SExpr acceder(Symbole nomVariable){
		return tabVariable.get(nomVariable);
	}
}
