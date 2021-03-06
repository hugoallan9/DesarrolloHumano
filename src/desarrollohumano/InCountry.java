/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desarrollohumano;

import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author hugo
 */
public class InCountry extends javax.swing.JDialog {
    private JFrame ventanaPadre;
    private Lista pais = new Lista();
    private Lista ban = new Lista();
    private String ruta;
    private String encontrado;
    /**
     * Creates new form InCountry
     */
    public InCountry(javax.swing.JFrame parent, Lista lis, Lista ban, boolean modal) {
        super(parent, modal);
        ventanaPadre = parent;
        pais = lis;
        this.ban = ban;
        initComponents();
        this.setVisible(true);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiqueta1 = new javax.swing.JLabel();
        texto1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        texto2 = new javax.swing.JTextField();
        etiquet3 = new javax.swing.JLabel();
        texto3 = new javax.swing.JTextField();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        bandera = new javax.swing.JButton();
        imagenBandera = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        etiqueta1.setText("Ingrese el nombre del pais:");

        texto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto1ActionPerformed(evt);
            }
        });
        texto1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                texto1FocusLost(evt);
            }
        });

        jLabel1.setText("Ingrese el continente: ");

        texto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texto2ActionPerformed(evt);
            }
        });

        etiquet3.setText("Ingrese el año:");

        texto3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                texto3KeyPressed(evt);
            }
        });

        aceptar.setText("Aceptar");
        aceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aceptarMouseClicked(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarMouseClicked(evt);
            }
        });

        bandera.setText("Bandera");
        bandera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                banderaMouseClicked(evt);
            }
        });
        bandera.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                banderaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(aceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelar)
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(texto1)
                            .addComponent(etiqueta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(texto2)
                            .addComponent(etiquet3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(texto3))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bandera)
                            .addComponent(imagenBandera, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiqueta1)
                        .addGap(18, 18, 18)
                        .addComponent(texto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imagenBandera, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bandera))
                .addGap(18, 18, 18)
                .addComponent(etiquet3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(texto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(aceptar))
                .addGap(34, 34, 34))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void texto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto1ActionPerformed

    private void texto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texto2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texto2ActionPerformed

    private void aceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aceptarMouseClicked
        // TODO add your handling code here:
        metodoIngreso();
    }//GEN-LAST:event_aceptarMouseClicked

    private void cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_cancelarMouseClicked

    private void texto3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_texto3KeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            metodoIngreso();
        }
        
    }//GEN-LAST:event_texto3KeyPressed

    private void banderaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_banderaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_banderaKeyPressed

    private void banderaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_banderaMouseClicked
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser(".");
        ImagePreviewPanel preview = new ImagePreviewPanel();
    fc.setAccessory(preview);
    fc.addPropertyChangeListener(preview);
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION){
            File archive =fc.getSelectedFile();
            ruta = archive.getPath();
            ban.ingresoNodo(new Pais(texto1.getText(), texto2.getText() , 2000 , 2));
            ban.imprimirLista();
            ban.accesoAleatorio(ban.getPosicion()).setPath(ruta);
            System.out.println("La ruta para la bandera es: " + ruta);
            
            }
    }//GEN-LAST:event_banderaMouseClicked

    private void texto1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_texto1FocusLost
        // TODO add your handling code here:
        Pais temp = ban.getNodo(texto1.getText(), 1);
        encontrado = temp.getName();
        System.out.println(encontrado);
        if(!encontrado.equalsIgnoreCase("")){
            texto2.setText(temp.getContinent());
            ruta = temp.getPath();
            imagenBandera.setIcon(new javax.swing.ImageIcon(temp.getPath()));
        }
    }//GEN-LAST:event_texto1FocusLost

    
    public void metodoIngreso(){
             if(!texto1.getText().equals("") && !texto2.getText().equals("") && !texto3.getText().equals("") ){
            imagenBandera.setIcon(new javax.swing.ImageIcon(ruta));    
            System.out.println("Antes del ingreso: ");
            pais.imprimirLista();
            Lista sub = pais.getSubList( Integer.parseInt(texto3.getText() ));
            System.out.println("Imprimiendo la sublista para verificar");
            sub.imprimirLista();
            Pais existencia = sub.getNodo(texto1.getText().toUpperCase(), 1);
            System.out.println("Imprimiendo el nodo de busqueda para ver que pasa: ");
            existencia.imprimir();
            if( !existencia.getName().equals("") ){
                JOptionPane.showMessageDialog(this, "Pais Ya ingresado!!!!", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                pais.ingresoNodo(new Pais( texto1.getText().toUpperCase() , texto2.getText().toUpperCase(), Integer.parseInt(texto3.getText()) , Menu.contador ));
                pais.accesoAleatorio(pais.getPosicion()).setPath(ruta);
                System.out.println(pais.accesoAleatorio( pais.getPosicion()).getPath());
                Menu.contador++;
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
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    public javax.swing.JButton bandera;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel etiquet3;
    private javax.swing.JLabel etiqueta1;
    private javax.swing.JLabel imagenBandera;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField texto1;
    private javax.swing.JTextField texto2;
    private javax.swing.JTextField texto3;
    // End of variables declaration//GEN-END:variables
}
