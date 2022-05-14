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

/**
 *
 * @author jp
 */
public class NewConexion extends Conexion {

    public NewConexion(String url) {
        super(url);
    }

    public NewConexion(String user, String pass, String url) {
        super(user, pass, url);
    }

    public boolean INSERT(Contenedor c) {
        return super.INSERT(c.getTabla(), c.getColumnas(), c.getValores());
    }

    public boolean UPDATE(Contenedor c) {
        return super.UPDATE(c.getTabla(), c.getCamposValores(), c.getWhere());
    }

    @Override
    public boolean DELETE(String tablas, String where) {
        return super.DELETE(tablas, where);
    }

}
