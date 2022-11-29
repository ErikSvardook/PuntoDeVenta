
package venta.maven.hibernate.model;
import venta.maven.hibernate.entity.Venta;

import java.util.List;


public interface IVentaModel {
    
    
     public void insertarRegistroVenta(Venta venta);
    public List<Venta> obtenerRegistrosVenta(); 
    
    
}
