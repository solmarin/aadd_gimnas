package DATOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import MODELO.Gimnasio;

public class SQLGyms {
	Connection c = null;
	Statement sentencia = null;
	ArrayList<Gimnasio> aGyms = new ArrayList <Gimnasio>(); 

	public void conectar() {

		try {

			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:servidor/bdgimnasios.db");
			System.out.println("EXITO AL CONECTAR A LA BBDD");

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "ERROR AL CONECTAR A LA BBDD: "+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);

		}

	}
	
	public ArrayList<Gimnasio> consultar() throws SQLException {

		conectar();
		sentencia = c.createStatement();
		String consultaSql = "SELECT * FROM GIMNASIO;";

		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);

			while (rs.next()) {
				int idGym = rs.getInt("idGym");
				String nombre = rs.getString("nombre");
				String direccion = rs.getString("direccion");
				
				aGyms.add(new Gimnasio(idGym, nombre, direccion));

			}
		
			rs.close();
			sentencia.close();
			c.close();
		 

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "ERROR AL RECUPERAR DATOS: "+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			
		}
		return aGyms;

	}



}
