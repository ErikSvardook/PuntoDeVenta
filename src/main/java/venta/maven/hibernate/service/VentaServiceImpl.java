/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package venta.maven.hibernate.service;

import java.util.List;
import venta.maven.hibernate.entity.Venta;
import venta.maven.hibernate.model.IVentaModel;
import venta.maven.hibernate.model.VentaModelImpl;

/**
 *
 * @author labso20
 */
public class VentaServiceImpl implements IVentaService {
private IVentaModel modelo=new VentaModelImpl();
    @Override
    public void insertarRegistroVenta(Venta venta) {
    modelo.insertarRegistroVenta(venta);
    }

    @Override
    public List<Venta> obtenerRegistrosVenta() {
                   return modelo.obtenerRegistrosVenta();
    }
    
}
