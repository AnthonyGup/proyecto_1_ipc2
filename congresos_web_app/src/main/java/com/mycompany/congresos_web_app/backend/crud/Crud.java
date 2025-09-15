/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author antho
 */
public interface Crud<T> {
    
    /**
     * Metodo que crea un nuevo dato sobre la base de datos, se utiliza en su respectivo DAO
     * @param entidad es el dato que se quiere guardar con el nuevo registro creado
     * @return true si se logra, false si no
     * @throws java.sql.SQLException
     */
    public boolean create(T entidad) throws SQLException;
    
    /**
     * Metodo que lee un dato de la base de datos, se implementa en su respectiva DAO
     * @param id la identificacion por la cual se va a encontrar el registro buscado
     * @return el objeto ya creado y leido de la base de datos
     * @throws java.sql.SQLException
     */
    public T read(String id) throws SQLException;
    
    /**
     * Metodo que lee una tabla entera de la base de datos
     * @param tabla el nombre de la tabla que se busca
     * @return un arreglo de todos los datos encontrados en la tabla especificada
     * @throws java.sql.SQLException
     */
    public List<T> readAll(String tabla) throws SQLException;
    
    /**
     * Funcion que actualiza un dato de la base de datos basada en su primary key (logica extra en cada implementacion)
     * @param id identificacion del registro que queremos actualizar
     * @return true si se logra actualizar correctamente, fase si no
     * @throws java.sql.SQLException
     */
    public boolean update(String id) throws SQLException;
    
    /**
     * Metodo que elimina un registro de la base de datos, mediante su primary key
     * @param id identificacion del registro que queremos eliminar
     * @return true si se elimina con exito, false si no
     * @throws java.sql.SQLException
     */
    public boolean delete(String id) throws SQLException;
    
    /**
     * Metodo que devuelve la entidad buscada solo esa entidad
     * @param rs el resultset creado
     * @return la entidad
     * @throws SQLException 
     */
    public T obtenerEntidad(ResultSet rs) throws SQLException;
    
}
    