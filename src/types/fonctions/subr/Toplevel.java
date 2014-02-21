package types.fonctions.subr;

import types.donnees.Reader;
import ProgPrinc.Console;
import exceptions.LispException;

public class Toplevel extends Subr {

    @Override
    public String eval() {
        // TODO Auto-generated method stub
        return null;
    }

    public void toplevel() throws LispException {
        // TODO Auto-generated method stub
        while (true) {
            Console.print(">");
            try {
                Console.println(Reader.read().eval());
            } catch (LispException e) {
                Console.println(e.getMessage());
            } catch (Exception e) {
                Console.println("unexpectedException");
                e.printStackTrace();
            } finally {
            }
        }
    }
    
}
