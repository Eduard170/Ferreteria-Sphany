/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionCombo;
import javax.swing.JComboBox;

/**
 *
 * @author Judith
 */
public class CtrlCombo {
     public ConexionCombo BD = new ConexionCombo();
     
      public void llenarCombo(JComboBox cbo, String consulta, int columna)
    {
        try 
        {
            //Siempre que queremos llenar algo tenemos que limpiarlo
            cbo.removeAllItems();
            cbo.addItem("Seleccione ID");
            
            //Crea un objeto de tipo Statement para enviar consultas a la BD
            //el cual devuelve un Statement
            BD.st = BD.cnx.createStatement();
            //Ejecutamos el SQL
            //el cual devuelve un ResultSet (objeto en forma de tabla)
            BD.rs = BD.st.executeQuery(consulta);
            
            //Recorremos el ResultSet, nos devuelve verdadero cuando tiene un registro
            while(BD.rs.next())
            {
                //Al método getString le pasamos como argumento el nombre de la columna
                //o número de la columna de la tabla que queremos que nos devuelva.
                cbo.addItem(BD.rs.getString(columna));
            }
            
            //Para que no se seleccione ninguno en el combobox
            cbo.setSelectedIndex(0);
            
            //Limpiamos la memoria
            BD.rs.close();
            BD.st.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
