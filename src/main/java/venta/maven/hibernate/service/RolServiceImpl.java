
package venta.maven.hibernate.service;

import java.util.List;
import venta.maven.hibernate.entity.Rol;
import venta.maven.hibernate.model.IRolModel;
import venta.maven.hibernate.model.RolModelImpl;

//Clase que implementa los metodos de IRolService
public class RolServiceImpl implements IRolService{
private IRolModel modelo=new RolModelImpl();
    //Metodo para poder obtener los registros de usuario
    @Override
    public List<Rol> obtenerRegistros() {
               return modelo.obtenerRegistros();

    }
    
    //Metodo para poder insertar los registros de usuario
    @Override
    public void insertarRegistro(Rol rol) {
        modelo.insertarRegistro(rol);

    }
    
    //Metodo para poder actualizar los registros de usuario
    @Override
    public void actualizarRegistro(Rol rol) {
        modelo.actualizarRegistro(rol);
    }
    //Metodo para poder eliminar los registros de usuario
    @Override
    public void eliminarRegistro(Rol rol) {
        modelo.eliminarRegistro(rol);
    }

   


   
}
