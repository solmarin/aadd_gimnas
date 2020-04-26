package DATOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import MODELO.Usuario;

public class SQLUsers {

		Connection c = null;
		Statement sentencia = null;
		ArrayList<Usuario> aUsers = new ArrayList <Usuario>(); 
		public void conectar() {
			try {

				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:servidor/bdgimnasios.db");
				System.out.println("EXITO AL CONECTAR A LA BBDD");

			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "ERROR AL CONECTAR A LA BBDD: "+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			}

		}
		
		public ArrayList<Usuario> consultar() throws SQLException {

			conectar();
			sentencia = c.createStatement();
			
			//consulta sql
			String consultaSql = "SELECT * FROM USUARIO;";

			try {
				//ejecutar consulta sql
				ResultSet rs = sentencia.executeQuery(consultaSql);

				while (rs.next()) {
					String DNI = rs.getString("DNI");
					String nombre = rs.getString("nombre");
					String apellidos = rs.getString("apellidos");
					String fechaNacimiento = rs.getString("fechaNacimiento");
					String direccion = rs.getString("direccion");
					String contrasena = rs.getString("contraseña");
					String datos = rs.getString("datos");
					
					//tratamiento de datos
					boolean rol;
					if(rs.getInt("rol")==1) rol = true;
					else rol = false;
					
					boolean deudor;
					if(rs.getInt("deudor")==1) deudor = true;
					else deudor = false;
					
					//añadir al array
					aUsers.add(new Usuario(DNI,  nombre,  apellidos,  fechaNacimiento,  direccion, contrasena,  datos,  rol,  deudor));
				}
				rs.close();
				sentencia.close();
				c.close();

			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "ERROR AL RECUPERAR DATOS: "+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
				
			}
			return aUsers;
		}
		
		public ArrayList<Usuario> consultarFiltrando(int dni) throws SQLException {

			conectar();
			sentencia = c.createStatement();
			//consulta sql
			String consultaSql = "SELECT * FROM USUARIO WHERE DNI LIKE %"+dni+"%;";

			try {
				//ejecucion consulta sql
				ResultSet rs = sentencia.executeQuery(consultaSql);

				while (rs.next()) {
					String DNI = rs.getString("DNI");
					String nombre = rs.getString("nombre");
					String apellidos = rs.getString("apellidos");
					String fechaNacimiento = rs.getString("fechaNacimiento");
					String direccion = rs.getString("direccion");
					String contrasena = rs.getString("contraseña");
					String datos = rs.getString("datos");
					//tratamiento datos
					boolean rol;
					if(rs.getInt("rol")==1) rol = true;
					else rol = false;
					
					boolean deudor;
					if(rs.getInt("deudor")==1) deudor = true;
					else deudor = false;
					
					//añadir al array
					aUsers.add(new Usuario(DNI,  nombre,  apellidos,  fechaNacimiento,  direccion, contrasena,  datos,  rol,  deudor));
				}
				rs.close();
				sentencia.close();
				c.close();

			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "ERROR AL RECUPERAR DATOS: "+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
				
			}
			return aUsers;
		}
		
		public void crear(Usuario usu) throws SQLException {
			
			String sqlInsert = "INSERT INTO USUARIO(DNI, nombre, apellidos, fechaNacimiento, direccion," + 
					"contraseña, datos, rol, deudor) VALUES('"+usu.getDNI()+"','"+usu.getNombre()+"','"+usu.getApellidos()+"',"
							+ "'"+usu.getFechaNacimiento()+"','"+usu.getDireccion()+"','"+usu.getcontrasena()+"','"+usu.getDatos()+"',"
									+ ""+usu.isRol()+","+usu.isDeudor()+");";

			try {

				conectar();
				sentencia = c.createStatement();
				sentencia.executeUpdate(sqlInsert);
				sentencia.close();
				c.close();
				System.out.println("Datos insertados");

			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "ERROR AL INSERTAR DATOS EN LA TABLA: "+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			}

		}
		
		public void editar(String DNI, String nombre, String apellidos, String fechaNacimiento, String direccion,
				String contrasena, String datos, boolean rol, boolean deudor) throws SQLException {
			//tratamiento datos
			int rolNum;
			if(rol) rolNum = 1;
			else rolNum = 0;
			
			int deudorNum;
			if(deudor) deudorNum = 1;
			else deudorNum = 0;
			
			//consulta sql
			String sqlEdit = "UPDATE USUARIO SET DNI ='"+DNI+"', nombre = '"+nombre+"', apellidos ='"+apellidos+"',"
					+ "fechaNacimiento='"+fechaNacimiento+"', direccion='"+direccion+"', contraseña='"+contrasena+"',"
							+ "datos='"+datos+"', rol='"+rolNum+"', deudor='"+deudorNum+"' WHERE DNI ='"+DNI+"'";

			try {
				
				conectar();
				sentencia = c.createStatement();
				sentencia.executeUpdate(sqlEdit);
				sentencia.close();
				c.close();
				System.out.println("Datos actualizados");

			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "ERROR AL ACTUALIZAR DATOS EN LA TABLA: "+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
				
			}

		}
		
		public void eliminar(String DNI) throws SQLException {
			
			String sqlDelet = "DELETE FROM USUARIO WHERE DNI = '"+DNI+"'";

			try {

				conectar();
				sentencia = c.createStatement();
				sentencia.executeUpdate(sqlDelet);
				sentencia.close();
				c.close();
				System.out.println("Datos eliminados");

			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "ERROR AL BORRAR DATOS EN LA TABLA: "+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			
			}

		}

		

	}

