/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

/**Clase que hereda de Indice
 * Implementa metodo para el calculo del
 * indice de desarroloo humano
 *
 * @author Hugo Allan Garcia 200714466
 */
public class IDH extends Indice{
    /**
     *
     * @param esperanza
     * @param educacion
     * @param PIB
     */
    protected void calcularIDH(float esperanza, float educacion, float PIB){
        /**
         * Metodo que calcula el indice de desarrollo humano
         * @param esperanza 
         * @param educacion
         * @param PIB
         */
        indice = (1f/3f) * (esperanza + educacion + PIB);
    }
    
}
