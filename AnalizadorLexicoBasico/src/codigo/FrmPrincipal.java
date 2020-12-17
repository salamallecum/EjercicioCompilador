/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALEJO
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_Entrada = new javax.swing.JTextField();
        btn_Analizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Resultado = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador Lexico en Java");

        txt_Entrada.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_Entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_EntradaActionPerformed(evt);
            }
        });

        btn_Analizar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_Analizar.setText("Analizar");
        btn_Analizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AnalizarActionPerformed(evt);
            }
        });

        txt_Resultado.setColumns(20);
        txt_Resultado.setRows(5);
        jScrollPane1.setViewportView(txt_Resultado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_Entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btn_Analizar)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Analizar)
                    .addComponent(txt_Entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_EntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_EntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_EntradaActionPerformed

    //Metodo del boton Analizar
    private void btn_AnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AnalizarActionPerformed
        
        //Crea un archivo y escribir en el todo lo que escribamos para analizar
        File archivo = new File("archivo.txt");
        PrintWriter escribir;
        try {
            escribir = new PrintWriter(archivo);
            escribir.print(txt_Entrada.getText());
            escribir.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Reader lector = new BufferedReader(new FileReader("archivo.txt"));
            Lexer lexer = new Lexer(lector);
            String resultado = "";
            
            while(true){
                Tokens tokens = lexer.yylex();
                
                if(tokens == null){
                    resultado += "FIN";
                    txt_Resultado.setText(resultado);
                    return; 
                }
                
                switch(tokens){
                    case ERROR:
                        resultado += "Simbolo no definido\n";
                        break;
                        
                    case Identificador: case Numero: case Reservadas:
                        resultado += lexer.lexeme + " Es un " + tokens + "\n";
                        break;
                        
                    default:
                        resultado += "Token: " + tokens + "\n";
                        break;
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_btn_AnalizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Analizar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_Entrada;
    private javax.swing.JTextArea txt_Resultado;
    // End of variables declaration//GEN-END:variables
}
