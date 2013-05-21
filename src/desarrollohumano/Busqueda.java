/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author WinAcc
 */
public class Busqueda extends JDialog{
    Lista pais = new Lista();
    JFrame ventanaPadre;
    
    //Elementos Graficos
     JTextField texto = new JTextField();
     JLabel eti = new JLabel("Ingrese el pais a buscar: ");
     JLabel esperanza = new JLabel();
     JLabel educacion = new JLabel();
     JLabel pib = new JLabel();
     JLabel idh = new JLabel();
     JPanel panelBusqueda  = new JPanel();
     GraficaBarras panelGrafico = new GraficaBarras(0f,0f,0f,0f);
     int r;
     
     
    
    /**
     *Constructor de la clase
     * @param fr
     * @param pai
     */
    public Busqueda(JFrame fr , Lista pai, boolean modal ){
        super(fr, modal);
        this.ventanaPadre = fr;
        this.pais = pai;
        initDialogo();
        this.setVisible(true);
        
    }
    
    private void  initDialogo(){
        setSize(1000,500);
        setLocationRelativeTo(null);
        // Creando los objetos Necesarios
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout( new BoxLayout( panelPrincipal , BoxLayout.X_AXIS));
        panelPrincipal.add(Box.createRigidArea(new Dimension(-90,100)));
        
        //Creando los paneles secundarios
        
        panelBusqueda.setLayout(null);
        TitledBorder border = new TitledBorder(
                                  new LineBorder(Color.blue),
                                  "Estadisticas de Pais",
                                  TitledBorder.CENTER,
                                  TitledBorder.BELOW_TOP);
        border.setTitleColor(Color.black);
        
        
        panelGrafico.setBorder(border);
        
       JButton buscar = new JButton("Buscar Pais");
        
        texto.setBounds(120,40,200,20);
        eti.setBounds(120,25,200,15);
        buscar.setBounds(120, 70, 200,15);
        buscar.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent event){
                llamarB(event);
            }
            
        });
        
        
        //Agregando los componentes al panel
        panelBusqueda.add(texto);
        panelBusqueda.add(eti);
        panelBusqueda.add(buscar);
        
        
        
        //Agregando los paneles
        this.getContentPane().add(panelPrincipal);
        panelPrincipal.add(panelBusqueda);
        panelPrincipal.add(panelGrafico);
        
    }
    
    private void llamarB(ActionEvent e ){
         Pais temp = pais.getNodo(texto.getText(), 2);
         String r = temp.getName();
         if( r.equalsIgnoreCase("") ){
             JOptionPane.showMessageDialog(this,"Pais no ha sido ingresado, Ingreselo primero" , "Error", JOptionPane.ERROR_MESSAGE);
         }else{
             System.out.println(r);
             esperanza.setText("El Indice de esperanza de vida es: " + temp.getIndice('0'));
             educacion.setText("El Indice de educacion es: " + temp.getIndice('1'));
             pib.setText("El Indice del pib es: " + temp.getIndice('2'));
             idh.setText("El Indice de Desarrollo Humano es: " + temp.getIndice('3'));
             esperanza.setBounds(120, 130, 300,15);
             educacion.setBounds(120, 160, 300,15);
             pib.setBounds(120, 190, 300,15);
             idh.setBounds(120, 220, 300,15);
             EscrituraTexto report = new EscrituraTexto("ReportePais.html", "Reporte Por Pais");
             report.escribirTabla(temp);
             JButton verReporte = new JButton("Ver en HTML");
             verReporte.setBounds(200, 250, 200, 20);
             verReporte.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed ( ActionEvent event ){
                     llamarHTML(event);
                 }
             });
             JButton Eliminar = new JButton("Eliminar Pais");
             Eliminar.setBounds(200,290 , 200, 20);
             Eliminar.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent event){
                llamarEliminacion(event);
            }

                 
            
        });
             panelBusqueda.add(Eliminar);
             panelBusqueda.add(verReporte);
             panelBusqueda.add(esperanza);
             panelBusqueda.add(educacion);
             panelBusqueda.add(pib);
             panelBusqueda.add(idh);
             panelBusqueda.repaint();
             panelGrafico.GraficaBarras(temp.getIndice('0'), temp.getIndice('1'),
                temp.getIndice('2'), temp.getIndice('3'));
             
             panelGrafico.repaint();
             
             
             
         }
        
    }
    
    private void llamarEliminacion(ActionEvent event) {
                     int res = JOptionPane.showConfirmDialog(this, "Esta seguro de querer eliminar este pais?");
                     if(res == 0){
                         Pais temp = pais.getNodo(texto.getText(), 2);
                         pais.eliminarNodo(temp);
                        
                     }
                    
                     System.out.println("El contador esta: " + Menu.contador );
                 }
    
    private void llamarHTML( ActionEvent event){
        try { 
            File file = new File("ReportePais.html");
            Desktop desk ;
            desk = Desktop.getDesktop();
            desk.open(file);
        } catch (IOException ex) {
            Logger.getLogger(Busqueda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
