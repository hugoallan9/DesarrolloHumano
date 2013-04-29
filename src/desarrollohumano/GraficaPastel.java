/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Hugo Allan Garcia 200714466
 */
public class GraficaPastel extends JDialog{
    JFrame ventanaPadre;
    Pais[] pais = new Pais[25];
    
    GraficaPastel(JFrame fr , Pais[] pais){
        this.ventanaPadre = fr;
        this.pais = pais;
        this.setVisible(true);
        initDialogo();
    }

    private void initDialogo() {
     setSize(600,450);
     setLocationRelativeTo(ventanaPadre);
     GraficaCircular pi = new GraficaCircular(pais);
     this.add(pi);
    }
    
    
}
