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

@SuppressWarnings("unused")
public class FinDelJuego {
	
	protected JFrame Frame;
	protected MapaLogico miMapa;
	protected JPanel Panel;
	protected JButton Next;
	private Clip Clip;
	private AudioInputStream Audio;
	
	public FinDelJuego (MapaLogico Mapa) {
		
	}
}