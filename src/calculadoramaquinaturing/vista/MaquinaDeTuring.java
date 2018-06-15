/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoramaquinaturing.vista;

import calculadoramaquinaturing.vista.control.ControlEntradas;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author law
 */
public class MaquinaDeTuring extends JPanel{
    
    private ControlEntradas controlEntradas;
    private String CADENA;
    private String OPERACION, CAD1, CAD2;
    private int NUMERO_1, NUMERO_2, RESPUESTA, RESIDUO;
    private boolean CINTA_VACIA = false;
    private boolean PINTAR_CINTA_EN_BLANCO = false;
    
    private int anchoVentana = 1000, altoventana = 600;
    private int anchoCuadro, altoCuadro;
    private int NUMERO_TOTAL_DE_POSICIONES;
    
    
    //Imagenes
    public Image img_uno    = getToolkit().getImage(getClass().getResource("imagenes/1.png"));//---------------> 0
    public Image img_suma   = getToolkit().getImage(getClass().getResource("imagenes/mas.png"));//-------------> 1
    public Image img_resta  = getToolkit().getImage(getClass().getResource("imagenes/menos.png"));//-----------> 2
    public Image img_multi  = getToolkit().getImage(getClass().getResource("imagenes/multiplicacion.png"));//--> 3
    public Image img_divi   = getToolkit().getImage(getClass().getResource("imagenes/division.png"));//--------> 4
    public Image img_igual  = getToolkit().getImage(getClass().getResource("imagenes/igual.png"));//-----------> 5
    public Image img_resid  = getToolkit().getImage(getClass().getResource("imagenes/r.png"));//---------------> 6
    public Image img_x_ree  = getToolkit().getImage(getClass().getResource("imagenes/x.png"));//---------------> 7
    public Image img_numer  = getToolkit().getImage(getClass().getResource("imagenes/numeral.png"));//---------> 8
    
    
    
    private ArrayList<Cuadro> CINTA = new ArrayList<Cuadro>();
    private ArrayList<Cuadro> CINTA_EN_BLANCO = new ArrayList<Cuadro>();
    private ArrayList<Image> IMGS = new ArrayList<Image>();
    
    
    
    
    public MaquinaDeTuring(String cadena){
        this.CADENA = cadena;
        setLayout(null);
        setSize(anchoVentana, altoventana);
        procesarDatosLlegada();
        
    }
    
    
    
    
    
    
    
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        //Laz linea horizontale de la cinta
        g.drawLine(0, 198, anchoVentana, 198);
        g.drawLine(0, 199, anchoVentana, 199);
        //g.drawLine(100, 200, 900, 200);
        g.drawLine(0, 201, anchoVentana, 201);
        g.drawLine(0, 202, anchoVentana, 202);
        
        
        g.drawLine(0, 298, anchoVentana, 298);
        g.drawLine(0, 299, anchoVentana, 299);
        //g.drawLine(100, 300, 900, 300);
        g.drawLine(0, 301, anchoVentana, 301);
        g.drawLine(0, 302, anchoVentana, 302);
        
        if(!CINTA_VACIA){
            //Si la cina esta vacia,la dibujamos vacia
            g.drawLine((anchoVentana/2) - 25, 201, (anchoVentana/2) - 25, 299);
            g.drawLine((anchoVentana/2) - 24, 201, (anchoVentana/2) - 24, 299);
            g.drawLine((anchoVentana/2) + 24, 201, (anchoVentana/2) + 24, 299);
            g.drawLine((anchoVentana/2) + 25, 201, (anchoVentana/2) + 25, 299);
            
            //Textos descriptivos
            g.setFont(new Font("SansSerif", 2, 36));
            
            g.drawString("#", (anchoVentana/2)-10, 255);
            
        }
        
        
        
