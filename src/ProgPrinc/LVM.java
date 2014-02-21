package ProgPrinc;

import jus.util.*;
import java.io.*;

import exceptions.LispException;
import types.fonctions.subr.Toplevel;

public class LVM implements Serializable {

    public LVM() throws LispException {
        /*		try {
        Console.println(Resources.getBundle("LispEnter"));
        XmlHandler.read("/Lisp.xml");
        } catch (LispException e) {
        Console.println("toplevel:");
        Console.printStack(e);
        }*/
        Console.println("Bienvenue dans notre interpreteur LISP");
        new Toplevel().toplevel();
    }

    /**
     * arrêt de la machine lisp
     */
    public static void quit() {
        Console.println("Merci");
        //Console.println(Resources.getBundle("LispExit"));
        System.exit(0);
    }
}
