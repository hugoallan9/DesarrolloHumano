/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author hugo
 */
public class PaneEtiquetas extends JPanel {
    //atributos de la clase
    JComboBox opcion = new JComboBox();
    JLabel[] etiqueta = new JLabel[5];
    
    PaneEtiquetas( ){
        
        initPane();
        
    }

    private void initPane() {
       opcion.addItem("Top 5");
       opcion.addItem("Ultimos 5 paises");
       opcion.addItem("Primeros 3 por Continente");
       opcion.addItem("Ultimos 3 por Continente");
       opcion.setBounds(100, 30, 200, 20);
       
       for ( int i = 0 ; i < 5 ; i++){
           etiqueta[i] = new JLabel();
           etiqueta[i].setBounds(100, 60 + 25*i, 300, 20);
           this.add(etiqueta[i]);
       }
       
       opcion.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent event){
                insertar(event);
            }

             private void insertar(ActionEvent event) {
                 int op = opcion.getSelectedIndex();
                 switch(op){
                     
                         
                         
                 }
                         
                 
             }
            
        });
       
       
       
       
       
       this.add(opcion);
       
       //Layout para este panel
       this.setLayout(null);
       
    }
    
    
    
}
