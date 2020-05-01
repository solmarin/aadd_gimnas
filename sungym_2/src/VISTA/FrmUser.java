package VISTA;
import javax.swing.table.DefaultTableModel;

import DATOS.SQLEs;
import MODELO.ES;
import MODELO.Usuario;
import RECURSOS.TextPrompt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

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

	public JFrame frameUser;
	private JTextField txtFechaIn;
	private JTextField txtFechaFi;
	private Usuario usuario;
	private String horas;
	private DefaultTableModel model;
	private SQLEs sqlEs;

	/**
	 * Create the application.
	 * @throws ParseException 
	 * @throws SQLException 
	 */
	public FrmUser(Usuario usu) throws SQLException, ParseException {
		usuario = usu;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException, ParseException {
		//ventana
		frameUser = new JFrame();
		frameUser.getContentPane().setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		frameUser.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frameUser.getContentPane().setBackground(SystemColor.text);
		frameUser.setBounds(0, 0, 800, 800);
		frameUser.setLocationRelativeTo(null);
		frameUser.setResizable(false);
		frameUser.getContentPane().setLayout(null);
		frameUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Label informativo
		JLabel JLlogin = new JLabel(" USER 				       		                                     Sungym");
		JLlogin.setBackground(new Color(255, 51, 255));
		JLlogin.setOpaque(true);
		JLlogin.setFont(new Font("Courier New", Font.CENTER_BASELINE, 23));
		JLlogin.setForeground(Color.WHITE);
		JLlogin.setBounds(0, 0, 800, 40);
		frameUser.getContentPane().add(JLlogin, BorderLayout.NORTH);
		
		//InformaciÃ³n usuario
		JLabel JLInfo = new JLabel(" YOUR INFORMATION ");
		JLInfo.setOpaque(true);
		JLInfo.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 18));
		JLInfo.setForeground(new Color(255, 51, 255));
		JLInfo.setBounds(0, 40, 800, 40);
		frameUser.getContentPane().add(JLInfo, BorderLayout.NORTH);
		
		JLabel JLname = new JLabel("Name");
		JLname.setBounds(60, 101, 70, 15);
		frameUser.getContentPane().add(JLname);
		
		JLabel JLnamec = new JLabel(usuario.getNombre()+" "+usuario.getApellidos());
		JLnamec.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		JLnamec.setBounds(70, 120, 245, 15);
		frameUser.getContentPane().add(JLnamec);
		
		JLabel JLDni = new JLabel("DNI");
		JLDni.setBounds(423, 101, 70, 15);
		frameUser.getContentPane().add(JLDni);
		
		JLabel JLDniC = new JLabel(usuario.getDNI());
		JLDniC.setFont(new Font("Dialog", Font.ITALIC, 12));
		JLDniC.setBounds(433, 120, 97, 15);
		frameUser.getContentPane().add(JLDniC);
		
		JLabel JDBirthdate = new JLabel("Birth date");
		JDBirthdate.setBounds(56, 147, 111, 15);
		frameUser.getContentPane().add(JDBirthdate);
		
		JLabel JLBirthdateC = new JLabel(usuario.getFechaNacimiento());
		JLBirthdateC.setFont(new Font("Dialog", Font.ITALIC, 12));
		JLBirthdateC.setBounds(70, 167, 97, 15);
		frameUser.getContentPane().add(JLBirthdateC);
		
		JLabel JLAddress = new JLabel("Address");
		JLAddress.setBounds(56, 194, 111, 15);
		frameUser.getContentPane().add(JLAddress);
		
		JLabel JLAddressC = new JLabel(usuario.getDireccion());
		JLAddressC.setFont(new Font("Dialog", Font.ITALIC, 12));
		JLAddressC.setBounds(76, 210, 304, 15);
		frameUser.getContentPane().add(JLAddressC);
		
		JLabel JLAddInfo = new JLabel("Additional Information");
		JLAddInfo.setBounds(422, 147, 240, 15);
		frameUser.getContentPane().add(JLAddInfo);
		
		JLabel JLAddInfoC= new JLabel(usuario.getDatos());
		JLAddInfoC.setVerticalAlignment(SwingConstants.TOP);
		JLAddInfoC.setFont(new Font("Dialog", Font.ITALIC, 12));
		JLAddInfoC.setBounds(433, 167, 324, 34);
		frameUser.getContentPane().add(JLAddInfoC);
		
		//check de deutor
		JCheckBox chckbxPagado = new JCheckBox("Payed");
		chckbxPagado.setBackground(SystemColor.text);
		chckbxPagado.setBounds(599, 275, 77, 23);
		chckbxPagado.setEnabled(false);
		chckbxPagado.setSelected(usuario.isDeudor());
		frameUser.getContentPane().add(chckbxPagado);
		

		
		//Tabla con scroll
		Object[] titulos = {"Id GYM", "Fecha y hora", "Entrada/Salida"};
		Object[] celdas = {};
		 
		JScrollPane scroll = new JScrollPane();
		scroll.setBackground(Color.WHITE);
		 model = new DefaultTableModel(celdas,0){ 
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
		frameUser.getContentPane().add(scroll);
		
				
		//Label informativo
		JLabel JLFiltrar = new JLabel("Filter");
		JLFiltrar.setBounds(60, 258, 70, 15);
		frameUser.getContentPane().add(JLFiltrar);
		
		//txt fecha inicial
		txtFechaIn = new JTextField();
		txtFechaIn.setBounds(69, 292, 90, 19);
		frameUser.getContentPane().add(txtFechaIn);
		txtFechaIn.setColumns(10);
		TextPrompt placeholderIn = new TextPrompt("yyyy/mm/dd/", txtFechaIn);
		placeholderIn.changeAlpha(0.75f);
		frameUser.getContentPane().add(txtFechaIn);
		txtFechaIn.setHorizontalAlignment(SwingConstants.CENTER); 
		txtFechaIn.setColumns(10);
		
		
		//txt fecha final 
		txtFechaFi = new JTextField();
		txtFechaFi.setColumns(10);
		txtFechaFi.setBounds(170, 292, 90, 19);
		frameUser.getContentPane().add(txtFechaFi);
	    table.getTableHeader().setReorderingAllowed(false);
	    
	    TextPrompt placeholderFi = new TextPrompt("yyyy/mm/dd/", txtFechaFi);
	    placeholderFi.changeAlpha(0.75f);
		frameUser.getContentPane().add(txtFechaFi);
		txtFechaFi.setHorizontalAlignment(SwingConstants.CENTER); 
		txtFechaFi.setColumns(10);
		
		//texto horas totales
		JLabel JLHoras = new JLabel("TOTALES EN EL GIMNASIO		");
		JLHoras.setFont(new Font("Dialog", Font.BOLD, 12));
		JLHoras.setBounds(133, 640, 400, 15);
		frameUser.getContentPane().add(JLHoras);
		
		//calculamos horas
		horas = calcular(txtFechaIn.getText(),txtFechaFi.getText());
		JLabel JLtotal = new JLabel(horas);
		JLtotal.setFont(new Font("Dialog", Font.BOLD, 12));
		JLtotal.setBounds(143, 700, 400, 15);
		frameUser.getContentPane().add(JLtotal);
		
		
		//botton filtrar
		ImageIcon iconBFilter = new ImageIcon("src/RECURSOS/filtrar.png");
        ImageIcon iconBEFilter = new ImageIcon(iconBFilter.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
        
		JButton bFilter = new JButton();
		bFilter.setBounds(255, 283, 45, 28);
		frameUser.getContentPane().add(bFilter);
		bFilter.setMnemonic(KeyEvent.VK_ENTER);
		bFilter.setIgnoreRepaint(true);
		bFilter.setBorderPainted(false);
		bFilter.setContentAreaFilled(false);
		bFilter.setIcon(iconBEFilter);
		bFilter.setFocusable(false);
		
		//Evento: clicar boton para filtrar la tabla de datos
		bFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!txtFechaIn.getText().equals("") && !txtFechaFi.getText().equals("")) {
					filtrarTabla(txtFechaIn.getText(),txtFechaFi.getText());
				}else {
					actualizarTabla();
					System.out.println("actualizar");
				}
				
				try {
					horas = calcular(txtFechaIn.getText(),txtFechaFi.getText());
					JLtotal.setText(horas);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
	    
	    //Rellenamos la tabla
		actualizarTabla();			

	}
	/**
	 * Función para actualizar los campos de la tabla con los datos del usuario.
	 */
	public void actualizarTabla() {
		
		try {
		 model.setRowCount(0);
		 sqlEs = new SQLEs();
		 for(ES c: sqlEs.consultar(usuario.getDNI())) {
		    	if(c != null) {
		    		int idGym = c.getIdGym();
					String fechaHora = c.getFechaHora();
					boolean eS = c.iseS();
			    	
					model.addRow(new Object[] {idGym,fechaHora,eS});
		    	}  	
		    }
		 } catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
		 }
		
	}
	/**
	 * Función para filtrar la tabla por dos fechas.
	 * @param ini = fecha incial 
	 * @param fin = fecha final
	 */
	public void filtrarTabla(String ini, String fin) {
		
		try {
		 model.setRowCount(0);
		 sqlEs = new SQLEs();
		 for(ES c: sqlEs.consultar(ini,fin,usuario.getDNI())) {
		    	if(c != null) {
		    		int idGym = c.getIdGym();
					String fechaHora = c.getFechaHora();
					boolean eS = c.iseS();
			    	
					model.addRow(new Object[] {idGym,fechaHora,eS});
		    	}  	
		    }
		 } catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
		 }
		
	}
	/**
	 * Función para llamar a la funcion calcular horas pasando dos fechas por parametro o no.
	 * @param ini
	 * @param fin
	 * @return
	 * @throws SQLException
	 * @throws ParseException
	 */
	public String calcular(String ini, String fin) throws SQLException, ParseException {
		SQLEs sqlEs2 = new SQLEs();
		String total = null;
		String inicio = null;
		String finall =null;
		
		//Tratamos los casos: no filtrar por fecha y filtrar por fecha
		if(ini.isEmpty() && fin.isEmpty()) {
			ArrayList<ES> eS = sqlEs2.consultar(usuario.getDNI());
			inicio = eS.get(0).getFechaHora();
			finall = eS.get(eS.size()-1).getFechaHora();

		}else {
			inicio = ini;
			finall = fin;
			
		}
		//calculamos el total de horass
		total = sqlEs2.calcular(inicio, finall, usuario.getDNI());
		
		return total;
	}
	
	
}
