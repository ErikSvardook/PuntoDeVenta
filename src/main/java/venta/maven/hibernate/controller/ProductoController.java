/*
Autor:Erik Jarquín Sánchez 
Creacion:15/Nov/2022
Actualizacion:27/Nov/2022
Descripcion: En este clase se implementan los metodos  para obtener registros, insertarregistro,
actualizar registro, eliminar registro y también los metodos de validaciones del modulo Producto.
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
        listaRegistroProducto = service.obtenerRegistrosProducto();
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

    //Metodo para cancelar las acciones
    public void onRowCancel(RowEditEvent event) {
        producto = (Producto) event.getObject();
        service.eliminarRegistro(producto);
        FacesMessage mensaje = new FacesMessage("Registro eliminado esxitosamente");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    //Metodo para eliminar registros
    public void eliminarRegistro() {
        service.eliminarRegistro(producto);
    }

    //Metodo para actualizar registros
    public void actualizarRegistro() {
        service.actualizarRegistro(producto);
    }

    //Metodo para validar solo texto
    public void validarTexto(FacesContext context, UIComponent toValidate, Object value) {
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        if (!texto.matches("[A-Za-z]*")) {
            ((UIInput) toValidate).setValid(false);
            context.addMessage("Nota", new FacesMessage("Solo deben ingresarse letras"));
        }
    }

    //Metodo para validar solo numeros
    public void validarNumeros(FacesContext context, UIComponent toValidate, Object value) {
        context = FacesContext.getCurrentInstance();
        String texto = (String) value;
        if (!texto.matches("^[0-9]+([.])?([0-9]+)?$")) {
            ((UIInput) toValidate).setValid(false);
            context.addMessage("nota", new FacesMessage("Solo deben ingresarse numeros flotantes"));
        }
    }
}
