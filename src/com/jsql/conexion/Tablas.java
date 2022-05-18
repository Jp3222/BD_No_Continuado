package com.jsql.conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Tablas {

    /**
     *
     * @param rs
     * @param columas
     * @return
     */
    public static ArrayList<Object[]> getListaObjects(ResultSet rs, int columas) {
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

    /**
     * 
     * @param rs
     * @param colms
     * @return
     */
    public static ArrayList<String[]> getListaString(ResultSet rs, int colms) {
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
    /**
     * 
     * @param rs
     * @param colms
     * @return 
     */
    public static ArrayList<String[]> getListaString(ResultSet rs, String[] colms) {
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
    
    /**
     * 
     * @param rs
     * @param col
     * @return 
     */
    public static String[][] getArregloString(ResultSet rs, int col) {
        ArrayList<String[]> lista = getListaString(rs, col);
        String[][] matriz = new String[lista.size()][col];
        int i = 0;
        for (String[] strings : lista) {
            matriz[i] = strings;
            i++;
        }
        return matriz;
    }

    public static String[][] getArregloString(ResultSet rs, String[] col) {
        ArrayList<String[]> lista = Tablas.getListaString(rs, col);
        String[][] matriz = new String[lista.size()][col.length];
        int i = 0;
        for (String[] strings : lista) {
            matriz[i] = strings;
            i++;
        }
        return matriz;
    }
    
    /**
     * 
     * @param rs
     * @param columas
     * @return 
     */
    public static Object[][] getArrayObjects(ResultSet rs, int columas) {
        ArrayList<Object[]> lista = getListaObjects(rs, columas);
        try {
            if (!lista.isEmpty()) {
                Object[][] matriz = new Object[lista.size()][columas];
                for (int i = 0; i < matriz.length; i++) {
                    Object[] elems = new Object[columas];
                    for (int j = 0; j < columas; j++) {
                        elems[j] = rs.getObject(j + 1);
                    }
                    matriz[i] = elems;
                }
                lista = null;
                return matriz;

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
