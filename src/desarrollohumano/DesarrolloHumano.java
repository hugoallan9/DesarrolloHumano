/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

/**
 * Clase principal desde la cual corre todo el programa
 * desde esta clase se carga todo el entorno grafico
 * @author Hugo Allan Garcia 200714466
 */

public class DesarrolloHumano{

    

    /**
     *Metodo principal, hilo desde el cual corre 
     * toda la aplicacion.
     * @param args
     */
    public static void main(String[] args) {
    MenuPrincipal app = new MenuPrincipal(); 
    app.initVentana();
    }
    
   
}


