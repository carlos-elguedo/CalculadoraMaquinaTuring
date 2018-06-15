/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoramaquinaturing.vista;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author SIS
 */
public class Cuadro {
    
    private String valor;
    private int ancho;
    private int alto;
    private int imagen;
    private int coorX;
    private int coorY;
    private boolean visible;

    public Cuadro(String valor, int ancho, int alto, int imagen, int coorX, int coorY, boolean visible) {
        this.valor = valor;
        this.ancho = ancho;
        this.alto = alto;
        this.imagen = imagen;
        this.coorX = coorX;
        this.coorY = coorY;
        this.visible = visible;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    

    
    
    
    
    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getCoorX() {
        return coorX;
    }

    public void setCoorX(int coorX) {
        this.coorX = coorX;
    }

    public int getCoorY() {
        return coorY;
    }

    public void setCoorY(int coorY) {
        this.coorY = coorY;
    }
    
    

    
    
    
}
