/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venta.maven.hibernate.service;

import java.util.List;
import venta.maven.hibernate.entity.Producto;

/**
 *
 * @author emili
 */
public interface IProductoService {
      public void insertarRegistroProducto(Producto producto);
    public List<Producto> obtenerRegistrosProducto();  
}
