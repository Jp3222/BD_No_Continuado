package com.jsql.database;

import java.util.ArrayList;
import com.jsql.conexion.Conexion;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public  class DB extends Conexion {

    private ArrayList<String> columnas;

    public DB(String user, String pass, String url) {
        super(user, pass, url);
        super.conectar();
    }
    
}
