package com.jsql.conexion;

import com.jsql.sentencias.SQL;
import com.jsql.sentencias.Func;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class Conexion extends BD {

    private static Conexion Instancia;

    public static Conexion getInstancia(String user, String pass, String url) {
        if (Instancia == null) {
            Instancia = new Conexion(user, pass, url);
        }
        return Instancia;
    }

    public static Conexion getInstancia() {
        return Instancia;
    }

    public static String getLOCAL_URL(String port, String db) {
        return "jdbc:mysql://localhost:" + port + "/" + db;
    }

    private final Pre_Querys query;
    private final SQL sentecias;
    private Statement st;

    protected Conexion(String user, String pass, String url) {
        super(user, pass, url);
        this.query = new Pre_Querys(cn);
        sentecias = new SQL();
    }

    public boolean insert(String tabla, String datos) throws SQLException {
        st = cn.createStatement();
        return st.execute(sentecias.INSERT(tabla, datos));
    }

    public boolean insert(String tabla, String campos, String datos) throws SQLException {
        st = cn.createStatement();
        return st.execute(sentecias.INSERT(tabla, campos, datos));
    }

    public int update(String tabla, String campos_datos, String where) throws SQLException {
        st = cn.createStatement();
        return st.executeUpdate(sentecias.UPDATE(tabla, campos_datos, where));
    }

    public int update(String tabla, String campo, String dato, String where) throws SQLException {
        st = cn.createStatement();
        return st.executeUpdate(sentecias.UPDATE(tabla, campo, dato, where));
    }

    public void delete(String tablas, String where) throws SQLException {
        st = cn.createStatement();
        st.execute(sentecias.DELETE(tablas, where));
    }

    public ResultSet select(String tabla) throws SQLException {
        st = cn.createStatement();
        return st.executeQuery(sentecias.SELECT(tabla));
    }

    public ResultSet select(String tabla, String campos) throws SQLException {
        st = cn.createStatement();
        return st.executeQuery(sentecias.SELECT(tabla, campos));
    }

    public ResultSet select(String tabla, String campos, String where) throws SQLException {
        st = cn.createStatement();
        return st.executeQuery(sentecias.SELECT(tabla, campos, where));
    }

    public String getDatos(String... datos) {
        return Func.getDatos(datos);
    }

    public String getColumnas(String... datos) {
        return Func.getColumas(datos);
    }

    public String getCampos_Datos(String[] campos, String[] datos) {
        return Func.getCampos_Datos(campos, datos);
    }

    public void close() {
        try {
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
