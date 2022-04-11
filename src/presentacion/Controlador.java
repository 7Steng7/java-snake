
package presentacion;

import java.awt.event.*;


public class Controlador implements ActionListener, KeyListener{

    private Modelo modelo;
    private char direccion = 'R';
    
    public Controlador(Vista aThis) {
        modelo = aThis.getModelo();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        try{
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direccion != 'R') {
                        direccion = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direccion != 'L') {
                        direccion = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direccion != 'D') {
                        direccion = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direccion != 'U') {
                        direccion = 'D';
                    }
                    break;
            }
            modelo.recibirTecla(direccion);
        }catch(Exception t){
            System.err.println(t);
        }
    }
    

    @Override
    public void keyReleased(KeyEvent e){
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        modelo.simular();
    } 
}
