/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
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
    JLabel[] etiqueta = new JLabel[6];
    Lista pais = new Lista();
    int boton;
    
    PaneEtiquetas(Lista pais ){
        this.pais = (Lista) pais.clone();
        initPane();
        
    }

    public void initPane() {
       opcion.addItem("Top 5");
       opcion.addItem("Ultimos 5 paises");
       opcion.addItem("Primeros 3 por Continente");
       opcion.addItem("Ultimos 3 por Continente");
       opcion.setBounds(100, 30, 200, 20);
       
       for ( int i = 0 ; i < 6 ; i++){
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
        Reporte report;
        Lista sub = new Lista();
                
                 accionEstadistica();
                         
                 
             }
             
             
            
        });
       
       
       this.add(opcion);
       
       //Layout para este panel
       this.setLayout(null);
       
       
       
       
       
    }
    
    public void accionEstadistica(){
        int op = opcion.getSelectedIndex();
        Reporte report;
        Lista sub = new Lista();
                 switch(op){
                     case 0:
                         boton = 0;
                         int year = Integer.parseInt(JOptionPane.showInputDialog("¿De que año?"));
                         sub = pais.getSubList(year);
                         report = new Reporte( sub );
                        
                         if ( sub.getPosicion() != 0 ){
                             report.ordenarLista(1, sub.getPosicion() , 2 );
                             sub.imprimirLista();
                             etiqueta[0].setText(String.format("%-5s%-15s%-12s%-10s", "ID" , "NOMBRE" ,
                                     "IDH" , "PUESTO"));
                             //Creando el html
                             EscrituraTexto es = new EscrituraTexto("top5.html","Top 5 Año: " + year);
                             es.escribirComparacion(report.getReporte() ,0 );
                            
                            
                             
                             //limpiando las etiquetas:
                             for( int i = 1 ; i < 6 ; i++){
                                 etiqueta[i].setText("");
                             }
                             
                             for( int i = 1 ; i <= sub.getPosicion(); i++ ){
                                 etiqueta[i].setText(String.format("%-5d%-15s%-15f%-10d", sub.accesoAleatorio(i).getID(), sub.accesoAleatorio(i).getName() 
                                          , sub.accesoAleatorio(i).getIndice('3') , i )  );
                                 
                             }
                             this.repaint();

                         }else{
                             JOptionPane.showMessageDialog( this, "No ha ingresado ningún pais para el año " +year);
                         }
                         break;
                     case 1:
                         boton = 1;
                         year = Integer.parseInt(JOptionPane.showInputDialog("¿De que año?"));
                         sub = pais.getSubList(year);
                         report = new Reporte( sub );
                        
                         if ( sub.getPosicion() != 0 ){
                             report.ordenarLista(1, sub.getPosicion() , 1 );
                             sub.imprimirLista();
                             etiqueta[0].setText(String.format("%-5s%-15s%-12s%-10s", "ID" , "NOMBRE" ,
                                     "IDH" , "PUESTO"));
                             //Creando el html
                             EscrituraTexto es = new EscrituraTexto("Notop5.html","Top 5 Año: " + year);
                             es.escribirComparacion(report.getReporte() , report.getReporte().getPosicion() +1  );
                             
                             
                             //limpiando las etiquetas:
                             for( int i = 1 ; i < 6 ; i++){
                                 etiqueta[i].setText("");
                             }
                             
                             for( int i = 1 ; i <= sub.getPosicion(); i++ ){
                                 etiqueta[i].setText(String.format("%-5d%-15s%-15f%-10d", report.getReporte().accesoAleatorio(i).getID(), report.getReporte().accesoAleatorio(i).getName() 
                                          , report.getReporte().accesoAleatorio(i).getIndice('3') , i )  );
                                 
                             }
                             this.repaint();

                         }else{
                             JOptionPane.showMessageDialog( this, "No ha ingresado ningún pais para el año " +year);
                         }
                         break;
                         
                     case 2:
                         boton = 2;
                         year = Integer.parseInt(JOptionPane.showInputDialog("¿De que año?"));
                         String continente = JOptionPane.showInputDialog("¿De que continente?");
                         sub = pais.getSubList(year);
                         report = new Reporte( sub );
                        
                         if ( sub.getPosicion() != 0 ){
                             report.ordenarLista(1, sub.getPosicion() , 2 );
                             report.ordenContinente(continente);
                             //sub.imprimirLista();
                             etiqueta[0].setText(String.format("%-5s%-15s%-12s%-10s", "ID" , "NOMBRE" ,
                                     "IDH" , "PUESTO"));
                             //Creando el html
                             EscrituraTexto es = new EscrituraTexto("top3.html","Top 3 Año: " + year);
                             Lista nueva = report.getReporteContinental();
                             nueva.imprimirLista();
                             es.escribirComparacion( report.getReporteContinental() , 0 );
                             //agregando el boton
                            
                
                             
                             //limpiando las etiquetas:
                             for( int i = 1 ; i < 6 ; i++){
                                 etiqueta[i].setText("");
                             } 
                             
                              for( int i = 1 ;  i <= report.getReporteContinental().getPosicion() ; i++ ){
                                 etiqueta[i].setText(String.format("%-5d%-15s%-15f%-10d", report.getReporteContinental().accesoAleatorio(i).getID(), report.getReporteContinental().accesoAleatorio(i).getName() 
                                          , report.getReporteContinental().accesoAleatorio(i).getIndice('3') , i )  );
                                 
                             }

                             this.repaint();
                  
                         }else{
                             JOptionPane.showMessageDialog( this, "No ha ingresado ningún pais para el año " +year);
                         }
                         break;
                         
                    case 3:
                         boton = 3;
                         year = Integer.parseInt(JOptionPane.showInputDialog("¿De que año?"));
                         continente = JOptionPane.showInputDialog("¿De que continente?");
                         sub = pais.getSubList(year);
                         report = new Reporte( sub );
                        
                         if ( sub.getPosicion() != 0 ){
                             report.ordenarLista(1, sub.getPosicion() , 1 );
                             report.ordenContinente(continente);
                             sub.imprimirLista();
                             etiqueta[0].setText(String.format("%-5s%-15s%-12s%-10s", "ID" , "NOMBRE" ,
                                     "IDH" , "PUESTO"));
                             //Creando el html
                             EscrituraTexto es = new EscrituraTexto("Notop3.html","No Top 3 Año: " + year);
                             Lista nueva =  report.getReporteContinental();
                             nueva.imprimirLista();
                             es.escribirComparacion( report.getReporteContinental() , nueva.getPosicion() + 1 );
                             //agregando el boton
                            
                
                             
                             //limpiando las etiquetas:
                             for( int i = 1 ; i < 6 ; i++){
                                 etiqueta[i].setText("");
                             }
                             
                             for( int i = 1 ;  i <= report.getReporteContinental().getPosicion() ; i++ ){
                                 etiqueta[i].setText(String.format("%-5d%-15s%-15f%-10d", report.getReporteContinental().accesoAleatorio(i).getID(), report.getReporteContinental().accesoAleatorio(i).getName() 
                                          , report.getReporteContinental().accesoAleatorio(i).getIndice('3') , i )  );
                                 
                             }
                             this.repaint();
                  
                         }else{
                             JOptionPane.showMessageDialog( this, "No ha ingresado ningún pais para el año " +year);
                         }
                         break;
                         
                         
                 }
                 
                  //agregando el boton
                             JButton html = new JButton("Ver en HTML");
                             html.setBounds(120, 230, 150, 20);
                             html.addActionListener( new ActionListener() {
                                 @Override
                                 public void actionPerformed( ActionEvent event){
                                llamarNavegador(event);
                                }
            
                            });
                             this.add(html);
    }
    
    private void llamarNavegador(ActionEvent e){
        switch(boton){
            case 0:
                try { 
                   File file = new File("top5.html");
                    Desktop desk ;
                    desk = Desktop.getDesktop();
                    desk.open(file);
           
            
                } catch (IOException ex) {
                    Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                
                
            case 1:
                try { 
                    File file = new File("Notop5.html");
                    Desktop desk ;
                    desk = Desktop.getDesktop();
                    desk.open(file);
                } catch (IOException ex) {
                    Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                
            case 2:
                 try { 
                    File file = new File("top3.html");
                    Desktop desk ;
                    desk = Desktop.getDesktop();
                    desk.open(file);
                } catch (IOException ex) {
                    Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                
                
            case 3:
                try { 
                    File file = new File("Notop3.html");
                    Desktop desk ;
                    desk = Desktop.getDesktop();
                    desk.open(file);
                } catch (IOException ex) {
                    Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                
                
                
        }
         
    }
    
    private void llamarNavegador2(ActionEvent e){
         
    }
    
        private void llamarNavegador3(ActionEvent e){
        
    }
    
    
}
