package com.jsql.sentencias;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author jp
 */
interface Querys {

    public String SELECT(String Tabla);

    public String SELECT(String Tabla, String Campos);

    public String SELECT(String Tabla, String Campos, String Where);
    
    public String QUERY(String query);

}
