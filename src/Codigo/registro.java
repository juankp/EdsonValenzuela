
package Codigo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.SimpleDateFormat;
import java.util.Date;



public class registro extends cliente{
   
    //funcion que entrega la fecha actual en formato yyyyMMdd
    
    public static String getFechaActual() {
    Date ahora = new Date();
    SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
    return formateador.format(ahora);
    }
    
    //verificar solo palabras
   public static boolean esPalabra(String palabra)
    {
        for(int i = 0; i < palabra.length(); i++)
        {
            if(!((palabra.charAt(i) > 64 && palabra.charAt(i) < 91) ||
    (palabra.charAt(i) > 96 && palabra.charAt(i) < 123)))
            return false;
        }
        return true;
    }
    
    //ingreso de un nuevo cliente a la base de datos
    
    public static void ingreso() throws ClassNotFoundException, IOException
    {
       try
       {
        cliente nuevo = new cliente();
        String name;
        Integer rut;
        nuevo.nombre = "";
        nuevo.rut = "";
         //lee el nombre y lo convierte a mayuscula para mayor orden
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el nombre: ");
        nuevo.nombre = (in.readLine()).toUpperCase();
        System.out.println("Ingrese el rut: ");
        nuevo.rut = (in.readLine()).toUpperCase();
        
        while(esPalabra(nuevo.nombre)== false) //verifica si el nombre tiene solo letras
        {
             System.out.println("Lo siento, la palabra contiene caracteres no validos");
             System.out.println("                         ");
            System.out.println("Ingrese el nombre nuevamente: ");
            nuevo.nombre = (in.readLine()).toUpperCase();
        }

        name = nuevo.nombre;
        rut = Integer.parseInt(nuevo.rut);
        
        Class.forName("org.apache.derby.jdbc.ClientDriver"); //prueba es base de datos

        
            String url = "jdbc:derby://localhost/Edson;create=true;user=edson;password=edson";
            Connection conn = DriverManager.getConnection(url);
            conn.setSchema("EDSON");
            Statement s = conn.createStatement();
            s.execute("INSERT INTO CLIENTE (NOMBRE,RUT) VALUES ('"+name+"','"+rut+"')");
            ResultSet rs = s.getResultSet();

//            while (rs.next()) {
//                System.out.println(rs.getString("CLIENTE") + ": " + rs.getString("REGISTROS"));
//            }

            conn.close();
        }

         catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
            

        }
      }
    
    
    
     
        
    
    
}
    

