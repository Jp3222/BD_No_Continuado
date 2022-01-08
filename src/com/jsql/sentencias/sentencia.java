package com.jsql.sentencias;

/**
 *
 * @author HP
 */
public abstract class sentencia<T> {

    protected String sentencia(T[] conjunto) {
        String sen = "";
        for (T items : conjunto) {
            sen += "'" + items + "' ,";
        }
        return sen;
    }

}
