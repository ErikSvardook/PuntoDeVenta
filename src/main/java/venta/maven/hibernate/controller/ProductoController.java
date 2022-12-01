/*
Autor:Erik Jarquín Sánchez 
Creacion:15/Nov/2022
Actualizacion:27/Nov/2022
Descripcion: En este clase se implementan los metodos  para obtener registros, insertarregistro,
actualizar registro, eliminar registro y también los metodos de validaciones.
 */
package venta.maven.hibernate.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import venta.maven.hibernate.entity.Producto;
import venta.maven.hibernate.service.IProductoService;
import venta.maven.hibernate.service.ProductoServiceImpl;

@RequestScoped
@ManagedBean(name = "producto")
public class ProductoController {

    //Se definen las variables de manera global para utilizarlas en los metodos
    private static IProductoService service;
    private Producto producto;
    private List<Producto> listaRegistroProducto;

    //Este metodo es el que inicializara todos
    @PostConstruct
    public void init() {
        service = new ProductoServiceImpl();
        producto = new Producto();
        listaRegistroProducto = service.obtenerRegistrosProducto();
    }

    //Metodo main para hacer pruebas de los metodos
    public static void main(String[] args) {
        Producto producto = new Producto();
        service = new ProductoServiceImpl();
        service.insertarRegistroProducto(producto);
    }

    //Este metodo se utiliza para crear los registros
    public void crearRegistro() {
        service.insertarRegistroProducto(producto);
        System.out.println("INGRESANDO");
    }

    //Se inserta el producto
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    //Se obtiene el producto
    public Producto getProducto() {
        return producto;
    }

    //Se obtiene la lista de productos
    public List<Producto> getListaRegistroProducto() {
        return listaRegistroProducto;
    }

    //Metodo para editar
    public void onRowEdit(RowEditEvent event) {
        producto = (Producto) event.getObject();
        service.actualizarRegistro(producto);
        FacesMessage mensaje = new FacesMessage("Registro editado exitosamente");
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

    public void validarTexto(FacesContext context, UIComponent toValidate, Object value) {
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;

        if (!texto.matches("[A-Z]*")) {
            ((UIInput) toValidate).setValid(false);
            context.addMessage("Nota", new FacesMessage("Solo deben ingresarse letras"));
        }
    }

    public void validarNumeros(FacesContext context, UIComponent toValidate, Object value) {
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;

        if (texto.compareTo("hola") == 0) {
            ((UIInput) toValidate).setValid(false);
            context.addMessage("nota", new FacesMessage("xxxxx"));
        }
    }
}
