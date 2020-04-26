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

public class FrmUser {

	private JFrame frame;
	private JTextField txtFechaIn;
	private JTextField txtFechaFi;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUser window = new FrmUser();
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
	public FrmUser() {
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
		JLabel JLlogin = new JLabel(" USER 				       		                                     Sungym");
		JLlogin.setBackground(new Color(255, 51, 255));
		JLlogin.setOpaque(true);
		JLlogin.setFont(new Font("Courier New", Font.CENTER_BASELINE, 23));
		JLlogin.setForeground(Color.WHITE);
		JLlogin.setBounds(0, 0, 800, 40);
		frame.getContentPane().add(JLlogin, BorderLayout.NORTH);
		
		//Información usuario
		JLabel JLInfo = new JLabel(" YOUR INFORMATION ");
		JLInfo.setOpaque(true);
		JLInfo.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 18));
		JLInfo.setForeground(new Color(255, 51, 255));
		JLInfo.setBounds(0, 40, 800, 40);
		frame.getContentPane().add(JLInfo, BorderLayout.NORTH);
		
		JLabel JLname = new JLabel("Name");
		JLname.setBounds(60, 101, 70, 15);
		frame.getContentPane().add(JLname);
		
		JLabel JLnamec = new JLabel("Sol Marín Esteban");
		JLnamec.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		JLnamec.setBounds(70, 120, 245, 15);
		frame.getContentPane().add(JLnamec);
		
		JLabel JLDni = new JLabel("DNI");
		JLDni.setBounds(423, 101, 70, 15);
		frame.getContentPane().add(JLDni);
		
		JLabel JLDniC = new JLabel("39500266C");
		JLDniC.setFont(new Font("Dialog", Font.ITALIC, 12));
		JLDniC.setBounds(433, 120, 97, 15);
		frame.getContentPane().add(JLDniC);
		
		JLabel JDBirthdate = new JLabel("Birth date");
		JDBirthdate.setBounds(56, 147, 111, 15);
		frame.getContentPane().add(JDBirthdate);
		
		JLabel JLBirthdateC = new JLabel("25/01/1999");
		JLBirthdateC.setFont(new Font("Dialog", Font.ITALIC, 12));
		JLBirthdateC.setBounds(70, 167, 97, 15);
		frame.getContentPane().add(JLBirthdateC);
		
		JLabel JLAddress = new JLabel("Address");
		JLAddress.setBounds(56, 194, 111, 15);
		frame.getContentPane().add(JLAddress);
		
		JLabel JLAddressC = new JLabel("C/ Rafael de casanova 108, 3-2");
		JLAddressC.setFont(new Font("Dialog", Font.ITALIC, 12));
		JLAddressC.setBounds(76, 210, 304, 15);
		frame.getContentPane().add(JLAddressC);
		
		JLabel JLAddInfo = new JLabel("Additional Information");
		JLAddInfo.setBounds(422, 147, 240, 15);
		frame.getContentPane().add(JLAddInfo);
		
		JLabel JLAddInfoC= new JLabel("Dolor de espalda cronico y asma");
		JLAddInfoC.setVerticalAlignment(SwingConstants.TOP);
		JLAddInfoC.setFont(new Font("Dialog", Font.ITALIC, 12));
		JLAddInfoC.setBounds(433, 167, 324, 34);
		frame.getContentPane().add(JLAddInfoC);
		
		//check de deutor
		JCheckBox chckbxPagado = new JCheckBox("Payed");
		chckbxPagado.setBackground(SystemColor.text);
		chckbxPagado.setBounds(599, 275, 77, 23);
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
		scroll.setBounds(52, 346, 700, 283);;
		table.setBackground(new Color(255, 204, 255));
		frame.getContentPane().add(scroll);
		
		//Label informativo
		JLabel JLFiltrar = new JLabel("Filter");
		JLFiltrar.setBounds(60, 258, 70, 15);
		frame.getContentPane().add(JLFiltrar);
		
		//txt fecha inicial
		txtFechaIn = new JTextField();
		txtFechaIn.setBounds(69, 292, 90, 19);
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
		txtFechaFi.setBounds(170, 292, 90, 19);
		frame.getContentPane().add(txtFechaFi);
	    table.getTableHeader().setReorderingAllowed(false);
	    
	    TextPrompt placeholderFi = new TextPrompt("dd/mm/yyyy", txtFechaFi);
	    placeholderFi.changeAlpha(0.75f);
		frame.getContentPane().add(txtFechaFi);
		txtFechaFi.setHorizontalAlignment(SwingConstants.CENTER); 
		txtFechaFi.setColumns(10);
		
		//botton filtrar
		ImageIcon iconBFilter = new ImageIcon("src/RECURSOS/filtrar.png");
        ImageIcon iconBEFilter = new ImageIcon(iconBFilter.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
        
		JButton bFilter = new JButton();
		bFilter.setBounds(255, 283, 45, 28);
		frame.getContentPane().add(bFilter);
		bFilter.setMnemonic(KeyEvent.VK_ENTER);
		bFilter.setIgnoreRepaint(true);
		bFilter.setBorderPainted(false);
		bFilter.setContentAreaFilled(false);
		bFilter.setIcon(iconBEFilter);
		bFilter.setFocusable(false);
	    
	    //Datos de prueba (diseño)
	    model.addRow(new Object[] {"00001","24/10/2019","19:02","Entrada"});
	    model.addRow(new Object[] {"00001","24/10/2019","20:30","Salida"});
	

		
	
		

	}
}
