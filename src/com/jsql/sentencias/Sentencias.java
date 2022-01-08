package com.jsql.sentencias;

import java.util.logging.Logger;

public class Sentencias {

    private static final Logger LOG = Logger.getLogger(Sentencias.class.getName());

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

    public String SELECT(String Tabla, String Campo, String Where) {
        return "select " + Campo + " from " + Tabla + " Where " + Where;
    }

    public String SELECT(String Tabla, String Campo) {
        return "select " + Campo + " from " + Tabla;
    }

    public String UPDATE(String Tabla, String data, String where) {
        return "update " + Tabla + " set " + data + " where " + where;
    }

    public String UPDATE(String Tabla, String campo, String dato, String where) {
        return "update " + Tabla + " set " + campo + " = " + "'" + dato + "'" + " where " + where;
    }

    public String DELETE(String Tabla, String where) {
        return "delete from " + Tabla + " where " + where;
    }

    public String INSERT(String Tabla, String Campos, String Values) {
        return "insert into " + Tabla + " (" + Campos + ")" + " Values (" + Values + ")";
    }

    public String INSERT(String Tabla, String Values) {
        return "insert into " + Tabla + " Values (" + Values + ")";
    }

}
