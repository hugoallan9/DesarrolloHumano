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
    private Lista reporte, continente, muyAlto, alto, medio, bajo ;
    int rendimiento[] = new int[4];
    float porcentaje[] = new float[4];
    
    
    Reporte(Lista particular){
        this.reporte = (Lista) particular.clone();
    }
    
    /**
     * Metodo para ordenar la lista de reportes
     * @param posInicial Posicion inicial desde la cual se desea ordenar
     * @param posFinal Posicion hasta donde se desea ordenar
     * @param op 1 para orden ascendente y 2 para orden descendentes
     */
    public void ordenarLista(int posInicial, int posFinal, int op){
        int posPivote = (posInicial + posFinal ) / 2;
        float pivote = reporte.accesoAleatorio(posPivote).getIndice('3');
        int i = posInicial;
        int j = posFinal;
        switch(op){
            case 1:
                do{
                    while(Float.compare(pivote, reporte.accesoAleatorio(i).getIndice('3')) > 0 ){
                        i++;
                    }
                    
                    while(Float.compare(pivote, reporte.accesoAleatorio(j).getIndice('3')) < 0){
                        j--;
                    }
                    
                    if(  i<=j ){
                        reporte.intercambioNodo(i, j);
                        i++;
                        j--;
                    }
                }while(i <=j);
                break;
                
            case 2:
                do{
                    while(Float.compare(pivote, reporte.accesoAleatorio(i).getIndice('3')) < 0 ){
                        i++;
                    }
                    
                    while(Float.compare(pivote, reporte.accesoAleatorio(j).getIndice('3')) > 0){
                        j--;
                    }
                    
                    if(  i<=j ){
                        reporte.intercambioNodo(i, j);
                        i++;
                        j--;
                    }
                }while(i <=j);
                break;
                
                
            
                
                
        }
        
        if( i < posFinal){
            ordenarLista(i, posFinal, op);
        }
        
        if( j > posInicial){
            ordenarLista(posInicial, j , op);  
        }
        
    }
    
    public void ordenContinente(String nombreCont){
        continente = new Lista();
        //Antes de aplicar este metodo se debe 
        //aplicar el metodo de ordenarLista()
        //para que reporte quede ordenada.
        
        //Recorriendo la lista reportes
        for(int i = 1 ; i <= reporte.getPosicion(); i++){
            Pais temp = reporte.accesoAleatorio(i);
            String nombre = temp.getContinent();
            if( nombre.equalsIgnoreCase(nombreCont) ){
                Pais nuevo = (Pais) temp.clone();
                nuevo.setRightLink(null);
                nuevo.setLeftLink(null);
                continente.ingresoNodo( nuevo );
            }
        }
    }
    
    /**
     * Metodo para calcular el numero de paises que hay en cada rango.
     */
    public void calcularRendimiento(){
        //inicializando los contadores
        for(int i = 0 ; i < 4 ; i++){
            rendimiento[i] = 0;
        }
        
        //Asignando los valores adecuados
        
        //Paises con rango muy alto
        for (int i = 1 ; i <= reporte.getPosicion() ; i++){
            Pais temp = reporte.accesoAleatorio(i);
            if( temp.getIndice('3') >= 0.8){
                muyAlto.ingresoNodo(temp);
                rendimiento[0]++;
            }
        }
        
        //Paises con rango alto
        for(int i = 1 ; i <= reporte.getPosicion() ; i++ ){
            Pais temp = reporte.accesoAleatorio(i);
            if( 0.7 <= temp.getIndice('3') && temp.getIndice('3') < 0.8 ){
                alto.ingresoNodo(temp);
                rendimiento[1]++;
            }
        }
        
        //Paises con rango medio
        for(int i = 1 ; i <= reporte.getPosicion() ; i++ ){
            Pais temp = reporte.accesoAleatorio(i);
            if( 0.5 <= temp.getIndice('3') && temp.getIndice('3') < 0.7 ){
                medio.ingresoNodo(temp);
                rendimiento[2]++;
            }
        }
        
        //Paises con rango bajo
        for(int i = 1 ; i <= reporte.getPosicion() ; i++ ){
            Pais temp = reporte.accesoAleatorio(i);
            if( 0.3 <= temp.getIndice('3') && temp.getIndice('3') < 0.5 ){
                bajo.ingresoNodo(temp);
                rendimiento[3]++;
            }
            
        }
        
    }
   
    
    /**
     * Metodo para obtener los porcentajes de cada rango.
     */
    public void calcularPorcentajes(){
        for(int i = 0 ; i < 4 ; i++){
            porcentaje[i] = ( rendimiento[i] * 100 ) / reporte.getPosicion();
        }
    }
    
    public Lista getReporte(){
        return reporte;
    }
    
    public Lista getReporteContinental(){
        return continente;
    }
    
    
    
    
   
}