        if(PINTAR_CINTA_EN_BLANCO){
            for(int i = 0; i< CINTA_EN_BLANCO.size(); i++){
                g.drawImage(IMGS.get(CINTA_EN_BLANCO.get(i).getImagen()), CINTA_EN_BLANCO.get(i).getCoorX(), CINTA_EN_BLANCO.get(i).getCoorY(), CINTA_EN_BLANCO.get(i).getAncho(), CINTA_EN_BLANCO.get(i).getAlto(), this);
                System.out.println("Pinto " + i);
            }
            System.err.println("-----------------");
        }//Fin del que pinta la cinta vacia
        
        
        
        
        
    }//Fin del metodo pain









    public void procesarDatosLlegada(){
    
        String op = "", cad1 = "", cad2 = "";
        
        //Sacamos primero el caracter de la operacion
        if(this.CADENA.contains("+"))op = "+";
        if(this.CADENA.contains("-"))op = "-";
        if(this.CADENA.contains("x"))op = "x";
        if(this.CADENA.contains("/"))op = "/";
        
        
        
        cad1 = this.CADENA.substring(0, this.CADENA.indexOf(op));
        cad2 = this.CADENA.substring(this.CADENA.indexOf(op)+1, this.CADENA.length());
        
        //System.out.println("Cad1: " + cad1);
        //System.out.println("Cad2: " + cad2);
        
        
        //Asignamos los datos a las variabes locales
        this.CAD1 = cad1;
        this.CAD2 = cad2;
        this.OPERACION = op;
        this.NUMERO_1 = Integer.parseInt(cad1);
        this.NUMERO_2 = Integer.parseInt(cad2);
        
        System.out.print(this.CADENA + " = ");
        switch(op){
            case "+":
                System.out.println(this.NUMERO_1 + this.NUMERO_2);
                this.RESPUESTA = this.NUMERO_1 + this.NUMERO_2;
                break;
            case "-":
                System.out.println(this.NUMERO_1 - this.NUMERO_2);
                this.RESPUESTA = this.NUMERO_1 - this.NUMERO_2;
                break;
            case "x":
                System.out.println(this.NUMERO_1 * this.NUMERO_2);
                this.RESPUESTA = this.NUMERO_1 * this.NUMERO_2;
                break;
            case "/":
                System.out.println(this.NUMERO_1 / this.NUMERO_2);
                this.RESPUESTA = this.NUMERO_1 / this.NUMERO_2;
                this.RESIDUO = this.NUMERO_1 % this.NUMERO_2;
                break;
            default:
                System.out.println(this.NUMERO_1 +" No se proceso "+ this.NUMERO_2);
                break;
        }
        this.NUMERO_TOTAL_DE_POSICIONES = this.NUMERO_1 + this.NUMERO_2 + 2 + Math.abs(this.RESPUESTA);
        if(op.equals("/") && this.RESIDUO != 0) this.NUMERO_TOTAL_DE_POSICIONES += this.RESIDUO + 1;
        System.err.println("Numero toral de posiciones: " + NUMERO_TOTAL_DE_POSICIONES);
        
        iniciarComponentes();
        
    }//Fin del metodo procesar datos

    
    
    
    
    
    
    
    
    
    
    public void iniciarComponentes(){
        
        this.anchoCuadro = anchoVentana/NUMERO_TOTAL_DE_POSICIONES;
        this.altoCuadro = 100;
        
        if(anchoCuadro>100){
            anchoCuadro = 100;
        }
        
        
        
        int band = anchoCuadro * NUMERO_TOTAL_DE_POSICIONES;
        int band2 = (anchoCuadro/2)-(band/2);
        int contadorx = anchoCuadro;
        
        
        IMGS.add(img_uno);
        IMGS.add(img_suma);
        IMGS.add(img_resta);
        IMGS.add(img_multi);
        IMGS.add(img_divi);
        IMGS.add(img_igual);
        IMGS.add(img_resid);
        IMGS.add(img_x_ree);
        IMGS.add(img_numer);
        
        for(int i = 0; i<this.NUMERO_1; i++){
            CINTA.add(new Cuadro("1", anchoCuadro, altoCuadro, 0, contadorx, 203, false));
            CINTA_EN_BLANCO.add(new Cuadro("#", anchoCuadro, altoCuadro, 8, contadorx, 203, false));
            contadorx += anchoCuadro;
            System.err.println("-------------------------------------------" + contadorx);
        }
        
        
        int indexOperacion = 0;
        switch(this.OPERACION){
            case "+":
                indexOperacion = 1;
                break;
            case "-":
                indexOperacion = 2;
                break;
            case "x":
                indexOperacion = 3;
                break;
            case "/":
                indexOperacion = 4;
                break;
        }
        CINTA.add(new Cuadro(this.OPERACION, anchoCuadro, altoCuadro, indexOperacion, (contadorx), 203, false));
        CINTA_EN_BLANCO.add(new Cuadro("#", anchoCuadro, altoCuadro, 8, (contadorx), 203, false));
        contadorx += anchoCuadro;
        System.err.println("-------------------------------------------" + contadorx);
        
        
        
        
        for(int i = 0; i<this.NUMERO_2; i++){
            CINTA.add(new Cuadro("1", anchoCuadro, altoCuadro, 0, (contadorx), 203, false));
            CINTA_EN_BLANCO.add(new Cuadro("#", anchoCuadro, altoCuadro, 8, (contadorx), 203, false));
            contadorx += anchoCuadro;
            System.err.println("-------------------------------------------" + contadorx);
        }
        
        
        
        
        
        
        for(int i = 0; i< CINTA_EN_BLANCO.size(); i++){
            System.out.println("Pocicion>" + i +": " +CINTA_EN_BLANCO.get(i).getImagen() +" - "+ CINTA_EN_BLANCO.get(i).getCoorX()+" - "+ CINTA_EN_BLANCO.get(i).getCoorY() +" - "+ CINTA_EN_BLANCO.get(i).getAncho()+" - "+ CINTA_EN_BLANCO.get(i).getAlto());
            System.err.println();
        }
        
        String respuesta = controlEntradas.darResultado(indexOperacion, this.NUMERO_1, this.NUMERO_2);
        
        new IniciarOperacion().start();
        
    }//Fin de la funcion iniciar componentes
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private class IniciarOperacion extends Thread{
        public IniciarOperacion(){
            
        }
        
        
        @Override
        public void run(){
            try {sleep(2000);} catch (InterruptedException ex) {}
            CINTA_VACIA = true;
            PINTAR_CINTA_EN_BLANCO = true;
            repaint();
            
        }
    }//Fin de la clase privada IniciarOperacion
    
}//Fin de la clase principal
