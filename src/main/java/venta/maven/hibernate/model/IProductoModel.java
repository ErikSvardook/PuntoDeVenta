/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venta.maven.hibernate.model;

import java.util.List;
import venta.maven.hibernate.entity.Producto;

/**
 *
 * @author emili
 */
public interface IProductoModel {
  public void insertarRegistroProducto(Producto producto);
    public List<Producto> obtenerRegistrosProdProducto(); 
    public void actualizarRegistro(Producto producto);
    public void eliminarRegistro(Producto producto);
}
