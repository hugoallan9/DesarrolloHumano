/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

/**Clase dedicada al manejo de reportes
 * dentro de ella hay metodos que son utiles para ordenar
 * y encontrar objetos
 *
 * @author Hugo Allan Garcia 200714466
 */
public class Reporte {
    int continente[] = new int[3];
    int pais[] = new int[2];
    int rendimiento[] = new int[4];
    int angulos[] = new int[4];
    
    
    /**
     * Metodo que ordena un arreglo de la clase de paises en 
     * funcion a los nombres de manera alfabetica.
     * @param paises
     * @param posInicial
     * @param posFinal
     */
    protected void ordenNombres(Pais[] paises, int posInicial, int posFinal){
    /**
     * En este metodo se implementa el algoritmo de ordenacion
     * QuickSort para ordenar el nombre de los paises
     * ordena el arreglo de tal forma que el nombre de los paises
     * quedan ordenado de manera alfabetica
     * @param paises un arreglo de objetos de la clase pais
     */
        // Variable de tipo Pais para hacer los intercambios
        Pais temporal = new Pais();
        // Calculando la posicion del centro
        int posPivote = ( posInicial + posFinal ) /2;
        //obteniendo el elemento central
        String pivote = paises[posPivote].getName();
        int i = posInicial;
        int j = posFinal;
        
        do{
            //verifica que los elementos del lado izquierdo del pivote
            //sean mas pequenos que el
            while( paises[i].getName().compareTo(pivote) < 0 ){
                i++;
            }
            
            //verifica que los elementos del lado derecho  sean mayores
            //que el pivote
            while( paises[j].getName().compareTo(pivote) > 0 ){
                j--;
            }
            
            //Haciendo el intercambio 
            
            if (i <= j){
                temporal = paises[i];
                paises[i] = paises[j];
                paises[j] = temporal;
                i++;
                j--;
            }
            
        }while(i <= j);
        
        //Llama recursivamente a la funcion ordeNombres
        
        if(i < posFinal)
            ordenNombres(paises, i, posFinal);
        
        if(j > posInicial)
            ordenNombres(paises, posInicial, j);
        
    }
    
    /**
     *
     * @param paises
     * @param name
     * @param posInicial
     * @param posFinal
     * @return
     */
    protected int encontrarPais(Pais[] paises, String name, int posInicial, 
            int posFinal){
        int posicion = -1;
        int comienzo;
        /**
         * Algoritmo que implemeta la busqueda binaria para encontrar
         * la posicion en la que esta alojado un pais
         * @param paises Arreglo de objeto de clase paises
         * @param name Es el string a comparar
         */
        
        while(posInicial <= posFinal){
            comienzo = ( posInicial + posFinal )/2;
            if( name.equalsIgnoreCase(paises[comienzo].getName())){
                posicion = comienzo;
                return posicion;
            }else{
                if(name.compareTo(paises[comienzo].getName()) < 0){
                    posFinal = comienzo - 1;
                }else{
                    if(name.compareTo(paises[comienzo].getName()) > 0){
                        posInicial = comienzo + 1;
                    }
                }
            }
        }
        
        
        return posicion;
    }
    
    
    /**
     *
     * @param paises
     * @param posicion
     * @param longitud
     */
    protected void eliminarPais(Pais[] paises, int posicion, int longitud){
    /**
     * Funcion que corre de posicion los objetos del arreglo ingresado, 
     * comenzando desde la posicion ingresada, de tal forma que cuando
     * termina el objeto que estaba en la posicion ingresada deja de 
     * existir
     */
        
        for( int i = posicion ; i < longitud ; i++ ){
            
            
            //Borrando al ultimo objeto
            if( i == longitud - 1){
                paises[i] = new Pais();
                paises[i].Pais("zzzz", "zzzzz");
            }else{
                paises[i] = paises[i+1];
            }
       }
        //Hacer decrecer a longitud
            //longitud--;
    }
    
