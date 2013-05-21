/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

import java.io.Serializable;

/** Desde esta clase se crean objetos que pueden
 * manejar la informacion basica de un pais
 * como su nombre y a que continente pertenece, ademas de los
 * indices necesarios. Son nodos para la construcción de una lista.
 *
 * @author Hugo Allan Garcia 
 */
public class Pais implements Cloneable, Serializable {
    private IDH desarrolloHumano;
    private Esperanza hope;
    private Educacion education;
    private PIB productoInterno;
    private int id, year;
    private String name, continent, path;
    private Pais rightLink, leftLink;
    private float[] valor = new float[4];
    
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
        rightLink = null;
        leftLink = null;
        hope = new Esperanza();
        desarrolloHumano = new IDH();
        education = new Educacion();
        productoInterno = new PIB();
        
    }
    
    public Pais(){
     this.name = "";
     this.continent = "";
     this.year = 0;
     this.id = 0;
     this.rightLink = null;
     this.leftLink = null;
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
            case '0':
                indice = hope.getIndex();
                break;
            case '1':
                indice = education.getIndex();
                break;
                
            case '2':
                indice = productoInterno.getIndex();
                break;
             
            case '3':
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
    
    public IDH getIDH(){
        return (this.desarrolloHumano);
    }
    
    public Educacion getEducacion(){
        return (this.education);
    }
    
    public Esperanza getEsperanza(){
        return (this.hope);
    }
    
    public PIB getPIB(){
        return (this.productoInterno);
    }
    
    public void imprimir(){
        System.out.printf("\t%-20s%-25s%-10d%-10d \n", getName(),getContinent(),getYear(),getID());
        
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setContinent(String continent){
        this.continent = continent;
    }
    
    public void setDH(IDH ds){
        this.desarrolloHumano = ds;
        
    }
    
    public void setEducacion(Educacion edu){
        this.education = edu;
    }
    
    public void setEsperanza(Esperanza es){
        this.hope = es;
    }
    
    public void setPIB(PIB pib){
        this.productoInterno = pib;
    }
    
    public void setPath(String p){
        this.path = p;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public void setYear(int anio){
        this.year = anio;
    }
    
    public void setHope(float val){
        valor[0] = val;
    }
    
    public void setAlfabetizacion(float val){
        valor[1] = val;
    }
    
    public void setMatricula(float val){
        valor[2] = val;
    }
    
    public void setProducto(float val){
        valor[3] = val;
    }
    
    
    public float getHope(){
        return valor[0];
    }
    
    public float getAlfabetizacion(){
        return valor[1];
        
    }
    
    public float getMatricula(){
        return valor[2];
    }
    
    public float getProducto(){
        return valor[3];
    }
    
    public void set(float val){
        valor[0] = val;
    }
    
    public void cambiarInfo(Pais nodo){
        this.setContinent(nodo.getContinent());
        this.setDH(nodo.getIDH());
        this.setEducacion(nodo.getEducacion());
        this.setEsperanza(nodo.getEsperanza());
        this.setID(nodo.getID());
        this.setName(nodo.getName());
        this.setPath(nodo.getPath());
        this.setPIB(nodo.getPIB());
        this.setYear(nodo.getYear());
        this.setHope(nodo.getHope());
        this.setAlfabetizacion(nodo.getAlfabetizacion());
        this.setMatricula(nodo.getMatricula());
        this.setProducto(nodo.getProducto());
        
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
     
     public void imprimirIndices(){
         System.out.printf("\t %-10f%-10f%-10f%-10f %-10f \n", getHope() , getAlfabetizacion(), getMatricula(), getProducto() , getIndice('3') );
     }
}
