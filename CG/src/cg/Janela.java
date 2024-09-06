package cg;

import javax.swing.JFrame;

public class Janela extends JFrame{
    //Criação da Janela
       JFrame janela = new JFrame();
    
    //Criação do construtor
        Janela(){
        //Definição dos parametros da janela
            janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
            janela.setResizable(false);
            janela.setTitle("Caça ao tesouro");
            janela.setLocationRelativeTo(null);
            janela.setSize(300, 300);
            janela.setVisible(true);
            
        //Chamada do game panel
            GamePanel gamePanel = new GamePanel();
            
        //Adicionando o painel na tela
            janela.add(gamePanel);
            
        //Redimensionando a tela baseada no computador
            janela.pack();
            
            gamePanel.startGameThread();
        }
}