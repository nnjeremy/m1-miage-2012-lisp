package types.donnees;

public class Nil extends Atome implements Liste {
	
    public static final Nil NIL	 = new Nil();
        
	private Nil(){};
        
	@Override
	public String toString() {
		return "()";
	}
        
	@Override
	public String eval() {
		return toString();
	}

}
