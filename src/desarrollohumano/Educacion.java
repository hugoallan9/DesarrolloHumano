/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

/** La clase Educacion es hija de la clase Indice
 * Implementa nuevos metodos para calcular el indice
 * 
 *
 * @author Hugo Allan García Monterrosa
 */
public class Educacion extends Indice{
    final float VALOR_MAXIMO = 100;
    final float VALOR_MINIMO = 0;
    
    /**
     *
     * @param maximo Maximo permitido para el indice
     * @param minimo Minimo permitido para el indice
     * @param indicador1 Valor ingresado por usuario
     * @param indicador2 Valor ingresado por usuario
     */
    protected void calcularIndice(float maximo, float minimo, float indicador1, 
            float indicador2){
        /**
         * Metodo que calcula el Indice de educacion
         * @param indicador1 Ingresado por usuario para la alfabetizacion
         * @param indicador2 Ingresado por usuario para la matriculacion
         */
         
        indice = (2f/3f) * (indicador1 - minimo  ) / ( maximo - minimo ) + (1f/3f) * 
                ( indicador2 - minimo ) / ( maximo - minimo );
        
    }
}
