/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author hugo
 */
public class Estadistica extends JDialog{
    Pais[] pais = new Pais[25];
    JFrame ventanaPadre;
    
    
    Estadistica(JFrame fr , Pais[] pais){
        this.pais = pais;
        this.ventanaPadre = fr;
        this.setVisible(true);
        initDialogo();
    }

    private void initDialogo() {
        setSize(400,400);
        setLocationRelativeTo(ventanaPadre);
        PaneEtiquetas panel = new PaneEtiquetas(pais);
        this.getContentPane().add(panel);
        
    }
    
    
    
}
