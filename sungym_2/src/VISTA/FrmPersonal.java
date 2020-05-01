package VISTA;
import javax.swing.table.DefaultTableModel;

import DATOS.SQLEs;
import DATOS.SQLUsers;
import MODELO.ES;
import MODELO.Usuario;
import RECURSOS.TextPrompt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

public class FrmPersonal {
	//Declaración de variables
		public JFrame framePersonal;
		private JTextField txtFechaIn;
		private JTextField txtFechaFi;
		private JTextField textField;
		private JTextField textFieldName;
		private JTextField textFieldDni;
		private JTextField textFieldBirth;
		private JTextField textFieldAdress;
		private JTextField textFieldOther;
		
		private Usuario usuario;
		private Usuario createUser;
		
		private DefaultTableModel model;
		
		private SQLEs sqlEs;
		
		private String horas;
		
		private JButton bEditUser;
		private JButton bCrearUser;
		private JButton bDeleteUser;
		private JButton bFilter;
		private JButton bSave;
		
		private JLabel JLlogin;
		private JLabel JLInfo;
		private JLabel JLNameUser;
		private JLabel JLNameUserc;
		private JLabel JLUserDni;
		private JLabel JLUserDniC;
		private JLabel JDUserBirthdate;
		private JLabel JLUserBirthdateC;
		private JLabel JLUserAddress;
		private JLabel JLUserAddressC;
		private JLabel JLUserInfo;
		private JLabel JLname;
		private JLabel JLnamec;
		private JLabel JLDni;
		private JLabel JLDniC;
		private JLabel JDBirthdate;
		private JLabel JLBirthdateC;
		private JLabel JLAddress;
		private JLabel JLAddressC;
		private JLabel JLAddInfo;
		private JLabel JLAddInfoC;
		private JLabel JLFiltrar;
		private JLabel JLtotal;
		private JLabel FilterDNI;
		 private JTextField textFieldApell;
		
		private JCheckBox chckbxPagado;
		
		private Object[] titulos = {"Id GYM","Id cliente", "Fecha", "Entrada/Salida"};
		private Object[] celdas = {};
		
		private JScrollPane scroll;
		
		private JTable table;
	
		private TextPrompt placeholderIn;
		private TextPrompt placeholderFi;
		
		private ImageIcon iconBFilter ;
	    private ImageIcon iconBEFilter;
	    
	    private boolean crear;
	    private boolean editar;
	    private JTextField textFieldContra;
	   
	    

	/**
	 * Create the application.
	 * @throws ParseException 
	 * @throws SQLException 
	 */
	public FrmPersonal(Usuario usu) throws SQLException, ParseException {
		usuario = usu;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException, ParseException {
		diseño();
		eventos();
 
	}
	/**
	 * Función que determina el diseño de la vista.
	 */
	public void diseño() {
		//ventana
			framePersonal = new JFrame();
			framePersonal.getContentPane().setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
			framePersonal.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			framePersonal.getContentPane().setBackground(SystemColor.text);
			framePersonal.setBounds(0, 0, 800, 800);
			framePersonal.setLocationRelativeTo(null);
			framePersonal.setResizable(false);
			framePersonal.getContentPane().setLayout(null);
			framePersonal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		//Label informativo
			JLlogin = new JLabel(" STAFF 		                                          Sungym");
			JLlogin.setBackground(Color.black);
			JLlogin.setOpaque(true);
			JLlogin.setFont(new Font("Courier New", Font.CENTER_BASELINE, 23));
			JLlogin.setForeground(Color.WHITE);
			JLlogin.setBounds(0, 0, 800, 40);
			framePersonal.getContentPane().add(JLlogin, BorderLayout.NORTH);
			
		//Información staff
			JLInfo = new JLabel(" YOUR INFORMATION ");
			JLInfo.setOpaque(true);
			JLInfo.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 18));
			JLInfo.setForeground(Color.BLACK);
			JLInfo.setBounds(0, 40, 800, 40);
			framePersonal.getContentPane().add(JLInfo, BorderLayout.NORTH);
			
			JLNameUser = new JLabel("Name");
			JLNameUser.setBounds(70, 258, 70, 15);
			framePersonal.getContentPane().add(JLNameUser);
			
