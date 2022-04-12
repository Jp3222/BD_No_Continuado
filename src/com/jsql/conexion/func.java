package com.jsql.conexion;

import java.util.ArrayList;

/**
 *
 * @author jp
 */
public class func {

    public static <T> boolean in(T[] array, T elem) {
        for (T t : array) {
            if (t.equals(elem)) {
                return true;
            }
        }
        return false;
    }

    public static <T> ArrayList<T> exp(T[] array, int... exp) {
        ArrayList<T> lista = new ArrayList<>();
        for (int i : exp) {
            if (!in(array, array[i])) {
                lista.add(array[i]);
            }
        }
        return lista;
    }

}
