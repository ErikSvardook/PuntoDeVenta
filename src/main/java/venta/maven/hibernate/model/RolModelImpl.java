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

    public static void main(String[] args) {

        IRolModel modelo = new RolModelImpl();

        Rol producto = new Rol();
        producto.setRol("SUPERUSUARIO");
        producto.setNombre("MILO");
        producto.setContraseña("123");
        

    }

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
