package BackEnd;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagemPanel extends JPanel{
	@Override
	protected void paintComponent(Graphics GraficoGenerico) {
		try {
			Graphics2D grafico2d = (Graphics2D) GraficoGenerico;
			InputStream imageInputStream = getClass().getResourceAsStream("jogo.jpg");
			BufferedImage bufferimage = ImageIO.read(imageInputStream);
			Image imageRedimensionada = bufferimage.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
			grafico2d.drawImage(imageRedimensionada, 0, 0, this);
			
		} catch (Exception e) {
			System.err.println("Imagem nao encontrada!");
		}
	}
}
