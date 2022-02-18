package com.jsql.database;

import java.util.ArrayList;
import com.jsql.conexion.Conexion;
import java.lang.reflect.Array;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class DB extends Conexion {

    private ArrayList<TB> Tablas;

    public DB(String user, String pass, String url) {
        super(user, pass, url);
        super.conectar();
    }

}
