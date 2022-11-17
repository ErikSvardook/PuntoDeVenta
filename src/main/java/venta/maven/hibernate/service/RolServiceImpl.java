/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venta.maven.hibernate.service;

import java.util.List;
import venta.maven.hibernate.entity.Producto;
import venta.maven.hibernate.entity.Rol;
import venta.maven.hibernate.model.IRolModel;
import venta.maven.hibernate.model.RolModelImpl;

/**
 *
 * @author emili
 */
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

   


   
}
