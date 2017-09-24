package GUI;

import Logica.*;
import entidades.*;
import Enemigos.*;
import Controlables.*;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

@SuppressWarnings({ "serial", "unused" })
public class GUI extends JFrame {
	private JFrame ventana;
	private ContadorTiempo tiempo;
	private static int width=500;
	private static int height=320;
	private static String direccion= "src\\GUI\\Sprites Mapas\\Mapa1.png";
	private MapaVisual mapa;
	private Nivel nivel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater (new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public GUI () {
		this.getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(517, 360);
		mapa = new MapaVisual(width,height,direccion);
		nivel= new Nivel(this);
		this.getContentPane().add(mapa);
		this.add(mapa);
		tiempo = new ContadorTiempo(nivel);
		tiempo.start();
		//ver();
	}
	
	public MapaVisual getMapaVisual() {
		return mapa;
	}
	
	/**
	 * metodo que reproduce sonidos (para botones en particular, tengo entendido que para lo que seria BGM tenemos que hacer un Thread)
	 * @param nombreSonido direccion al archivo de sonido (DEBE SER UN .wav, NO funciona con otros formatos)
	 */
	private void ReproducirSonido(String nombreSonido){
	       try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	       } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
	         System.out.println("Error al reproducir el sonido.");
	       }
	     }
	
	private void ver() {
		APie E = new APie(new Posicion (80,60));
		E.getGrafico().setVisible(true);
		this.getContentPane().add(E.getGrafico());
	}
}