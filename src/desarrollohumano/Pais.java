/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

/** Desde esta clase se crean objetos que pueden
 * manejar la informacion basica de un pais
 * como su nombre y a que continente pertenece
 *
 * @author Hugo Allan Garcia 
 */
public class Pais {
    String nombre, continente;
    Esperanza hope = new Esperanza();
    Educacion education = new Educacion();
    PIB productoInterno = new PIB();
    IDH desarrollo = new IDH();
    float[] valores = new float[4];
    
    /**
     *Metodo constructor de la clase, inicializa el nombre
     * y el continente de un pais
     */
    protected void Pais(){
        nombre = "";
        continente = "";
    }
    
    /**
     * Se sobreescribe al constructor para poderle 
     * dar nombre y continente a cada pais
     * @param name
     * @param continent
     */
    protected void Pais(String name, String continent){
    /**
     * Constructor de la clase
     * @param String name continente 
     */
        nombre = name;
        continente = continent;
    }
    
    /**
     * Metodo que devuelve el nombre del pais
     * @return nombre
     */
    protected String getName(){
       
        return nombre;
    }
    
    /**
     * Metodo que devuelve el continente al que pertenece
     * @return continente
     */
    protected String getContinent(){
        return continente;
    }
    
    
}
