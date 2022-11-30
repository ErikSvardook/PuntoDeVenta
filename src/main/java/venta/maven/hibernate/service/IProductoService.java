/*
Autor: Gamaliel Silva Lopez
Creacion: 15/11/20222
Actualizacion: 01/12/2022
Descripción: Se declaran los métodos de producto
*/
package venta.maven.hibernate.service;

import java.util.List;
import venta.maven.hibernate.entity.Producto;
//Interface donde se declaran los metodos de producto

public interface IProductoService {
    //Metodo para insertar registros de producto
    public void insertarRegistroProducto(Producto producto);
    //Metodo para obtener registros de producto
    public List<Producto> obtenerRegistrosProducto();
    //Metodo para actualizar registro de producto
    public void actualizarRegistro(Producto producto);
    //Metodo para eliminar registro de producto
    public void eliminarRegistro(Producto producto);
}
