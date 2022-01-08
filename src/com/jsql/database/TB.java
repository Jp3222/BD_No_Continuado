package com.jsql.database;

import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public abstract class TB {

    static Instancia getInstancia(String Table, String[] Columnas) {
        Instancia obj = new Instancia(Table, Columnas);
        return obj;
    }

    private String Table;
    private String[] Columnas;

    public TB(String Table, String[] Columnas) {
        this.Table = Table;
        this.Columnas = Columnas;
    }

    public String getTable() {
        return Table;
    }

    public void setTable(String Table) {
        this.Table = Table;
    }

    public String[] getColumnas() {
        return Columnas;
    }

    public void setColumnas(String[] Columnas) {
        this.Columnas = Columnas;
    }

}

class Instancia extends TB {

    private static final Logger LOG = Logger.getLogger(Instancia.class.getName());

    public static Instancia getNodo(String Table, String[] Columnas) {
        return new Instancia(Table, Columnas);
    }

    Instancia(String Table, String[] Columnas) {
        super(Table, Columnas);
    }

}
