package CONTROLADOR;

import java.sql.SQLException;
import java.text.ParseException;

import DATOS.*;

/**
 * Programa principal para testear todos los objetos y relaciones con la BBDD (SQLite).
 * @author Sol Marín
 * @version 1
 *
 */
public class Testeo {

	public static void main(String[] args) throws SQLException, ParseException{
		
		/*//Conectar a la BBDD y mostrar los gimnasios
		SQLGyms sqlgyms = new SQLGyms();
		System.out.println(sqlgyms.consultar().toString());
		
		//Creacion usuarios de prueba
		Usuario usuario1 = new Usuario("39500266C","Sol","Marin", 25/01/1999, "Calle 1", "solete", "asma", false, false);
		Usuario usuario2 = new Usuario("111111111A","Nombre prueba" , "Apellido prueba","1/1/1111","Direccion prueba", "Contrasena prueba","Datos prueba",false, false);
		
		
		//Conectar a la BBDD
		SQLUsers sqlusers = new SQLUsers();
		sqlusers.crear(usuario1);
		sqlusers.editar("39500266C","Sol","Marin","25/01/1999", "Nose 2","solete","", true, true);
		sqlusers.crear(usuario2);
		System.out.println(sqlusers.consultar().toString());
		sqlusers.eliminar("111111111A");
		System.out.println(sqlusers.consultar().toString());
		*/
		
		//Conectar a la BBDD y mostrar las entradas y salidas
		SQLEs sqlEs = new SQLEs();
		/*ES es = new ES(1,"39500266C","20/20/2020 19:00", true);
		ES es1= new ES(1,"11111111A","21/20/2020 19:00", true);
		ES es2 = new ES(1,"11111111A","21/20/2020 20:00", false);
		ES es3 = new ES(1,"11111111A","24/20/2020 21:00", true);
		ES es4 = new ES(1,"11111111A","24/20/2020 21:30", false);
		sqlEs.crear(es);
		sqlEs.crear(es1);
		sqlEs.crear(es2);
		sqlEs.crear(es3);
		sqlEs.crear(es4);
		System.out.println(sqlEs.consultar("39500266C").toString());
		System.out.println(sqlEs.consultar("21/20/2020 19:00","24/20/2020 21:00","11111111A").toString());
		*/
		
		//probar funcion calcular
		System.out.println(sqlEs.calcular("2020/10/01 10:00:00","2020/10/02 14:00:00","11111111A"));

		
		
		
		
	}
}
