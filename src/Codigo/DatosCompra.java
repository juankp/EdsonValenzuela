/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Codigo;

/**
 *
 * @author Yo elijo mi pc
 */
public class DatosCompra {

    public DatosCompra(String numero, String proveedor, String fecha, String descripcion, String orden, String condicion, String total) {
        this.numero = numero;
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.orden = orden;
        this.condicion = condicion;
        this.total = total;
    }
    
    

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public DatosCompra(String numero, String proveedor, String fecha, String descripcion, String orden, String condicion,String especifico, String total) {
        this.numero = numero;
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.orden = orden;
        this.condicion = condicion;
        this.especifico = especifico;
        this.total = total;
        
    }

    public String getEspecifico() {
        return especifico;
    }

    public void setEspecifico(String especifico) {
        this.especifico = especifico;
    }
    
    String numero,proveedor,fecha,descripcion,orden,condicion,total,especifico;
}
