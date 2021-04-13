package FrontEnd;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import BackEnd.ImagemPanel;

public class Janela extends JFrame{
	
	private ImagemPanel jpnComImagem;
	private JButton btnJogar;
	private JButton btnSair;
	private JLabel lblInicio;
	private JLabel lblRegras;
	
	public Janela() {
		super();
		this.configurarFrame();
		this.configurarJpanelComImagem();
		this.setTitle("JOGO DOS DADOS");
		this.add(this.jpnComImagem);
		this.setVisible(true);
		this.criarComponentes();
		this.adicionarComponentes();
	}
	
	private void criarComponentes() {
		this.btnJogar = new JButton("JOGAR");
		this.btnSair = new JButton("SAIR");
		this.lblInicio = new JLabel("JOGO DOS DADOS");
		this.lblRegras = new JLabel("NO JOGO, VOCE TEM 3 TENTATIVAS PARA ACERTAR O VALOR SOMADO DE DOIS DADOS, APOSTE SUAS FICHAS E VENHA JOGAR");
	}
	
	private void adicionarComponentes() {
		this.lblInicio.setFont(new Font("Arial", Font.ITALIC,86));
		this.jpnComImagem.add(lblInicio);
		this.jpnComImagem.add(this.btnJogar);
		this.btnJogar.addActionListener(e -> {
        	JanelaJogo janelajogo = new JanelaJogo();
        });
		this.jpnComImagem.add(this.btnSair);
		this.btnSair.addActionListener(e -> {
        	System.exit(0);
        });
		this.lblRegras.setFont(new Font("Arial", Font.ITALIC,12));
		this.jpnComImagem.add(lblRegras);
	}
	
	
	private void configurarFrame() {
		this.setTitle("JPanel com imagens");
		this.setSize(850,300);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void configurarJpanelComImagem() {
		this.jpnComImagem = new ImagemPanel();
		this.jpnComImagem.setPreferredSize(this.getSize());
	}
	
}
	