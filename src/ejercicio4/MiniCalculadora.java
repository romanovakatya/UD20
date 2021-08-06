package ejercicio4;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class MiniCalculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNumber1;
	private JTextField textFieldNumber2;
	private JTextField textFieldResultado;
	private JButton btnSuma;
	private JButton btnResta;
	private JButton btnMultiplicacion;
	private JButton btnDivision;
	private JButton btnAbout;
	private JButton btnExit;
	private JPanel panel;
	private int number1;
	private int number2;
	private float result;
	private JButton btnDelete;

	/**
	 * Create the frame.
	 */
	public MiniCalculadora() {
		setTitle("MiniCalculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 10, 10, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 10, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNumber1 = new JLabel("Number 1");
		lblNumber1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNumber1 = new GridBagConstraints();
		gbc_lblNumber1.weightx = 0.1;
		gbc_lblNumber1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumber1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNumber1.gridx = 0;
		gbc_lblNumber1.gridy = 0;
		contentPane.add(lblNumber1, gbc_lblNumber1);

		JLabel lblNumber2 = new JLabel("Number 2");
		lblNumber2.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNumber2 = new GridBagConstraints();
		gbc_lblNumber2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumber2.weightx = 0.1;
		gbc_lblNumber2.gridx = 1;
		gbc_lblNumber2.gridy = 0;
		contentPane.add(lblNumber2, gbc_lblNumber2);

		JLabel lblResultado = new JLabel("Result");
		lblResultado.setForeground(Color.BLACK);
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblResultado = new GridBagConstraints();
		gbc_lblResultado.gridwidth = 2;
		gbc_lblResultado.weightx = 0.1;
		gbc_lblResultado.insets = new Insets(0, 0, 5, 0);
		gbc_lblResultado.gridx = 2;
		gbc_lblResultado.gridy = 0;
		contentPane.add(lblResultado, gbc_lblResultado);

		textFieldNumber1 = new JTextField();
		textFieldNumber1.setBorder(new LineBorder(new Color(171, 173, 179)));

		// escuchamos cuando usuario empieza introducir datos de número uno,
		textFieldNumber1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				try {

					number1 = Integer.parseInt(textFieldNumber1.getText());
					textFieldNumber1.setBorder(new LineBorder(Color.green));

				}
				// controlamos si usuario escribe una letra en vez de cifra,
				// o no pone nada,
				catch (InputMismatchException ex) {
					textFieldNumber1.setBorder(new LineBorder(Color.red));
					focusGained(e);
					textFieldNumber1.setText("");

				} catch (NumberFormatException ex1) {

					textFieldNumber1.setBorder(new LineBorder(Color.red));
					focusGained(e);
					textFieldNumber1.setText("");
				}
			}
		});

		GridBagConstraints gbc_textFieldNumber1 = new GridBagConstraints();
		gbc_textFieldNumber1.weightx = 0.1;
		gbc_textFieldNumber1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNumber1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNumber1.gridx = 0;
		gbc_textFieldNumber1.gridy = 1;
		contentPane.add(textFieldNumber1, gbc_textFieldNumber1);
		textFieldNumber1.setColumns(10);

		textFieldNumber2 = new JTextField();
		textFieldNumber2.setBorder(new LineBorder(new Color(171, 173, 179)));

		// escuchamos cuando usuario empieza introducir datos de número dos,
		textFieldNumber2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {

					number2 = Integer.parseInt(textFieldNumber2.getText());

					textFieldNumber2.setBorder(new LineBorder(Color.green));

				}
				// controlamos si usuario escribe una letra en vez de cifra,
				// o no pone nada,
				catch (InputMismatchException ex) {
					textFieldNumber2.setBorder(new LineBorder(Color.red));
					focusGained(e);
					textFieldNumber2.setText("");

				} catch (NumberFormatException ex1) {

					textFieldNumber2.setBorder(new LineBorder(Color.red));
					focusGained(e);
					textFieldNumber2.setText("");
				}
			}

		});
		GridBagConstraints gbc_textFieldNumber2 = new GridBagConstraints();
		gbc_textFieldNumber2.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNumber2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNumber2.gridx = 1;
		gbc_textFieldNumber2.gridy = 1;
		contentPane.add(textFieldNumber2, gbc_textFieldNumber2);
		textFieldNumber2.setColumns(10);

		textFieldResultado = new JTextField();
		textFieldResultado.setBorder(new LineBorder(new Color(171, 173, 179)));
		textFieldResultado.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldResultado.setEditable(false);
		GridBagConstraints gbc_textFieldResultado = new GridBagConstraints();
		gbc_textFieldResultado.gridwidth = 2;
		gbc_textFieldResultado.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldResultado.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldResultado.gridx = 2;
		gbc_textFieldResultado.gridy = 1;
		contentPane.add(textFieldResultado, gbc_textFieldResultado);
		textFieldResultado.setColumns(10);

		btnSuma = new JButton("+");
		// listener para sumar dos números,
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				result = Calculo.sumar(number1, number2);
				textFieldResultado.setText(result + "");
			}
		});

		btnSuma.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnSuma = new GridBagConstraints();
		gbc_btnSuma.insets = new Insets(10, 0, 5, 5);
		gbc_btnSuma.gridx = 0;
		gbc_btnSuma.gridy = 2;
		contentPane.add(btnSuma, gbc_btnSuma);

		btnResta = new JButton("-");
		// listener para restar un número de otro,
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				result = Calculo.restar(number1, number2);
				textFieldResultado.setText(result + "");
			}
		});

		btnResta.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnResta = new GridBagConstraints();
		gbc_btnResta.weightx = 0.3;
		gbc_btnResta.insets = new Insets(10, 0, 5, 5);
		gbc_btnResta.gridx = 1;
		gbc_btnResta.gridy = 2;
		contentPane.add(btnResta, gbc_btnResta);

		btnMultiplicacion = new JButton("*");
		// listener para multiplicar dos números,
		btnMultiplicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				result = Calculo.multiplicar(number1, number2);
				textFieldResultado.setText(result + "");
			}
		});
		btnMultiplicacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnMultiplicacion = new GridBagConstraints();
		gbc_btnMultiplicacion.insets = new Insets(10, 0, 5, 5);
		gbc_btnMultiplicacion.gridx = 2;
		gbc_btnMultiplicacion.gridy = 2;
		contentPane.add(btnMultiplicacion, gbc_btnMultiplicacion);

		btnDivision = new JButton("/");
		// listener para dividir número uno a número dos,
		btnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// controlamos división a 0,
				// no podemos controlar exception con try/catch porque utilizamos,
				// float para mostrar resultado exacto donde división a cero,
				// es legal,
				if (number2 != 0) {
					result = Calculo.dividir(number1, number2);
					textFieldResultado.setText(result + "");
				} else {
					textFieldNumber2.setBorder(new LineBorder(Color.red));
					textFieldNumber2.setText("");

					JOptionPane.showMessageDialog(btnDivision, "División a zero es imposible");
				}
			}
		});
		btnDivision.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnDivision = new GridBagConstraints();
		gbc_btnDivision.weightx = 1.0;
		gbc_btnDivision.insets = new Insets(10, 0, 5, 0);
		gbc_btnDivision.gridx = 3;
		gbc_btnDivision.gridy = 2;
		contentPane.add(btnDivision, gbc_btnDivision);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);

		// para mostrar información sobre aplicación,
		btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnAbout,
						"Es una minicalculadora que sabe sumar, restar, multiplicar y dividir\n\r"
								+ "para activar botones de los cálculos hay que introducir numero 1 y numero 2");
			}
		});

		// botón que elimina datos de los campos,
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textFieldNumber1.setText("");
				textFieldNumber2.setText("");
				textFieldResultado.setText("");
				number1 = 0;
				number2 = 0;
				result = 0;
				textFieldNumber1.setBorder(new LineBorder(Color.gray));
				textFieldNumber2.setBorder(new LineBorder(Color.gray));
				textFieldResultado.setBorder(new LineBorder(Color.gray));
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setForeground(new Color(0, 0, 0));
		btnDelete.setBackground(Color.RED);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 1;
		gbc_btnDelete.gridy = 3;
		contentPane.add(btnDelete, gbc_btnDelete);
		GridBagConstraints gbc_btnAbout = new GridBagConstraints();
		gbc_btnAbout.insets = new Insets(0, 0, 0, 5);
		gbc_btnAbout.gridx = 2;
		gbc_btnAbout.gridy = 4;
		contentPane.add(btnAbout, gbc_btnAbout);

		// botón para acabar la aplicación,
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.gridx = 3;
		gbc_btnExit.gridy = 4;
		contentPane.add(btnExit, gbc_btnExit);
	}

}
