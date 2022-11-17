/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package venta.maven.hibernate.model;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import venta.maven.hibernate.entity.Venta;

/**
 *
 * @author labso20
 */
public class VentaModelImpl implements IVentaModel{
 
     private SessionFactory sf;
    private Session sesion;
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
            System.out.println("Error: " + e.getMessage());

        }    }

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
            System.out.println("Error: " + e.getMessage());
        }
        return listaventa;    }
  
    
     public static void main(String[] args) {
  
         
         
    }

  

  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
