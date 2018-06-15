/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoramaquinaturing.vista;

import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author law
 */
public class MaquinaDeTuring extends JPanel{
    
    private String CADENA;
    private String OPERACION, CAD1, CAD2;
    private int NUMERO_1, NUMERO_2, RESPUESTA, RESIDUO;
    private boolean CINTA_VACIA = false;
    private int anchoVentana = 1000, altoventana = 600;
    private int NUMERO_TOTAL_DE_POSICIONES;
    private int CABEZAL = 0;
    private ArrayList<String> CINTA_STRING = new ArrayList<String>();
    
    
    
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
        
        //Llenamos la cinta de String
        //Primer elemento
        CINTA_STRING.add("#");
        //Los primeros unos
        for(int i = 0; i<this.NUMERO_1; i++){
            CINTA_STRING.add("1");
        }
        //Añadimos el simbolo de la operacion
        CINTA_STRING.add(op);
        //Los segundos unos
        for(int i = 0; i<this.NUMERO_2; i++){
            CINTA_STRING.add("1");
        }
        //Ultimo caracter
        for(int i = 0; i<100; i++){
            CINTA_STRING.add("#");
        }
        
        
        
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
        
//        for(int i = 0; i<this.CINTA_STRING.size(); i++){
//            System.out.print(" " + CINTA_STRING.get(i));
//        }
        sumaNodo1();
    }//Fin del metodo procesar datos

    
    //Primer nodo
    public void sumaNodo1(){
        int siguiente_funcion = 0;
        switch(CINTA_STRING.get(this.CABEZAL)){
            case "#":
                this.CINTA_STRING.set(CABEZAL, "#");
                this.CABEZAL += 1;
                siguiente_funcion = 1;
                break;
            case "1":
                this.CINTA_STRING.set(CABEZAL, "X");
                this.CABEZAL += 1;
                siguiente_funcion = 1;
                break;
            case "+":
                this.CINTA_STRING.set(CABEZAL, "+");
                this.CABEZAL += 1;
                siguiente_funcion = 2;
                break;
        }
        
        //Ahora dependiendo del valor que tomo la variable de siguiente funcion, se llama al roximo destino
        //Se queda ahi mismo
        if(siguiente_funcion == 1){
            sumaNodo1();
        }
        //Pasa al nodo 2
        if(siguiente_funcion == 2){
            sumaNodo2();
        }
    }//Fin del primer nodo
    
    
    
    
    
    
    //Segundo nodo
    public void sumaNodo2(){
        int siguiente_funcion = 0;
        switch(CINTA_STRING.get(this.CABEZAL)){
            case "1":
                this.CINTA_STRING.set(CABEZAL, "X");
                this.CABEZAL += 1;
                siguiente_funcion = 2;
                break;
            case "#":
                this.CINTA_STRING.set(CABEZAL, "=");
                this.CABEZAL -= 1;
                siguiente_funcion = 3;
                break;
        }
        
        //Ahora dependiendo del valor que tomo la variable de siguiente funcion, se llama al roximo destino
        //Se queda ahi mismo
        if(siguiente_funcion == 2){
            sumaNodo2();
        }
        //Pasa al nodo 3
        if(siguiente_funcion == 3){
            sumaNodo3();
        }
        
    }//Fin del segundo nodo
    
    
    
    
    //Tercera nodo
    public void sumaNodo3(){
        int siguiente_funcion = 0;
        switch(CINTA_STRING.get(this.CABEZAL)){
            case "1":
                this.CINTA_STRING.set(CABEZAL, "1");
                this.CABEZAL -= 1;
                siguiente_funcion = 3;
                break;
            case "X":
                this.CINTA_STRING.set(CABEZAL, "X");
                this.CABEZAL -= 1;
                siguiente_funcion = 3;
                break;
            case "+":
                this.CINTA_STRING.set(CABEZAL, "+");
                this.CABEZAL -= 1;
                siguiente_funcion = 3;
                break;
            case "=":
                this.CINTA_STRING.set(CABEZAL, "=");
                this.CABEZAL -= 1;
                siguiente_funcion = 3;
                break;
            case "#":
                this.CINTA_STRING.set(CABEZAL, "#");
                this.CABEZAL += 1;
                siguiente_funcion = 4;
                break;
        }
        
        //Ahora dependiendo del valor que tomo la variable de siguiente funcion, se llama al roximo destino
        //Se queda ahi mismo
        if(siguiente_funcion == 3){
            sumaNodo3();
        }
        //Pasa al nodo 4
        if(siguiente_funcion == 4){
            sumaNodo4();
            
        }
        
    }//Fin del tercer nodo
    
    
    
    //Cuarto nodo
    public void sumaNodo4(){
        int siguiente_funcion = 0;
        switch(CINTA_STRING.get(this.CABEZAL)){
            case "=":
                this.CINTA_STRING.set(CABEZAL, "=");
                //this.CABEZAL -= 1;
                siguiente_funcion = 6;
                break;
            case "+":
                this.CINTA_STRING.set(CABEZAL, "+");
                this.CABEZAL += 1;
                siguiente_funcion = 4;
                break;
            case "1":
                this.CINTA_STRING.set(CABEZAL, "1");
                this.CABEZAL += 1;
                siguiente_funcion = 4;
                break;
            case "X":
                this.CINTA_STRING.set(CABEZAL, "1");
                this.CABEZAL += 1;
                siguiente_funcion = 5;
                break;
        }
        
        //Ahora dependiendo del valor que tomo la variable de siguiente funcion, se llama al roximo destino
        //Se queda ahi mismo
        if(siguiente_funcion == 4){
            sumaNodo4();
        }
        //Pasa al nodo 5
        if(siguiente_funcion == 5){
            sumaNodo5();
            
        }
        
        //Pasa al nodo 6, el final
        if(siguiente_funcion == 6){
            sumaNodo6Final();
        }
        
    }//Fin del cuarto nodo
    
    
    
    
    
    //Quinto nodo
    public void sumaNodo5(){
        int siguiente_funcion = 0;
        switch(CINTA_STRING.get(this.CABEZAL)){
            case "X":
                this.CINTA_STRING.set(CABEZAL, "X");
                this.CABEZAL += 1;
                siguiente_funcion = 5;
                break;
            case "+":
                this.CINTA_STRING.set(CABEZAL, "+");
                this.CABEZAL += 1;
                siguiente_funcion = 5;
                break;
            case "=":
                this.CINTA_STRING.set(CABEZAL, "=");
                this.CABEZAL += 1;
                siguiente_funcion = 5;
                break;
            case "1":
                this.CINTA_STRING.set(CABEZAL, "1");
                this.CABEZAL += 1;
                siguiente_funcion = 5;
                break;
            case "#":
                this.CINTA_STRING.set(CABEZAL, "1");
                this.CABEZAL -= 1;
                siguiente_funcion = 3;
                break;
        }
        
        //Ahora dependiendo del valor que tomo la variable de siguiente funcion, se llama al roximo destino
        //Se queda ahi mismo
        if(siguiente_funcion == 5){
            sumaNodo5();
        }
        
        //Pasa al nodo 3, el final
        if(siguiente_funcion == 3){
            sumaNodo3();
        }
        
    }//Fin del QUINTO nodo
    
    
    
    
    
    
    //Quinto nodo
    public void sumaNodo6Final(){
        
        
        
        for(int i = 0; i<this.CINTA_STRING.size(); i++){
            if(i > 0 && CINTA_STRING.get(i).equals("#")){
                System.out.print(" " + CINTA_STRING.get(i));
                break;
            }else{
                System.out.print(" " + CINTA_STRING.get(i));
            }
                
        }
        //System.out.println("Cabezal = " + this.CABEZAL);
        
    }//Fin del SEXTO nodo el final
    
    
    
}//Fin de la clase
