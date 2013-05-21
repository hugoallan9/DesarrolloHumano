/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hugo
 */
public class EscrituraTexto {
    private File f;
    private FileWriter escritora;
    private BufferedWriter temporal;
    private PrintWriter impresora;
    File archive = null;
    FileReader lector = null;
    Scanner tempo = null;
    
    EscrituraTexto( String nombre , String titulo){
        try{
            f = new File( nombre );
            escritora = new FileWriter(f);
            temporal = new BufferedWriter(escritora);
            impresora =  new PrintWriter(temporal);
            
            impresora.write("<HTML lang = \" es \" >"  + "\n");
            impresora.write("\t <HEAD>" + "\n");
            impresora.write("\t\t <TITLE> " + titulo + "</TITLE> \n");
            impresora.write("\t </HEAD> \n");
            impresora.write("\t <BODY> \n");
            impresora.write("<div align = \"center\"> \n");
            impresora.write("\t <b>" + "<font size = 7>" + titulo + "</font>"+ "</b> \n");
            impresora.write("</div> \n");
            
            temporal.newLine();
            impresora.close();
            temporal.close();
            
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    EscrituraTexto(){
        
    }
    
    public void escribirTabla(Pais nodo){
        try{
            escritora = new FileWriter(f,true);
            temporal = new BufferedWriter(escritora);
            impresora =  new PrintWriter(temporal);
            
            impresora.append( "<div align = \"center\"> \n");
            impresora.append("      <table width=\"100\" cellspacing=\"2\" cellpadding=\"25\" border=\"0\" bgcolor=\"#165480\">");
            impresora.append("<tr>\n" +
            "    <td bgcolor=\"#ffffcc\">\n" +
            "   <font face=\"verdana, arial, helvetica\" size=1>\n" +
            "   ID \n" +
            "   </font>\n" +
            "   </td>\n" );
            impresora.append(
            "    <td bgcolor=\"#ffffcc\">\n" +
            "   <font face=\"verdana, arial, helvetica\" size=1>\n" +
            "   PAIS \n" +
            "   </font>\n" +
            "   </td>\n " );
            impresora.append(
            "    <td bgcolor=\"#ffffcc\">\n" +
            "   <font face=\"verdana, arial, helvetica\" size=1>\n" +
            "    BANDERA \n" +
            "   </font>\n" +
            "   </td>\n" );
            impresora.append(
            "    <td bgcolor=\"#ffffcc\">\n" +
            "   <font face=\"verdana, arial, helvetica\" size=1>\n" +
            "   CONTINENTE \n" +
            "   </font>\n" +
            "   </td>\n" );
            impresora.append(
            "    <td bgcolor=\"#ffffcc\">\n" +
            "   <font face=\"verdana, arial, helvetica\" size=1>\n" +
            "   AÑO \n" +
            "   </font>\n" +
            "   </td>\n" );
            impresora.append(
            "    <td bgcolor=\"#ffffcc\">\n" +
            "   <font face=\"verdana, arial, helvetica\" size=1>\n" +
            "   INDICE DE VIDA \n" +
            "   </font>\n" +
            "   </td>\n" );
            impresora.append(
            "    <td bgcolor=\"#ffffcc\">\n" +
            "   <font face=\"verdana, arial, helvetica\" size=1>\n" +
            "   INDICE DE EDUACION \n" +
            "   </font>\n" +
            "   </td>\n" );
            impresora.append(
            "    <td bgcolor=\"#ffffcc\">\n" +
            "   <font face=\"verdana, arial, helvetica\" size=1>\n" +
            "   INDICE DE PIB \n" +
            "   </font>\n" +
            "   </td>\n" );
            
            impresora.append(
            "    <td bgcolor=\"#ffffcc\">\n" +
            "   <font face=\"verdana, arial, helvetica\" size=1>\n" +
            "   INDICE DE IDH \n" +
            "   </font>\n" +
            "   </td>\n" + "</tr> \n" );
            impresora.append("<tr>\n" +
            "    <td bgcolor=\"#5FA6D7\">\n" +
            "   <font face=\"verdana, arial, helvetica\" size=1>\n" 
            + nodo.getID() +    "\n" +
            "   </font>\n" +
            "   </td>\n" );
             impresora.append(
            "    <td bgcolor=\"#5FA6D7\">\n" +
            "   <font face=\"verdana, arial, helvetica\" size=1>\n" 
            + nodo.getName()  +  "\n" +
            "   </font>\n" +
            "   </td>\n" );
            impresora.append(
            "    <td bgcolor=\"#5FA6D7\">\n" +
            "   <font face=\"verdana, arial, helvetica\" size=1>\n" 
            + "<IMG SRC=\" " + nodo.getPath() + "\" ALT=\"Bandera No Disponible \">"  +  "\n" +
            "   </font>\n" +
            "   </td>\n" );
              impresora.append(
            "    <td bgcolor=\"#5FA6D7\">\n" +
            "   <font face=\"verdana, arial, helvetica\" size=1>\n" 
            + nodo.getContinent()  +  "\n" +
            "   </font>\n" +
            "   </td>\n" );
            impresora.append(
            "    <td bgcolor=\"#5FA6D7\">\n" +
            "   <font face=\"verdana, arial, helvetica\" size=1>\n" 
            + nodo.getYear()  +  "\n" +
            "   </font>\n" +
            "   </td>\n" );
            impresora.append(
            "    <td bgcolor=\"#5FA6D7\">\n" +
            "   <font face=\"verdana, arial, helvetica\" size=1>\n" 
            + nodo.getIndice('0')  +  "\n" +
            "   </font>\n" +
            "   </td>\n" );
            impresora.append(
            "    <td bgcolor=\"#5FA6D7\">\n" +
            "   <font face=\"verdana, arial, helvetica\" size=1>\n" 
            + nodo.getIndice('1')  +  "\n" +
            "   </font>\n" +
            "   </td>\n" );
              impresora.append(
            "    <td bgcolor=\"#5FA6D7\">\n" +
            "   <font face=\"verdana, arial, helvetica\" size=1>\n" 
            + nodo.getIndice('2')  +  "\n" +
            "   </font>\n" +
            "   </td>\n" );    
              impresora.append(
            "    <td bgcolor=\"#5FA6D7\">\n" +
            "   <font face=\"verdana, arial, helvetica\" size=1>\n" 
            + nodo.getIndice('3')  +  "\n" +
            "   </font>\n" +
            "   </td>\n" + "</tr>");
            impresora.append("</table>\n " + "</div> \n" + "</BODY> \n" + "</HTML>");
            
            
            
            
            
            impresora.close();
            temporal.close();
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
            
        }
        
    }
    
    public void escribirContador(int contador){
        try{
            f = new File("contador.txt");
            escritora = new FileWriter(f);
            temporal = new BufferedWriter(escritora);
            impresora =  new PrintWriter(temporal);
            
            impresora.write( String.valueOf(contador)    );
            temporal.newLine();
            impresora.close();
            temporal.close();
            
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public int leerContador(String ruta){
        archive = new File(ruta);
        try {
            lector = new FileReader(archive);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscrituraTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
        tempo = new Scanner(lector);
        tempo.useLocale(Locale.ENGLISH);
        tempo.useDelimiter(" ");
        
        return ( Integer.parseInt(tempo.nextLine()) );
        
        
    }
    
    
    
    
    
    
}
