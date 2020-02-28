package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ArchivoGui {

	private JFrame frmModuloParaGestionar;
	private JTextField textNombre;
	private JLabel lblTipoArchivo;
	private JTextField textTipoArchivo;
	private JLabel lblMensaje;
	public JTextArea textAreaRsult;
	private JTextField textBuscar;
	private JTextArea textAreaMensaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArchivoGui window = new ArchivoGui();
					window.frmModuloParaGestionar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ArchivoGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmModuloParaGestionar = new JFrame();
		frmModuloParaGestionar.setTitle("MODULO PARA GESTIONAR ARCHIVOS LOCALES");
		frmModuloParaGestionar.setBounds(100, 100, 947, 597);
		frmModuloParaGestionar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModuloParaGestionar.getContentPane().setLayout(null);

		JLabel lblNombre = new JLabel("Nombre del Archivo");
		lblNombre.setBounds(54, 44, 118, 16);
		frmModuloParaGestionar.getContentPane().add(lblNombre);

		textNombre = new JTextField();
		textNombre.setBounds(184, 41, 248, 30);
		frmModuloParaGestionar.getContentPane().add(textNombre);
		textNombre.setColumns(10);

		lblTipoArchivo = new JLabel("Tipo de extension");
		lblTipoArchivo.setBounds(54, 101, 118, 16);
		frmModuloParaGestionar.getContentPane().add(lblTipoArchivo);

		textTipoArchivo = new JTextField();
		textTipoArchivo.setBounds(184, 98, 116, 30);
		frmModuloParaGestionar.getContentPane().add(textTipoArchivo);
		textTipoArchivo.setColumns(10);

		lblMensaje = new JLabel("Mensaje");
		lblMensaje.setBounds(54, 158, 56, 16);
		frmModuloParaGestionar.getContentPane().add(lblMensaje);

		textAreaMensaje = new JTextArea();
		textAreaMensaje.setBounds(54, 187, 378, 255);
		frmModuloParaGestionar.getContentPane().add(textAreaMensaje);

		JButton btnCrear = new JButton("CREAR");
		btnCrear.setBounds(187, 476, 97, 25);
		frmModuloParaGestionar.getContentPane().add(btnCrear);

		JLabel lblBuscar = new JLabel("Burcar Directorio/Archivo");
		lblBuscar.setBounds(517, 29, 155, 16);
		frmModuloParaGestionar.getContentPane().add(lblBuscar);

		textBuscar = new JTextField();
		textBuscar.setBounds(517, 44, 378, 30);
		frmModuloParaGestionar.getContentPane().add(textBuscar);
		textBuscar.setColumns(10);

		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(668, 87, 97, 25);
		frmModuloParaGestionar.getContentPane().add(btnBuscar);

		JTextArea textAreaRsult = new JTextArea();
		textAreaRsult.setBounds(517, 155, 378, 332);
		frmModuloParaGestionar.getContentPane().add(textAreaRsult);
		// textAreaRsult.setColumns(10);

		// accion para escribir un archivo en java
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = textAreaMensaje.getText();
				String nomArc = textNombre.getText();
				String tipoArc = textTipoArchivo.getText();

				if (e.getSource() == btnCrear) {
					File file = new File("C:\\ejemplo\\" + nomArc + "." + tipoArc);

					try {
						FileWriter writer = new FileWriter(file);
						PrintWriter escribir = new PrintWriter(writer);
						escribir.append(texto);
						JOptionPane.showMessageDialog(null, "El archivo ha sido creado con exito");
						escribir.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}

			}
		});

		// accion para leer un archivo por medio una direccion como parametro
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == btnBuscar) {
					File file = new File(textBuscar.getText());

					if (file.exists()) {

						textAreaRsult.setText("Nombre del archivo: " + file.getName());

						if (file.isFile()) {
							textAreaRsult.setText("Tipo de archivo: File");

							try {
								BufferedReader leer = new BufferedReader(new FileReader(file));
								StringBuffer buffer = new StringBuffer();
								String texto;
								textAreaRsult.append(
										"\n\n**************************************************************************************\n\n");

								while ((texto = leer.readLine()) != null) {
									buffer.append(texto + "\n");
								}

								textAreaRsult.append(buffer.toString());

							} catch (Exception e2) {
								// TODO: handle exception
								JOptionPane.showInputDialog(null, "ERROR EN EL ARCHIVO");
							}
						}

						if (file.isDirectory()) {
							textAreaRsult.setText("Tipo de archivo: Directory");
							String directorio[] = file.list();
							textAreaRsult.append("\n\n ****** Archivos que contiene el directorio: *******\n");
							for (int i = 0; i < directorio.length; i++) {
								textAreaRsult.append("* " + directorio[i] + "\n");
							}
						}
					} else
						textAreaRsult.setText("El nombre del archivo no existe o no se ha encontrado");
				}
			}
		});
	}
}
