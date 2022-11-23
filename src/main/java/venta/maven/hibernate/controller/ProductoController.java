/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package venta.maven.hibernate.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
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

    
      public void onRowEdit(RowEditEvent event) {
        producto = (Producto) event.getObject();
        service.actualizarRegistro(producto);
        FacesMessage mensaje = new FacesMessage("Registro editado esxitosamente");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
        
    }

    public void onRowCancel(RowEditEvent event) {
        producto = (Producto) event.getObject();
       
        service.eliminarRegistro(producto);
        FacesMessage mensaje = new FacesMessage("Registro eliminado esxitosamente");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    
    public void eliminarRegistro() {
        service.eliminarRegistro(producto);
    }

    public void actualizarRegistro() {
        service.actualizarRegistro(producto);
    }
}