			JLNameUserc = new JLabel(usuario.getNombre()+" "+usuario.getApellidos());
			JLNameUserc.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
			JLNameUserc.setBounds(70, 120, 245, 15);
			framePersonal.getContentPane().add(JLNameUserc);
			
			JLUserDni = new JLabel("DNI");
			JLUserDni.setBounds(281, 101, 70, 15);
			framePersonal.getContentPane().add(JLUserDni);
			
			JLUserDniC = new JLabel(usuario.getDNI());
			JLUserDniC.setFont(new Font("Dialog", Font.ITALIC, 12));
			JLUserDniC.setBounds(291, 120, 97, 15);
			framePersonal.getContentPane().add(JLUserDniC);
			
			JDUserBirthdate = new JLabel("Birth date");
			JDUserBirthdate.setBounds(451, 101, 111, 15);
			framePersonal.getContentPane().add(JDUserBirthdate);
			
			JLUserBirthdateC = new JLabel(usuario.getFechaNacimiento());
			JLUserBirthdateC.setFont(new Font("Dialog", Font.ITALIC, 12));
			JLUserBirthdateC.setBounds(461, 120, 97, 15);
			framePersonal.getContentPane().add(JLUserBirthdateC);
			
			JLUserAddress = new JLabel("Address");
			JLUserAddress.setBounds(60, 147, 111, 15);
			framePersonal.getContentPane().add(JLUserAddress);
			
