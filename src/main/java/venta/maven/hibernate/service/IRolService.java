/*
Autor: Gamaliel Silva Lopez
Creacion: 15/11/20222
Actualizacion: 01/12/2022
Descripción: Se declaran los métodos del usuario
*/
package venta.maven.hibernate.service;

import java.util.List;
import venta.maven.hibernate.entity.Rol;
//Interface donde se declaran los metodos de usuario

public interface IRolService {
    //Metodo para insertar registros de usuarios

    public void insertarRegistro(Rol rol);
    //Metodo para obtener registros de usuario

    public List<Rol> obtenerRegistros();
    //Metodo para actualizar registro de usuario

    public void actualizarRegistro(Rol rol);
    //Metodo para eliminar registro de usuario

    public void eliminarRegistro(Rol rol);

}
