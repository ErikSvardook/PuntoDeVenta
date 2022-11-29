
package venta.maven.hibernate.service;

import java.util.List;
import venta.maven.hibernate.entity.Producto;
import venta.maven.hibernate.model.IProductoModel;
import venta.maven.hibernate.model.ProductoModelImpl;


public class ProductoServiceImpl implements IProductoService{
private IProductoModel modelo=new ProductoModelImpl();

    @Override
    public void insertarRegistroProducto(Producto producto) {
    modelo.insertarRegistroProducto(producto);
    }

    @Override
    public List<Producto> obtenerRegistrosProducto() {
                   return modelo.obtenerRegistrosProdProducto();

    }

    @Override
    public void actualizarRegistro(Producto producto) {
         modelo.actualizarRegistro(producto);
    }

    @Override
    public void eliminarRegistro(Producto producto) {
         modelo.eliminarRegistro(producto);
    }

  
}
