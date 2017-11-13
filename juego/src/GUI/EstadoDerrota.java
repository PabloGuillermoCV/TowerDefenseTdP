package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Logica.MapaLogico;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class EstadoDerrota {
	
	protected JFrame Frame;
	protected MapaLogico miMapa;
	protected JPanel Panel;
	protected JButton Next;
	private Clip Clip;
	private AudioInputStream Audio;
	
	public EstadoDerrota (MapaLogico Mapa) {
		this.miMapa = Mapa;
		miMapa.getNivel().getAudio().Desactivar(); //no me desactiva la música no se porque, pero solo a partir del Nivel 2
		Frame = new JFrame ("Has Perdido");
		Frame.setBounds (100, 100, 350, 200);
		Frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		try {
			Audio = AudioSystem.getAudioInputStream (new File("src\\Audio\\Audio.Sonidos\\Derrota.WAV").getAbsoluteFile());
			Clip = AudioSystem.getClip ();
			if (Audio != null) {
				Clip.open (Audio);
				Clip.start ();
				Clip.loop (javax.sound.sampled.Clip.LOOP_CONTINUOUSLY);
			}
		}
		catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace ();
		}
		catch (LineUnavailableException e) {
			e.printStackTrace ();
		}
		
		Panel = new JPanel ();
		Frame.getContentPane ().add (Panel, BorderLayout.CENTER);
		Panel.setLayout (null);
		
		Next = new JButton ("Reiniciar");
		Next.setBounds (90, 127, 122, 23);
		Next.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent arg0) {
				Clip.stop ();
				Frame.setVisible (false);
				Frame.dispose();
				//Falta hacer que todo se reinicie
				miMapa.eliminarTodo();
				miMapa.getNivel().reiniciar();
			}
		});
		Panel.add (Next, BorderLayout.CENTER);
		
		JTextArea txtrpulsaElBotn = new JTextArea();
		txtrpulsaElBotn.setLineWrap(true);
		txtrpulsaElBotn.setWrapStyleWord(true);
		txtrpulsaElBotn.setEnabled(false);
		txtrpulsaElBotn.setBackground(Color.WHITE);
		txtrpulsaElBotn.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrpulsaElBotn.setEditable(false);
		txtrpulsaElBotn.setText("Pulsa el bot\u00F3n de abajo para empezar el nivel de nuevo. \u00A1buena suerte, Comandante!");
		txtrpulsaElBotn.setBounds(10, 25, 292, 78);
		Panel.add(txtrpulsaElBotn);
		Next.setVisible (true);
		
		Frame.setVisible (true);
	}
}