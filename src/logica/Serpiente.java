    
package logica;

import java.util.Random;

public class Serpiente extends Thread{
private int cuerpo = 6;
private int tamanoParte;
private int frutaX;
private int frutaY;
private int frutasComidas;
private int altoEspacio;
private int anchoEspacio;
private int espacios;
private int snakeX [];
private int snakeY [];
private boolean vivo = true;
Random aleatorio;

public Serpiente (int ancho, int alto, int parte){
        this.anchoEspacio = ancho;
        this.altoEspacio = alto;
        this.tamanoParte = parte;
        this.espacios = (altoEspacio*anchoEspacio)/(tamanoParte*tamanoParte);
        this.snakeY = new int [espacios];
        this.snakeX = new int [espacios];
}
public void esperar(int tiempoMS) {
        try {
            Thread.sleep(tiempoMS);
        } catch (InterruptedException ex) {
        }
}
public void movimiento(char direccion){
    
    for(int i = cuerpo; i > 0; i--) {
	snakeX[i] = snakeX[i-1];
	snakeY[i] = snakeY[i-1];
    }
		
    switch(direccion) {
	case 'U'://Arriba
            snakeY[0] = snakeY[0] - tamanoParte;
            break;
        case 'D'://Abajo
            snakeY[0] = snakeY[0] + tamanoParte;
            break;
        case 'L'://Izquierda
            snakeX[0] = snakeX[0] - tamanoParte;
            break;
        case 'R'://Derecha
            snakeX[0] = snakeX[0] + tamanoParte;
            break;
        }    
    }
public void viviendo (){
    //¿Cabeza toca alguna parte del cuerpo?
    for(int i = cuerpo; i >0; i--){
        if(snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]){
            this.vivo = false;
        }
    }
    //¿Cabeza toca borde izquierdo?
    if(snakeX[0] < 0) {
	this.vivo = false;
    }
    //¿Cabeza toca borde derecho?
    if(snakeX[0] >= anchoEspacio) {
	this.vivo = false;
    }
    //¿Cabeza toca borde superior?
    if(snakeY[0] < 0) {
	this.vivo = false;
    }
    //¿Cabeza toca borde inferior?
    if(snakeY[0] >= altoEspacio) {
	this.vivo = false;
    }
}

public void crearFruta (){
    this.frutaX = (int) Math.floor(Math.random()*(0-600+1)+600);
    this.frutaX =  ((int) frutaX/tamanoParte)*tamanoParte;
    this.frutaY = (int) Math.floor(Math.random()*(0-600+1)+600);
    this.frutaY =  ((int) frutaY/tamanoParte)*tamanoParte;
}

public void frutaComida() {
    if(snakeX[0] == frutaX && snakeY[0] == frutaY){
	cuerpo ++;
	frutasComidas++;
	this.crearFruta();
    }
}
public int getFrutaComida(){
    return this.frutasComidas;
}
public int[] getsnakeX(){
    return this.snakeX;
}

public int[] getsnakeY(){
    return this.snakeY;
}

public int getCuerpo(){
    return this.cuerpo;
}

public int getFrutaX (){
    return this.frutaX;
}

public int getFrutaY (){
    return this.frutaY;
}

public boolean getViviendo(){
    return this.vivo;
}

}
