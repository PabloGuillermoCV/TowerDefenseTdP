package GUI;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import Logica.Nivel;


public class ContadorTiempo extends Thread {

	private Nivel nivel;
	private AudioInputStream audioInputStream;

	ContadorTiempo(Nivel lvl) {
		nivel = lvl;
	}
	
	public Nivel getNivel () {
		return nivel;
	}

	public void run() {
		while(!nivel.getMapa().getListaEnemigos().isEmpty() && nivel.getMapa().getJugador().getVidas() > 0){
			try {
				nivel.moverEnemigos();
				Thread.sleep (0);
				nivel.InteraccionControlableEnemigo();
							
			} catch (InterruptedException e) {
				System.out.println("error en el thread");
				e.printStackTrace();
			}
		}
		//bajo estas condiciones, si salgo del while por la primera condicion
		//es porque gané la partida y debo pasar al siguiente Nivel
		if (nivel.getMapa().getListaEnemigos().isEmpty()) {
			estadoVictoria ();
		}
		else {
			//Sino sali por la segunda condicion y perdi la partida
			if (nivel.getMapa().getJugador().getVidas() == 0) {
				estadoDerrota ();
			}
		}
	}
	
	private void estadoVictoria () {
		audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream (new File("src\\Audio\\Audio.Sonidos\\Victoria.WAV").getAbsoluteFile());
		}
		catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace ();
		}
   	    Clip clip;
		try {
			clip = AudioSystem.getClip ();
			if (audioInputStream != null) {
				clip.open (audioInputStream);
				clip.start ();
			}
<<<<<<< HEAD
		}
		-<<<<<<< HEAD
		=======
				}
				catch (LineUnavailableException|IOException e) {
					e.printStackTrace ();
		@ -95,6 +93,5 @@ public class ContadorTiempo extends Thread {
				catch (LineUnavailableException|IOException e) {
					e.printStackTrace ();
				}
		>>>>>>> 42de22c5cb26e647602b461befa1fa7d9e618853
			}
=======
>>>>>>> da10a520f69cf5d76e93d02af5052e2d310a0639
		}
		catch (LineUnavailableException|IOException e) {
			e.printStackTrace ();
		}
	}
	
	private void estadoDerrota () {
		audioInputStream = null;
		JFrame frame = new JFrame ();
		frame.setBounds (100, 100, 450, 300);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		try {
			audioInputStream = AudioSystem.getAudioInputStream (new File("src\\Audio\\Audio.Sonidos\\Derrota.WAV").getAbsoluteFile());
		}
		catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace ();
		}
		Clip clip;
		try {
			clip = AudioSystem.getClip ();
			if (audioInputStream != null) {
				clip.open (audioInputStream);
				clip.start ();
			}
		}
		catch (LineUnavailableException|IOException e) {
			e.printStackTrace ();
		}
	}
}