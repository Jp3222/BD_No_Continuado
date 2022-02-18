package com.jsql.sentencias;

import java.util.logging.Logger;

public class SQL implements Commandos_Basicos {

    private static final Logger LOG = Logger.getLogger(SQL.class.getName());

    @Override
    public String INSERT(String Tabla, String Campos, String Values) {
        return "insert into " + Tabla + " (" + Campos + ")" + " Values (" + Values + ")";
    }

    @Override
    public String INSERT(String Tabla, String Values) {
        return "insert into " + Tabla + " Values (" + Values + ")";
    }

    @Override
    public String UPDATE(String Tabla, String data, String where) {
        return "update " + Tabla + " set " + data + " where " + where;
    }

    @Override
    public String UPDATE(String Tabla, String campo, String dato, String where) {
        return "update " + Tabla + " set " + campo + " = " + "'" + dato + "'" + " where " + where;
    }

    @Override
    public String DELETE(String Tabla, String where) {
        return "delete from " + Tabla + " where " + where;
    }

    @Override
    public String SELECT(String Tabla) {
        return "select * from " + Tabla;
    }

    @Override
    public String SELECT(String Tabla, String Campos) {
        return "select " + Campos + " from " + Tabla;
    }

    @Override
    public String SELECT(String Tabla, String Campos, String Where) {
        return "select " + Campos + " from " + Tabla + " Where " + Where;
    }

    @Override
    public String QUERY(String query) {
        return query;
    }

    @Override
    public String SENTENCIA(String sentencia) {
        return sentencia;
    }

}
