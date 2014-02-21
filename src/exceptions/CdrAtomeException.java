
package exceptions;

/**
 *
 * @author Home
 */
public class CdrAtomeException extends Exception {

    private String msg;

    public CdrAtomeException() {
        this.msg = "Le paramètre fournit est un atome";
    }

    public void printStackTrace() {
        System.out.println(this.msg);
    }
}
