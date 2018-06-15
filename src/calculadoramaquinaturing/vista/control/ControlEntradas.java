/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoramaquinaturing.vista.control;

/**
 *
 * @author law
 */
public class ControlEntradas {
    
    public ControlEntradas(){
        
    }
    
    public boolean puedeBorrar(String cadenaEnCuestion){
        boolean retorno = false;
        
        if(!cadenaEnCuestion.equals(""))retorno = true;
        
        return retorno;
    }
    
    public boolean puedeAnadirOperacion(String cadenaEnCuestion){
        boolean retorno = false;
        
        if(!cadenaEnCuestion.equals("")){
            if(cadenaEnCuestion.indexOf("+") == -1 && cadenaEnCuestion.indexOf("-") == -1 && cadenaEnCuestion.indexOf("x") == -1 && cadenaEnCuestion.indexOf("/") == -1){
                //La cadena tiene algo y no contiene caracteres de operaciones
                retorno = true;
            }
        }
        
        return retorno;
    }
    
    
    public boolean puedeRealizarCalculo(String cadenaEnCuestion){
        boolean retorno = false;
        
        if(!cadenaEnCuestion.equals("")){
            if(cadenaEnCuestion.indexOf("+") != -1 || cadenaEnCuestion.indexOf("-") != -1 || cadenaEnCuestion.indexOf("x") != -1 || cadenaEnCuestion.indexOf("/") != -1){
                //La cadena tiene algo y no contiene caracteres de operaciones
                //Ahora se comprueba que la cadena termine en un numero y no en una operacion
                if(!cadenaEnCuestion.endsWith("+") && !cadenaEnCuestion.endsWith("-") && !cadenaEnCuestion.endsWith("x") && !cadenaEnCuestion.endsWith("/")){
                    retorno = true;
                }
            }
        }
        return retorno;
    }
    
    
}
