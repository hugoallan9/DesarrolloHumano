/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Hugo Allan Garcia    
 */
public class InPais extends JDialog{
    JFrame ventanaPadre;
    Pais[] pais = new Pais[25];
    //Hacer los TextField
    JTextField texto1 = new JTextField();
    JTextField texto2 = new JTextField();
    
    public InPais(JFrame fr , Pais[] pai, int j){
        this.ventanaPadre = fr;
        pais = pai;
        initDialogo();
        this.setVisible(true);
    }
    
    private void initDialogo(){
        
        
        //Iniciando con el panel
        JPanel pan0 = new JPanel();
        setSize(300,300);
        setLocationRelativeTo(ventanaPadre);
        pan0.setLayout(null);
        
        
        //Hacer los JLabel
        JLabel etiqueta1 = new JLabel("Ingrese Un Pais: ");
        JLabel etiqueta2 = new JLabel("Ingrese el continete: ");
        
        //Hacer lo Botones
        JButton aceptar = new JButton("aceptar");
        JButton cancelar = new JButton("cancelar");
        
        //Posicion de todo
        texto1.setBounds(50,50,200,20);
        texto2.setBounds(50,100,200,20);
        etiqueta1.setBounds(50,30,200,20);
        etiqueta2.setBounds(50,80,200,20);
        aceptar.setBounds(50,140,200,20);
        cancelar.setBounds(50,180,200,20);
        
        //Agregar los eventos para los botones
        aceptar.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event){
               llamarRes(event);
           } 
        });
        
        cancelar.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event){
               llamarCan(event);
           } 
        });
        
        //agregando todo al panel y el panel al Dialog
        pan0.add(texto1);
        pan0.add(texto2);
        pan0.add(etiqueta1);
        pan0.add(etiqueta2);
        pan0.add(aceptar);
        pan0.add(cancelar);
        this.add(pan0);
        
        
    }
    
    
    
    private void llamarRes(ActionEvent e){
        if(!texto1.getText().equals("") && !texto2.getText().equals("")){
            Reporte report = new Reporte();
            report.ordenNombres(pais, 0, MenuPrincipal.contador);
            for(int i =0 ; i <= MenuPrincipal.contador ; i++){
            System.out.println(pais[i].getName());
                    }
            System.out.println("***********");
            int existencia = report.encontrarPais(pais, texto1.getText().toUpperCase(),0 , MenuPrincipal.contador);
            if(existencia != -1){
                JOptionPane.showMessageDialog(this, "Pais Ya ingresado!!!!", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                pais[MenuPrincipal.contador].Pais(texto1.getText().toUpperCase(),texto2.getText().toUpperCase());
                MenuPrincipal.contador++;
                int r = JOptionPane.showConfirmDialog(this, "Pais ïngresado con Exito!!!. Desea ingresar otro Pais?");
                if(r == 1){
                    this.setVisible(false);
                    ventanaPadre.setVisible(true);
                    
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Dejo algun campo en blanco", "Error", JOptionPane.ERROR_MESSAGE);
        }
             
    }
    
    private void llamarCan(ActionEvent e){
        this.setVisible(false);
    }
    
}
