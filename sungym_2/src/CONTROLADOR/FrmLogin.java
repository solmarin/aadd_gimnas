package CONTROLADOR;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import RECURSOS.TextPrompt;
import VISTA.FrmPersonal;
import VISTA.FrmSign;
import VISTA.FrmUser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JTextField;

import DATOS.SQLUsers;
import MODELO.Usuario;

import javax.swing.JPasswordField;
import java.awt.ComponentOrientation;
/**
 * Clase que controla el diseño y la programación de la vista para entrar al programa. 
 * @author Sol Marín
 * @version 3
 *
 */
public class FrmLogin {
	//Declaración de variables
		private JFrame frameLogin;
		private JTextField JTFUser;
		private JPasswordField passwordField;
		private JLabel JLlogin;
		private TextPrompt placeholder;
		private ImageIcon iconBSign;
	    private ImageIcon iconEBSign;
	    private ImageIcon iconBSignin;
	    private ImageIcon iconEBSignin;
	    private JButton bSign;
	    private JButton bSingin;
	    private JLabel JLImagen;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin window = new FrmLogin();
					window.frameLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.diseño();
		this.eventos();
	}
	
	/**
	 * Función que contiene todos los parametros de diseño de la vista.
	 */
	public void diseño() {
		//Ventana
			frameLogin = new JFrame();
			frameLogin.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			frameLogin.getContentPane().setBackground(SystemColor.text);
			frameLogin.setBounds(0, 0, 450, 300);
			frameLogin.setLocationRelativeTo(null);
			frameLogin.getContentPane().setLayout(null);
			frameLogin.setResizable(false);
			frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		//Label informativo
			JLlogin = new JLabel(" LOGIN				       		            Sungym");
			JLlogin.setBackground(new Color(255, 51, 255));
			JLlogin.setOpaque(true);
			JLlogin.setFont(new Font("Courier New", Font.CENTER_BASELINE, 23));
			JLlogin.setForeground(Color.WHITE);
			JLlogin.setBounds(0, 0, 450, 40);
			frameLogin.getContentPane().add(JLlogin, BorderLayout.NORTH);
			
		//TextField usuario
			JTFUser = new JTextField();
			JTFUser.setBounds(144, 83, 150, 24);
			placeholder = new TextPrompt("User", JTFUser);
		    placeholder.changeAlpha(0.75f);
		    placeholder.changeStyle(Font.ITALIC);
			frameLogin.getContentPane().add(JTFUser);
			JTFUser.setHorizontalAlignment(JTextField.LEFT); 
			JTFUser.setColumns(10);
			
		//Contraseña
			passwordField = new JPasswordField("Password");
			passwordField.setBounds(144, 110, 150, 24);
			frameLogin.getContentPane().add(passwordField);
			
		//Icono de boton fichar
			iconBSign = new ImageIcon("src/RECURSOS/sign.png");
	        iconEBSign = new ImageIcon(iconBSign.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
	        
	     //Boton para fichar
			bSign = new JButton();
			bSign.setBounds(390, 207, 34, 40);
			frameLogin.getContentPane().add(bSign);
			bSign.setMnemonic(KeyEvent.VK_ENTER);
			bSign.setIgnoreRepaint(true);
			bSign.setBorderPainted(false);
			bSign.setContentAreaFilled(false);
			bSign.setIcon(iconEBSign);
			bSign.setFocusable(false);
			
		//Icono de boton entrar
			iconBSignin= new ImageIcon("src/RECURSOS/signin.png");
	        iconEBSignin = new ImageIcon(iconBSignin.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
			
		//Boton para entrar 
			bSingin = new JButton();
			bSingin.setBounds(165, 164, 117, 25);
			frameLogin.getContentPane().add(bSingin);
			bSingin.setMnemonic(KeyEvent.VK_ENTER);
			bSingin.setIgnoreRepaint(true);
			bSingin.setBorderPainted(false);
			bSingin.setContentAreaFilled(false);
			bSingin.setIcon(iconEBSignin);
			bSingin.setFocusable(false);
				
		//Imagen fondo
			JLImagen = new JLabel();
			JLImagen.setBackground(new Color(255, 255, 255));
			JLImagen.setOpaque(true);
			JLImagen.setBounds(0, 34, 450, 238);
			JLImagen.setIcon(new ImageIcon(FrmLogin.class.getResource("/RECURSOS/gym.jpg")));
			JLImagen.setFocusable(false);
			
			frameLogin.getContentPane().add(JLImagen);
		
	}
	
	/**
	 * Función que contiene y ejecuta los eventos de la vista.
	 */
	public void eventos() {
		//Evento: abrir ventana sign
			bSign.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					FrmSign frmSign = new FrmSign();
					FrmSign.frameSign.setVisible(true);
			
				}
			});
				
		//Evento: abrir ventana de usuario o admin
			bSingin.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							try {
								comprobarUsuario();
							} catch (SQLException | ParseException e) {
								JOptionPane.showConfirmDialog(null, "Error: administar programador. Nota: botón fichar.", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
							} 
						}
					});
		
	}
	
	/**
	 * Función que comprueba si existe el usuario. En caso afirmativo, se mira si la contraseña es correcta y 
	 * que tipo de usuario es para abrirle la ventana correspondiente a su tipo de usuario.
	 * @throws ParseException 
	 * @throws SQLException 
	 * 
	 */
	public void comprobarUsuario() throws SQLException, ParseException {
		SQLUsers sqlUsers = new SQLUsers();
		ArrayList<Usuario> usu = null;
		try {
			 usu = sqlUsers.consultar(JTFUser.getText());
		} catch (SQLException e) {
			JOptionPane.showConfirmDialog(null, "Error: administrar programador. Nota: comprobar usuario.", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);

		}
		
		if(usu.isEmpty()) {
			JOptionPane.showConfirmDialog(null, "Error: el usuario no existe.", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
		}else {
			if(usu.get(0).getcontrasena().contentEquals(String.valueOf(passwordField.getPassword()))) {
				//abrir ventana segun tipo de usuario
				if (isPersonal(usu.get(0))){
					FrmPersonal frmPersonal = new FrmPersonal(usu.get(0));
					frmPersonal.framePersonal.setVisible(true);
				}else {
					FrmUser frmUser = new FrmUser(usu.get(0));
					frmUser.frameUser.setVisible(true);
				}
			}else {
				JOptionPane.showConfirmDialog(null, "Error: contraseña o usuario incorrecto", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
				
			}
		}
		
	}
	
	/**
	 * Función para saber si el usuario es del personal o un cliente.
	 * @param usu = DNI del usuario
	 * @return booleano true = personal false = cliente
	 */
	public boolean isPersonal(Usuario usu) {
		if(usu.isRol()) return true;
		else return false;
	}
	
}
