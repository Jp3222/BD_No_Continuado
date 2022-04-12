package com.jsql.database;

import java.util.ArrayList;
import com.jsql.conexion.Conexion;

/**
 *
 * @author HP
 */
public class DB extends Conexion {

    private ArrayList<TB> Tablas;

    public DB(String user, String pass, String url) {
        super(user, pass, url);
    }

}
