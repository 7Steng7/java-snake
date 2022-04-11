package presentacion;

import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import logica.Serpiente;

public final class Modelo implements Runnable {
    
    private Thread hiloDibujo;
    private boolean animando;
    private Vista ventana;
    private Serpiente tablero;
    private char direccion = 'R';
    
    // Para evitar parpadeo, utilizaremos doble buffer con:
    private Canvas lienzo; // referenciación al lienzo de la ventana
    private BufferedImage dobleBuffer;
    
    public Modelo() {
        animando = false;
        lienzo = getVentana().getLienzo();
        dobleBuffer = new BufferedImage(lienzo.getWidth(), lienzo.getHeight(), BufferedImage.TYPE_INT_ARGB);
    }
    public void iniciar() {
        getVentana().getBtnAnimar().setText("Iniciar");        
        getVentana().setSize(200, 300);
        getVentana().setVisible(true);
    } 
    private void dibujar() { 
            Graphics g = lienzo.getGraphics();
            Graphics pincel = dobleBuffer.getGraphics(); // Todo el dibujo se trabaja en el dobleBuffer
            pincel.setColor(Color.cyan);
            pincel.fillRect(0, 0, lienzo.getWidth(), lienzo.getHeight());
        
        pincel.setColor(Color.red);
        pincel.fillRect(getTablero().getFrutaX(),getTablero().getFrutaY(),20,20);
            for(int i = 0; i< getTablero().getCuerpo();i++) {
                if(i == 0) {
                    pincel.setColor(Color.black);//Color de la cabeza
                    pincel.fillRect(getTablero().getsnakeX()[i], getTablero().getsnakeY()[i], 20, 20);
                }
                else {
                    pincel.setColor(Color.black); //Color del cuerpo
                    pincel.fillRect(getTablero().getsnakeX()[i], getTablero().getsnakeY()[i], 20, 20);
                }			
                }  
        g.drawImage(dobleBuffer, 0, 0, lienzo); // Por último este dibujo se muestra en el lienzo
        getVentana().getScore().setText("Score : "+getTablero().getFrutaComida());
    }
    
    public void simular() {
        try {
            if (animando) {                
                animando = false;                
                hiloDibujo = null;                
                getVentana().getBtnAnimar().setText("Iniciar");    
                getVentana().setSize(200, 300); 
                
            } else {   
                animando = true;
                getVentana().getBtnAnimar().setText("Detener");    
                getVentana().setSize(800, 650);
                hiloDibujo = new Thread(this);
                hiloDibujo.start();                
            }
        } catch (Exception ex) {            
            System.out.println(ex);
        }
    }
    public void recibirTecla(char tecla){
        direccion = tecla;
    }
     // ------ para la funcionalidad del dibujo del hilo
    @Override
    public void run() {
        Canvas lienzo = getVentana().getLienzo();
        dobleBuffer = new BufferedImage(lienzo.getWidth(), lienzo.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics lapiz = dobleBuffer.getGraphics();
        while (animando) {
            getTablero().movimiento(direccion);
            getTablero().viviendo();
            if(getTablero().getViviendo()== false){
                gameOver(lapiz);
            }else{
               getTablero().viviendo(); 
               getTablero().frutaComida();
               dibujar();
               getTablero().esperar(150);
            }
        }
    }
    public void gameOver(Graphics lapiz) {
        Graphics g = lienzo.getGraphics();
        Graphics pincel = dobleBuffer.getGraphics();
        pincel.setColor(Color.black);
        pincel.fillRect(0, 0, lienzo.getWidth(), lienzo.getHeight());
        pincel.setColor(Color.red);
        pincel.setFont(new java.awt.Font("Courier New", 0, 20));
        pincel.drawString("Game over", 270, 270);
        g.drawImage(dobleBuffer, 0, 0, lienzo);
    }
    
    public Vista getVentana() {
        if (ventana == null) {
            ventana = new Vista(this);
        }
        return ventana;
    }
    public Serpiente getTablero() {
        if (tablero == null) {
            tablero = new Serpiente(600,600,20);
            tablero.crearFruta();
        }
        return tablero; 
    }

}
