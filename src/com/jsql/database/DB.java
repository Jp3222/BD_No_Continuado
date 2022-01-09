package com.jsql.database;

import java.util.ArrayList;
import com.jsql.conexion.Conexion;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class DB extends Conexion {

    private ArrayList<String> columnas;

    public DB(String user, String pass, String url) {
        super(user, pass, url);
        Conectar();
    }

    public void Conectar() {
        this.conectar();
    }

    public TB getTabla(String Table) throws NullPointerException {
        try {
            String col[] = null;
            select(Table, Table);
            return TB.getInstancia(Table, col);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
