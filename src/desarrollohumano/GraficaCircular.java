/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Hugo Allan Garcia 200714466
 */
public class GraficaCircular extends JPanel {
    Pais[] pais = new Pais[25];
    Reporte reporte = new Reporte();
    
    GraficaCircular(Pais[] pais){
        this.pais = pais;
        reporte.contadorPaises(pais, MenuPrincipal.contador);
        reporte.conversionAngulos();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int ancho = getWidth();
        int alto =  getHeight();
        g.translate( this.getInsets().left,this.getInsets().top );
        
        
        //Dibujando la grafica circular
        int posicion = 0;
        g.setColor(Color.RED);
        g.fillArc(40, 40 , 300, 300 , 0 , reporte.angulos[0]);
        g.fillRect(360, 40, 10, 10);
        g.setColor(Color.BLACK);
        g.drawString("Muy Alto", 380 , 50);
        g.drawString(String.valueOf(reporte.rendimiento[0]), 440, 50);
        posicion = posicion + reporte.angulos[0];
        
        
        g.setColor(Color.BLUE);
        g.fillArc(40, 40 , 300, 300 , posicion , reporte.angulos[1]);
        g.fillRect(360, 60, 10, 10);
        g.setColor(Color.BLACK);
        g.drawString("Alto", 380 , 70);
        g.drawString(String.valueOf(reporte.rendimiento[1]), 440, 70);
        posicion = posicion + reporte.angulos[1];
        
        
        g.setColor(Color.GREEN);
        g.fillArc(40, 40 , 300, 300 , posicion , reporte.angulos[2]);
        g.fillRect(360, 80, 10, 10);
        g.setColor(Color.BLACK);
        g.drawString("Medio", 380 , 90);
        g.drawString(String.valueOf(reporte.rendimiento[2]), 440, 90);
        posicion = posicion + reporte.angulos[2];
        
        g.setColor(Color.YELLOW);
        g.fillArc(40, 40 , 300, 300 , posicion , reporte.angulos[3]);
        g.fillRect(360, 100, 10, 10);
        g.setColor(Color.BLACK);
        g.drawString("Bajo", 380 , 110);
        g.drawString(String.valueOf(reporte.rendimiento[3]), 440, 110);
        
        //codigo basura
        for (int i = 0 ; i < 4 ; i++){
            System.out.println(reporte.rendimiento[i]);
        }
        
        for (int i = 0 ; i < 4 ; i++){
            System.out.println(reporte.angulos[i]);
        }
        
        
    }
    
 
    
    
}
