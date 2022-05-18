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
 * Esta clase ayuda a establece una conexion con la base de datos e implementa
 * las funciones basicas
 *
 * @author HP
 */
public class Conexion extends BD implements FuncionesBasicas {

    private static Conexion Instancia;

    /**
     * Este metodo crea una nueva e unica instancia de la clase Conexion
     *
     * @param user cadena que establece el usuario de la base de datos
     * @param pass cadena que establece la contraseña de la base de datos
     * @param url cadena que establece la direccion de la base de datos
     * @return una nueva y unica instancia con los parametros establecidos
     */
    public static Conexion getInstancia(String user, String pass, String url) {
        if (Instancia == null) {
            Instancia = new Conexion(user, pass, url);
        }
        return Instancia;
    }

    /**
     *
     * @return
     */
    public static Conexion getInstancia() {
        return Instancia;
    }

    /**
     * Metodo que retorna una direccion local de la base de datos
     *
     * @param i defien el gestor de base de datos que se usara
     * <br>1 mysql
     * <br>2 postgresql
     * <br>3 sqlite
     * @param port cadena que establece el puerto de la base de datos
     * @param db cadena que establece el nombre de la base de datos
     * @return una cadena con los parametros establecidos que representan una
     * direccion local
     */
    public static String getLOCAL_URL_MYSQL(int i, String port, String db) {
        String direccion = "jdbc:";
        String locacion = "://localhost:";
        String motor;

        switch (i) {
            case 1:
                motor = "mysql";
                break;
            case 2:
                motor = "postgresql";
                break;
            case 3:
                motor = "sqlite";
                break;
            default:
                throw new AssertionError();
        }
        return direccion + motor + locacion + port + "/" + db;

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
    public boolean insert(String tabla, String datos) {
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
    public boolean insert(String tabla, String campos, String datos) {
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
    public boolean insert(String tabla, String campos, String datos, String where) {
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
    public boolean update(String tabla, String campos_datos, String where) {
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
    public boolean update(String tabla, String campos, String datos, String where) {
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
    public boolean updateNumbers(String tabla, String campos, String datos, String where) {
        try {
            st = cn.createStatement();
            st.executeUpdate(sql.UPDATENUMBERS(tabla, campos, datos, where));
            cerrarStament();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(String tablas, String where) {
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
    public ResultSet select(String tabla) {
        try {
            st = cn.createStatement();
            return st.executeQuery(sql.SELECT(tabla));
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ResultSet select(String tabla, String campos) {
        try {
            st = cn.createStatement();
            return st.executeQuery(sql.SELECT(tabla, campos));
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ResultSet select(String tabla, String campos, String where) {
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
