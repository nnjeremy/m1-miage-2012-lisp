package types.donnees;

public class Symbole extends Atome {
	
	private String symbole;
	
	public Symbole(String symbole){
		this.symbole=symbole;
	}
	
	public String symbole(){
		return this.symbole;
	}

	@Override
	public String toString() {
		return symbole;
	}

	@Override
	public String eval() {
		return toString();
	}


}
