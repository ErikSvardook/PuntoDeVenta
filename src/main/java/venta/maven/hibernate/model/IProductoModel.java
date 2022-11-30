package venta.maven.hibernate.model;

import java.util.List;
import venta.maven.hibernate.entity.Producto;

//Interface que define los metodos de producto
public interface IProductoModel {

    //Metodo para insertar registros de producto
    public void insertarRegistroProducto(Producto producto);
    //Metodo para obtener registros de producto

    public List<Producto> obtenerRegistrosProdProducto();

    //Metodo para actualizar registros de producto
    public void actualizarRegistro(Producto producto);

    //Metodo para eliminar registros de producto
    public void eliminarRegistro(Producto producto);
}
