package com.jsql.conexion;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class Pre_Querys {

    private final ArrayList<PreparedStatement> lista;
    private final Connection cn;

    public Pre_Querys(Connection cn) {
        this.lista = new ArrayList<>(0);
        this.cn = cn;
    }

    public boolean add_PreQuery(String query) throws SQLException {
        PreparedStatement ps = cn.prepareStatement(query);
        return lista.add(ps);
    }

    public void setString(int indexQuery, int indexP, String param) throws SQLException {
        lista.get(indexP).setString(indexP, param);
    }

    public ResultSet executeQuery(int index) throws SQLException {
        return lista.get(index).executeQuery();
    }

}
