/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.congresos_web_app.backend.crud;

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
     */
    public boolean create(T entidad);
    
    /**
     * Metodo que lee un dato de la base de datos, se implementa en su respectiva DAO
     * @param id la identificacion por la cual se va a encontrar el registro buscado
     * @return el objeto ya creado y leido de la base de datos
     */
    public T read(String id);
    
    /**
     * Metodo que lee una tabla entera de la base de datos
     * @param tabla el nombre de la tabla que se busca
     * @return un arreglo de todos los datos encontrados en la tabla especificada
     */
    public List<T> readAll(String tabla);
    
    /**
     * Funcion que actualiza un dato de la base de datos basada en su primary key (logica extra en cada implementacion)
     * @param id identificacion del registro que queremos actualizar
     * @return true si se logra actualizar correctamente, fase si no
     */
    public boolean update(String id);
    
    /**
     * Metodo que elimina un registro de la base de datos, mediante su primary key
     * @param id identificacion del registro que queremos eliminar
     * @return true si se elimina con exito, false si no
     */
    public boolean delete(String id);
}
