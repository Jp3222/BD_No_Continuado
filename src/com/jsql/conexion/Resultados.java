package com.jsql.conexion;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Resultados {

    private PreparedStatement[] lista;

    public void add(Connection cn, String[] consultas_Preparadas) throws SQLException {
        lista = new PreparedStatement[consultas_Preparadas.length];
        for (int i = 0; i < lista.length; i++) {
            lista[i] = cn.prepareStatement(consultas_Preparadas[i]);
        }
    }
}
