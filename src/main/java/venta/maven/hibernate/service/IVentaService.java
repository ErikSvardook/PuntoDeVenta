
package venta.maven.hibernate.service;

import java.util.List;
import venta.maven.hibernate.entity.Venta;


public interface IVentaService {
    
     public void insertarRegistroVenta(Venta venta);
    public List<Venta> obtenerRegistrosVenta();
    
    
    
}
