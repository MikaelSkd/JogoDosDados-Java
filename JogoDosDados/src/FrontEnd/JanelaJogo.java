package FrontEnd;

import java.net.URL;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class JanelaJogo {

	public JanelaJogo() {
		try {
			Jogo();
		} catch (Exception e) {
			System.err.println("Tente novamente, o jogo aposta em voce");
		}
		
	}
	
	public void Jogo() {
		Random geradorAleatorios = new Random();
        int numero1, numero2, soma, tentativas, aposta, opcao;
        boolean acertou;
        
        // repetição do jogo
        do{
        	
        	Play();
			
        	
        	JOptionPane.showMessageDialog(null, "Os dados iram rolar, tente acertar o resultado!", "JOGO DOS DADOS", JOptionPane.QUESTION_MESSAGE);
            numero1 = geradorAleatorios.nextInt(6)+1;
            numero2 = geradorAleatorios.nextInt(6)+1;
            soma = numero1 + numero2;
            System.out.println("Numero 1 = " + numero1 + " Número 2 = " + numero2 + " Soma = " + soma);
            tentativas = 3;
            acertou = false;
            while(!acertou && tentativas > 0){
       
                aposta = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite sua aposta: ", "JOGO DOS DADOS", JOptionPane.QUESTION_MESSAGE));
                tentativas--;
                if(soma == aposta){
                    acertou = true;
                }else{
                	if(tentativas == 0) {
                		JOptionPane.showMessageDialog(null, "Você errou! Suas tentativas encerraram.", "JOGO DOS DADOS", JOptionPane.QUESTION_MESSAGE);
                	}else
                		JOptionPane.showMessageDialog(null, "Você errou! Você tem " + tentativas + ".", "JOGO DOS DADOS", JOptionPane.QUESTION_MESSAGE);
                }
            }
            if(acertou){
                JOptionPane.showMessageDialog(null, "Você acertou! Parabéns!", "JOGO DOS DADOS", JOptionPane.QUESTION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Jogo encerrado!", "JOGO DOS DADOS", JOptionPane.QUESTION_MESSAGE);
            }
            opcao = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?");
        }while(opcao == 0);
	}
	//Para finalidade do som, deve se aguarda um pouco, pois ele ira buscar o site 
	private void Play() {
		try {
			URL url = new URL("http://www.ringelkater.de/Sounds/2geraeusche_gegenst/wuerfelbecher.wav");
			Clip oClip = AudioSystem.getClip();
			AudioInputStream oStream = AudioSystem.getAudioInputStream(url);
			oClip.open(oStream);
			oClip.loop(0);
			
		}catch(Exception e) {
			System.err.println("Audio nao encontrado!");
		}
		
	}
}
