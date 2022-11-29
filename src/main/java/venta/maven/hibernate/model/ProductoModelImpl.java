
package venta.maven.hibernate.model;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import venta.maven.hibernate.entity.Producto;


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
          
        }
        return listaproducto;    }
  
    
     public static void main(String[] args) {
        IProductoModel modelo = new ProductoModelImpl();
        
        
        Producto producto = new Producto();
        modelo.insertarRegistroProducto(producto);
         
        
         
         
         
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
            

        }
            }

  

  
 
    
    
}
