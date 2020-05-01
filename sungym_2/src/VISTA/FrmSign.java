package VISTA;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import DATOS.SQLUsers;
import MODELO.ES;
import MODELO.Usuario;

import java.awt.ComponentOrientation;
public class FrmSign {
	//Declaración variables
		public static JFrame frameSign;
		private JTextField JTFDNI;
		private JLabel JLlogin;
		private TextPrompt placeholder;
		private ImageIcon iconBSign;
        private ImageIcon iconEBSign;
        private JButton bSign;

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
		this.diseño();
		this.eventos();
	}
	
	/**
	 * Función para controlar y definir el diseño de la vista para fichar.
	 */
	public void diseño() {
		//Ventana
			frameSign = new JFrame();
			frameSign.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			frameSign.getContentPane().setBackground(SystemColor.controlDkShadow);
			frameSign.setBounds(0, 0, 450, 300);
			frameSign.setLocationRelativeTo(null);
			frameSign.getContentPane().setLayout(null);
			frameSign.setResizable(false);
			frameSign.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Label informativo
			JLlogin = new JLabel(" SIGN				       		            Sungym");
			JLlogin.setBackground(new Color(255, 51, 255));
			JLlogin.setOpaque(true);
			JLlogin.setFont(new Font("Courier New", Font.CENTER_BASELINE, 23));
			JLlogin.setForeground(Color.WHITE);
			JLlogin.setBounds(0, 0, 450, 40);
			frameSign.getContentPane().add(JLlogin, BorderLayout.NORTH);
			
		//TextField usuario
			JTFDNI = new JTextField();
			JTFDNI.setBounds(144, 83, 150, 24);
			placeholder = new TextPrompt("DNI", JTFDNI);
		    placeholder.changeAlpha(0.75f);
		    placeholder.changeStyle(Font.ITALIC);
			frameSign.getContentPane().add(JTFDNI);
			JTFDNI.setHorizontalAlignment(JTextField.LEFT); 
			JTFDNI.setColumns(10);
			
		//Icono de boton fichar
			iconBSign = new ImageIcon("src/RECURSOS/sign.png");
	        iconEBSign = new ImageIcon(iconBSign.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
	        
	    //Boton para fichar
			bSign = new JButton();
			bSign.setBounds(210, 128, 34, 40);
			frameSign.getContentPane().add(bSign);
			bSign.setMnemonic(KeyEvent.VK_ENTER);
			bSign.setIgnoreRepaint(true);
			bSign.setBorderPainted(false);
			bSign.setContentAreaFilled(false);
			bSign.setIcon(iconEBSign);
			bSign.setFocusable(false);
		
	}
	
	/**
	 * Función que controla los eventos de la vista para fichar.
	 */
	public void eventos() {
		//Evento: crear un nuevo registro en tabla ES
			bSign.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//declaramos y inicializamos variables
					SQLGyms sqlGyms = new SQLGyms();
					SQLEs sqlEs = new SQLEs();
					
					if(existe()) {
					//consulta sql para añadir el registro a la tablas
						try {
							sqlEs.crear(new ES(generarGym(sqlEs,sqlGyms,JTFDNI.getText().toUpperCase()),JTFDNI.getText(),generarFecha(),generarEoS(sqlEs,JTFDNI.getText().toUpperCase())));
							JOptionPane.showMessageDialog(null, "Registro realizado.");
						} catch (SQLException e) {
							JOptionPane.showConfirmDialog(null, "Error: no se ha podido guardar el registro.", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showConfirmDialog(null, "Error: no existe el usuario", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});			
		
	}
	/**
	 * Función para consultar si existe el usuario.
	 */
	public boolean existe() {
		SQLUsers sqlUser = new SQLUsers();
		ArrayList <Usuario> usu = null;
		try {
			usu = sqlUser.consultar(JTFDNI.getText().toUpperCase());
		} catch (SQLException e1) {
			JOptionPane.showConfirmDialog(null, "Error: administrar programador.Nota: buscar usuario", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
		}
		
		if(usu.size()<1) return false;
		else return true;
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
				+ Integer.toString(cal.get(Calendar.HOUR_OF_DAY))+":"
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
			JOptionPane.showConfirmDialog(null, "Error: administrar programador. Nota: generar EoS", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
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
			JOptionPane.showConfirmDialog(null, "Error:administrar programador. Nota: generar Gym, ","Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);

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
			JOptionPane.showConfirmDialog(null, "Error:administrar programador. Nota: num aleatorio. ", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
		}
		idGym = (int)Math.floor(Math.random()*max+1);
		
		return idGym;
		
	}
	
}
