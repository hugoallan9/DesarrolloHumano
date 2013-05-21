/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

import java.io.Serializable;

/**
 *
 * @author hugo
 */
public class Bandera implements Serializable{
    String[] pais = new String[50];
    String[] ruta = new String[50];
    int contador = 2;
    
    
    Bandera(){
        //Inicializando los arreglos
        pais[0] = "GUATEMALA";
        ruta[0] = "/mnt/Datos/Dropbox/Sistemas/IPC1 2013/Proyecto/DesarrolloHumano/src/Banderas/flag_GT.gif";
        pais[1] = "MEXICO";
        ruta[1] = "/mnt/Datos/Dropbox/Sistemas/IPC1 2013/Proyecto/DesarrolloHumano/src/Banderas/flag_MX.gif";
        for( int i = 2 ; i < 50 ; i++){
            pais[i] = "zzz";
            ruta[i] = "zzz";
        }
    }
    
    
    public void ingresarRuta(String pai, String ru){
        pais[contador] = pai;
        ruta[contador] = ru;
        contador++;
    }
    
    public void ordenarPais(int posInicial , int posFinal){
        int posPivote = (posInicial + posFinal ) / 2;
        String pivote = pais[posPivote] ;
        int i = posInicial;
        int j = posFinal;
        
        do{
            //verifica que los elementos del lado izquierdo del pivote
            //sean mas pequenos que el
            while( pais[i].compareTo(pivote) < 0 ){
                i++;
            }
            
            //verifica que los elementos del lado derecho sean mayores
            //que el pivote
            while( pais[j].compareTo(pivote) > 0 ){
                j--;
            }
            
            //Haciendo el intercambio
            
            if (i <= j){
                String temp = pais[i];
                String temp1 = ruta[i];
                pais[i] = pais[j];
                ruta[i] = ruta[j];
                pais[j] = temp;
                ruta[j] = temp1;
                i++;
                j--;
            }
            
        }while(i <= j);
        
        //Llama recursivamente a la funcion ordeNombres
        
        if(i < posFinal)
            ordenarPais( i, posFinal);
        
        if(j > posInicial)
            ordenarPais(posInicial, j);
    }
    
    public int buscarPais(String nombre, int posInicial, int posFinal){
        int posicion = -1;
        int comienzo;
        
        while(posInicial <= posFinal){
            comienzo = ( posInicial + posFinal )/2;
            if( nombre.equalsIgnoreCase(pais[comienzo])){
                posicion = comienzo;
                return posicion;
            }else{
                if(nombre.compareTo(pais[comienzo]) < 0){
                    posFinal = comienzo - 1;
                }else{
                    if(nombre.compareTo(pais[comienzo]) > 0){
                        posInicial = comienzo + 1;
                    }
                }
            }
        }
        
        
        return posicion;
    
    }
    
    public int getContador(){
        return contador;
    }
    
    public String getRuta(int pos){
        return ruta[pos];
    }
    
    
}


