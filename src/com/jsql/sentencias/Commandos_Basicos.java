package com.jsql.sentencias;

/**
 *
 * @author jp
 */
interface Commandos_Basicos extends Sentencias_Basicas, Querys_Basicos {

    public String QUERY(String query);
    
    public String SENTENCIA(String sentencia);
}
