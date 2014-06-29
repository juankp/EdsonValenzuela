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
public class FormatoRut {
 
    public String getRutFormato(String rut) throws Exception {
        String FRut[] = new String[5];
 
        if (String.valueOf(rut).length() == 9) {
            FRut[0] = String.valueOf(rut).substring(0, 2);
            FRut[1] = String.valueOf(rut).substring(2, 5);
            FRut[2] = String.valueOf(rut).substring(5, 8);
            FRut[3] = String.valueOf(rut).substring(8, 9);
        }
 
        if (String.valueOf(rut).length() ==  8 )  {
            FRut[0] = String.valueOf(rut).substring(0, 1);
            FRut[1] = String.valueOf(rut).substring(1, 4);
            FRut[2] = String.valueOf(rut).substring(4, 7);
            FRut[3] = String.valueOf(rut).substring(7, 8);
        }
        return String.valueOf(FRut[0] + "." + FRut[1] + "." + FRut[2] + "-" + FRut[3]);
    }
 
}
