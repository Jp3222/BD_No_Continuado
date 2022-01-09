package com.jsql.sentencias;

/**
 *
 * @author jp
 */
interface Sentencias {

    public String INSERT(String Tabla, String Valores);

    public String INSERT(String Tabla, String Valores, String Where);

    public String UPDATE(String Tabla, String Data, String where);

    public String UPDATE(String Tabla, String Campo, String Remplazo, String Where);

    public String DELETE(String Tabla, String Where);

    public String Sentencia(String sentencia);

}
