package com.jsql.database;

import java.util.ArrayList;
import com.jsql.conexion.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class DB extends Conexion {

    private ArrayList<String> columnas;

    public DB(String user, String pass, String url) {
        super(user, pass, url);
        conectar();
    }

    public TB getTabla(String Table) throws NullPointerException{
        try {
            String columnas[] = null;
            select(Table, Table);
            return TB.getInstancia(Table, columnas);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
