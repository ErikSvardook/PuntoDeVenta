
package venta.maven.hibernate.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import venta.maven.hibernate.entity.Rol;
import venta.maven.hibernate.service.IRolService;
import venta.maven.hibernate.service.RolServiceImpl;


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

 
     
    public void crearRegistro() {

        service.insertarRegistro(rol);

  
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
    }

    public void actualizarRegistro() {
        service.actualizarRegistro(rol);
    }
    
    
}
