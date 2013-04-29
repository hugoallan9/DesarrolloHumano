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
public class Grafica2Barras extends JPanel{
    
    float esperanza, esperanza2, educacion, educacion2,
            pib, pib2, idh, idh2;
    
    /**
     *
     * @param esperanza
     * @param esperanza2
     * @param educacion
     * @param educacion2
     * @param pib
     * @param pib
     * @param idh
     * @param idh2
     */
    public Grafica2Barras(float esperanza , float esperanza2, float educacion, 
            float educacion2, float pib,  float pib2
            , float idh , float idh2){
        this.esperanza = esperanza;
        this.esperanza2 = esperanza2;
        this.educacion = educacion;
        this.educacion2 = educacion2;
        this.pib = pib;
        this.pib2 = pib2;
        this.idh = idh;
        this.idh2 = idh2;
    }
    
    /**
     *
     * @param esperanza
     * @param esperanza2
     * @param educacion
     * @param educacion2
     * @param pib
     * @param pib2
     * @param idh
     * @param idh2
     */
    public void Grafica2Barras(float esperanza , float esperanza2, float educacion, 
            float educacion2, float pib,  float pib2
            , float idh , float idh2){
        this.esperanza = esperanza;
        this.esperanza2 = esperanza2;
        this.educacion = educacion;
        this.educacion2 = educacion2;
        this.pib = pib;
        this.pib2 = pib2;
        this.idh = idh;
        this.idh2 = idh2;
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
            g.drawString(nameIndice[i - 1], ( ( ancho )/5 ) * i, alto - alto/10  );
        }
        
        //Rectangulo Esperanza
        
        g.setColor(Color.BLUE);
        g.fillRect( (ancho )/5 , calcularPixel(esperanza,coor) , ancho/20 , (int) (coor[0] - calcularPixel(esperanza,coor)) );
        g.setColor(Color.ORANGE);
        g.fillRect( (ancho)/5 + ancho/20, calcularPixel(esperanza2,coor) , ancho/20 , (int) (coor[0] - calcularPixel(esperanza2,coor)) );
        
        //Rectangulo Educacion
        g.setColor(Color.BLUE);
        g.fillRect( 2 * (ancho )/5 , calcularPixel(educacion,coor) , ancho/20 , (int) (coor[0] - calcularPixel(educacion,coor)) );
        g.setColor(Color.ORANGE);
        g.fillRect( 2 * (ancho)/5 + ancho/20 , calcularPixel(educacion2,coor) , ancho/20 , (int) (coor[0] - calcularPixel(educacion2,coor)) );
        
        //Rectangulo PIB
        g.setColor(Color.BLUE);
        g.fillRect( 3 * (ancho )/5 , calcularPixel(pib,coor) , ancho/20 , (int) (coor[0] - calcularPixel(pib,coor)) );
        g.setColor(Color.ORANGE);
        g.fillRect( 3 * (ancho )/5 + ancho/20 , calcularPixel(pib2,coor) , ancho/20 , (int) (coor[0] - calcularPixel(pib2,coor)) );
        //Rectangulo IDH
        g.setColor(Color.BLUE);
        g.fillRect( 4 * (ancho ) /5 , calcularPixel(idh,coor) , ancho/20 , (int) (coor[0] - calcularPixel(idh,coor)) );
        g.setColor(Color.ORANGE);
        g.fillRect( 4 * (ancho ) /5 + ancho/20 , calcularPixel(idh2,coor) , ancho/20 , (int) (coor[0] - calcularPixel(idh2,coor)) );
        
        //Rectangulo ID1
        g.setColor(Color.BLUE);
        g.drawString("Pais 1", ancho - 50 , 28);
        g.fillRect(ancho -50, 30  , 10, 10);
        
        g.setColor(Color.ORANGE);
        g.drawString("Pais 2", ancho - 50 ,58 );
        g.fillRect(ancho - 50 , 60, 10, 10);
        
    }
    
    int  calcularPixel(float valor , float[] co ){
        int pixel = (int) ( (co[4] - co[0]) * valor + co[0]);
        return pixel;
    }
    
}
