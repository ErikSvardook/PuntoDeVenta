/*
Autor:Hermilo Almaraz Vargas
Creacion:15/Nov/2022
Actualizacion:01/12/2022
Descripcion: Se definen los metodos de ventas
*/
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
