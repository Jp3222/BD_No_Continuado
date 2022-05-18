/*
 * Copyright 2022 jp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jsql;

import java.sql.ResultSet;

/**
 *
 * @author jp
 */
public interface FuncionesBasicas {

    /**
     * Metodo encargado de insertar datos en la base de datos suponiendo que se
     * pasen de parameto todos los datos solicitados
     *
     * @param tabla es la tabla de la base de datos a la cual se le insertaran
     * todos los datos
     * @param datos cadena de datos que se insertaran en la base de datos
     * @return true si los datos se han insertado correctamente o false si no se
     * insertaron
     */
    public boolean insert(String tabla, String datos);

    /**
     * Metodo encargado de insertar datos en los campos especificados
     *
     * @param tabla es la tabla de la base de datos a la cual se le insertaran
     * todos los datos
     * @param campos cadena de datos que especifica los campos a los cuales se
     * les insertara informacion
     * @param datos cadena de datos que se insertaran en la base de datos
     * @return true si los datos se han insertado correctamente o false si no se
     * insertaron
     */
    public boolean insert(String tabla, String campos, String datos);

    /**
     * Metodo encargado de insertar los datos en los campos especificados
     * cumpliendo una condicion establecida
     *
     * @param tabla es la tabla de la base de datos a la cual se le insertaran
     * todos los datos
     * @param campos cadena de datos que especifica los campos a los cuales se
     * les insertara informacion
     * @param datos cadena de datos que se insertaran en la base de datos
     * @param where cadena que establece una condicion la cual deba cumplirse
     * para insertar los datos
     * @return true si los datos se han insertado correctamente o false si no se
     * insertaron
     */
    public boolean insert(String tabla, String campos, String datos, String where);

    public boolean update(String tabla, String campos_datos, String where);

    public boolean update(String tabla, String campos, String datos, String where);

    public boolean updateNumbers(String tabla, String campos, String datos, String where);

    public boolean delete(String tablas, String where);

    public ResultSet select(String tabla);

    public ResultSet select(String tabla, String campos);

    public ResultSet select(String tabla, String campos, String where);
}
