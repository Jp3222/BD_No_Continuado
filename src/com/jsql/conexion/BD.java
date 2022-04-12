package com.jsql.conexion;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Juan Pablo
 * @version 0.1 Esta clase esta dedicada a la conexion de la base de datos
 */
abstract class BD {

    /**
     * user: pass: url:
     */
    protected final String user, pass, url;
    protected Connection cn;
    protected boolean Conexion;

    /**
     * @param user
     * @param pass
     * @param url
     */
    protected BD(String user, String pass, String url) {
        this.user = user;
        this.pass = pass;
        this.url = url;
    }

    /**
     */
    public void conectar() {
        try {
            cn = DriverManager.getConnection(url, user, pass);
            Conexion = true;
            init();
        } catch (SQLException ex) {
            Conexion = false;
            System.out.println(ex.getMessage());
        }
    }

    public void init() {

    }

    /**
     */
    public void desconectar() {
        try {
            cn.close();
            Conexion = false;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     */
    public boolean isConexion() {
        return Conexion;
    }

    /**
     */
    public Connection getCn() {
        return cn;
    }

    @Override
    public String toString() {
        return "conexion{\nuser: " + user
                + "\npassword: " + pass
                + "\nurl: " + url
                + "\n}";
    }

}
