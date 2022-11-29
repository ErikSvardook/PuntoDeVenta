
package venta.maven.hibernate.model;

import java.util.List;
import venta.maven.hibernate.entity.Rol;


public interface IRolModel {
 
    public void insertarRegistro(Rol rol);
    public List<Rol> obtenerRegistros();
    public void actualizarRegistro(Rol rol);
    public void eliminarRegistro(Rol rol);
}
