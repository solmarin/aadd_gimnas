package CONTROLADOR;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import RECURSOS.TextPrompt;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.ComponentOrientation;
public class FrmLogin {

	private JFrame frame;
	private JTextField JTFUser;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin window = new FrmLogin();
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
	public FrmLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Ventana
		
		frame = new JFrame();
		frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame.getContentPane().setBackground(SystemColor.text);
		frame.setBounds(0, 0, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Imagen fondo login
		//ImageIcon iFLogin = new ImageIcon("src/RECURSOS/login.png");
        //ImageIcon iEFLogin = new ImageIcon(iFLogin.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT));
		
		//Label informativo
		JLabel JLlogin = new JLabel(" LOGIN				       		            Sungym");
		JLlogin.setBackground(new Color(255, 51, 255));
		JLlogin.setOpaque(true);
		JLlogin.setFont(new Font("Courier New", Font.CENTER_BASELINE, 23));
		JLlogin.setForeground(Color.WHITE);
		JLlogin.setBounds(0, 0, 450, 40);
		frame.getContentPane().add(JLlogin, BorderLayout.NORTH);
		
		//TextField usuario
		JTFUser = new JTextField();
		JTFUser.setBounds(144, 83, 150, 24);
		TextPrompt placeholder = new TextPrompt("User", JTFUser);
	    placeholder.changeAlpha(0.75f);
	    placeholder.changeStyle(Font.ITALIC);
		frame.getContentPane().add(JTFUser);
		JTFUser.setHorizontalAlignment(JTextField.LEFT); 
		JTFUser.setColumns(10);
		
		//Contraseña
		passwordField = new JPasswordField("Password");
		passwordField.setBounds(144, 110, 150, 24);
		frame.getContentPane().add(passwordField);
		
		//Icono de boton fichar
		ImageIcon iconBSign = new ImageIcon("src/RECURSOS/sign.png");
        ImageIcon iconEBSign = new ImageIcon(iconBSign.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
        
        //Boton para fichar
		JButton bSign = new JButton();
		bSign.setBounds(390, 207, 34, 40);
		frame.getContentPane().add(bSign);
		bSign.setMnemonic(KeyEvent.VK_ENTER);
		bSign.setIgnoreRepaint(true);
		bSign.setBorderPainted(false);
		bSign.setContentAreaFilled(false);
		bSign.setIcon(iconEBSign);
		bSign.setFocusable(false);
		
		bSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
			}
		});
		
		//Icono de boton entrar
		ImageIcon iconBSignin= new ImageIcon("src/RECURSOS/signin.png");
        ImageIcon iconEBSignin = new ImageIcon(iconBSignin.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
		
		//Boton para entrar 
		JButton bSingin = new JButton();
		bSingin.setBounds(165, 164, 117, 25);
		frame.getContentPane().add(bSingin);
		bSingin.setMnemonic(KeyEvent.VK_ENTER);
		bSingin.setIgnoreRepaint(true);
		bSingin.setBorderPainted(false);
		bSingin.setContentAreaFilled(false);
		bSingin.setIcon(iconEBSignin);
		bSingin.setFocusable(false);
		
		JLabel JLImagen = new JLabel();
		JLImagen.setBackground(new Color(255, 255, 255));
		JLImagen.setOpaque(true);
		JLImagen.setBounds(0, 34, 450, 238);
		JLImagen.setIcon(new ImageIcon(FrmLogin.class.getResource("/RECURSOS/gym.jpg")));
		JLImagen.setFocusable(false);
		
		frame.getContentPane().add(JLImagen);
		
		
		
		
		
				
		
	}
}
