package ejercicio3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import javax.swing.JRadioButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EncuestaGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ButtonGroup bgroup;
	private JSlider slider;
	private JRadioButton rdbtnWindows;
	private JRadioButton rdbtnLinux;
	private JRadioButton rdbtnMac;
	private JCheckBox chckbxProgramacion;
	private JCheckBox chckbxDisegn;
	private JCheckBox chckbxAdministracion;


	/**
	 * Create the frame.
	 */
	public EncuestaGUI() {
		setTitle("Encuesta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));

		rdbtnWindows = new JRadioButton("Windows");
		rdbtnWindows.setSelected(true);
		rdbtnWindows.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(rdbtnWindows);
		
		rdbtnLinux = new JRadioButton("Linux");
		rdbtnLinux.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(rdbtnLinux);

		rdbtnMac = new JRadioButton("Mac");
		rdbtnMac.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(rdbtnMac);

		bgroup = new ButtonGroup();
		bgroup.add(rdbtnWindows);
		bgroup.add(rdbtnLinux);
		bgroup.add(rdbtnMac);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 1, 0, 0));

		chckbxProgramacion = new JCheckBox("Programación");
		
		chckbxProgramacion.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(chckbxProgramacion);
			
		chckbxDisegn = new JCheckBox("Diseño gráfico");
		chckbxDisegn.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(chckbxDisegn);
		
		chckbxAdministracion = new JCheckBox("Administración");		
		chckbxAdministracion.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(chckbxAdministracion);

		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 1, 0, 0));

		JLabel lblHoras = new JLabel("Horas dedicadas en el ordenador:");
		lblHoras.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblHoras);

		slider = new JSlider();
		lblHoras.setLabelFor(slider);
		slider.setValue(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(1);
		slider.setMaximum(10);
		slider.setMajorTickSpacing(1);
		panel_3.add(slider);

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setVgap(20);
		contentPane.add(panel_4);

		JButton btnShow = new JButton("Mostrar datos");
		btnShow.addActionListener(showDate);
		panel_4.add(btnShow);			
	}
	
	//listener que coge todos los datos de la encuesta y los muestra en un pop,
	ActionListener showDate = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			//radio botónes, puede ser solo una opción elegida,
			String message = "Sistema operativo: ";
			if (rdbtnMac.isSelected()) {
				message += rdbtnMac.getText();
			}
			else if(rdbtnLinux.isSelected()) {
				message += rdbtnLinux.getText();
			}else {
				message += rdbtnWindows.getText();
			}
			
			message += "\n";
			
			//checkbox, puede ser de 0 a N opciones elegidos,
			if (chckbxProgramacion.isSelected()) {
				message += "Especialidad: " + chckbxProgramacion.getText() + "\n";
			}
			if (chckbxDisegn.isSelected()) {
				message += "Especialidad: " + chckbxDisegn.getText() + "\n";
			}
			if (chckbxAdministracion.isSelected()) {
				message += "Especialidad: " + chckbxAdministracion.getText() + "\n";
			}
			
			//datos de slider,
			message += "Horas en el ordenador: " + slider.getValue();
			
			JOptionPane.showInternalMessageDialog(contentPane, message);
						
		}
	};

}
