/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author HugoAllan
 */
public class InEstimadores extends JDialog{
    JFrame ventanaPadre;
    JPanel ingreso = new JPanel();
    Pais[] pais;
    JTextField[] indicador = new JTextField[4];
    JLabel[] etiqueta = new JLabel[4];
    JTextField buscar = new JTextField();
    JButton botonIngreso = new JButton("Aceptar");
    int r;
    
    InEstimadores(JFrame fr , Pais[] pai){
        this.ventanaPadre = fr;
        this.pais = pai;
        initDialogo();
        this.setVisible(true);
    }
    
    private void initDialogo(){
        setSize(400,450);
        setLocationRelativeTo(ventanaPadre);
        // Creando los objetos Necesarios
        JPanel panelPrincipal = new JPanel();
        Dimension minSize = new Dimension(-32, 0);
        Dimension prefSize = new Dimension(-32, 0);
        Dimension maxSize = new Dimension(64, 0);
        panelPrincipal.setLayout( new BoxLayout( panelPrincipal , BoxLayout.Y_AXIS));
        
        panelPrincipal.add(new Box.Filler(minSize, prefSize, maxSize));
        
        //construyendo el panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        
        //Boton
        JButton aceptar = new JButton("Ingresar valores");
        aceptar.setBounds(120,105,200,20);
        aceptar.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent event){
                llamarIngreso(event);
            }
        });
        
        botonIngreso.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent event){
                llamarIndex(event);
            }

           
        });
        
        buscar.setBounds(120,80,200,20);
        
        //Etiqueta
        JLabel eti1 = new JLabel("Ingrese el pais: ");
        eti1.setBounds(20,80, 120,15);
        
      
        
        
        ingreso.setLayout(null);
        
      
        
        
        //agragando al panel
        panel.add(eti1);
        panel.add(buscar);
        panel.add(aceptar);
        
        //Agregando panel
        panelPrincipal.add(panel);
        panelPrincipal.add(ingreso);
        this.add(panelPrincipal);
        
    }
    
     private void llamarIngreso(ActionEvent event) {
         Reporte report = new Reporte();
         report.ordenNombres(pais, 0 , MenuPrincipal.contador );
         r = report.encontrarPais(pais, buscar.getText().toUpperCase(), 0, MenuPrincipal.contador);
         if( r == -1 ){
             JOptionPane.showMessageDialog(this,"Pais no ha sido ingresado, Ingreselo primero" , "Error", JOptionPane.ERROR_MESSAGE);
         }else{
               //Inicializando etiquetas
                for(int i = 0 ; i < 4 ; i++ ){
                    etiqueta[i] = new JLabel();
                    indicador[i] = new JTextField();
                }
              
                
             for ( int i = 0 ; i < 4 ; i++){
                    etiqueta[i].setBounds(40, 1 + 40 * i , 230, 20);
                    indicador[i].setBounds(40, 20 + 40 * i , 230, 15);
                    indicador[i].setText(String.valueOf(pais[r].valores[i]));
                    ingreso.add(etiqueta[i]);
                    ingreso.add(indicador[i]);
             }
             etiqueta[0].setText("Ingrese el estimador de esperanza");
             etiqueta[1].setText("Ingrese el estimador de alfetizacion");
             etiqueta[2].setText("Ingrese el estimador de matriculacion");
             etiqueta[3].setText("Ingrese el estimador del PIB");
             
             botonIngreso.setBounds(100, 165, 200, 20);
             ingreso.add(botonIngreso);
             ingreso.repaint();
         }
               
     }
     
      private void llamarIndex(ActionEvent event) {
          
          loop1:
                for(int i = 0 ; i < 4 ; i++){
                    if(!indicador[i].getText().isEmpty()){
                        switch(i){
                            case 0:
                            if(Float.parseFloat(indicador[0].getText()) > pais[0].hope.VALOR_MAXIMO 
                                || Float.parseFloat(indicador[0].getText()) < pais[0].hope.VALOR_MINIMO ) {
                                JOptionPane.showMessageDialog(this, "No ha respetado los limites de los indices", "error", 
                                    JOptionPane.ERROR_MESSAGE);
                                break loop1;
                            }else{
                                pais[r].valores[0] = Float.parseFloat(indicador[0].getText());
                                pais[r].hope.calcularIndice(pais[0].hope.VALOR_MAXIMO, pais[0].hope.VALOR_MINIMO,
                                            Float.parseFloat(indicador[0].getText()));
                                System.out.println(pais[r].hope.getIndex());
                            }
                            
                            case 1:
                                if(Float.parseFloat(indicador[1].getText()) > pais[0].education.VALOR_MAXIMO 
                                    || Float.parseFloat(indicador[1].getText()) < pais[0].education.VALOR_MINIMO ) {
                                    JOptionPane.showMessageDialog(this, "No ha respetado los limites de los indices", "error", 
                                    JOptionPane.ERROR_MESSAGE);
                                    break loop1;
                                }else{
                                pais[r].valores[1] = Float.parseFloat(indicador[1].getText());
                                pais[r].education.calcularIndice(pais[0].education.VALOR_MAXIMO, 
                                            pais[0].education.VALOR_MINIMO, Float.parseFloat(indicador[1].getText()),
                                            Float.parseFloat(indicador[2].getText()));
                                    System.out.println(pais[r].education.getIndex());
                             }
                           
                            case 2: 
                                if(Float.parseFloat(indicador[2].getText()) > pais[0].education.VALOR_MAXIMO 
                                    || Float.parseFloat(indicador[2].getText()) < pais[0].education.VALOR_MINIMO ) {
                                    
                                    JOptionPane.showMessageDialog(this, "No ha respetado los limites de los indices", "error", 
                                    JOptionPane.ERROR_MESSAGE);
                                    
                                    break loop1;
                                }else{
                                pais[r].valores[2] = Float.parseFloat(indicador[2].getText());
                                pais[r].education.calcularIndice(pais[0].education.VALOR_MAXIMO, 
                                            pais[0].education.VALOR_MINIMO, Float.parseFloat(indicador[1].getText()),
                                            Float.parseFloat(indicador[2].getText()));
                                    System.out.println(pais[r].education.getIndex());
                             }
                                
                            case 3:
                                if(java.lang.Math.log10( Float.parseFloat(indicador[3].getText())) >  java.lang.Math.log10(40000)
                                    || java.lang.Math.log10(Float.parseFloat(indicador[3].getText())) < pais[0].productoInterno.VALOR_MINIMO ) {
                                    System.out.println("++++++++++++++++++++++");
                                    System.out.println(indicador[i].getText());
                                    JOptionPane.showMessageDialog(this, "No ha respetado los limites de los indices  3", "error", 
                                    JOptionPane.ERROR_MESSAGE);
                                    break loop1;
                                }else{
                                 pais[r].valores[3] = Float.parseFloat(indicador[3].getText());
                                 pais[r].productoInterno.calcularIndice(pais[0].productoInterno.VALOR_MAXIMO,
                                            pais[0].productoInterno.VALOR_MINIMO, (float) java.lang.Math.log10(Float.parseFloat(indicador[3].getText())));
                                  //Finalmente Calculando el IDH
                                  pais[r].desarrollo.calcularIDH(pais[r].hope.getIndex(), pais[r].education.getIndex(),
                                         pais[r].productoInterno.getIndex());
                                  JOptionPane.showMessageDialog(this, "Estimadores ingresados!", "exito", JOptionPane.INFORMATION_MESSAGE);
                                  this.setVisible(false);
                                  ventanaPadre.setVisible(true);
                                  break loop1;
                                 
                              }
                           }
                        }else{
                            JOptionPane.showMessageDialog(this, "No ha llenado los campos requeridos", "error", 
                                JOptionPane.ERROR_MESSAGE);
                                break loop1;
                    }
                }
          
         
                                         
            }
    
}
