/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

/**
 *Clase padre para crear los indices que le
 * corresponden a un pais
 * @author Hugo Allan Garcia 200714466
 */
public class Indice {
    
    float indice;
    
   
    
    /**
     *
     * @param maximo
     * @param minimo
     * @param indicador
     */
    protected void calcularIndice(float maximo, float minimo, float indicador){
    /**
     * Metodo que calcula los indices a partir de 
     * un dato ingresado por el usuario
     * @param maximo Valor maximo permitido para el indice 
     * @param minimo Valor minimo permitido para el indice
     * @param indicador Valor que el usuario entra para el calculo de indice
     */
        indice = ( indicador - minimo ) / ( maximo - minimo );
    }
    
    /**
     * Metodo para retornar el indice
     * @return indice
     */
    protected float getIndex(){
        return indice;
    }
    
        
    
}
