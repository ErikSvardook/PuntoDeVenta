
package venta.maven.hibernate.service;

import java.util.List;
import venta.maven.hibernate.entity.Producto;

public interface IProductoService {
      public void insertarRegistroProducto(Producto producto);
    public List<Producto> obtenerRegistrosProducto(); 
    public void actualizarRegistro(Producto producto);
    public void eliminarRegistro(Producto producto);
}
