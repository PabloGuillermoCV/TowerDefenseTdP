package Audio;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sonido {
	
	private AudioInputStream audioInputStream;
	private Clip clip;
	private static Sonido Instancia;
	
	public static Sonido getInstancia() {
		if(Instancia == null) {
			Instancia = new Sonido();
		}
		
		return Instancia;
	}
	
	/**
	 * m�todo que inicia la m�sica seteada PREVIAMENTE por el m�todo setAudio(File)
	 */
	public void Activar() {
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	/**
	 * m�todo que detiene la m�sica seteada PREVIAMENTE por el m�todo setAudio(File)
	 */
	public void Desactivar() {
		clip.close();
	}
	
	/**
	 * m�todo que setea la canci�n a reproducir
	 * @param cancion direcci�n de la canci�n a reproducir
	 */
	public void setAudio(File cancion){
		try {
			audioInputStream = AudioSystem.getAudioInputStream(cancion);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream); //cuando seteo el audio lo abro, con esto manejamos el audio de los niveles
			//despues se llama a Sonido.activar();
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}