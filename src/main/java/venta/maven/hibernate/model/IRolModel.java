/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venta.maven.hibernate.model;

import java.util.List;
import venta.maven.hibernate.entity.Rol;

/**
 *
 * @author emili
 */
public interface IRolModel {
 
    public void insertarRegistro(Rol rol);
    public List<Rol> obtenerRegistros();
    public void actualizarRegistro(Rol rol);
    public void eliminarRegistro(Rol rol);
}
