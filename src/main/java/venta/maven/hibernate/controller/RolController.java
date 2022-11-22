/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venta.maven.hibernate.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import venta.maven.hibernate.entity.Producto;
import venta.maven.hibernate.entity.Rol;
import venta.maven.hibernate.service.IRolService;
import venta.maven.hibernate.service.RolServiceImpl;

/**
 *
 * @author emili
 */
@RequestScoped
@ManagedBean(name = "rol")
public class RolController implements Serializable {

    private static IRolService service;
    private Rol rol;
    private List<Rol> listaRegistros;

    @PostConstruct
    public void init() {
        service = new RolServiceImpl();
        rol = new Rol();
        listaRegistros = service.obtenerRegistros();

    }

  /*  public static void main(String[] args) {
        Rol rol = new Rol();
        rol.setRol("Admin");
        service = new RolServiceImpl();

    }*/

 
     
    public void crearRegistro() {

        service.insertarRegistro(rol);

        System.out.println("INGRESANDO");
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getListaRegistros() {
        return listaRegistros;
    }

    public void onRowEdit(RowEditEvent event) {
        rol = (Rol) event.getObject();
        service.actualizarRegistro(rol);
        FacesMessage mensaje = new FacesMessage("Registro editado esxitosamente");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
        
    }

    public void onRowCancel(RowEditEvent event) {
        rol = (Rol) event.getObject();
       
        service.eliminarRegistro(rol);
        FacesMessage mensaje = new FacesMessage("Registro eliminado esxitosamente");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminarRegistro() {
        service.eliminarRegistro(rol);
        System.out.println("Eliminando");
    }

    public void actualizarRegistro() {
        service.actualizarRegistro(rol);
        System.out.println("Eliminando");
    }
}
