package com.jsql.sentencias;

/**
 *
 * @author HP
 * @param <T>
 */
public abstract class sentencia<T> {

    protected String sentencia(T[] conjunto) {
        String sen = "";
        for (T items : conjunto) {
            sen += "'" + items + "' ,";
        }
        sen = sen.substring(0, sen.length() - 1);
        return sen;
    }

}
