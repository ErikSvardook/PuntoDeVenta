/*
Autor:Hermilo Almaraz Vargas
Creacion:15/Nov/2022
Actualizacion:24/Nov/2022
Descripcion: En este clase se implementan los metodos obtener registros, insertarregistro,
actualizarregistro y eliminarregistro con ayuda de los elementos de hibernate.
*/

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
 
    //Método para insertar registro de un producto
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


            }   
    }
    
    //Método para obtener registros de los productos
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
        return listaproducto;    
    }
    //Método para actualizar registro de productos
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

            }  
    }

    //Método para eliminar registro de un producto
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
