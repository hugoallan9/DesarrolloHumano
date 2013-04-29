/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

import java.awt.Color;
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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author WinAcc
 */
public class Busqueda extends JDialog{
    Pais[] pais = new Pais[25];
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
    public Busqueda(JFrame fr , Pais[] pai ){
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
         Reporte report = new Reporte();
         report.ordenNombres(pais, 0 , MenuPrincipal.contador );
         r = report.encontrarPais(pais, texto.getText().toUpperCase(), 0, MenuPrincipal.contador);
         if( r == -1 ){
             JOptionPane.showMessageDialog(this,"Pais no ha sido ingresado, Ingreselo primero" , "Error", JOptionPane.ERROR_MESSAGE);
         }else{
             System.out.println(r);
             esperanza.setText("El Indice de esperanza de vida es: " + pais[r].hope.getIndex());
             educacion.setText("El Indice de educacion es: " + pais[r].education.getIndex());
             pib.setText("El Indice del pib es: " + pais[r].productoInterno.getIndex());
             idh.setText("El Indice de esperanza de vida es: " + pais[r].desarrollo.getIndex());
             esperanza.setBounds(120, 130, 300,15);
             educacion.setBounds(120, 160, 300,15);
             pib.setBounds(120, 190, 300,15);
             idh.setBounds(120, 220, 300,15);
             JButton Eliminar = new JButton("Eliminar Pais");
             Eliminar.setBounds(200,290 , 200, 20);
             Eliminar.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent event){
                llamarEliminacion(event);
            }

                 
            
        });
             panelBusqueda.add(Eliminar);
             panelBusqueda.add(esperanza);
             panelBusqueda.add(educacion);
             panelBusqueda.add(pib);
             panelBusqueda.add(idh);
             panelBusqueda.repaint();
             panelGrafico.GraficaBarras(pais[r].hope.getIndex(),pais[r].education.getIndex(),
                pais[r].productoInterno.getIndex(),pais[r].desarrollo.getIndex());
             
             panelGrafico.repaint();
             
             
             
         }
        
    }
    
    private void llamarEliminacion(ActionEvent event) {
                     Reporte reporte = new Reporte();
                     System.out.println("El contador esta: " + MenuPrincipal.contador );
                     int res = JOptionPane.showConfirmDialog(this, "Esta seguro de querer eliminar este pais?");
                     System.out.println(res);
                     if(res == 0){
                     reporte.eliminarPais(pais, r, MenuPrincipal.contador);
                     MenuPrincipal.contador--;
                     }
                    
                     System.out.println("El contador esta: " + MenuPrincipal.contador );
                 }
    
}
