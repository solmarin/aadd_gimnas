package DATOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import MODELO.ES;

public class SQLEs {
	Connection c = null;
	Statement sentencia = null;
	ArrayList<ES> aES = new ArrayList <ES>(); 
	/**
	 * Función conexión con la BBDD
	 */
	public void conectar() {

		try {

			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:servidor/bdgimnasios.db");
			System.out.println("EXITO AL CONECTAR A LA BBDD");

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "CONTACTE TECNICO BBDD:"+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);

		}

	}
	/**
	 * Función para crear un registro ES
	 * @param es
	 * @throws SQLException
	 */
	public void crear(ES es) throws SQLException {
		
		String sqlInsert = "INSERT INTO ES(idGym,idCliente,fechaHora, eS) VALUES('"+es.getIdGym()+"','"+es.getIdCliente()+"','"+es.getFechaHora()+"',"
			+es.iseS()+");";

		try {

			conectar();
			sentencia = c.createStatement();
			sentencia.executeUpdate(sqlInsert);
			sentencia.close();
			c.close();
			System.out.println("Datos insertados");

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "CONTACTE TECNICO BBDD:"+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
		}

	}
	/**
	 * Función para consultar los registros sin filtrar.
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ES> consultar() throws SQLException {

		conectar();
		sentencia = c.createStatement();
		String consultaSql = "SELECT * FROM ES;";

		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);

			while (rs.next()) {
				
				int idGym = rs.getInt("idGym");
				String idCliente = rs.getString("idCliente");
				String fechaHora = rs.getString("fechaHora");
				boolean eS = rs.getBoolean("eS");
				
				aES.add(new ES(idGym, idCliente, fechaHora, eS));

			}
		
			rs.close();
			sentencia.close();
			c.close();
		 

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "CONTACTE TECNICO BBDD:"+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			
		}
		return aES;

	}
	/**
	 * Función para filtrar los registros por dni.
	 * @param DNI
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ES> consultar(String DNI) throws SQLException {

		conectar();
		sentencia = c.createStatement();
		String consultaSql;
		
		if(DNI.length() == 9)consultaSql = "SELECT * FROM ES WHERE idCliente LIKE '"+DNI+"';";
		else consultaSql = "SELECT * FROM ES WHERE idCliente LIKE '%"+DNI+"%';";

		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);

			while (rs.next()) {
				
				int idGym = rs.getInt("idGym");
				String idCliente = rs.getString("idCliente");
				String fechaHora = rs.getString("fechaHora");
				boolean eS = rs.getBoolean("eS");
				
				aES.add(new ES(idGym, idCliente, fechaHora, eS));

			}
		
			rs.close();
			sentencia.close();
			c.close();
		 

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "CONTACTE TECNICO BBDD:"+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			
		}
		return aES;

	}
	/**
	 * Función para filtrar los registros por fecha y dni
	 * @param INICIO
	 * @param FINAL
	 * @param DNI
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ES> consultar(String INICIO, String FINAL, String DNI) throws SQLException {

		conectar();
		sentencia = c.createStatement();
		String consultaSql = "SELECT * FROM ES WHERE idCliente LIKE '%"+DNI+"%' AND fechaHora BETWEEN '"+INICIO+"' AND '"+FINAL+"';";

		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);

			while (rs.next()) {
				
				int idGym = rs.getInt("idGym");
				String idCliente = rs.getString("idCliente");
				String fechaHora = rs.getString("fechaHora");
				boolean eS = rs.getBoolean("eS");
				
				aES.add(new ES(idGym, idCliente, fechaHora, eS));

			}
		
			rs.close();
			sentencia.close();
			c.close();
		 

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "CONTACTE TECNICO BBDD:"+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			
		}
		return aES;

	}
	

	/**
	 * Metodo que calcula las horas totales dentro de un array que intercala entradas y salidas del gimnasio.
	 * @param DNI del usuario 
	 * @return horas y minutos totales
	 * @throws ParseException 
	 * @throws SQLException 
	 */
	public String calcular(String INICIO,String FINAL,String DNI) throws ParseException, SQLException {
		System.out.println("calculando...");
		long total = 0;
		ArrayList<ES> aEs = consultar(INICIO, FINAL, DNI); 
		for(int i = 0; i<aEs.size()-1;i++) {
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date1 =  sdf.parse(aEs.get(i).getFechaHora());
			Date date2 =  sdf.parse(aEs.get(i+1).getFechaHora());
			
			long diferencia = date2.getTime()-date1.getTime();	
			total  = total + diferencia;
			i++;
		}
		long diffSg = total / 1000 % 60;  
		long diffMin = total / (60 * 1000) % 60; 
		long diffH = total / (60 * 60 * 1000);
		
		return " Horas: "+diffH+" mins: "+diffMin+" ss:"+diffSg;
		
	}
	
}
