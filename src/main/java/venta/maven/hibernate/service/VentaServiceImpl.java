
package venta.maven.hibernate.service;

import java.util.List;
import venta.maven.hibernate.entity.Venta;
import venta.maven.hibernate.model.IVentaModel;
import venta.maven.hibernate.model.VentaModelImpl;


public class VentaServiceImpl implements IVentaService {
private IVentaModel modelo=new VentaModelImpl();
    @Override
    public void insertarRegistroVenta(Venta venta) {
    modelo.insertarRegistroVenta(venta);
    }

    @Override
    public List<Venta> obtenerRegistrosVenta() {
                   return modelo.obtenerRegistrosVenta();
    }
    
}