			JLUserAddressC = new JLabel(usuario.getDireccion());
			JLUserAddressC.setFont(new Font("Dialog", Font.ITALIC, 12));
			JLUserAddressC.setBounds(81, 166, 304, 15);
			framePersonal.getContentPane().add(JLUserAddressC);
			
			
		//Información del usuario filtrado
			JLUserInfo = new JLabel(" USER INFORMATION ");
			JLUserInfo.setOpaque(true);
			JLUserInfo.setForeground(Color.BLACK);
			JLUserInfo.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 18));
			JLUserInfo.setBounds(0, 206, 800, 40);
			framePersonal.getContentPane().add(JLUserInfo);

			JLname = new JLabel("Name");
			JLname.setBounds(60, 93, 70, 15);
			framePersonal.getContentPane().add(JLname);
			
			JLnamec = new JLabel();
			JLnamec.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
			JLnamec.setBounds(80, 286, 206, 14);
			framePersonal.getContentPane().add(JLnamec);
			
			JLDni = new JLabel("DNI");
			JLDni.setBounds(318, 258, 70, 15);
			framePersonal.getContentPane().add(JLDni);
			
			JLDniC = new JLabel();
			JLDniC.setFont(new Font("Dialog", Font.ITALIC, 12));
			JLDniC.setBounds(314, 278, 111, 23);
			framePersonal.getContentPane().add(JLDniC);
			
			JDBirthdate = new JLabel("Birth date");
			JDBirthdate.setBounds(461, 258, 111, 15);
			framePersonal.getContentPane().add(JDBirthdate);
			
			JLBirthdateC = new JLabel();
			JLBirthdateC.setFont(new Font("Dialog", Font.ITALIC, 12));
			JLBirthdateC.setBounds(471, 285, 97, 15);
			framePersonal.getContentPane().add(JLBirthdateC);
			
			JLAddress = new JLabel("Address");
			JLAddress.setBounds(70, 314, 111, 15);
			framePersonal.getContentPane().add(JLAddress);
			
			JLAddressC = new JLabel();
			JLAddressC.setFont(new Font("Dialog", Font.ITALIC, 12));
			JLAddressC.setBounds(80, 336, 304, 15);
			framePersonal.getContentPane().add(JLAddressC);
			
			JLAddInfo = new JLabel("Additional Information");
			JLAddInfo.setBounds(318, 310, 240, 15);
			framePersonal.getContentPane().add(JLAddInfo);
			
			JLAddInfoC = new JLabel();
			JLAddInfoC.setVerticalAlignment(SwingConstants.TOP);
			JLAddInfoC.setFont(new Font("Dialog", Font.ITALIC, 12));
			JLAddInfoC.setBounds(328, 336, 324, 34);
			framePersonal.getContentPane().add(JLAddInfoC);
			
		//check de deutor
			chckbxPagado = new JCheckBox("Payed");
			chckbxPagado.setBackground(SystemColor.text);
			chckbxPagado.setBounds(633, 258, 77, 23);
			chckbxPagado.setEnabled(false);
			framePersonal.getContentPane().add(chckbxPagado);
			 
			scroll = new JScrollPane();
			scroll.setBackground(Color.WHITE);
			 model = new DefaultTableModel(celdas,0){ 

				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int rowIndex,int coluumnIndex) {return false;}
				};
			model.setColumnIdentifiers(titulos);
			table =new JTable();
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
			framePersonal.getContentPane().add(scroll);
			
		//Label informativo
			JLFiltrar = new JLabel("Filter");
			JLFiltrar.setBounds(60, 363, 70, 15);
			framePersonal.getContentPane().add(JLFiltrar);
			
		//txt fecha inicial
			txtFechaIn = new JTextField();
			txtFechaIn.setBounds(60, 390, 90, 19);
			framePersonal.getContentPane().add(txtFechaIn);
			txtFechaIn.setColumns(10);
			placeholderIn = new TextPrompt("yyyy/mm/dd", txtFechaIn);
			placeholderIn.changeAlpha(0.75f);
			framePersonal.getContentPane().add(txtFechaIn);
			txtFechaIn.setHorizontalAlignment(SwingConstants.CENTER); 
			txtFechaIn.setColumns(10);
			
		//txt fecha final 
			txtFechaFi = new JTextField();
			txtFechaFi.setColumns(10);
			txtFechaFi.setBounds(164, 390, 90, 19);
			framePersonal.getContentPane().add(txtFechaFi);
		    table.getTableHeader().setReorderingAllowed(false);
		    
		    placeholderFi = new TextPrompt("yyyy/mm/dd", txtFechaFi);
		    placeholderFi.changeAlpha(0.75f);
			framePersonal.getContentPane().add(txtFechaFi);
			txtFechaFi.setHorizontalAlignment(SwingConstants.CENTER); 
			txtFechaFi.setColumns(10);
			
		//calculamos horas
			horas = "Dias:0 Horas:0 Min: 0 Seg:0";
			JLtotal = new JLabel(horas);
			JLtotal.setFont(new Font("Dialog", Font.BOLD, 12));
			JLtotal.setBounds(451, 717, 201, 15);
			framePersonal.getContentPane().add(JLtotal);
				
		//Icono de boton filtrar
			iconBFilter = new ImageIcon("src/RECURSOS/filtrarO.png");
	        iconBEFilter = new ImageIcon(iconBFilter.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
	        
			bFilter = new JButton();
			bFilter.setBounds(255, 390, 31, 32);
			framePersonal.getContentPane().add(bFilter);
			bFilter.setMnemonic(KeyEvent.VK_ENTER);
			bFilter.setIgnoreRepaint(true);
			bFilter.setBorderPainted(false);
			bFilter.setContentAreaFilled(false);
			bFilter.setIcon(iconBEFilter);
			bFilter.setFocusable(false);
			
		//dni txt 
			textField = new JTextField();
			textField.setBounds(500, 392, 181, 23);
			framePersonal.getContentPane().add(textField);
			textField.setColumns(10);
			

			FilterDNI = new JLabel("DNI");
			FilterDNI.setBounds(452, 392, 38, 15);
			framePersonal.getContentPane().add(FilterDNI);
		
		   //Butons personalitzar usuaris
		    bCrearUser = new JButton("CREATE USER");
		    bCrearUser.setBounds(71, 700, 110, 50);
		    bCrearUser.setFont(new Font("Dialog", Font.BOLD, 10));
		    bCrearUser.setBackground(Color.lightGray);
		    framePersonal.getContentPane().add(bCrearUser);
		    
		    bEditUser = new JButton("EDIT USER");
		    bEditUser.setBounds(193, 700, 100, 50);
		    bEditUser.setFont(new Font("Dialog", Font.BOLD, 10));
		    bEditUser.setBackground(Color.lightGray);
		    framePersonal.getContentPane().add(bEditUser);
		    
		    bDeleteUser = new JButton("DELETE USER");
		    bDeleteUser.setBounds(304, 700, 121, 50);
		    bDeleteUser.setFont(new Font("Dialog", Font.BOLD, 10));
		    bDeleteUser.setBackground(Color.lightGray);
		    framePersonal.getContentPane().add(bDeleteUser);
		    
		    bSave = new JButton("Save");
		    bSave.setBounds(670, 700, 84, 50);
		    bSave.setFont(new Font("Dialog", Font.BOLD, 10));
		    bSave.setBackground(Color.lightGray);
		    framePersonal.getContentPane().add(bSave);
		    
		//campos crear usuarios	
			textFieldName= new JTextField();
		    textFieldName.setBounds(80, 278, 70, 22);
		    textFieldName.setVisible(false);
		    textFieldName.setEnabled(false);
		    framePersonal.getContentPane().add(textFieldName);
		    textFieldName.setColumns(10);
		    
		    textFieldDni = new JTextField();
		    textFieldDni.setBounds(328, 285, 116, 22);
		    textFieldDni.setVisible(false);
		    textFieldDni.setEnabled(false);
		    framePersonal.getContentPane().add(textFieldDni);
		    textFieldDni.setColumns(10);
		    
		    textFieldBirth = new JTextField();
		    textFieldBirth.setBounds(471, 285, 116, 22);
		    textFieldBirth.setVisible(false);
		    textFieldBirth.setEnabled(false);
		    framePersonal.getContentPane().add(textFieldBirth);
		    textFieldBirth.setColumns(10);
		    
		    textFieldAdress = new JTextField();
		    textFieldAdress.setBounds(80, 329, 159, 32);
		    textFieldAdress.setVisible(false);
		    textFieldAdress.setEnabled(false);
		    framePersonal.getContentPane().add(textFieldAdress);
		    textFieldAdress.setColumns(10);
		    
		    textFieldOther = new JTextField();
		    textFieldOther.setBounds(328, 336, 353, 34);
		    textFieldOther.setVisible(false);
		    textFieldOther.setEnabled(false);
		    framePersonal.getContentPane().add(textFieldOther);
		    textFieldOther.setColumns(10);
		    
		    textFieldApell = new JTextField();
		    textFieldApell.setBounds(159, 278, 116, 22);
		    textFieldApell.setVisible(false);
		    textFieldApell.setEnabled(false);
		    framePersonal.getContentPane().add(textFieldApell);
		    textFieldApell.setColumns(10);
		    
		    textFieldContra = new JTextField();
		    textFieldContra.setBounds(291, 389, 116, 22);
		    textFieldContra.setVisible(false);
		    textFieldContra.setEnabled(false);
		    framePersonal.getContentPane().add(textFieldContra);
		    textFieldContra.setColumns(10);
		    
		    crear = false;
		    editar = false;
		    
		    actualizarTabla(textField.getText());
		   
	}
	/**
	 * Función que controla los eventos de la vista.
	 */
	public void eventos() {
			
			//Evento: clicar boton para filtrar la tabla de datos
			bFilter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(textField.getText().length()==9 && txtFechaIn.getText().matches("^[0-9]{4}/(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])$")
							&& txtFechaFi.getText().matches("^[0-9]{4}/(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])$")) {
						filtrarTabla(txtFechaIn.getText(),txtFechaFi.getText());
						try {
							horas = calcular(txtFechaIn.getText(),txtFechaFi.getText());
							JLtotal.setText(horas);
						} catch (SQLException | ParseException e) {
							// TODO Auto-generated catch block
							JOptionPane.showConfirmDialog(null, "Error: administrar programador. Nota: filtrar fechas", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
						} 				
					}else {
						JOptionPane.showConfirmDialog(null, "Error: DNI o fechas incorrectas", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
	
					}
				}
			});
			
			//Evento: escribir en el dni
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					actualizarTabla(textField.getText());
					//Actualizar datos cliente
					if(textField.getText().length()==9) {
						
						SQLUsers sqlUsuario = new SQLUsers();
					
						try {
							Usuario usu = sqlUsuario.consultar(textField.getText()).get(0);
							if(usu!=null) {
								JLnamec.setText(usu.getNombre()+" "+usu.getApellidos());
								JLDniC.setText(usu.getDNI());
								JLBirthdateC.setText(usu.getFechaNacimiento());
								JLAddressC.setText(usu.getDireccion());
								JLAddInfoC.setText(usu.getDatos());
								chckbxPagado.setSelected(usu.isDeudor());
								framePersonal.getContentPane().add(chckbxPagado);
							}
							
						} catch (SQLException e1) {
							System.out.println("Error: no existe el usuario");
						}
					}else {
						JLnamec.setText("");
						JLDniC.setText("");
						JLBirthdateC.setText("");
						JLAddressC.setText("");
						JLAddInfoC.setText("");
						chckbxPagado.setSelected(false);
						framePersonal.getContentPane().add(chckbxPagado);
						
					}
				}
			});
			
			//Evento: crear nuevo usuario
		    bCrearUser.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					activeDiseño();
					crear = true;
				}
		    });
		    
		    //Evento: eliminar un usuario
		    bDeleteUser.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					if(textField.getText().length()==9) {
						 int dialogResult = JOptionPane.showConfirmDialog (null, "Seguro que quieres eliminar el cliente?","BORRAR CLIENTE",JOptionPane.YES_NO_OPTION);
						 if(dialogResult == JOptionPane.YES_OPTION){
							   delUser();
							}
					
					}else JOptionPane.showConfirmDialog(null, "Error: el usuario no existe.", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);

				}
		    });
		    
		    //Evento: editar un usuario
		    bEditUser.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(textField.getText().length()==9) {
	
					    textFieldContra.setEnabled(true);
					    textFieldContra.setVisible(true);
					    activeDiseño();
						textFieldDni.setVisible(false);
						textFieldDni.setEditable(false);
						editar = true;
					}else JOptionPane.showConfirmDialog(null, "Error: el usuario no existe.", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
				}
		    });
		    
		    //Evento: opciones del save
		    bSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					  if(crear)createUser();
					  else if (editar) editUser();
					  
					  bEditUser.setEnabled(true);
					  bDeleteUser.setEnabled(true);
					  bCrearUser.setEnabled(true);
				}
		    });
		    
	}
	/**
	 * Función para actualizar los campos de la tabla con los datos del usuario.
	 */
	public void actualizarTabla(String dni) {
		try {
		 model.setRowCount(0);
		 sqlEs = new SQLEs();
		 for(ES c: sqlEs.consultar(dni)) {
		    	if(c != null) {
		    		int idGym = c.getIdGym();
					String fechaHora = c.getFechaHora();
					String idCliente = c.getIdCliente();
					if(c.iseS()) model.addRow(new Object[] {idGym,idCliente, fechaHora,"Entrada"});
					else model.addRow(new Object[] {idGym,idCliente, fechaHora,"Salida"});
		    	}  	
		    }
		 } catch (NumberFormatException | SQLException e) {
				System.out.println("resultado: tabla vacia");
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
			ArrayList<ES> eS = sqlEs2.consultar(textField.getText());
			inicio = eS.get(0).getFechaHora();
			finall = eS.get(eS.size()-1).getFechaHora();

		}else {
			inicio = ini;
			finall = fin;
			
		}
		//calculamos el total de horass
		total = sqlEs2.calcular(inicio, finall, textField.getText());
		
		return total;
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
		 for(ES c: sqlEs.consultar(ini,fin,textField.getText())) {
		    	if(c != null) {
		    		int idGym = c.getIdGym();
					String fechaHora = c.getFechaHora();
					if(c.iseS()) model.addRow(new Object[] {idGym,textField.getText(), fechaHora,"Entrada"});
					else model.addRow(new Object[] {idGym,textField.getText(), fechaHora,"Salida"});
		    	}  	
		    }
		 } catch (NumberFormatException | SQLException e) {
			 JOptionPane.showConfirmDialog(null, "Error: adminitrar programador.Nota: filtrado por fecha..", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
		 }
		
	}
	/**
	 * Función para crear un usuario.
	 */
	public void createUser() {
		
			crear = false;
		
			SQLUsers sqlUsers = new SQLUsers();
			String contraseña = textFieldName.getText()+ textFieldDni.getText().substring(0,4);
 			try {
 				 createUser = new Usuario(textFieldDni.getText(),textFieldName.getText(),textFieldApell.getText(),textFieldBirth.getText(),textFieldAdress.getText(),
 						contraseña,textFieldOther.getText(),false,chckbxPagado.isSelected());
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "Error: Usuario no creado. Contacte con tecnico.", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			}
		    
			try {
				sqlUsers.crear(createUser);
				JOptionPane.showMessageDialog(null, "Crear usuario: operación realizada correctamente.");
			} catch (SQLException e) {
				JOptionPane.showConfirmDialog(null, "Error: Usuario no creado. Contacte con tecnico.", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			}
			
			resetDiseño();
			
	}
	/**
	 * Función para borrar un usuario.
	 */
	public void delUser() {
		SQLUsers sqlUsers =  new SQLUsers();
		try {
			sqlUsers.eliminar(textField.getText());
			JOptionPane.showMessageDialog(null, "Eliminar usuario: operación realizada correctamente.");
		} catch (SQLException e) {
			JOptionPane.showConfirmDialog(null, "Error: Usuario no borrado. Contacte con tecnico.", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);

		}
	}
	/**
	 * Función para editar un usuario.
	 */
	public void editUser() {
		
		editar = false;
	
		SQLUsers sqlUsers = new SQLUsers();
	    
		try {
			sqlUsers.editar(textField.getText(),textFieldName.getText(),textFieldApell.getText(),textFieldBirth.getText(),textFieldAdress.getText(),
					textFieldContra.getText(),textFieldOther.getText(),false,chckbxPagado.isSelected());
			JOptionPane.showMessageDialog(null, "Editar usuario: operación realizada correctamente.");
		} catch (SQLException e) {
			JOptionPane.showConfirmDialog(null, "Error: Usuario no editado. Contacte con tecnico.", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);

		}
		
		resetDiseño();
	 
	}
	
	/**
	 * Función para activar algunos componentes del diseño.
	 */
	public void activeDiseño() {
		
		bEditUser.setEnabled(false);
		bDeleteUser.setEnabled(false);
		bCrearUser.setEnabled(false);
		
	    textFieldName.setVisible(true);
	    textFieldName.setEnabled(true);
	    textFieldApell.setVisible(true);
	    textFieldApell.setEnabled(true);
	    textFieldDni.setVisible(true);
	    textFieldDni.setEnabled(true);
	    textFieldBirth.setVisible(true);
	    textFieldBirth.setEnabled(true);
	    textFieldAdress.setVisible(true);
	    textFieldAdress.setEnabled(true);
	    textFieldOther.setVisible(true);
	    textFieldOther.setEnabled(true);
	    chckbxPagado.setEnabled(true);
		framePersonal.getContentPane().add(chckbxPagado);	
		
	}
	/**
	 * Función para volver a silenciar/esconder algunos parametros de diseño. 
	 */
	public void resetDiseño() {
		textFieldName.setVisible(false);
	    textFieldName.setEnabled(false);
	    textFieldApell.setVisible(false);
	    textFieldApell.setEnabled(false);
	    textFieldDni.setVisible(false);
	    textFieldDni.setEnabled(false);
	    textFieldBirth.setVisible(false);
	    textFieldBirth.setEnabled(false);
	    textFieldAdress.setVisible(false);
	    textFieldAdress.setEnabled(false);
	    textFieldOther.setVisible(false);
	    textFieldOther.setEnabled(false);
	    chckbxPagado.setEnabled(false);
	    textFieldContra.setVisible(false);
	    textFieldContra.setEnabled(false);
		framePersonal.getContentPane().add(chckbxPagado);
		
		textFieldName.setText("");
	    textFieldApell.setText("");
	    textFieldDni.setText("");
	    textFieldBirth.setText("");
	    textFieldAdress.setText("");
	    textFieldOther.setText("");
	    textFieldContra.setText("");
		
	}
	

}