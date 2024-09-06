package cg;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    
    public boolean upPressed, downPressed, rightPressed, leftPressed; 

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_S){
            upPressed = true;
        }
        if(code == KeyEvent.VK_W){
            downPressed = true;
        }
        if(code == KeyEvent.VK_A){
            rightPressed = true;
        }
        if(code == KeyEvent.VK_D){
            leftPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_S){
            upPressed = false;
        }
        if(code == KeyEvent.VK_W){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A){
            rightPressed = false;
        }
        if(code == KeyEvent.VK_D){
            leftPressed = false;
        }
    }
    
}
