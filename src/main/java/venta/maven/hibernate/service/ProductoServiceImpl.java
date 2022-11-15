/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venta.maven.hibernate.service;

import java.util.List;
import venta.maven.hibernate.entity.Producto;
import venta.maven.hibernate.model.IProductoModel;
import venta.maven.hibernate.model.ProductoModelImpl;

/**
 *
 * @author emili
 */
public class ProductoServiceImpl implements IProductoService{
private IProductoModel modelo=new ProductoModelImpl();

    @Override
    public void insertarRegistroProducto(Producto producto) {
    modelo.insertarRegistroProducto(producto);
    }

    @Override
    public List<Producto> obtenerRegistrosProducto() {
                   return modelo.obtenerRegistrosProdProducto();

    }

  
}
