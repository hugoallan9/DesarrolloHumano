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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author hugo
 */
public class Comparacion extends JDialog {
    
    Pais[] pais = new Pais[25];
    JFrame ventanaPadre = new JFrame();
    Grafica2Barras panelGrafico;
    JComboBox pais1 = new JComboBox();
    JComboBox pais2 = new JComboBox();
    JLabel etiqueta[] =new JLabel[10];
    int b1,b2;
    
    
    Comparacion(JFrame fr , Pais[] pais){
        this.panelGrafico = new Grafica2Barras(0f,0f,0f,0f,0f,0f,0f,0f);
        this.pais = pais;
        this.ventanaPadre = fr;
        this.setVisible(true);
        initDialogo();
    }
    

    private void initDialogo() {
        setSize(1000,500);
        setLocationRelativeTo(null);
        // Creando los objetos Necesarios
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout( new BoxLayout( panelPrincipal , BoxLayout.X_AXIS));
        panelPrincipal.add(Box.createRigidArea(new Dimension(-250,100)));
        
        final JPanel panelComparativa = new JPanel();
        panelComparativa.setLayout(null);
     
        
        //Titulo para panel grafico
        TitledBorder border = new TitledBorder(
                                  new LineBorder(Color.blue),
                                  "Comparativa de Paises",
                                  TitledBorder.CENTER,
                                  TitledBorder.BELOW_TOP);
        border.setTitleColor(Color.black);
        
        panelGrafico.setBorder(border);
        
        //Inicializando los combo
        for (int i = 0 ;  i < MenuPrincipal.contador ; i++){
            pais1.addItem(pais[i].getName());
            pais2.addItem(pais[i].getName());
            
        }
        
        pais1.setBounds(280,40,250,20);
        pais2.setBounds(280,80,250,20);
        
        for (int i = 0 ; i < 10 ; i++){
            etiqueta[i] = new JLabel();
            etiqueta[i].setBounds(280, 110 + 25 * i, 250, 18);
        }
        pais1.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent event){
                insertarP1(event);
            }

             private void insertarP1(ActionEvent event) {
                 b1 = pais1.getSelectedIndex();
                 //pais2.removeItemAt(b1);    
                 etiqueta[0].setText(pais1.getSelectedItem().toString());
                 etiqueta[1].setText("El indice de esperanza es: " + 
                         pais[b1].hope.getIndex());
                 etiqueta[2].setText("El indice de educacion es: " + 
                         pais[b1].education.getIndex());
                 etiqueta[3].setText("El indice del pib es: " + 
                         pais[b1].productoInterno.getIndex());
                 etiqueta[4].setText("El indice de idh es: " + 
                         pais[b1].desarrollo.getIndex());
                 for (int i = 0 ; i < 5 ; i++)
                     panelComparativa.add(etiqueta[i]);
                 panelComparativa.repaint();
                 panelGrafico.Grafica2Barras(pais[b1].hope.getIndex(), 
                         pais[0].hope.getIndex(), pais[b1].education.getIndex(),
                         pais[0].education.getIndex(),pais[b1].productoInterno.getIndex(),
                         pais[0].productoInterno.getIndex(),
                         pais[b1].desarrollo.getIndex(), pais[0].desarrollo.getIndex());
                 panelGrafico.repaint();
                 
             }
            
        });
        
          pais2.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent event){
                insertarP2(event);
            }

             private void insertarP2(ActionEvent event) {
                 b2 = pais2.getSelectedIndex();
                 
                     
                 etiqueta[5].setText(pais2.getSelectedItem().toString());
                 etiqueta[6].setText("El indice de esperanza es: " + 
                         pais[b2].hope.getIndex());
                 etiqueta[7].setText("El indice de educacion es: " + 
                         pais[b2].education.getIndex());
                 etiqueta[8].setText("El indice del pib es: " + 
                         pais[b2].productoInterno.getIndex());
                 etiqueta[9].setText("El indice de idh es: " + 
                         pais[b2].desarrollo.getIndex());
                 for (int i = 5 ; i < 10 ; i++)
                     panelComparativa.add(etiqueta[i]);
                 panelComparativa.repaint();
                 panelGrafico.Grafica2Barras(pais[b1].hope.getIndex(), 
                         pais[b2].hope.getIndex(), pais[b1].education.getIndex(),
                         pais[b2].education.getIndex(),pais[b1].productoInterno.getIndex(),
                         pais[b2].productoInterno.getIndex(),
                         pais[b1].desarrollo.getIndex(), pais[b2].desarrollo.getIndex());
                 panelGrafico.repaint();
             }
            
        });
          
        //Etiquetas
          JLabel p1 = new JLabel("Seleccione el primer pais");
          p1.setBounds(280,20,250,18);
          JLabel p2 = new JLabel("Seleccione pais de comparacion");
          p2.setBounds(280,60, 250,18);
        //agregando componentes al panel
          panelComparativa.add(p1);
          panelComparativa.add(pais1);
          panelComparativa.add(p2);
          panelComparativa.add(pais2);
          
        
        //agregando paneles
        this.getContentPane().add(panelPrincipal);
        panelPrincipal.add(panelComparativa);
        panelPrincipal.add(panelGrafico);
        
    }
    
    
}
