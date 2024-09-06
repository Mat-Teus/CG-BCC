package cg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    //Definição de atributos dos tiles
        final int tileOriginal = 16;
        final int escala = 3;
        final int tileFinal = tileOriginal * escala;
        final int maxTelaColuna = 16;
        final int maxTelaLinha = 12;
        final int telaLargura = tileFinal * maxTelaColuna; //769 pixels
        final int telaAltura = tileFinal * maxTelaLinha;  //576 pixels
        int playerX = 100;
        int playerY = 100;
        int speed = 4;
        KeyHandler tecla = new KeyHandler();
        int FPS = 60;
        
    //Criação da thread para o jogo
        Thread gameThread;
        
    //Definição do construtor    
        public GamePanel(){
        //Definição dos tiles na tela
            this.setPreferredSize(new Dimension(telaLargura,telaAltura));
            this.setBackground(Color.black);
            this.setDoubleBuffered(true);
            this.addKeyListener(tecla);
            this.setFocusable(true);
        }
        
    //Função que começa a thread do jogo
        public void startGameThread(){
        //Definições da game thread
            gameThread = new Thread(this);
            gameThread.start();
        }
        
    //Implementação do Runnable
        @Override
        public void run() {
        long currentTime;
        double desenhaIntervalo = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long timer = 0;
        long drawCount = 0;
        
            
        //Loop para testar se a thread funciona
            while(gameThread != null){
                currentTime = System.nanoTime();
                delta +=  (currentTime - lastTime)/desenhaIntervalo;
                timer +=  (currentTime - lastTime)/desenhaIntervalo;
                lastTime = currentTime;
                
                if(delta>=1){
                    update();
                    repaint();
                    delta--;
                    drawCount++;
                }
            }
        }
        
        public void update(){
            if(tecla.upPressed == true){
                playerY += speed;
            }
            if(tecla.downPressed == true){
                playerY -= speed;
            }
            if(tecla.leftPressed == true){
                playerX += speed;
            }
            if(tecla.rightPressed == true){
                playerX -= speed;
            }
        }
        
        @Override
        public void paintComponent (Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.white);
            g2.fillRect(playerX, playerY, tileFinal, tileFinal);
            g2.dispose();
        }
}
