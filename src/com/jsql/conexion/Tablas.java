/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsql.conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Tablas {

    public ArrayList<String[]> Tabla_String(ResultSet rs, int columnas) throws SQLException {
        ArrayList<String[]> lista = new ArrayList<>(0);
        String[] elems = new String[columnas];
        while (rs.next()) {
            for (int j = 0; j < columnas; j++) {
                elems[j] = rs.getString(j);
            }
            lista.add(elems);
        }
        return lista;
    }

    public ArrayList<String[]> Tabla_String(ResultSet rs, String[] columnas) throws SQLException {
        ArrayList<String[]> lista = new ArrayList<>(0);
        String[] elems = new String[columnas.length];
        int i;
        while (rs.next()) {
            i = 0;
            for (String columna : columnas) {
                elems[i] = rs.getString(columna);
                i++;
            }
            lista.add(elems);
        }
        return lista;
    }

}
