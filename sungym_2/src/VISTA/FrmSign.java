package VISTA;
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

import java.awt.ComponentOrientation;
public class FrmSign {

	private JFrame frame;
	private JTextField JTFDNI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSign window = new FrmSign();
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
	public FrmSign() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Ventana
		
		frame = new JFrame();
		frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame.getContentPane().setBackground(SystemColor.controlDkShadow);
		frame.setBounds(0, 0, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Imagen fichar 
		//ImageIcon iFFondo = new ImageIcon("src/RECURSOS/pesas.png");
       // ImageIcon iFEFondo = new ImageIcon(iFFondo.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_DEFAULT));
		
		//Label informativo
		JLabel JLlogin = new JLabel(" SIGN				       		            Sungym");
		JLlogin.setBackground(new Color(255, 51, 255));
		JLlogin.setOpaque(true);
		JLlogin.setFont(new Font("Courier New", Font.CENTER_BASELINE, 23));
		JLlogin.setForeground(Color.WHITE);
		JLlogin.setBounds(0, 0, 450, 40);
		frame.getContentPane().add(JLlogin, BorderLayout.NORTH);
		
		//TextField usuario
		JTFDNI = new JTextField();
		JTFDNI.setBounds(144, 83, 150, 24);
		TextPrompt placeholder = new TextPrompt("DNI", JTFDNI);
	    placeholder.changeAlpha(0.75f);
	    placeholder.changeStyle(Font.ITALIC);
		frame.getContentPane().add(JTFDNI);
		JTFDNI.setHorizontalAlignment(JTextField.LEFT); 
		JTFDNI.setColumns(10);
		
		//Icono de boton fichar
		ImageIcon iconBSign = new ImageIcon("src/RECURSOS/sign.png");
        ImageIcon iconEBSign = new ImageIcon(iconBSign.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
        
        //Boton para fichar
		JButton bSign = new JButton();
		bSign.setBounds(210, 128, 34, 40);
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
		
	}
}
