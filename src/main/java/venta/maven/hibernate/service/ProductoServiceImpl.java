package venta.maven.hibernate.service;
import java.util.List;
import venta.maven.hibernate.entity.Producto;
import venta.maven.hibernate.model.IProductoModel;
import venta.maven.hibernate.model.ProductoModelImpl;
//Clase que implementa los metodos de IProductoService
public class ProductoServiceImpl implements IProductoService {

    private IProductoModel modelo = new ProductoModelImpl();
    //Metodo para poder insertar los registros de producto
    @Override
    public void insertarRegistroProducto(Producto producto) {
        modelo.insertarRegistroProducto(producto);
    }
    //Metodo para poder obtener los registros de producto
    @Override
    public List<Producto> obtenerRegistrosProducto() {
        return modelo.obtenerRegistrosProdProducto();

    }

    //Metodo para poder actualzar registros de producto
    @Override
    public void actualizarRegistro(Producto producto) {
        modelo.actualizarRegistro(producto);
    }

    //Metodo para poder eliminar los registros de producto
    @Override
    public void eliminarRegistro(Producto producto) {
        modelo.eliminarRegistro(producto);
    }

}
