package ProgPrinc;

import exceptions.LispException;

public class Lisp {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            new LVM();
        } catch (LispException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
