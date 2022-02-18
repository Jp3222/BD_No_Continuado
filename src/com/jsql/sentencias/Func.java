package com.jsql.sentencias;

/**
 *
 * @author jp
 */
public class Func {

    public static String getDatos(String... values) {
        String v = "";
        for (String value : values) {
            v += "'" + value + "',";
        }
        v = v.substring(0, v.length() - 1);
        return v;
    }

    public static String getColumas(String... colums) {
        String v = "";
        for (String value : colums) {
            v += "" + value + ",";
        }
        v = v.substring(0, v.length() - 1);
        return v;
    }

    public static String getCampos_Datos(String[] campos, String[] datos) {
        if (campos.length != datos.length) {
            return null;
        }
        String sent = "";
        for (int i = 0; i < campos.length; i++) {
            sent += campos[i] + " = " + "'" + datos[i] + "',";
        }
        return sent.substring(0, sent.length() - 1);
    }
}
