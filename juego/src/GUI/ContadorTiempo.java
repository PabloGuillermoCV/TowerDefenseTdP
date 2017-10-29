package GUI;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Logica.Nivel;


public class ContadorTiempo extends Thread {

	private Nivel nivel;

	ContadorTiempo(Nivel lvl) {
		nivel = lvl;
	}
	
	public Nivel getNivel () {
		return nivel;
	}

	public void run() {
		while(!nivel.getMapa().getListaEnemigos().isEmpty()){
			try {
				nivel.moverEnemigos();
				//System.out.println("estoy en ContadorTiempo");
				Thread.sleep (1000);
				nivel.InteraccionControlableEnemigo();
				
			} catch (InterruptedException e) {
				System.out.println("error en el thread");
				e.printStackTrace();
			}
		}
		//bajo estas condiciones, si salgo del while es porque gané la partida y debo pasar al siguiente Nivel
		cantarVictoria();
	}
	
	private void cantarVictoria(){
		 AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File("src\\Audio\\Audio.Sonidos\\Victoria.WAV").getAbsoluteFile());
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	    Clip clip;
			try {
				clip = AudioSystem.getClip();
				if(audioInputStream != null){
					clip.open(audioInputStream);
					clip.start();
				}
			} catch (LineUnavailableException |IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}