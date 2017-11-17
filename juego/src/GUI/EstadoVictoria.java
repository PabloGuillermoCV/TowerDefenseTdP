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
import Logica.Niveles.Nivel;
import javax.swing.JTextArea;

public class EstadoVictoria {
	
	protected JFrame Frame;
	protected Nivel nivel;
	protected JPanel Panel;
	protected JButton Next;
	private Clip Clip;
	private AudioInputStream Audio;
	private JTextArea txtrbienHechoComandante;
	
	public EstadoVictoria (Nivel nivel) {
		this.nivel = nivel;
		nivel.desactivarAudio();
		Frame = new JFrame ("Has Ganado!");
		Frame.setBounds (100, 100, 350, 200);
		Frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		try {
			Audio = AudioSystem.getAudioInputStream (new File("src\\Audio\\Audio.Sonidos\\Victoria.WAV").getAbsoluteFile());
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
		
		Next = new JButton ("Siguiente Nivel");
		Next.setBounds (86, 127, 122, 23);
		Next.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent arg0) {
				Clip.stop ();
				Frame.setVisible (false);
				Frame.dispose(); //Elimino el Frame para liberar memoria
				nivel.getMapa().eliminarTodo ();
				nivel.siguienteNivel ();
			}
		});
		Panel.add (Next, BorderLayout.CENTER);
		
		txtrbienHechoComandante = new JTextArea();
		txtrbienHechoComandante.setEnabled(true);
		txtrbienHechoComandante.setEditable(false);
		txtrbienHechoComandante.setWrapStyleWord(true);
		txtrbienHechoComandante.setLineWrap(true);
		txtrbienHechoComandante.setText("\u00A1Bien hecho, Comandante! \u00A1Has repelido la Invasi\u00F3n!  \u00A1Vayamos al siguiente campamento para defenderlo!");
		txtrbienHechoComandante.setBounds(10, 11, 302, 105);
		Panel.add(txtrbienHechoComandante);
		Next.setVisible (true);
		
		Frame.setVisible (true);
	}
}