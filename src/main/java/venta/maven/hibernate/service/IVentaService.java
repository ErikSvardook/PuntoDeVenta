package venta.maven.hibernate.service;

import java.util.List;
import venta.maven.hibernate.entity.Venta;

//Interface donde se declaran los metodos de ventas
public interface IVentaService {

    //Metodo para insertar registros de ventas
    public void insertarRegistroVenta(Venta venta);

    //Metodo para obtener registros de ventas
    public List<Venta> obtenerRegistrosVenta();
}
