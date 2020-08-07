/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generagrafico;
import dk.brics.automaton.RegExp;
import dk.brics.automaton.Automaton;
import java.io.*;


/**
 * @author Carlos
 * @author luisa
 * @author Pablo
 * @author Josue
 */
public class figura1 extends javax.swing.JFrame{
    public String mensaje = "", grafo="";
    public String er1 = "", er2="", ejemplo="";
    private FileWriter archivo = null;
    private PrintWriter pw = null; 
    private String rutaDot = "C:\\Program Files\\Graphviz 2.44.1\\bin\\dot.exe"; //LA RUTA DONDE NOS MUESTRA DONDE ESTA INSTALADO 
    String textoBase = "C:\\Automatas\\EntradaParcial.txt";
    String imagen = "C:\\Automatas\\EntradaParcial.jpg";
    String parametroT = "-Tjpg";
    String parametroO = "-o";
    
    /**
     * comienzo de creacion de clase forma1
     */
    public figura1() {
        initComponents();
        lbIndicaAutomata.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        tfExpresionRegular = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbIndicaAutomata = new javax.swing.JLabel();
        btCargarER = new javax.swing.JButton();
        btVerAutomata = new javax.swing.JButton();
        lbEjemploCadena = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 51));
        setMaximumSize(new java.awt.Dimension(500, 250));
        setMinimumSize(new java.awt.Dimension(500, 250));
        setPreferredSize(new java.awt.Dimension(500, 250));
        getContentPane().setLayout(null);
        getContentPane().add(tfExpresionRegular);
        tfExpresionRegular.setBounds(190, 30, 180, 30);

        jLabel1.setText("Insertar la cadena a evaluar");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 30, 230, 30);

        lbIndicaAutomata.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbIndicaAutomata);
        lbIndicaAutomata.setBounds(90, 140, 360, 50);

        btCargarER.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btCargarER.setText("Ejecutar Expresion Regular");
        btCargarER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCargarERActionPerformed(evt);
            }
        });
        getContentPane().add(btCargarER);
        btCargarER.setBounds(90, 90, 170, 30);

        btVerAutomata.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btVerAutomata.setText("Automata de la Cadena");
        btVerAutomata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerAutomataActionPerformed(evt);
            }
        });
        getContentPane().add(btVerAutomata);
        btVerAutomata.setBounds(300, 90, 160, 30);

        lbEjemploCadena.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbEjemploCadena);
        lbEjemploCadena.setBounds(20, 180, 460, 40);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void btCargarERActionPerformed(java.awt.event.ActionEvent evt) {                                           
        reinicio();
        borraArchivo(textoBase);
        borraArchivo(imagen);
        convierteCadena();
        revisaCadena();
        ejemploCadena();
        grafico();
        creaTexto();
        creaImagen();
    }                                          

    private void btVerAutomataActionPerformed(java.awt.event.ActionEvent evt) {                                              
        repaint();
        new Automata().setVisible(true);
    }                                             
    
    private void convierteCadena(){
        er1 = tfExpresionRegular.getText();
        for (int j=0; j< er1.length();j++){
            char letra = er1.charAt(j);
            int ascii = (int) letra;
            //System.out.print(ascii);
            if (ascii == 32){
                er2=er2+" ";
            }
            else{
                er2=er2+letra;
            }
        }
    }
    
    private void revisaCadena(){
        //er2 = tfExpresionRegular.getText();
        for (int i=0; i< er2.length();i++){
            char token = er2.charAt(i);
            //int ascii = (int) token;
            //System.out.print(ascii);
            //if (ascii == 32){
            if (token == ' '){
                mensaje = "La expresion regular representa un AFND";
                break;
            }
            else{
                mensaje = "La expresion regular representa un AFD";
            }
        }
        lbIndicaAutomata.setText(mensaje);
        lbIndicaAutomata.setVisible(true);
    }
    
    private void grafico(){
        //System.out.print(er2);
        RegExp exp_reg = new RegExp(er2);
        Automaton aut = exp_reg.toAutomaton();
        grafo = aut.toDot();       
        //System.out.println(grafo);
    }
    
    public void creaTexto(){
        try{
                archivo = new FileWriter(textoBase);
                pw = new PrintWriter(archivo);
                grafo = grafo.replace("u0020","Ɛ");
                pw.write(grafo);
                archivo.close();
                grafo="";
        }
        catch(IOException e){
            System.err.println("ERROR en archivo: "+ e.toString());
        }
    }
    
    public void creaImagen(){
        try{
            String[] cmd = new String[5];
            cmd[0] = rutaDot;
            cmd[1] = parametroT;
            cmd[2] = textoBase;
            cmd[3] = parametroO;
            cmd[4] = imagen;

            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void borraArchivo(String path){
        File archivo = new File(path);
        archivo.delete();
    }
    
    public void reinicio(){
        lbIndicaAutomata.setText("");
        lbIndicaAutomata.setVisible(false);
        mensaje = ""; 
        grafo= "";
        er1 = ""; 
        er2= "";
        ejemplo = "";
        archivo = null;
        pw=null;
    }
    
    public void ejemploCadena(){
        int cont=0;
        for (int i=0; i< er2.length();i++){
            char token = er2.charAt(i);
            if (token == '*' || token == '+'){
                cont=cont+1;
            }
        }
        if (cont==0){
            ejemplo=er2;
            ejemplo = ejemplo.replace(" ","");
        }
        else
            ejemplo = ejemploEspecial(er2);
        lbEjemploCadena.setText("Cadena valida de la ER: "+ejemplo);
        lbEjemploCadena.setVisible(true);
    }
    
    public String ejemploEspecial(String cadena){
        String kleene="";
        cadena=cadena.replace("+","");
        for (int i=0; i< cadena.length();i++){
            char token = cadena.charAt(i);
            if (token == '*'){
                kleene=cadena.charAt(i-1)+"*";
                cadena=cadena.replace(kleene,"  ");                
            }
        }
        cadena = cadena.replace(" ","");
        return cadena;
    }
        
    public static void main(String args[]) {
                try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(figura1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(figura1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(figura1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(figura1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new figura1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btCargarER;
    private javax.swing.JButton btVerAutomata;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbEjemploCadena;
    private javax.swing.JLabel lbIndicaAutomata;
    private javax.swing.JTextField tfExpresionRegular;
    // End of variables declaration                   
}
