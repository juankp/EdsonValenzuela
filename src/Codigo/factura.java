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
public class factura {
    
    

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }
    public String rut;
    public int cod_cliente;
    public int cod_chofer;
    public int cod_camion;
    public int cod_rampla;
    
    public String descripcion;
    public String cantidad;
    public String precio_u;
    public String total;
    public String iva;
    public String especifico;
    public String excento;
    public String cond_venta;
    public String orden_c;
    public String guia_d;

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getCod_chofer() {
        return cod_chofer;
    }

    public void setCod_chofer(int cod_chofer) {
        this.cod_chofer = cod_chofer;
    }

    public int getCod_camion() {
        return cod_camion;
    }

    public void setCod_camion(int cod_camion) {
        this.cod_camion = cod_camion;
    }

    public int getCod_rampla() {
        return cod_rampla;
    }

    public void setCod_rampla(int cod_rampla) {
        this.cod_rampla = cod_rampla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio_u() {
        return precio_u;
    }

    public void setPrecio_u(String precio_u) {
        this.precio_u = precio_u;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getEspecifico() {
        return especifico;
    }

    public void setEspecifico(String especifico) {
        this.especifico = especifico;
    }

    public String getExcento() {
        return excento;
    }

    public void setExcento(String excento) {
        this.excento = excento;
    }

    public String getCond_venta() {
        return cond_venta;
    }

    public void setCond_venta(String cond_venta) {
        this.cond_venta = cond_venta;
    }

    public String getOrden_c() {
        return orden_c;
    }

    public void setOrden_c(String orden_c) {
        this.orden_c = orden_c;
    }

    public factura(String rut, int cod_chofer, int cod_camion, int cod_rampla, String descripcion, String cantidad, String precio_u, String total, String iva, String especifico, String excento, String cond_venta, String orden_c) {
        this.rut = rut;
        this.cod_chofer = cod_chofer;
        this.cod_camion = cod_camion;
        this.cod_rampla = cod_rampla;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio_u = precio_u;
        this.total = total;
        this.iva = iva;
        this.especifico = especifico;
        this.excento = excento;
        this.cond_venta = cond_venta;
        this.orden_c = orden_c;
    }

    public factura() {
    }
    
}
