package exceptions;

public class LispException extends Exception {

    private String message = "Erreur syntaxique";

    public LispException() {
    }

    public void printStackTrace() {
        System.out.println(this.message);
    }
}
