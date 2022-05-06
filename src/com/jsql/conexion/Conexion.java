package com.jsql.conexion;

import com.jsql.Func;
import com.jsql.FuncionesBasicas;
import com.jsql.sql.SQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Conexion extends BD implements FuncionesBasicas {

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

    private final SQL sql;
    private PreQuerys query;
    private Statement st;

    protected Conexion(String user, String pass, String url) {
        super(user, pass, url);
        sql = new SQL();
    }

    public Conexion(String url) {
        super(url);
        sql = new SQL();
    }

    @Override
    public boolean INSERT(String tabla, String datos) {
        try {
            st = cn.createStatement();
            st.executeUpdate(sql.INSERT(tabla, datos));
            cerrarStament();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean INSERT(String tabla, String campos, String datos) {
        try {
            st = cn.createStatement();
            st.executeUpdate(sql.INSERT(tabla, campos, datos));
            cerrarStament();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean INSERT(String tabla, String campos, String datos, String where) {
        try {
            st = cn.createStatement();
            st.executeUpdate(sql.INSERT(tabla, campos, datos, where));
            cerrarStament();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean UPDATE(String tabla, String campos_datos, String where) {
        try {
            st = cn.createStatement();
            st.executeUpdate(sql.UPDATE(tabla, campos_datos, where));
            cerrarStament();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean UPDATE(String tabla, String campos, String datos, String where) {
        try {
            st = cn.createStatement();
            st.executeUpdate(sql.UPDATE(tabla, campos, datos, where));
            cerrarStament();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean DELETE(String tablas, String where) {
        try {
            st = cn.createStatement();
            st.execute(sql.DELETE(tablas, where));
            cerrarStament();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ResultSet SELECT(String tabla) {
        try {
            st = cn.createStatement();
            return st.executeQuery(sql.SELECT(tabla));
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ResultSet SELECT(String tabla, String campos) {
        try {
            st = cn.createStatement();
            return st.executeQuery(sql.SELECT(tabla, campos));
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ResultSet SELECT(String tabla, String campos, String where) {
        try {
            st = cn.createStatement();
            return st.executeQuery(sql.SELECT(tabla, campos, where));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void cerrarStament() {
        try {
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getCampos(String... campos) {
        return Func.getCampos(campos);
    }

    public String getDatos(String... Datos) {
        return Func.getDatos(Datos);
    }

    public String getCampos_Datos(String[] campos, String[] datos) {
        return Func.getCampos_Datos(campos, datos);
    }

    public void setQuery(PreQuerys query) {
        this.query = query;
        this.query.setCn(cn);
    }

    public SQL getSql() {
        return sql;
    }

}
