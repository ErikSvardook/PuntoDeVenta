/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package venta.maven.hibernate.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import venta.maven.hibernate.entity.Producto;
import venta.maven.hibernate.service.IProductoService;
import venta.maven.hibernate.service.ProductoServiceImpl;

/**
 *
 * @author labso20
 */
@RequestScoped
@ManagedBean(name = "producto")
public class ProductoController {

    private static IProductoService service;

    private Producto producto;
    private List<Producto> listaRegistroProducto;

    @PostConstruct
    public void init() {
        service = new ProductoServiceImpl();
        producto = new Producto();
        listaRegistroProducto = service.obtenerRegistrosProducto();

    }

    public static void main(String[] args) {

        Producto producto = new Producto();
        producto.setNombrep("modem");
        producto.setPreciop(10);
        producto.setCantidadp(10);

        service = new ProductoServiceImpl();
        service.insertarRegistroProducto(producto);

    }

      public void crearRegistro() {
        service.insertarRegistroProducto(producto);
        System.out.println("INGRESANDO");
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

  

    public Producto getProducto() {
        return producto;
    }

    public List<Producto> getListaRegistroProducto() {
        return listaRegistroProducto;
    }

   
}
