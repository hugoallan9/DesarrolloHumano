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
    Lista pais = new Lista();
    JFrame ventanaPadre;
    
    
    Estadistica(JFrame fr , Lista pais, boolean modal){
        super(fr, modal);
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
