package com.jsql.conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

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
            lista.add(elems.clone());
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
            lista.add(elems.clone());
        }
        return lista;
    }

    public String[][] Tabla(ResultSet rs, int col) throws SQLException {
        ArrayList<String[]> lista = Tabla_String(rs, col);
        String matriz[][] = new String[lista.size()][col];
        for (int i = 0; i < lista.size(); i++) {
            matriz[i] = lista.remove(i);
        }
        return matriz;
    }

    public String[][] Tabla(ResultSet rs, String[] col) throws SQLException {
        ArrayList<String[]> lista = Tabla_String(rs, col);
        String matriz[][] = new String[lista.size()][col.length];
        for (int i = 0; i < lista.size(); i++) {
            matriz[i] = lista.remove(i);
        }
        return matriz;
    }

    public DefaultTableModel getModelo(ResultSet rs, String[] col) throws SQLException {
        ArrayList<String[]> lista = Tabla_String(rs, col);
        DefaultTableModel tb = new DefaultTableModel();
        for (String string : col) {
            tb.addColumn(string);
        }
        for (String[] strings : lista) {
            tb.addRow(strings);
        }
        return tb;
    }

}
