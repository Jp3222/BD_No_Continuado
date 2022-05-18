package com.jsql.sql;

/**
 *
 * @author jp
 */
public class SQL extends Sentencias implements SentenciasBasicas {

    @Override
    public String INSERT(String tabla, String datos) {
        return "insert into " + tabla + " values (" + datos + ")";
    }

    @Override
    public String INSERT(String tabla, String campos, String datos) {
        return "insert into " + tabla + " (" + campos + ") values (" + datos + ")";
    }

    @Override
    public String INSERT(String tabla, String campos, String datos, String where) {
        return "insert into " + tabla + " (" + campos + ") values (" + datos + ") where " + where;
    }

    @Override
    public String UPDATE(String tabla, String campos_datos, String where) {
        return "update " + tabla + " set " + campos_datos + " where " + where;
    }

    @Override
    public String UPDATE(String tabla, String campos, String datos, String where) {
        return "update " + tabla + " set " + campos + " = '" + datos + "' where " + where;
    }

    
    public String UPDATENUMBERS(String tabla, String campos, String datos, String where) {
        return "update " + tabla + " set " + campos + " = " + datos + " where " + where;
    }

    @Override
    public String DELETE(String tablas, String where) {
        return "delete from " + tablas + " where " + where;
    }

    @Override
    public String SELECT(String tabla) {
        return "select * from " + tabla;
    }

    @Override
    public String SELECT(String tabla, String campos) {
        return "select " + campos + " from " + tabla;
    }

    @Override
    public String SELECT(String tabla, String campos, String where) {
        return "select " + campos + " from " + tabla + " where " + where;
    }

}
