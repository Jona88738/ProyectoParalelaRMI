/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import rmiproyectopalabras.Cliente;

/**
 *
 * @author Jona xD
 */
public class ventana extends JFrame {

    private JPanel pan = new JPanel();
    private JTextArea textAreaMo = new JTextArea();
    private JScrollPane scroll = new JScrollPane(textAreaMo, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    private JTextArea textAlgoritmo = new JTextArea();
    private JScrollPane scrollAl = new JScrollPane(textAlgoritmo, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    private JLabel sgSecuencial = new JLabel("");
    private JLabel sgFork = new JLabel("");
    private JLabel sgExe = new JLabel("");

    private char[] arr;
    private char[] arrAux;
    private String text = "";
    private int[] posiEspacio;
    
    Cliente cliente;
    public ventana() {
        pantalla();
        panel();
        text();
        textArea();
        btnObtenerTexto();
        btnSecuencial();
        btnForkJoin();
        btnExecute();
        btnLimpiar();

        cliente = new Cliente();
    }

    public void pantalla() {
        this.setSize(1200, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Palabras");
        this.setLocationRelativeTo(null);
    }

    public void panel() {
        JLabel titulo = new JLabel();
        titulo.setText("Proyecto de palabras");
        titulo.setBounds(500, 10, 150, 20);
        
        this.getContentPane().add(pan);
        pan.setBackground(Color.lightGray);
        pan.setLayout(null);
        pan.add(titulo);

    }

    public void text() {
        JLabel textNum = new JLabel();
        textNum.setText("Ingresa el texto");
        textNum.setBounds(190, 50, 200, 20);
        pan.add(textNum);

        JLabel textResul = new JLabel("Texto modificado");
        textResul.setBounds(860, 50, 150, 20);
        pan.add(textResul);

        sgSecuencial.setBounds(200, 550, 50, 20);
        sgSecuencial.setFont(new Font("Dialog",Font.BOLD,18));
        pan.add(sgSecuencial);

        sgFork.setBounds(360, 550, 50, 20);
        sgFork.setFont(new Font("Dialog",Font.BOLD,18));
        pan.add(sgFork);
        sgExe.setBounds(490, 550, 50, 20);
        sgExe.setFont(new Font("Dialog",Font.BOLD,18));
        pan.add(sgExe);
    }

    public void textArea() {
       // font fuente = new font("Dialog",Font.BOLD,36);
        textAreaMo.setLineWrap(true);
        textAreaMo.setFont(new Font("Dialog",Font.BOLD,18));
        scroll.setBounds(50, 80, 400, 450);

        pan.add(scroll);

        textAlgoritmo.setLineWrap(true);
        textAlgoritmo.setFont(new Font("Dialog",Font.BOLD,18));
        scrollAl.setBounds(700, 80, 400, 450);
        pan.add(scrollAl);
    }
    
    public int[] prepararArr(String text ){
        
        int cantEspacio = 0;
                int i = 0;

                //espacio es igual a 32 
                while (i < text.length()) {
                    if (text.charAt(i) == 32 ||  text.charAt(i) == '\n' ) {
                        // System.out.println("Encontrado");
                        cantEspacio++;
                    }
                    
                    i++;

                }
                i = 0;
                int p = 1; //0
                int[]  posiEspacio = new int[cantEspacio+1];
                //System.out.println("total "+eps.length);

                for (int j = 0; j < text.length(); j++) {

                    if (text.charAt(i) == 32 || text.charAt(i) == '\n') {
                        //System.out.println("En "+i);
                        //a++;
                        posiEspacio[p] = i;
                        p++;
                    }
                    i++;
                }
                return posiEspacio;
    }
    
    public void btnObtenerTexto(){
        JButton botonIngresar = new JButton("Ingresar");
        botonIngresar.setBounds(10, 600, 100, 30);
         botonIngresar.setBackground(Color.GREEN);
          botonIngresar.setForeground(Color.black);
        pan.add(botonIngresar);
        
        botonIngresar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
  
                
                text = textAreaMo.getText();

                int cantPalab = text.length();
                arr = new char[cantPalab];
                arr = text.toCharArray();
                
                
               posiEspacio = prepararArr(text);
                try {
                    cliente.servidor.cadena(text);
                } catch (RemoteException ex) {
                    Logger.getLogger(ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
               JOptionPane.showMessageDialog(null, "Informacion Ingresada");
            }
            
        });
    }
    public void btnSecuencial() {
        JButton botonIngre = new JButton("Secuencial");
        botonIngre.setBounds(180, 600, 100, 30);
        botonIngre.setBackground(Color.GREEN);
        botonIngre.setForeground(Color.black);
        pan.add(botonIngre);

        botonIngre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if(text.equals("")){
                        JOptionPane.showMessageDialog(null, "Ingresa primero un Texto \nDespues da click al boton Ingresar");
                }else{
                    
                    long inicio = System.currentTimeMillis();
                secuencial sec = new secuencial(text, posiEspacio);
                sec.recurPalabra(arr, posiEspacio, posiEspacio.length - 1);
                    try {
                        cliente.servidor.secuencial();
                    } catch (RemoteException ex) {
                        Logger.getLogger(ventana.class.getName()).log(Level.SEVERE, null, ex);
                    }
                long finall = System.currentTimeMillis();
                
                double tiempo = (double) (finall - inicio);
                textAlgoritmo.setText(String.valueOf(arr));
                sgSecuencial.setText("" + tiempo);
                arr = text.toCharArray();
                }
                
                
            }

        });
    }

    public void btnForkJoin() {
        JButton btnFork = new JButton("Fork/Join");
        btnFork.setBounds(320, 600, 100, 30);
        btnFork.setBackground(Color.GREEN);
        btnFork.setForeground(Color.black);
        pan.add(btnFork);

        btnFork.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                //int medio = (posiEspacio.length) / 2;
                
                if(text.equals("")){
                        JOptionPane.showMessageDialog(null, "Ingresa primero un Texto \nDespues da click al boton Ingresar");
                }else{
                    
                    
                    ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
                forkJoin algoritmo = new forkJoin(arr, posiEspacio, posiEspacio.length - 1);
                
                long inicio = System.currentTimeMillis();
                pool.invoke(algoritmo);
                
                
                long fin = System.currentTimeMillis();
                double tiempo = (double) fin - inicio;
                sgFork.setText("" + tiempo);
                textAlgoritmo.setText(String.valueOf(arr));

                pool.isShutdown();
                
                arr = text.toCharArray();
                }
                

            }

        });
    }

    public void btnExecute() {
        JButton btnExecute = new JButton("Execute");
        btnExecute.setBounds(450, 600, 100, 30);
        btnExecute.setBackground(Color.GREEN);
        btnExecute.setForeground(Color.black);
        pan.add(btnExecute);

        btnExecute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 
                
                
                 if(text.equals("")){
                        JOptionPane.showMessageDialog(null, "Ingresa primero un Texto \nDespues da click al boton Ingresar");
                }else{
                int medio = (posiEspacio.length) / 6;
                
                int limite = 0;
                      ExecutorService executor = Executors.newFixedThreadPool(6);
                long in = System.currentTimeMillis();
                
                executor.execute( new executeService(arr, posiEspacio,0,medio) );
                executor.execute( new executeService(arr, posiEspacio, medio,medio*2) );
                executor.execute( new executeService(arr, posiEspacio, medio*2,medio*3) );
                executor.execute( new executeService(arr, posiEspacio, medio*3,medio*4) );
                executor.execute( new executeService(arr, posiEspacio, medio*4,medio*5) );
                executor.execute( new executeService(arr, posiEspacio, medio*5,medio*6-1) );
                
                
                
                executor.shutdownNow();
                
                while (!executor.isTerminated()) {

                }
                
                long fin = System.currentTimeMillis();
                double tiempo = (double) fin - in;
                sgExe.setText("" + tiempo);
                textAlgoritmo.setText(String.valueOf(arr));
                
                arr = text.toCharArray();
                 }
                //ArrayList<executeService>execu = new ArrayList<executeService>();
                
               
            }

        });
    }

    public void btnLimpiar() {
        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(600, 600, 100, 30);
        btnLimpiar.setBackground(Color.GREEN);
        btnLimpiar.setForeground(Color.black);
        pan.add(btnLimpiar);
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAlgoritmo.setText("");
                textAreaMo.setText("");
            }

        });

    }
}
