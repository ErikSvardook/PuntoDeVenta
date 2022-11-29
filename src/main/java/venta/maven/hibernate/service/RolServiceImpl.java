
package venta.maven.hibernate.service;

import java.util.List;
import venta.maven.hibernate.entity.Rol;
import venta.maven.hibernate.model.IRolModel;
import venta.maven.hibernate.model.RolModelImpl;


public class RolServiceImpl implements IRolService{
private IRolModel modelo=new RolModelImpl();

    @Override
    public List<Rol> obtenerRegistros() {
               return modelo.obtenerRegistros();

    }

    @Override
    public void insertarRegistro(Rol rol) {
        modelo.insertarRegistro(rol);

    }

    @Override
    public void actualizarRegistro(Rol rol) {
        modelo.actualizarRegistro(rol);
    }

    @Override
    public void eliminarRegistro(Rol rol) {
        modelo.eliminarRegistro(rol);
    }

   


   
}
