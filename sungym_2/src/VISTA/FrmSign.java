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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.WindowConstants;

import DATOS.SQLEs;
import DATOS.SQLGyms;
import MODELO.ES;

import java.awt.ComponentOrientation;
public class FrmSign {

	public static JFrame frameSign;
	private JTextField JTFDNI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSign window = new FrmSign();
					window.frameSign.setVisible(true);
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
		
		frameSign = new JFrame();
		frameSign.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frameSign.getContentPane().setBackground(SystemColor.controlDkShadow);
		frameSign.setBounds(0, 0, 450, 300);
		frameSign.setLocationRelativeTo(null);
		frameSign.getContentPane().setLayout(null);
		frameSign.setResizable(false);
		frameSign.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
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
		frameSign.getContentPane().add(JLlogin, BorderLayout.NORTH);
		
		//TextField usuario
		JTFDNI = new JTextField();
		JTFDNI.setBounds(144, 83, 150, 24);
		TextPrompt placeholder = new TextPrompt("DNI", JTFDNI);
	    placeholder.changeAlpha(0.75f);
	    placeholder.changeStyle(Font.ITALIC);
		frameSign.getContentPane().add(JTFDNI);
		JTFDNI.setHorizontalAlignment(JTextField.LEFT); 
		JTFDNI.setColumns(10);
		
		//Icono de boton fichar
		ImageIcon iconBSign = new ImageIcon("src/RECURSOS/sign.png");
        ImageIcon iconEBSign = new ImageIcon(iconBSign.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
        
        //Boton para fichar
		JButton bSign = new JButton();
		bSign.setBounds(210, 128, 34, 40);
		frameSign.getContentPane().add(bSign);
		bSign.setMnemonic(KeyEvent.VK_ENTER);
		bSign.setIgnoreRepaint(true);
		bSign.setBorderPainted(false);
		bSign.setContentAreaFilled(false);
		bSign.setIcon(iconEBSign);
		bSign.setFocusable(false);
		
		bSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//declaramos y inicializamos variables
				SQLGyms sqlGyms = new SQLGyms();
				SQLEs sqlEs = new SQLEs();
								
				//consulta sql para añadir el registro a la tablas
				
				try {
					sqlEs.crear(new ES(generarGym(sqlEs,sqlGyms,JTFDNI.getText()),JTFDNI.getText(),generarFecha(),generarEoS(sqlEs,JTFDNI.getText())));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		
			}
		});			
		
	}
	/**
	 * funcion para atrapar la fecha actual del sistema y devolverla.
	 * @return fecha en formato yyy/mm/dd hh:mm:ss
	 */
	public String generarFecha() {
		Calendar cal;
		String fecha;
		
		cal = Calendar.getInstance();
		
		fecha = Integer.toString(cal.get(Calendar.YEAR))+"/"
				+ Integer.toString(cal.get(Calendar.MONTH))+"/"
				+ Integer.toString(cal.get(Calendar.DATE))+" "
				+ Integer.toString(cal.get(Calendar.HOUR))+":"
				+ Integer.toString(cal.get(Calendar.MINUTE))+":"
				+ Integer.toString(cal.get(Calendar.SECOND));
		
		return fecha;
		
	}
	/**
	 * Función que devuelve el booleano para generar la siguiente entrada o salida segun los campos que ya existen en la tabla.
	 * @param sqlEs
	 * @param DNI campo para filtrar la consulta en la tabla ES
	 * @return booleano
	 */
	public boolean generarEoS(SQLEs sqlEs, String DNI){
		ArrayList<ES> aES = null;
		try {
			aES = sqlEs.consultar(DNI);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("errrrror");
		}
		
		//Tratamiento segun si existe ya un registro o no con este DNI
		if (aES.isEmpty())return true;	
		else {
			ES es = aES.get(aES.size() - 1);
			if(es.iseS()) return false;
			else return true;
		}
		
	}
	/**
	 * Función que te asigna un idgym segun si ya estas dentro, no estas dentro o no existes en la tabla.
	 * @param sqlEs
	 * @param sqlGyms
	 * @param DNI para filtrar la consulta en la tabla ES
	 * @return integer
	 */
	public int generarGym(SQLEs sqlEs, SQLGyms sqlGyms, String DNI){
		ArrayList<ES> aES = null;
		
		try {
			aES = sqlEs.consultar(DNI);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("errrrror");
		}
		
		//Tratamiento segun si existe ya un registro o no con este DNI y el idGym que devuelve 
		if (aES.isEmpty()) {
			 return numeroAleatorio(sqlGyms);
		}else {
			ES es = aES.get(aES.size() - 1);
			if(es.iseS()) return es.getIdGym();
			else return numeroAleatorio(sqlGyms);
		}
		
	}
	/**
	 * Función para generar un numeroAleatorio entre el numero maximo de gimnasios que hay.
	 * @param sqlGyms
	 * @return integer
	 */
	public int numeroAleatorio(SQLGyms sqlGyms) {
		int max = -1;
		int idGym;
		
		try {
			max = sqlGyms.consultar().size();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		idGym = (int)Math.floor(Math.random()*max+1);
		
		return idGym;
		
	}
	
}
