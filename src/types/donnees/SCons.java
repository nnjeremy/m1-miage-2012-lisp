package types.donnees;

import types.donnees.Reader;
import types.donnees.SCons;
import types.fonctions.subr.*;
import exceptions.*;

public class SCons implements Liste {

    private SExpr car;
    private SExpr cdr;

    public SCons(SExpr car, SExpr cdr) {
        this.car = car;
        this.cdr = cdr;
    }

    public SCons(SExpr elem) {
        car = elem;
        cdr = Nil.NIL;
    }

    public SExpr car() {
        return car;
    }

    public SExpr cdr() {
        return cdr;
    }

    public void setCdr(SExpr next) {
        cdr = next;
    }

    public String toString() {
        if (cdr() instanceof Symbole) {
            return car.toString() + " " + cdr.toString();
        } else if (cdr() instanceof Nil) {
            return car.toString();
        } else {
            return "(" + car.toString() + " " + cdr.toString() + ")";
        }
    }

    @Override
    public String eval() {
        // TODO Auto-generated method stub
        Car fcar = new Car();
        Cdr fcdr = new Cdr();
        Atom fatom = new Atom();
        Explode fexplode = new Explode();
        Scope fscope = new Scope();
        Set fset = new Set();
        Cons fcons = new Cons();
        Eq feq = new Eq();
        Implode fimplode = new Implode();
        Quit fquit = new Quit();
        try {
            if (car().toString().equalsIgnoreCase("car")) {
                return fcar.car(Reader.read(cdr.toString())).toString();
            }
            if (car().toString().equalsIgnoreCase("cdr")) {
                return fcdr.cdr(Reader.read(cdr.toString())).toString();
            }
            if (car().toString().equalsIgnoreCase("atom")) {
                return fatom.atom(Reader.read(cdr.toString())).toString();
            }
            if (car().toString().equalsIgnoreCase("explode")) {
                return fexplode.explode((Symbole)Reader.read(cdr.toString())).toString();
            }
            if (car().toString().equalsIgnoreCase("scope")) {
                return fscope.scope();
            }
            if (car().toString().equalsIgnoreCase("set")) {
                return fset.set(Reader.read(((SCons)((SCons)cdr).car()).car().toString()), Reader.read(((SCons)((SCons)cdr).car()).cdr().toString())).toString();
            }
            if (car().toString().equalsIgnoreCase("implode")) {
                return fimplode.implode(Reader.read(cdr.toString())).toString();
            }
            if (car().toString().equalsIgnoreCase("cons") && cdr instanceof SCons && ((SCons)cdr).cdr instanceof SCons) {
                return fcons.cons(Reader.read(((SCons)cdr).car.toString()), Reader.read(((SCons)((SCons)cdr).cdr).car.toString())).toString();
            }
            if (car().toString().equalsIgnoreCase("eq") && cdr instanceof SCons && ((SCons)cdr).cdr instanceof SCons) {
                return feq.eq(Reader.read(((SCons)cdr).car.toString()), Reader.read(((SCons)((SCons)cdr).cdr).car.toString())).toString();
            }
            if (car().toString().equalsIgnoreCase("quit")){
                fquit.quit();
            }
        } catch (CdrAtomeException e) {
            e.printStackTrace();
        } catch (CarAtomeException e) {
            e.printStackTrace();
        } catch (LispException e) {
            e.printStackTrace();
        }
        return toString();
    }
}
