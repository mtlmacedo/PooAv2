package logica;

import persistencia.UnidadeDAO;
import persistencia.UnidadeSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Main {
	

	public static void main(String[] args) {
	try {	
		
		
		String sql = "SELECT ID FROM UNIDADEMOVEL";
		
		DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
		Connection conn = DriverManager.getConnection(UnidadeSQL.URI, UnidadeSQL.USER, UnidadeSQL.PWD);
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
			System.out.println(rs.getString("ID"));
		ps.close();
		conn.close();	
		System.out.println("Finalizando");	
		
	/*Area area = new Area();
		UnidadeManhattan um1 = new UnidadeManhattan(1, 1, 3, true, true, true, true);
		UnidadeEuclidiana um2 = new UnidadeEuclidiana(1, 1, 4, true, true, true, true);
		UnidadeEuclidiana um3 = new UnidadeEuclidiana(5, 5, true, true, true, true);
		
		System.out.println(um1.calcularDistancia(2, 2));
		System.out.println(um2.calcularDistancia(2, 2));
		System.out.println(um3.calcularDistancia(2, 2));
		area.AdicionarUnidade(um1);
		area.AdicionarUnidade(um2);
		area.AdicionarUnidade(um3);
		System.out.println(area.monitorar(2, 2, true, true, true, true));
	
		//area.monitorar(1, 1, true, true, true, true);
		 * 
		 */
	}catch (Exception e) {
		System.out.println(e.getMessage());
	} {
		
	}
	}
}


