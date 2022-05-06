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
        try {
            cn = DriverManager.getConnection(url, user, pass);
            this.Conexion = true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            this.Conexion = false;
        }
    }

    protected BD(String url) {
        this.user = null;
        this.pass = null;
        this.url = url;
        try {
            cn = DriverManager.getConnection(url);
            this.Conexion = true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            this.Conexion = false;
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
