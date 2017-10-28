package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("unused")
public class MenuPrincipal {

	private JFrame frame;
	private JTextField Autores;
	private GUI siguienteNivel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblimagenDelTitulo = new JLabel("All your base are NOT belong to us");
		lblimagenDelTitulo.setFont(new Font("Century Schoolbook", Font.BOLD, 14));
		lblimagenDelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblimagenDelTitulo, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton jugar = new JButton("Empezar");
		jugar.setBounds(130, 56, 122, 23);
		jugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				siguienteNivel = GUI.InstanciaGUI();
				siguienteNivel.setVisible(true);
				siguienteNivel.setBounds(100,100,500,750);
				
				
			}
		});
		panel.setLayout(null);
		panel.add(jugar);
		
		JButton Opciones = new JButton("Opciones");
		Opciones.setBounds(156, 110, 77, 23);
		panel.add(Opciones);
		
		JButton EXIT = new JButton("Salir");
		EXIT.setBounds(156, 164, 77, 23);
		panel.add(EXIT);
		
		Autores = new JTextField();
		Autores.setBounds(156, 216, 86, 20);
		Autores.setText("TdP 2017");
		panel.add(Autores);
		Autores.setColumns(10);
	}
}