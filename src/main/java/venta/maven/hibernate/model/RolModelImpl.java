/*
Autor:Hermilo Almaraz Vargas
Creacion:10/Nov/2022
Actualizacion:22/Nov/2022
Descripcion: En este clase se implementan los metodos obtener registros, 
insertarregistro, actualizarregistro y eliminarregistro con ayuda de los
elementos de hibernate.
*/

package venta.maven.hibernate.model;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import venta.maven.hibernate.entity.Rol;

public class RolModelImpl implements IRolModel {

    private SessionFactory sf;
    private Session sesion;

    //Método para obtener registros de los ususarios 
    @Override
    public List<Rol> obtenerRegistros() {
        List<Rol> listaRol = null;
        try {
            sf = new Configuration().configure().buildSessionFactory();
            sesion = sf.openSession();
            listaRol = sesion.createCriteria(Rol.class).list();
            sesion.close();
            sf.close();
        } catch (HibernateException e) {

        }
        return listaRol;
    }

    //Método para insertar registro de un ususario
    @Override
    public void insertarRegistro(Rol rol) {

        try {
            sf = new Configuration().configure().buildSessionFactory();
            sesion = sf.openSession();
            sesion.beginTransaction();
            sesion.save(rol);
            sesion.getTransaction().commit();
            sesion.close();
            sf.close();
        } catch (HibernateException e) {

        }

    }

    //Método para actualizar registro
    @Override
    public void actualizarRegistro(Rol rol) {

        try {
            sf = new Configuration().configure().buildSessionFactory();
            sesion = sf.openSession();
            sesion.beginTransaction();
            sesion.update(rol);
            sesion.getTransaction().commit();
            sesion.close();
            sf.close();
        } catch (HibernateException e) {

        }

    }

    @Override
    public void eliminarRegistro(Rol rol) {
        try {
            sf = new Configuration().configure().buildSessionFactory();
            sesion = sf.openSession();
            sesion.beginTransaction();
            sesion.delete(rol);
            sesion.getTransaction().commit();
            sesion.close();
            sf.close();
        } catch (HibernateException e) {

        }

    }

}
