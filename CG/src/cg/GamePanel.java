package cg;

import java.awt.Color;
import java.awt.Dimension;
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
        
    //Criação da thread para o jogo
        Thread gameThread;
        
    //Definição do construtor    
        public GamePanel(){
        //Definição dos tiles na tela
            this.setPreferredSize(new Dimension(telaLargura,telaAltura));
            this.setBackground(Color.black);
            this.setDoubleBuffered(true);
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
        //Loop para testar se a thread funciona
            while(gameThread != null){
                System.out.println("The thread is running");
            }
        }
}
