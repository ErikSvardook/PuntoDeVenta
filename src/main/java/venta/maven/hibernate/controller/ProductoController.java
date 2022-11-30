
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
    
    
    public void validarTexto(FacesContext context, UIComponent toValidate, Object value){
        context = FacesContext.getCurrentInstance();
        String texto = (String)value;
        
        if(!texto.matches("[A-Z]*")){
            ((UIInput)toValidate).setValid(false);
            context.addMessage("Nota", new FacesMessage("Solo deben ingresarse letras"));
        }
    }
    
    public void validarNumeros(FacesContext context, UIComponent toValidate, Object value){
        context = FacesContext.getCurrentInstance();
        String texto = (String)value;
        
        if(texto.compareTo("hola")==0){
            ((UIInput)toValidate).setValid(false);
            context.addMessage("nota", new FacesMessage("xxxxx"));
        }
    }
    
}
