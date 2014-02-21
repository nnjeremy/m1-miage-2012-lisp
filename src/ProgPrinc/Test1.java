package ProgPrinc;

import exceptions.LispException;
import types.donnees.*;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*//Test Implode
		Implode testImplode = new Implode();
		Atome a = testImplode.implode("a b c");
		System.out.println(a);
		
		//Test cdr
		Cdr testCdr = new Cdr();
		SExpr s = testCdr.cdr(new SCons());
		System.out.println(s);*/
		
		try {
			Reader.read();
		} catch (LispException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
