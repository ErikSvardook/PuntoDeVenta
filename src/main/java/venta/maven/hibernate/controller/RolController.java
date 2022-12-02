/*
Autor:Erik Jarquín Sánchez 
Creacion:15/Nov/2022
Actualizacion:27/Nov/2022
Descripcion: En este clase se implementan los metodos  para obtener registros, insertarregistro,
actualizar registro, eliminar registro y también los metodos de validaciones del modulo Rol.
 */
package venta.maven.hibernate.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import venta.maven.hibernate.entity.Rol;
import venta.maven.hibernate.service.IRolService;
import venta.maven.hibernate.service.RolServiceImpl;

@RequestScoped
@ManagedBean(name = "rol")
public class RolController implements Serializable {

    //Se definen las variables de manera global para utilizarlas en los metodos
    private static IRolService service;
    private Rol rol;
    private List<Rol> listaRegistros;

    //Este metodo es el que inicializara todos
    @PostConstruct
    public void init() {
        service = new RolServiceImpl();
        rol = new Rol();
        listaRegistros = service.obtenerRegistros();
    }

    //Este metodo se utiliza para crear los registros
    public void crearRegistro() {
        service.insertarRegistro(rol);
        listaRegistros = service.obtenerRegistros();
    }

    //Se inserta el producto
    public Rol getRol() {
        return rol;
    }

    //Se obtiene el producto
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    //Se obtiene la lista de productos
    public List<Rol> getListaRegistros() {
        return listaRegistros;
    }

    //Metodo para editar
    public void onRowEdit(RowEditEvent event) {
        rol = (Rol) event.getObject();
        service.actualizarRegistro(rol);
        FacesMessage mensaje = new FacesMessage("Registro editado exitosamente");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    //Metodo para cancelar las acciones
    public void onRowCancel(RowEditEvent event) {
        rol = (Rol) event.getObject();
        service.eliminarRegistro(rol);
        FacesMessage mensaje = new FacesMessage("Registro eliminado exitosamente");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    //Metodo para eliminar registros
    public void eliminarRegistro(Rol rol) {
        service.eliminarRegistro(rol);
        listaRegistros = service.obtenerRegistros();
    }

    //Metodo para actualizar registros
    public void actualizarRegistro() {
        service.actualizarRegistro(rol);
        listaRegistros = service.obtenerRegistros();
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

}
