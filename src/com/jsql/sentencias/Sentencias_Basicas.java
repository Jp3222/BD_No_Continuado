package com.jsql.sentencias;

/**
 *
 * @author jp
 */
public interface Sentencias_Basicas{

    public String INSERT(String Tabla, String Valores);

    public String INSERT(String Tabla, String Valores, String Where);

    public String UPDATE(String Tabla, String Data, String where);

    public String UPDATE(String Tabla, String Campo, String Remplazo, String Where);

    public String DELETE(String Tabla, String Where);

}
