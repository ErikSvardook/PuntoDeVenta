
package venta.maven.hibernate.model;
import venta.maven.hibernate.entity.Venta;

import java.util.List;

//Interface que define los metodos de venta
public interface IVentaModel {
   //Metodo para insertar registros de ventas
    public void insertarRegistroVenta(Venta venta);
    //Metodo para obtner registros de usuario
    public List<Venta> obtenerRegistrosVenta(); 
    
    
}
