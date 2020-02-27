package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JButton;

public class ArchivoGui {

	private JFrame frmModuloParaGestionar;
	private JTextField textNombre;
	private JLabel lblTipoArchivo;
	private JTextField textTipoArchivo;
	private JLabel lblMensaje;
	private JTextField textBuscar;

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
		lblMensaje.setBounds(54, 179, 56, 16);
		frmModuloParaGestionar.getContentPane().add(lblMensaje);
		
		JTextArea textAreaMensaje = new JTextArea();
		textAreaMensaje.setBounds(54, 221, 378, 201);
		frmModuloParaGestionar.getContentPane().add(textAreaMensaje);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(411, 221, 21, 201);
		frmModuloParaGestionar.getContentPane().add(scrollBar);
		
		JButton btnCrear = new JButton("CREAR");
		btnCrear.setBounds(218, 472, 97, 25);
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
		
		JTextArea textAreaResultado = new JTextArea();
		textAreaResultado.setBounds(517, 154, 378, 343);
		frmModuloParaGestionar.getContentPane().add(textAreaResultado);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(874, 166, 21, 331);
		frmModuloParaGestionar.getContentPane().add(scrollBar_1);
	}
}
