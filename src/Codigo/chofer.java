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
public class chofer {
    
    public String Nombre;
    public String Rut;
    public String Fono;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getRut() {
        return Rut;
    }

    public void setRut(String Rut) {
        this.Rut = Rut;
    }

    public String getFono() {
        return Fono;
    }

    public void setFono(String Fono) {
        this.Fono = Fono;
    }

    public chofer(String Nombre, String Rut, String Fono) {
        this.Nombre = Nombre;
        this.Rut = Rut;
        this.Fono = Fono;
    }

    public chofer() {
    }
    
    
    
}
