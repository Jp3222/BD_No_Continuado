package com.jsql.conexion;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Juan Pablo
 * @version 0.1 Esta clase esta dedicada a la conexion de la base de datos
 */
abstract class BD {

    protected final String user, pass, url;
    protected Connection cn;
    protected boolean Conexion;

    /**
     * @param user usuario de la base de datos
     * @param pass contraseña del usuario
     * @param url direccion de alojamiento de la base de datos
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

    /**
     *Constructo
     * @param url
     */
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
     * Metodo encargado de cerrar la conexion y cambiar el estado de "conectado"
     * a "desconectado"
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
     * @return "true" si la conexion es establecida y "false" si la conexion no
     * se establecio
     */
    public boolean isConexion() {
        return Conexion;
    }

    /**
     * @return un objeto de tipo Connection instanciado el cual se encarga de
     * establecer la conexion a la base de datos
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
