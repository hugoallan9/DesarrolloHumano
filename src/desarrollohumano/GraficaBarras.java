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
 * @author WinAcc
 */
public class GraficaBarras extends JPanel{
    
    float esperanza;
    float educacion;
    float pib;
    float idh;
    
    public GraficaBarras(float esperanza , float educacion, float pib, float idh){
        this.esperanza = esperanza;
        this.educacion = educacion;
        this.pib = pib;
        this.idh = idh;
    }
    
    /**
     *
     * @param esperanza
     * @param educacion
     * @param pib
     * @param idh
     */
    public void GraficaBarras(float esperanza , float educacion, float pib, float idh){
        this.esperanza = esperanza;
        this.educacion = educacion;
        this.pib = pib;
        this.idh = idh;
    }
    
    @Override
    @SuppressWarnings("empty-statement")
    public void paintComponent( Graphics g ){
        super.paintComponent(g);
        int ancho = getWidth();
        int alto =  getHeight();
        g.translate( this.getInsets().left,this.getInsets().top );
        g.setColor(Color.WHITE);
        g.fillRect(0,0,ancho,alto);
        g.setColor(Color.GRAY);
        float[] coor = {0f , 0f, 0f, 0f,0f};
        for( int i = 1 ; i <= 5 ; i++){
           coor[i-1] = alto - ( ((alto - 80)/5 ) * i );
            g.drawLine(30, (int) coor[i-1] , ancho - 20, (int) coor[i-1] );
            System.out.println(  ( alto - ( ((alto - 80)/5 ) * i )));
        }
        g.drawLine(40, 70, 40, alto - 60);
        
        //Etiquetas de numeros
        g.setColor(Color.BLACK);
        for( int i = 1 ; i <= 5 ; i++){
            float j = 0.25f * (i - 1);
            g.drawString(Float.toString(j),15 , alto - ( (( alto - 75 )/5) * i ));
        }
        
        //Etiquetas de Nombres
        String[] nameIndice = {"Esperanza" , "Educacion" , "PIB" , "IDH"};
       
        for(int i = 1 ; i < 5 ; i++){
            g.drawString(nameIndice[i - 1], ( ( ancho  )/5 ) * i, alto - alto/10  );
        }
        
        //Rectangulo Esperanza
        
        g.setColor(Color.BLUE);
        g.fillRect( (ancho - 30)/5 , calcularPixel(esperanza,coor) , 60 , (int) (coor[0] - calcularPixel(esperanza,coor)) );
        
        //Rectangulo Educacion
        g.setColor(Color.CYAN);
        g.fillRect( 2 * (ancho - 30)/5 , calcularPixel(educacion,coor) , 60 , (int) (coor[0] - calcularPixel(educacion,coor)) );
        
        //Rectangulo PIB
        g.setColor(Color.YELLOW);
        g.fillRect( 3 * (ancho - 30)/5 , calcularPixel(pib,coor) , 60 , (int) (coor[0] - calcularPixel(pib,coor)) );
        
        //Rectangulo IDH
         g.setColor(Color.ORANGE);
        g.fillRect( 4*(ancho - 30) /5 , calcularPixel(idh,coor) , 60 , (int) (coor[0] - calcularPixel(idh,coor)) );
        
        
        
        
    }
    
    int  calcularPixel(float valor , float[] co ){
        int pixel = (int) ( (co[4] - co[0]) * valor + co[0]);
        return pixel;
    }
    
}
