
package venta.maven.hibernate.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import venta.maven.hibernate.service.IVentaService;
import venta.maven.hibernate.service.VentaServiceImpl;
import venta.maven.hibernate.entity.Venta;


public class VentaController {

    private static IVentaService service;

    private Venta venta;
    private List<Venta> listaRegistroVenta;

    @PostConstruct
    public void init() {
        service = new VentaServiceImpl();
        venta = new Venta();
        listaRegistroVenta = service.obtenerRegistrosVenta();

    }

    public static void main(String[] args) {

        Venta venta = new Venta();

        service = new VentaServiceImpl();
        service.insertarRegistroVenta(venta);

    }

    public void crearRegistro() {
        service.insertarRegistroVenta(venta);
        System.out.println("INGRESANDO");
    }

    public Venta getVenta() {
        return venta;
    }

    public List<Venta> getListaRegistroVenta() {
        return listaRegistroVenta;
    }

}
