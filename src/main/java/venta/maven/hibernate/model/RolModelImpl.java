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
import venta.maven.hibernate.entity.Rol;

/**
 *
 * @author emili
 */
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
            System.out.println("Error: " + e.getMessage());
        }
        return listaRol;
    }

    public static void main(String[] args) {

        IRolModel modelo = new RolModelImpl();

        Rol producto = new Rol();
        producto.setRol("SUPERUSUARIO");
        producto.setNombre("MILO");
        producto.setContraseña("123");
        System.out.println("Hola aun no entran los productos");

    }

    @Override
    public void insertarRegistro(Rol rol) {

        try {
            sf = new Configuration().configure().buildSessionFactory();
            sesion = sf.openSession();
            sesion.beginTransaction();
            sesion.save(rol);
            ;

            sesion.getTransaction().commit();
            sesion.close();
            sf.close();
        } catch (HibernateException e) {
            System.out.println("Error: " + e.getMessage());

        }

    }

}
