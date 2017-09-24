package Audio;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Sonido extends JFrame implements ActionListener{
	
    JButton[] boton1 = new JButton[5];
    Random x = new Random();
    ImageIcon[] cara = new ImageIcon[5];
    
    public Sonido(){
    	super("Pulse el boton");
    	for (int i = 0; i < 5; i++) {
    		cara[i] = new ImageIcon("src/GUI/Sprites Botones/cara" + (i+1) + ".png");
    		boton1[i] = new JButton();
    		boton1[i].setLayout(new GridLayout());
    		boton1[i].setIcon(cara[i]);
    		//boton1[i].setText("" + x.nextInt(500));
    		boton1[i].addActionListener(this);
    		add(boton1[i]);
    	}
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        boton1 [0].setText ("" + 200);
        boton1 [1].setText ("" + 300);
        boton1 [2].setText ("" + 500);
        boton1 [3].setText ("" + 500);
        boton1 [4].setText ("" + 650);
        
        setVisible(true);
    }
    
    public static void main(String[] Dar10){
        new Sonido();
    }
    
    /**
	 * metodo que reproduce sonidos (para botones en particular, tengo entendido que para lo que seria BGM tenemos que hacer un Thread)
	 * @param nombreSonido direccion al archivo de sonido (DEBE SER UN .wav, NO funciona con otros formatos)
	 */
    public void ReproducirSonido(String nombreSonido){
        try {
    	    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
       	    Clip clip = AudioSystem.getClip();
       	    clip.open(audioInputStream);
       	    clip.start();
        } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
    	    System.out.println("Error al reproducir el sonido.");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
            ReproducirSonido("src\\Audio\\Sonidos\\TestSound.wav");
    }
}