package venta.maven.hibernate.service;

import java.util.List;
import venta.maven.hibernate.entity.Venta;
import venta.maven.hibernate.model.IVentaModel;
import venta.maven.hibernate.model.VentaModelImpl;

//Clase que implementa los metodos de IVentalService
public class VentaServiceImpl implements IVentaService {

    private IVentaModel modelo = new VentaModelImpl();
    //Metodo para poder insertar los registros de ventas

    @Override
    public void insertarRegistroVenta(Venta venta) {
        modelo.insertarRegistroVenta(venta);
    }
    //Metodo para poder obtener los registros de ventas

    @Override
    public List<Venta> obtenerRegistrosVenta() {
        return modelo.obtenerRegistrosVenta();
    }

}
