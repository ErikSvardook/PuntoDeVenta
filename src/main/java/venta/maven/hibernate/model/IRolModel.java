/*
Autor: Erik Jarquín Sánchez 
Creacion:15/Nov/2022
Actualizacion:01/12/2022
Descripcion: Se definen los metodos de usurio
*/
package venta.maven.hibernate.model;

import java.util.List;
import venta.maven.hibernate.entity.Rol;

//Interface que define los metodos de usuario
public interface IRolModel {
    //Metodo para insertar registros de usuario

    public void insertarRegistro(Rol rol);

    //Metodo para obtener registros de usuario
    public List<Rol> obtenerRegistros();

    //Metodo para actualizar registros de usuario
    public void actualizarRegistro(Rol rol);

    //Metodo para eliminar registros de usuario
    public void eliminarRegistro(Rol rol);
}
