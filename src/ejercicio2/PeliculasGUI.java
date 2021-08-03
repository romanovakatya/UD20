package ejercicio2;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PeliculasGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JComboBox<Object> comboBox;

	/**
	 * Create the frame.
	 */
	public PeliculasGUI() {
		setTitle("Películas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel lblTitulo = new JLabel("Escribe el título de una película");
		lblTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblTitulo);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(30);
		panel_1.add(panel_3);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_3.add(textField);
		textField.setColumns(15);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAdd = new JButton("Añadir");
		
		//añadimos listener addPeli al botón añadir pelicula,
		btnAdd.addActionListener(addPeli);
		panel_4.add(btnAdd);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel lblPelis = new JLabel("Películas");
		lblPelis.setHorizontalAlignment(SwingConstants.CENTER);
		lblPelis.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_2.add(lblPelis);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_6.getLayout();
		flowLayout_1.setVgap(30);
		panel_2.add(panel_6);
		
		comboBox = new JComboBox<>();
		panel_6.add(comboBox);
		comboBox.addItem("Blade Runner");
		
	}
	
	//listener que escucha cuando se pulsa el botón Añadir,
	//cuando lo sucede coge el valor de textField y lo añade al menu desplegable,
	ActionListener addPeli = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			if (textField.getText().trim().length() > 0) {
				comboBox.addItem(textField.getText().trim());
				
			}else {
				JOptionPane.showMessageDialog(contentPane, "Escribe nombre de una película");
			}
			textField.setText(" ");	
		}
	};

}
