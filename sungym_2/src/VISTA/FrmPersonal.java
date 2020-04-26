package VISTA;
import javax.swing.table.DefaultTableModel;

import RECURSOS.TextPrompt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FrmPersonal {

	private JFrame frame;
	private JTextField txtFechaIn;
	private JTextField txtFechaFi;
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPersonal window = new FrmPersonal();
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
	public FrmPersonal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//ventana
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame.getContentPane().setBackground(SystemColor.text);
		frame.setBounds(0, 0, 800, 800);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Label informativo
		JLabel JLlogin = new JLabel(" STAFF 		                                          Sungym");
		JLlogin.setBackground(Color.black);
		JLlogin.setOpaque(true);
		JLlogin.setFont(new Font("Courier New", Font.CENTER_BASELINE, 23));
		JLlogin.setForeground(Color.WHITE);
		JLlogin.setBounds(0, 0, 800, 40);
		frame.getContentPane().add(JLlogin, BorderLayout.NORTH);
		
		//Información staff
		JLabel JLInfo = new JLabel(" YOUR INFORMATION ");
		JLInfo.setOpaque(true);
		JLInfo.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 18));
		JLInfo.setForeground(Color.BLACK);
		JLInfo.setBounds(0, 40, 800, 40);
		frame.getContentPane().add(JLInfo, BorderLayout.NORTH);
		
		JLabel JLname = new JLabel("Name");
		JLname.setBounds(60, 93, 70, 15);
		frame.getContentPane().add(JLname);
		
		JLabel JLnamec = new JLabel("Sol Marín Esteban");
		JLnamec.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		JLnamec.setBounds(80, 285, 206, 15);
		frame.getContentPane().add(JLnamec);
		
		JLabel JLDni = new JLabel("DNI");
		JLDni.setBounds(318, 258, 70, 15);
		frame.getContentPane().add(JLDni);
		
		JLabel JLDniC = new JLabel("39500266C");
		JLDniC.setFont(new Font("Dialog", Font.ITALIC, 12));
		JLDniC.setBounds(328, 285, 97, 15);
		frame.getContentPane().add(JLDniC);
		
		JLabel JDBirthdate = new JLabel("Birth date");
		JDBirthdate.setBounds(461, 258, 111, 15);
		frame.getContentPane().add(JDBirthdate);
		
		JLabel JLBirthdateC = new JLabel("25/01/1999");
		JLBirthdateC.setFont(new Font("Dialog", Font.ITALIC, 12));
		JLBirthdateC.setBounds(471, 285, 97, 15);
		frame.getContentPane().add(JLBirthdateC);
		
		JLabel JLAddress = new JLabel("Address");
		JLAddress.setBounds(70, 314, 111, 15);
		frame.getContentPane().add(JLAddress);
		
		JLabel JLAddressC = new JLabel("C/ Rafael de casanova 108, 3-2");
		JLAddressC.setFont(new Font("Dialog", Font.ITALIC, 12));
		JLAddressC.setBounds(80, 336, 304, 15);
		frame.getContentPane().add(JLAddressC);
		
		//Información del usuario filtrado
		JLabel JLUserInfo = new JLabel(" USER INFORMATION ");
		JLUserInfo.setOpaque(true);
		JLUserInfo.setForeground(Color.BLACK);
		JLUserInfo.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 18));
		JLUserInfo.setBounds(0, 206, 800, 40);
		frame.getContentPane().add(JLUserInfo);
		
		JLabel JLNameUser = new JLabel("Name");
		JLNameUser.setBounds(70, 258, 70, 15);
		frame.getContentPane().add(JLNameUser);
		
		JLabel JLNameUserc = new JLabel("Sol Marín Esteban");
		JLNameUserc.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		JLNameUserc.setBounds(70, 120, 245, 15);
		frame.getContentPane().add(JLNameUserc);
		
		JLabel JLUserDni = new JLabel("DNI");
		JLUserDni.setBounds(281, 101, 70, 15);
		frame.getContentPane().add(JLUserDni);
		
		JLabel JLUserDniC = new JLabel("39500266C");
		JLUserDniC.setFont(new Font("Dialog", Font.ITALIC, 12));
		JLUserDniC.setBounds(291, 120, 97, 15);
		frame.getContentPane().add(JLUserDniC);
		
		JLabel JDUserBirthdate = new JLabel("Birth date");
		JDUserBirthdate.setBounds(451, 101, 111, 15);
		frame.getContentPane().add(JDUserBirthdate);
		
		JLabel JLUserBirthdateC = new JLabel("25/01/1999");
		JLUserBirthdateC.setFont(new Font("Dialog", Font.ITALIC, 12));
		JLUserBirthdateC.setBounds(461, 120, 97, 15);
		frame.getContentPane().add(JLUserBirthdateC);
		
		JLabel JLUserAddress = new JLabel("Address");
		JLUserAddress.setBounds(60, 147, 111, 15);
		frame.getContentPane().add(JLUserAddress);
		
		JLabel JLUserAddressC = new JLabel("C/ Rafael de casanova 108, 3-2");
		JLUserAddressC.setFont(new Font("Dialog", Font.ITALIC, 12));
		JLUserAddressC.setBounds(81, 166, 304, 15);
		frame.getContentPane().add(JLUserAddressC);
		
		JLabel JLAddInfo = new JLabel("Additional Information");
		JLAddInfo.setBounds(318, 310, 240, 15);
		frame.getContentPane().add(JLAddInfo);
		
		JLabel JLAddInfoC= new JLabel("Dolor de espalda cronico y asma");
		JLAddInfoC.setVerticalAlignment(SwingConstants.TOP);
		JLAddInfoC.setFont(new Font("Dialog", Font.ITALIC, 12));
		JLAddInfoC.setBounds(328, 336, 324, 34);
		frame.getContentPane().add(JLAddInfoC);
		
		//check de deutor
		JCheckBox chckbxPagado = new JCheckBox("Payed");
		chckbxPagado.setBackground(SystemColor.text);
		chckbxPagado.setBounds(633, 258, 77, 23);
		frame.getContentPane().add(chckbxPagado);
		

		//Tabla con scroll
		Object[] titulos = {"Id GYM", "Fecha", "Hora", "Entrada/Salida"};
		Object[] celdas = {};
		 
		JScrollPane scroll = new JScrollPane();
		scroll.setBackground(Color.WHITE);
		DefaultTableModel model = new DefaultTableModel(celdas,0){ 
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex,int coluumnIndex) {return false;}
			};
		model.setColumnIdentifiers(titulos);
		JTable table=new JTable();
		table.setShowVerticalLines(false);
		table.setGridColor(new Color(128, 128, 128));
		table.setForeground(new Color(0, 0, 0));
		table.setEnabled(false);
		table.setModel(model);
	    table.setFont(new Font("FreeSans", Font.ITALIC, 15));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setRowHeight(18);
		scroll.setViewportView(table);
		scroll.setBounds(54, 435, 700, 246);;
		table.setBackground(Color.white);
		frame.getContentPane().add(scroll);
		
		//Label informativo
		JLabel JLFiltrar = new JLabel("Filter");
		JLFiltrar.setBounds(60, 363, 70, 15);
		frame.getContentPane().add(JLFiltrar);
		
		
		//txt fecha inicial
		txtFechaIn = new JTextField();
		txtFechaIn.setBounds(60, 390, 90, 19);
		frame.getContentPane().add(txtFechaIn);
		txtFechaIn.setColumns(10);
		TextPrompt placeholderIn = new TextPrompt("dd/mm/yyyy", txtFechaIn);
		placeholderIn.changeAlpha(0.75f);
		frame.getContentPane().add(txtFechaIn);
		txtFechaIn.setHorizontalAlignment(SwingConstants.CENTER); 
		txtFechaIn.setColumns(10);
		
		//txt fecha final 
		txtFechaFi = new JTextField();
		txtFechaFi.setColumns(10);
		txtFechaFi.setBounds(164, 390, 90, 19);
		frame.getContentPane().add(txtFechaFi);
	    table.getTableHeader().setReorderingAllowed(false);
	    
	    TextPrompt placeholderFi = new TextPrompt("dd/mm/yyyy", txtFechaFi);
	    placeholderFi.changeAlpha(0.75f);
		frame.getContentPane().add(txtFechaFi);
		txtFechaFi.setHorizontalAlignment(SwingConstants.CENTER); 
		txtFechaFi.setColumns(10);
		

		//Icono de boton filtrar
		ImageIcon iconBFilter = new ImageIcon("src/RECURSOS/filtrarO.png");
        ImageIcon iconBEFilter = new ImageIcon(iconBFilter.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
        
		JButton bFilter = new JButton();
		bFilter.setBounds(255, 390, 45, 28);
		frame.getContentPane().add(bFilter);
		bFilter.setMnemonic(KeyEvent.VK_ENTER);
		bFilter.setIgnoreRepaint(true);
		bFilter.setBorderPainted(false);
		bFilter.setContentAreaFilled(false);
		bFilter.setIcon(iconBEFilter);
		bFilter.setFocusable(false);
		
		//dni txt 
		textField = new JTextField();
		textField.setBounds(500, 392, 181, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel FilterDNI = new JLabel("DNI");
		FilterDNI.setBounds(430, 392, 70, 15);
		frame.getContentPane().add(FilterDNI);
		
	    
	    //Datos de prueba (diseño)
	    model.addRow(new Object[] {"00001","24/10/2019","19:02","Entrada"});
	    model.addRow(new Object[] {"00001","24/10/2019","20:30","Salida"});
	    
	    //Butons personalitzar usuaris
	    JButton bCrearUser = new JButton("CREATE USER");
	    bCrearUser.setBounds(90, 700, 110, 50);
	    bCrearUser.setFont(new Font("Dialog", Font.BOLD, 10));
	    bCrearUser.setBackground(Color.lightGray);
	    frame.add(bCrearUser);
	    
	    JButton bEditUser = new JButton("EDIT USER");
	    bEditUser.setBounds(220, 700, 100, 50);
	    bEditUser.setFont(new Font("Dialog", Font.BOLD, 10));
	    bEditUser.setBackground(Color.lightGray);
	    frame.add(bEditUser);
	    
	    JButton bDeleteUser = new JButton("DELETE USER");
	    bDeleteUser.setBounds(340, 700, 100, 50);
	    bDeleteUser.setFont(new Font("Dialog", Font.BOLD, 10));
	    bDeleteUser.setBackground(Color.lightGray);
	    frame.add(bDeleteUser);
	    
	    

	}
}
