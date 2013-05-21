/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hugo
 */
public class EscrituraBinaria {
    
    /**
     *  Metodo para escribir objetos en un archivo en binario
     * @param lis Lista a ser escrita
     * @param nombre nombre de la ubicacion
     */
    public void escribirBinario(String nombre, Lista lis){
        try{
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream (nombre));
            file.writeObject(lis);
            file.close();
        }catch(IOException  e){
            System.out.println(e);
            
        }
    }
    
    public Lista leerBinario(String ruta) throws ClassNotFoundException{
        Lista list = new Lista();
        try {
            ObjectInputStream file = new ObjectInputStream(new FileInputStream( ruta ));
            Lista lis = (Lista) file.readObject();
            list = (Lista) lis.clone();
        } catch (IOException ex) {
            Logger.getLogger(EscrituraBinaria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
