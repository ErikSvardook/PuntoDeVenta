/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venta.maven.hibernate.model;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import venta.maven.hibernate.entity.Producto;

/**
 *
 * @author emili
 */   //IRolModel
public class ProductoModelImpl implements IProductoModel{
 private SessionFactory sf;
    private Session sesion;
 @Override
    public void insertarRegistroProducto(Producto producto) {
 try {
            sf = new Configuration().configure().buildSessionFactory();
            sesion = sf.openSession();
            sesion.beginTransaction();
            sesion.save(producto);
            sesion.getTransaction().commit();
            sesion.close();
            sf.close();
        } catch (HibernateException e) {
            System.out.println("Error: " + e.getMessage());

        }    }

    @Override
    public List<Producto> obtenerRegistrosProdProducto() {
 List<Producto> listaproducto = null;
        try {
            sf = new Configuration().configure().buildSessionFactory();
            sesion = sf.openSession();
            listaproducto = sesion.createCriteria(Producto.class).list();
            sesion.close();
            sf.close();
        } catch (HibernateException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return listaproducto;    }
  
    
     public static void main(String[] args) {
        IProductoModel modelo = new ProductoModelImpl();
        
        
        Producto producto = new Producto();
       // producto.setIdprodcuto(10);
//        producto.setNombrep("modem");
//        producto.setPreciop(10);
//        producto.setCantidadp(10);
        modelo.insertarRegistroProducto(producto);
         System.out.println("Hola aun no entran los productos");
        
         
         /*
         
        
         IRolModel modelo = new RolModelImpl();
        Rol rol = new Rol();
        rol.setRol("admin");
        modelo.insertarRegistro(rol);
      
         
         */
         
         
    }

    @Override
    public void actualizarRegistro(Producto producto) {
  try {
            sf = new Configuration().configure().buildSessionFactory();
            sesion = sf.openSession();
            sesion.beginTransaction();
            sesion.update(producto);
            

            sesion.getTransaction().commit();
            sesion.close();
            sf.close();
        } catch (HibernateException e) {
            System.out.println("Error: " + e.getMessage());

        }    }

    @Override
    public void eliminarRegistro(Producto producto) {
 try {
            sf = new Configuration().configure().buildSessionFactory();
            sesion = sf.openSession();
            sesion.beginTransaction();
            sesion.delete(producto);
            

            sesion.getTransaction().commit();
            sesion.close();
            sf.close();
        } catch (HibernateException e) {
            System.out.println("Error: " + e.getMessage());

        }
            }

  

  
 
    
    
}
