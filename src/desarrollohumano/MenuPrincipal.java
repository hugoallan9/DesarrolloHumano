/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author WinAcc
 */
public class MenuPrincipal extends JFrame{
    //Declarando array de Paises
    Pais[] country = new Pais[25];
    //Contador de objetos
    static int contador = 0;
    
    public MenuPrincipal(){
        for(int i = contador ; i < 25 ; i++){
            country[i] = new Pais();
            country[i].Pais("zzzz","zzzzz");
        }
        initVentana();
        this.setVisible(true);
    }
    
    protected void initVentana(){
        
        //Dandole Formato a la ventana
        setTitle("Indice de Desarrollo Humano");
        setLocationRelativeTo(null);
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //El panel
        JPanel panel = new JPanel();
        
        //Dandole el formato a el panel
        panel.setLayout(new GridLayout(6,1,10,10));
        
        //Creando los botones
        JButton[] boton = new JButton[6];
        
        //Inicializando los botones
        for(int i = 0 ; i < 6 ; i++){
            boton[i] = new JButton();
        }
        
        //Iniciando los botones
        boton[0].setText("Ingresar Paises");
        boton[1].setText("Ingresar o Modificar Estimadores por Pais");
        boton[2].setText("Buscar Pais");
        boton[3].setText("Comparacion de dos paises");
        boton[4].setText("Grafica Circular de IDH");
        boton[5].setText("Estadisticas");
        
        //Agregando los eventos para los botones
        boton[0].addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent event){
                llamarD0(event);
            }
            
        });
        
        boton[1].addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent event){
                llamarD1(event);
            }
            
        });
        
        boton[2].addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent event){
                llamarD2(event);
            }
            
        });
        
        boton[3].addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent event){
                llamarD3(event);
            }
            
        });
        
        boton[4].addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent event){
                llamarD4(event);
            }
            
        });
        
        boton[5].addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent event){
                llamarD5(event);
            }

           
            
        });
        
        //Agregando los botones al panel
        for(int i = 0 ; i < 6 ; i++){
            panel.add(boton[i]);
        }
        
        //Agregando el panel al Frame
        this.getContentPane().add(panel);
        
        
    }
    
    private void llamarD0( ActionEvent e){
        InPais dia0 = new InPais(this, country,contador);
    }
    
    private void llamarD1( ActionEvent e){
        InEstimadores dia1 = new InEstimadores(this , country);
       
    }
    
    private void llamarD2( ActionEvent e){
         Busqueda dia2 =  new Busqueda(this , country);
    }
    
    private void llamarD3( ActionEvent e){
        Comparacion dia3 = new Comparacion(this,country);
    }
    
    private void llamarD4( ActionEvent e){
        GraficaPastel dia4 = new GraficaPastel(this, country);
        
    }
    
     private void llamarD5(ActionEvent event) {
                Estadistica dia5 = new Estadistica(this, country);
            }
    
    

}
