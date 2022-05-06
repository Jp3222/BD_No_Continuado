package com.jsql.conexion;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PreQuerys {

    private final ArrayList<PreparedStatement> lista;
    private Connection cn;

    public PreQuerys() {
        this.lista = new ArrayList<>(0);
    }

    public boolean addQuery(String query) throws SQLException {
        PreparedStatement ps = cn.prepareStatement(query);
        return lista.add(ps);
    }

    public void setString(int noQuery, int noParametro, String parametro) throws SQLException {
        lista.get(noQuery).setString(noParametro, parametro);
    }

    public ResultSet executeQuery(int index) throws SQLException {
        return lista.get(index).executeQuery();
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

}
