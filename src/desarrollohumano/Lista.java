/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

import java.io.Serializable;

/** Clase para el manejo de los nodos declarados 
 * en la clase Pais, se puede insertar, eliminar, 
 * ordenar y accesar de manera aleaotoria a dichos nodos.
 *
 * @author hugo
 */
public class Lista implements Cloneable,  Serializable{
    private Pais inicio;
    private int contador;
    
    Lista(){
        inicio = new Pais("","",0,0);
        contador = 0;
    }
    
    /**
     *  Metodo para ingresar un nodo
     * a la lista.
     * @param nuevo Nodo a ingresar. 
     */
    public void ingresoNodo(Pais nuevo){
        Pais ingreso = new Pais();
        int aux;
        ingreso = nuevo;
        aux = getPosicion();
        ingreso.setLeftLink(accesoAleatorio(aux));
        accesoAleatorio(aux).setRightLink(ingreso);
        contador++;
    }
    
    /**
     *  Funcion para obtener la lista
     * de cierto año en particular
     * @param anio El año para la lista
     * @return Una sublista correspontiente al año
     */
    public Lista getSubList(int anio){
        Lista sub = new Lista();
        Pais temp;
        for (int i = 1 ; i <= getPosicion(); i++){
            
            if(accesoAleatorio(i).getYear() == anio){
                temp = (Pais) accesoAleatorio(i).clone();
                temp.setLeftLink(null);
                temp.setRightLink(null);
                sub.ingresoNodo(temp);
            }
    }
        return sub;
    }
    
    /**
     * Metodo que imprime todos los elementos de la lista.
     */
    public void imprimirLista(){
        System.out.printf("\t%-20s%-25s%-10s%-10s\n", "Pais","Continente","Anio","ID");
        for(int i = 0 ; i <= getPosicion() ; i++){
            accesoAleatorio(i).imprimir();
        }
    }
    
    /**
     * Funcion que elimina un nodo en particular.
     * @param nodo El nodo a eliminar.
     * @return 
     */
    
    public boolean eliminarNodo(Pais nodo){
        boolean eliminar;
        Pais anterior = new Pais();
        Pais posterior = new Pais();
        if(  nodo.getRightLink() == null){
            anterior = nodo.getLeftLink();
            anterior.setRightLink(null);
            eliminar = true;
        }else{
            anterior = nodo.getLeftLink();
            posterior = nodo.getRightLink();
            anterior.setRightLink(posterior);
            posterior.setLeftLink(anterior);
            eliminar = true;
        }
        contador--;
        return eliminar;
        }
    
    /**
     *  Funcion para obtener la ultima posicion conocida de la lista
     * @return posicion
     */
    public int getPosicion(){
        return contador;
    
    }
    
    /**
     * Funcion que permite tener acceso Aleatorio a la lista, así
     * la lista puede funcionar como un arreglo en el cual se puede acceder
     * a cualquier elemento.
     * @param pos El nodo en la posicion pos.
     * @return 
     */
    public  Pais accesoAleatorio(int pos){
        Pais temporal = inicio;
        for(int i = 0 ; i < pos ; i++){
            temporal = temporal.getRightLink();
        }
        return temporal;
        
    }
    
    
    /**
     * Funcion para buscar un pais segun su nombre o id
     * @param campo Se ingresa aca el nombre o la id
     * @param op 1 para nombre y 2 para id.
     * @return 
     */
    public Pais getNodo(String campo, int op){
        Pais temp;
        temp = inicio;
        switch(op){
            case 1:
                while(!temp.getName().equalsIgnoreCase(campo) && temp.getRightLink() != null ){
                    temp = temp.getRightLink();
                }
                if( !temp.getName().equalsIgnoreCase(campo)  ){
                   temp = inicio;
                }
                break;
                
            case 2:
                while( Integer.compare(temp.getID(), Integer.parseInt(campo)) != 0 && temp.getRightLink() != null){
                    temp = temp.getRightLink();
                }
                if( Integer.compare(temp.getID(), Integer.parseInt(campo)) != 0  ){
                    temp = inicio;
                }
                break;
                
            default:
                System.out.println("Opcion invalida, solo 1 o 2");
        }
        
        
        
        
        
        return temp;
        
    }
    
    
    /**
     *  Metodo para ordenar alfabeticamente una lista
     * @param posInicial
     * @param posFinal 
     */
     public void ordenNombres(int posInicial, int posFinal){
        int posPivote = (posInicial + posFinal ) / 2;
        String pivote = accesoAleatorio(posPivote).getName() ;
        int i = posInicial;
        int j = posFinal;
        Pais temp;
        
        do{
            //verifica que los elementos del lado izquierdo del pivote
            //sean mas pequenos que el
            while( accesoAleatorio(i).getName().compareTo(pivote) < 0 ){
                i++;
            }
            
            //verifica que los elementos del lado derecho sean mayores
            //que el pivote
            while( accesoAleatorio(j).getName().compareTo(pivote) > 0 ){
                j--;
            }
            
            //Haciendo el intercambio
            
            if (i <= j){
                intercambioNodo(i,j);
                i++;
                j--;
            }
            
        }while(i <= j);
        
        //Llama recursivamente a la funcion ordeNombres
        
        if(i < posFinal)
            ordenNombres( i, posFinal);
        
        if(j > posInicial)
            ordenNombres(posInicial, j);
    }
     
     
     public void intercambioNodo(int i , int j){
         //Volcando informacion; 
         
         
         Pais post = accesoAleatorio(j);
         Pais inf = accesoAleatorio(i);
         Pais temp = (Pais) inf.clone();
         
         inf.cambiarInfo(post);
         post.cambiarInfo(temp);
     }
     
     
          public Object clone(){
        Object obj=null;
        try{
            obj=super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar");
        }
        return obj;
    }
     
     
  
     
   
    
    
    
}