    /**
     *
     * @param paises
     * @param posInicial
     * @param posFinal
     */
    protected void ordenIDH(Pais[] paises, int posInicial, int posFinal){
    /**
     * Metodo que ordena a los paises segun su IDH de menor a mayor
     */
        int i = posInicial;
        int j = posFinal; 
        Pais temporal = new Pais();
        int posPivote = ( i + j )/2;
        float pivote;
        pivote = paises[posPivote].desarrollo.getIndex();
        do{
            //verificando elementos del lado izquierdo del 
            //pivote
            while( paises[i].desarrollo.getIndex() < pivote ){
                i++;
            }
            
            //verificando elementos del lado derecho del pivote
            while( paises[j].desarrollo.getIndex() > pivote){
                j--;
            }
            
            //Haciendo el intercambio
            if( i <= j){
                temporal = paises[i];
                paises[i] = paises[j];
                paises[j] = temporal;
                i++;
                j--;
            }
        }while(i <= j);
        
        //Ordenando las nuevas listas
        if( i < posFinal){
            ordenIDH(paises, i , posFinal);
        }
        if( j > posFinal){
            ordenIDH(paises, posInicial, j);
        }
    }
    
     /**
     *
     * @param paises
     * @param posInicial
     * @param posFinal
     */
    protected void ordenMayorIDH(Pais[] paises, int posInicial, int posFinal){
    /**
     * Metodo que ordena a los paises segun su IDH de mayor a menor
     */
        int i = posInicial;
        int j = posFinal; 
        Pais temporal = new Pais();
        int posPivote = ( i + j )/2;
        float pivote;
        pivote = paises[posPivote].desarrollo.getIndex();
        do{
            //verificando elementos del lado izquierdo del 
            //pivote
            while( paises[i].desarrollo.getIndex() > pivote ){
                i++;
            }
            
            //verificando elementos del lado derecho del pivote
            while( paises[j].desarrollo.getIndex() < pivote){
                j--;
            }
            
            //Haciendo el intercambio
            if( i <= j){
                temporal = paises[i];
                paises[i] = paises[j];
                paises[j] = temporal;
                i++;
                j--;
            }
        }while(i <= j);
        
        //Ordenando las nuevas listas
        if( i < posFinal){
            ordenMayorIDH(paises, i , posFinal);
        }
        if( j > posFinal){
            ordenMayorIDH(paises, posInicial, j);
        }
    }
    
     /**
     *
     * @param paises
     * @param continente
     * @param inicio
     * @param fin
     * @return
     */
    protected int busquedaSecuencial(Pais[] paises , String continente, 
             int inicio, int fin){
     /**
      * Implementacion del algoritmo de busqueda secuncial
      * Util para clasificara a los paises segun su continente
      */
         
         for(int i = inicio ; i < fin ; i++ ){
             if(continente.equalsIgnoreCase(paises[i].getContinent())){
                 return i;
             }
         }
         return -1;
     }
     
     /**
     *
     * @param paises
     * @param longitud
     */
    protected void contadorPaises(Pais[] paises, int longitud){
         /**
          * Metodo que permite calcular el numero de paises en cada rango
          * segun el escalafon
          * Muy alto:  1 - 0.8
          * Alto: 0.7 - 0.79
          * Medio:  0.5 - 0.69
          * Bajo:  0.3 - 0.49
          */
         
         //Inicializando los contadores
         
         for(int i = 0; i < 4 ; i++){
             rendimiento[i]=0;
         }
         
         //Contando los paises en rango alto
         for (int i = 0 ; i <= longitud ; i++ ){
             if(0.8 <= paises[i].desarrollo.getIndex() ) {
                 rendimiento[0]++;
             }
         }
         
         for(int i = 0 ; i <= longitud ; i++ ){
             if(0.7 <= paises[i].desarrollo.getIndex() && 
                     paises[i].desarrollo.getIndex() < 0.8 ){
                 rendimiento[1]++;
             }
         }
         
         for(int i = 0 ; i <= longitud ; i++ ){
             if(0.5 <= paises[i].desarrollo.getIndex() && 
                     paises[i].desarrollo.getIndex() < 0.7){
                 rendimiento[2]++;
             }
         }
             
         for(int i = 0 ; i <= longitud  ; i++ ){
             if(0.3 <= paises[i].desarrollo.getIndex() && 
                     paises[i].desarrollo.getIndex() < 0.5){
                 rendimiento[3]++;
             }
         }
     }
     
     /**
     *
     */
    protected void conversionAngulos(){
         int suma;
         suma = 0;
         //Haciendo la suma 
         for(int i = 0; i < 4 ; i++){
             suma = suma + rendimiento[i];
             
         }
         
         //calculando los angulos
         
         for(int i = 0 ; i < 4 ; i++){
            angulos[i] = rendimiento[i] * 360 / suma;
         }
         
         
     }
}
