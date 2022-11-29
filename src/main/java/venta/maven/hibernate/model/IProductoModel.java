
package venta.maven.hibernate.model;

import java.util.List;
import venta.maven.hibernate.entity.Producto;


public interface IProductoModel {
  public void insertarRegistroProducto(Producto producto);
    public List<Producto> obtenerRegistrosProdProducto(); 
    public void actualizarRegistro(Producto producto);
    public void eliminarRegistro(Producto producto);
}
