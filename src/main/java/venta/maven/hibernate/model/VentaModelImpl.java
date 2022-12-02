/*
Autor:Hermilo Almaraz Vargas
Creacion:15/Nov/2022
Actualizacion:01/12/2022
Descripcion: Ventas
*/
package venta.maven.hibernate.model;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import venta.maven.hibernate.entity.Venta;


public class VentaModelImpl implements IVentaModel{
 
    private SessionFactory sf;
    private Session sesion;
    
   //Método para registrar venta
   @Override
    public void insertarRegistroVenta(Venta venta) {
     try {
            sf = new Configuration().configure().buildSessionFactory();
            sesion = sf.openSession();
            sesion.beginTransaction();
            sesion.save(venta);
            sesion.getTransaction().commit();
            sesion.close();
            sf.close();
        } catch (HibernateException e) {

        }   
    }
    
    //Método para obtener registro de ventas
    @Override
    public List<Venta> obtenerRegistrosVenta() {
        List<Venta> listaventa = null;
        try {
            sf = new Configuration().configure().buildSessionFactory();
            sesion = sf.openSession();
            listaventa = sesion.createCriteria(Venta.class).list();
            sesion.close();
            sf.close();
        } catch (HibernateException e) {
           
        }
        return listaventa;   
    }
  
}
