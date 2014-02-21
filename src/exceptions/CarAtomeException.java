
package exceptions;

/**
 *
 * @author Home
 */
public class CarAtomeException extends Exception {

    private String msg;

    public CarAtomeException() {
        this.msg = "Le paramètre fournit est un atome";
    }

    public void printStackTrace() {
        System.out.println(this.msg);
    }
}
