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
package com.jsql.conexion;

import com.jsql.Func;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jp
 */
public class Contenedor {

    private final List<String> campos;
    private final List<String> valores;
    private String tabla;
    private String where;

    public Contenedor() {
        campos = new ArrayList<>();
        valores = new ArrayList<>();
    }

    public Contenedor(String tabla) {
        this.campos = new ArrayList<>();
        this.valores = new ArrayList<>();
        this.tabla = tabla;
    }

    public void agregar(String columna, String valor) {
        this.campos.add(columna);
        this.valores.add(valor);
    }

    public void remover(int indice) {
        campos.remove(indice);
        valores.remove(indice);
    }

    public void cambiarValor(int indice, String newValor) {
        valores.set(indice, newValor);
    }

    public void cambiarCampo(int indice, String newCampo) {
        campos.set(indice, newCampo);
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getColumnas() {
        return Func.getCampos(campos);
    }

    public String getValores() {
        return Func.getDatos(valores);
    }

    public String getCamposValores() {
        return Func.getCampos_Datos(campos.toArray(String[]::new), valores.toArray(String[]::new));
    }

    public String getTabla() {
        return tabla;
    }

    public String getWhere() {
        return where;
    }

}
