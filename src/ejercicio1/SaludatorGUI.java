package ejercicio1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SaludatorGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public SaludatorGUI() {
		setTitle("Saludator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 200);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel lblSaludo = new JLabel("Escribe un nombre para saludar");
		lblSaludo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblSaludo);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textField);
		textField.setColumns(25);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JButton btnSaludar = new JButton("¡Saludar!");
		
		
		//añadimos un listener al botón,
		btnSaludar.addActionListener(saludar);
		
		btnSaludar.setBackground(SystemColor.window);
		
		panel_2.add(btnSaludar);
	}
	
	
	//listener que se ejecuta cuando sepulsa el botón Saludar,
	ActionListener saludar = new ActionListener() {
			//mostramos una salutación si usuario ha escrito su nombre o lo advirtimos,
			//que puesta el nombre,
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().trim().length() > 0) {
					JOptionPane.showMessageDialog(contentPane, "¡Hola " + textField.getText() + "!");
					
				}else {
					JOptionPane.showMessageDialog(contentPane, "Escribe un nombre");
				}
				textField.setText(" ");								
			}
	};	
}
