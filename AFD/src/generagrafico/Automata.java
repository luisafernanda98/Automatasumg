
package generagrafico;

import javax.swing.*;
/**
 *
 * @author Carlos
 * @author luisa
 * @author Pablo
 * @author Josue
 */
public class Automata extends javax.swing.JFrame {
    /**
     * Creates new form imagenAutomata
     */    
    public Automata() {
        initComponents();
        jLabel1.enable(true);
        jLabel1.setIcon(null);
        jLabel1.setIcon(new ImageIcon("C:\\Automatas\\EntradaParcial.jpg"));
    }
    
    /** En este metodo lo utilizamos para inicializar el constuctor del dicho formulario
     ** 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1300, 700));
        setMinimumSize(new java.awt.Dimension(1300, 700));
        setPreferredSize(new java.awt.Dimension(1300, 700));
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setEnabled(false);
        jLabel1.setFocusable(false);
        jLabel1.setMaximumSize(new java.awt.Dimension(1250, 650));
        jLabel1.setMinimumSize(new java.awt.Dimension(1250, 650));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(1250, 650));
        jLabel1.setRequestFocusEnabled(false);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(25, 75, 1250, 650);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Automata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Automata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Automata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Automata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /*a continuacion crea y muestra el formulario */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Automata().setVisible(true);
            }
        });
    }

    // Variable de declaracion                    
    private javax.swing.JLabel jLabel1;                 
}
