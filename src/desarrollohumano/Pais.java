/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

/** Desde esta clase se crean objetos que pueden
 * manejar la informacion basica de un pais
 * como su nombre y a que continente pertenece, ademas de los
 * indices necesarios. Son nodos para la construcción de una lista.
 *
 * @author Hugo Allan Garcia 
 */
public class Pais {
    private IDH desarrolloHumano;
    private Esperanza hope;
    private Educacion education;
    private PIB productoInterno;
    private int id, year;
    private String name, continent, path;
    Pais rightLink, leftLink;
    
    /**
     * Constructor de la clase Pais
     * @param nombre
     * @param continente
     * @param anio
     * @param id 
     */
    
    public Pais(String nombre, String continente, int anio, int id){
        name = nombre;
        continent = continente;
        year = anio;
        this.id = id;
        
    }
    
    /**
     * Metodo para hacer el link con el siguiente nodo
     * @param derecha 
     */
    public void setRightLink(Pais derecha){
        rightLink = derecha;
    }
    
    /**
     * Metodo para hacer el link con el nodo anterior
     * @param izquierda 
     */
    public void setLeftLink(Pais izquierda ){
        leftLink = izquierda;
    }
    
    /**
     * Metodo para recuperar el nombre del pais
     * @return El nombre del pais 
     */
    public String getName(){
        return name;
    }
    
    /**
     * Metodo para recuperar el continente al que
     * pertenece dicho nodo.
     * @return continent
     */
    public String getContinent(){
        return continent;
    }
    
    /**
     *  Funcion para recuperar 
     * el ano del pais
     * @return year
     */
    public int getYear(){
        return year;
        
    }
    
    /**
     * Funcion para recuperar 
     * el identificador 
     * otorgado por el sistema a este nodo
     * @return id
     */
    public int getID(){
        return id;
    }
    /**
     * Funcion para recuperar la ruta para
     * la bandera
     * @return path
     */
    public String getPath(){
        return path;
        
    }
    /**
     * Funcion para recuperar el siguiente
     * nodo en una lista enlazada
     * @return rightLink
     */
    public Pais getRightLink(){
        return rightLink;
    }
    /**
     * Funcion para recuperar el nodo 
     * anterior en una lista enlazada
     * @return 
     */
    public Pais getLeftLink(){
        return leftLink;
    }
    
    public float getIndice(char num){
        float indice;
        switch(num){
            case 0:
                indice = hope.getIndex();
                break;
            case 1:
                indice = education.getIndex();
                break;
                
            case 2:
                indice = productoInterno.getIndex();
                break;
             
            case 3:
                indice = desarrolloHumano.getIndex();
                break;
                
            default:
                System.out.println("No has ingresado una opcion Valida: Las opciones segun la tabla");
                System.out.println("0 Esperanza ");
                System.out.println("1 Educacion");
                System.out.println("2 Producto Interno");
                System.out.println("3 Desarrollo Humano");
                indice = -1;
        }
        
        return indice;
        
        
    }
    
    
}
