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

    public boolean INSERT(String tabla, String datos);

    public boolean INSERT(String tabla, String campos, String datos);

    public boolean INSERT(String tabla, String campos, String datos, String where);

    public boolean UPDATE(String tabla, String campos_datos, String where);

    public boolean UPDATE(String tabla, String campos, String datos, String where);

    public boolean DELETE(String tablas, String where);

    public ResultSet SELECT(String tabla);

    public ResultSet SELECT(String tabla, String campos);

    public ResultSet SELECT(String tabla, String campos, String where);
}
