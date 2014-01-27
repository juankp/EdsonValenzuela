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
public class rampla {
    public String Patente;
    public String Marca;
    public String Modelo;
    public String Anio;
    public String Tipo;

    public String getPatente() {
        return Patente;
    }

    public void setPatente(String Patente) {
        this.Patente = Patente;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getAnio() {
        return Anio;
    }

    public void setAnio(String Anio) {
        this.Anio = Anio;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public rampla(String Patente, String Marca, String Modelo, String Anio, String Tipo) {
        this.Patente = Patente;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Anio = Anio;
        this.Tipo = Tipo;
    }

    public rampla() {
    }
    
}
