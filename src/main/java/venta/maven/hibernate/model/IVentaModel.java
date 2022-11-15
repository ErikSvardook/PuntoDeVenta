/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package venta.maven.hibernate.model;
import venta.maven.hibernate.entity.Venta;

import java.util.List;

/**
 *
 * @author labso20
 */
public interface IVentaModel {
    
    
     public void insertarRegistroVenta(Venta venta);
    public List<Venta> obtenerRegistrosVenta(); 
    
    
}
