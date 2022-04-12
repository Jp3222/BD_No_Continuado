package com.jsql.conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Tablas {

    public static ArrayList<Object[]> Result_Objects(ResultSet rs, int columas) {
        ArrayList<Object[]> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                String[] elems = new String[columas];
                for (int i = 0; i < columas; i++) {
                    elems[i] = rs.getString(i + 1);
                }
                lista.add(elems);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    public static ArrayList<String[]> Result(ResultSet rs, int colms) {
        ArrayList<String[]> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                String[] elems = new String[colms];
                for (int i = 0; i < colms; i++) {
                    elems[i] = rs.getString(i + 1);
                }
                lista.add(elems);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    public static ArrayList<String[]> Result(ResultSet rs, String[] colms) {
        ArrayList<String[]> lista = new ArrayList<>();
        try {
            int i;
            while (rs.next()) {
                String[] elems = new String[colms.length];
                i = 0;
                for (String col : colms) {
                    elems[i] = rs.getString(col);
                    i++;
                }
                lista.add(elems);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    public static String[][] ResultArray(ResultSet rs, int col) {
        ArrayList<String[]> lista = Result(rs, col);
        String[][] matriz = new String[lista.size()][col];
        int i = 0;
        for (String[] strings : lista) {
            matriz[i] = strings;
            i++;
        }
        return matriz;
    }

    public static String[][] ResultArray(ResultSet rs, String[] col) {
        ArrayList<String[]> lista = Result(rs, col);
        String[][] matriz = new String[lista.size()][col.length];
        int i = 0;
        for (String[] strings : lista) {
            matriz[i] = strings;
            i++;
        }
        return matriz;
    }
}
