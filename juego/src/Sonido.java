
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
 
public class Sonido extends JFrame implements ActionListener{
    JButton boton1 = new JButton();
    ImageIcon cara = new ImageIcon("src/GUI/Sprites Botones/caraBoton.png");
    public Sonido(){
        super("Pulse el boton");
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        boton1.setIcon(cara);
        add(boton1);
        boton1.addActionListener(this);
        setVisible(true);
    }
    public static void main(String[] Dar10){
        new Sonido();
    }
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
        if(e.getSource() == boton1){
            ReproducirSonido("src/GUI/Sonidos/TestSound.wav");
        }
    }
}