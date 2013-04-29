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
    Pais[] pais = new Pais[25];
    Reporte r = new Reporte();
    JLabel[] etiqueta = new JLabel[5];
    
    PaneEtiquetas(Pais[] pais){
        this.pais = pais;
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
                     case 0:
                         r.ordenMayorIDH(pais, 0 , MenuPrincipal.contador - 1);
                         if(MenuPrincipal.contador <= 5){
                             for(int i = 0 ; i < MenuPrincipal.contador ; i++){
                                 etiqueta[i].setText(i + 1 + " " + pais[i].getName() + " " + 
                                         pais[i].desarrollo.getIndex());
                             }
                         }else{
                             for(int i = 0 ; i < 5 ; i++){
                                 etiqueta[i].setText(i + 1 + " " + pais[i].getName() + " " + 
                                         pais[i].desarrollo.getIndex());
                             }
                         }
                         break;
                     case 1:
                         r.ordenIDH(pais, 0 , MenuPrincipal.contador - 1);
                         if(MenuPrincipal.contador <= 5){
                             for(int i = 0 ; i < MenuPrincipal.contador ; i++){
                                 etiqueta[i].setText(i + 1 + " " + pais[i].getName() + " " + 
                                         pais[i].desarrollo.getIndex());
                             }
                         }else{
                             for(int i = 0 ; i < 5 ; i++){
                                 etiqueta[i].setText(i + 1 + " " + pais[i].getName() + " " + 
                                         pais[i].desarrollo.getIndex());
                             }
                         }
                         break;
                     
                     case 2:
                         r.ordenMayorIDH(pais, 0, MenuPrincipal.contador - 1);
                         int j = 1;
                         String continente = JOptionPane.showInputDialog("Cual es el continente?");
                         int[] posicion = new int[3];
                         posicion[0] = -1;
                         posicion[1] = -1;
                         posicion[2] = -1;
                         posicion[0] = r.busquedaSecuencial(pais, continente, 0 , MenuPrincipal.contador);
                         if(posicion[0] != -1){
                         do{   
                             posicion[j] = r.busquedaSecuencial(pais, continente, posicion[j-1] + 1, MenuPrincipal.contador );
                             System.out.println( "La posicion es "+ posicion[j]);
                             j++;
                         }while( j < 3 && posicion[j - 1] != -1);
                         }
                         
                         for(int i = 0 ; i < 3 ; i++){
                             if(posicion[i] != -1){
                                 etiqueta[i].setText(i + 1 + " " + pais[posicion[i]].getName() + " " +
                                         pais[posicion[i]].getContinent() + " " + pais[posicion[i]].desarrollo.getIndex() );
                                 System.out.println( "La posicion es "+ posicion[i]);
                             }else{
                                 etiqueta[i].setText(null);
                             }
                         }
                         etiqueta[3].setText(null);
                         etiqueta[4].setText(null);
                         
                         break;
                     case 3:
                         r.ordenIDH(pais, 0, MenuPrincipal.contador - 1);
                         j = 1;
                         continente = JOptionPane.showInputDialog("Cual es el continente?");
                         int[] pos = new int[3];
                         pos[0] = -1;
                         pos[1] = -1;
                         pos[2] = -1;
                         pos[0] = r.busquedaSecuencial(pais, continente, 0 , MenuPrincipal.contador);
                         if(pos[0] != -1){
                         do{   
                             pos[j] = r.busquedaSecuencial(pais, continente, pos[j-1] + 1, MenuPrincipal.contador );
                             System.out.println( "La posicion es "+ pos[j]);
                             j++;
                         }while( j < 3 && pos[j - 1] != -1);
                         }
                         
                         for(int i = 0 ; i < 3 ; i++){
                             if(pos[i] != -1){
                                 etiqueta[i].setText(i + 1 + " " + pais[pos[i]].getName() + " " +
                                         pais[pos[i]].getContinent() + " " + pais[pos[i]].desarrollo.getIndex() );
                                 System.out.println( "La posicion es "+ pos[i]);
                             }else{
                                 etiqueta[i].setText(null);
                             }
                         }
                         etiqueta[3].setText(null);
                         etiqueta[4].setText(null);
                         
                         break;
                         
                         
                 }
                         
                 
             }
            
        });
       
       
       
       
       
       this.add(opcion);
       
       //Layout para este panel
       this.setLayout(null);
       
    }
    
    
    
}
