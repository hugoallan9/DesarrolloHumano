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
            impresora.write("<style type=\"text/css\">\n" +
            "<!--\n" +
            "@import url(\"style.css\");\n" +
            "-->\n" +
            "</style>");
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
            impresora.append("      <table id=\"box-table-b\" width=\"100\" cellspacing=\"2\" cellpadding=\"25\" border=\"0\" bgcolor=\"#165480\">");
            impresora.append("<thead>\n" +
            "<tr>\n" +
            "<th scope=\"col\"> ID </th>\n" +
            "<th scope=\"col\"> NOMBRE</th>\n" +
            "<th scope=\"col\"> BANDERA</th>\n" +
            "<th scope=\"col\"> CONTINENTE </th>\n" +
            "<th scope=\"col\"> AÑO </th>\n" +
            "<th scope=\"col\"> ESPERANZA </th>\n" +
            "<th scope=\"col\"> EDUCACION </th>\n" +        
            "<th scope=\"col\"> PIB </th>\n" +
            "<th scope=\"col\"> IDH </th>\n" +
            "</tr>\n" +
            "</thead>");
            
            impresora.append("<tbody>");
            impresora.append("<tr>\n" +
            "    <td >\n" +
            "   <font face=\"verdana, arial, helvetica\" size=2>\n" 
            + nodo.getID() +    "\n" +
            "   </font>\n" +
            "   </td>\n" );
             impresora.append(
            "    <td >\n" +
            "   <font face=\"verdana, arial, helvetica\" size=2>\n" 
            + nodo.getName()  +  "\n" +
            "   </font>\n" +
            "   </td>\n" );
            impresora.append(
            "    <td >\n" +
            "   <font face=\"verdana, arial, helvetica\" size=2>\n" 
            + "<IMG SRC=\" " + nodo.getPath() + "\" ALT=\"Bandera No Disponible \">"  +  "\n" +
            "   </font>\n" +
            "   </td>\n" );
              impresora.append(
            "    <td >\n" +
            "   <font face=\"verdana, arial, helvetica\" size=2>\n" 
            + nodo.getContinent()  +  "\n" +
            "   </font>\n" +
            "   </td>\n" );
            impresora.append(
            "    <td >\n" +
            "   <font face=\"verdana, arial, helvetica\" size=2>\n" 
            + nodo.getYear()  +  "\n" +
            "   </font>\n" +
            "   </td>\n" );
            impresora.append(
            "    <td >\n" +
            "   <font face=\"verdana, arial, helvetica\" size=2>\n" 
            + nodo.getIndice('0')  +  "\n" +
            "   </font>\n" +
            "   </td>\n" );
            impresora.append(
            "    <td >\n" +
            "   <font face=\"verdana, arial, helvetica\" size=2>\n" 
            + nodo.getIndice('1')  +  "\n" +
            "   </font>\n" +
            "   </td>\n" );
              impresora.append(
            "    <td >\n" +
            "   <font face=\"verdana, arial, helvetica\" size=2>\n" 
            + nodo.getIndice('2')  +  "\n" +
            "   </font>\n" +
            "   </td>\n" );    
              impresora.append(
            "    <td >\n" +
            "   <font face=\"verdana, arial, helvetica\" size=2>\n" 
            + nodo.getIndice('3')  +  "\n" +
            "   </font>\n" +
            "   </td>\n" + "</tr>");
            impresora.append("</table>\n " + "</div> \n" + "</tbody>" + "</BODY> \n" + "</HTML>");
            impresora.close();
            temporal.close();
        }catch(IOException e){
            System.out.println("Error: " + e.getMessage());
            
        }
        
    }
    
    public  void escribirComparacion(Lista comparacion , int dispo){
        try{
            escritora = new FileWriter(f,true);
            temporal = new BufferedWriter(escritora);
            impresora =  new PrintWriter(temporal);
            
            impresora.append( "<div align = \"center\"> \n");
            impresora.append("      <table id=\"newspaper-b\" width=\"100\" cellspacing=\"2\" cellpadding=\"25\" border=\"0\">");
            impresora.append("<thead>\n" +
            "<tr>\n" +
            "<th scope=\"col\"> ID </th>\n" +
            "<th scope=\"col\"> NOMBRE</th>\n" +
            "<th scope=\"col\"> BANDERA</th>\n" +
            "<th scope=\"col\"> CONTINENTE </th>\n" +
            "<th scope=\"col\"> AÑO </th>\n" +
            "<th scope=\"col\"> IDH </th>\n" +
            "<th scope=\"col\"> POSICION </th>\n" +
            "</tr>\n" +
            "</thead>");
            
            impresora.append("<tbody>");
            for ( int i = 1 ; i <= comparacion.getPosicion() ; i++){
                impresora.append("<tr>\n" +
                "    <td >\n" +
                "   <font face=\"verdana, arial, helvetica\" size=2>\n" 
                + comparacion.accesoAleatorio(i).getID() +    "\n" +
                "   </font>\n" +
                "   </td>\n" );
                 impresora.append(
                "    <td >\n" +
                "   <font face=\"verdana, arial, helvetica\" size=2>\n" 
                + comparacion.accesoAleatorio(i).getName()  +  "\n" +
                "   </font>\n" +
                "   </td>\n" );
                impresora.append(
                "    <td >\n" +
                "   <font face=\"verdana, arial, helvetica\" size=2>\n" 
                + "<IMG SRC=\" " + comparacion.accesoAleatorio(i).getPath() + "\" ALT=\"Bandera No Disponible \">"  +  "\n" +
                "   </font>\n" +
                "   </td>\n" );
                  impresora.append(
                "    <td >\n" +
                "   <font face=\"verdana, arial, helvetica\" size=2>\n" 
                + comparacion.accesoAleatorio(i).getContinent()  +  "\n" +
                "   </font>\n" +
                "   </td>\n" );
                impresora.append(
                "    <td >\n" +
                "   <font face=\"verdana, arial, helvetica\" size=2>\n" 
                + comparacion.accesoAleatorio(i).getYear()  +  "\n" +
                "   </font>\n" +
                "   </td>\n" );
                 
                impresora.append(
                "    <td >\n" +
                "   <font face=\"verdana, arial, helvetica\" size=2>\n" 
                + comparacion.accesoAleatorio(i).getIndice('3')  +  "\n" +
                "   </font>\n" +
                "   </td>\n");
                int size = 12 - 2*i ;
                impresora.append(
                "    <td >\n" +
                "   <font face=\"verdana, arial, helvetica\" size=" + size + ">\n" 
                + absoluto(( dispo - i))  +  "\n" +
                "   </font>\n" +
                "   </td>\n" + "</tr>");
                
               
            }
            
                impresora.append("</table>\n " + "</div> \n" + "</tbody>" + "</BODY> \n" + "</HTML>");
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

    private String absoluto(int i) {
        String retorno;
        if ( i < 0){
            retorno = String.valueOf(-i);
        }else{
            retorno = String.valueOf(i);
        }
        return retorno;
    }
    
    
    
    
    
    
}
