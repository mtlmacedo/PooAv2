package persistencia;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logica.UnidadeEuclidiana;
import logica.UnidadeManhattan;
import logica.UnidadeMovel;
import logica.dto.UnidadeDTO;
import exception.UnidadeMovelExcepiton;

public class UnidadeSQL implements UnidadeDAO{
	
		private static final int UNIDADE_MANHATTAN = 0;
		private static final int UNIDADE_EUCLIDIANA = 1;	
		
		public static final String URI = "jdbc:hsqldb:file:C:\\Users\\mathe\\Desktop\\DB\\DB;hsqldb.lock_file=false";
		public static final String USER = "SA";
		public static final String PWD = "";
		public static final String DRIVE = "org.hsqldb.jdbc.JDBCDriver";

		private static String SAVE = "INSERT INTO UNIDADEMOVEL(LATITUDE, LONGITUDE, MEDIDORCO2, CAMERA, TERMOMETRO, MEDIDORMETANO, TIPOUNIDADE ) \r\n" +
									 "VALUES(?, ?, ?, ?, ?, ?, ?)";

		private static String RECOVERY_BY_ID = "SELECT ID, LATITUDE, LONGITUDE, MEDIDORCO2, CAMERA, TERMOMETRO, MEDIDORMETANO, TIPOUNIDADE \r\n" + 
	            					     	   " FROM UNIDADEMOVEL \r\n" +
	            					     	   " WHERE ID = ? \r\n";	

		private static String RECOVERY_ALL = "SELECT ID, LATITUDE, LONGITUDE, MEDIDORCO2, CAMERA, TERMOMETRO, MEDIDORMETANO, TIPOUNIDADE \r\n" + 
		     	   " FROM UNIDADEMOVEL \r\n";	
		
		private static String UPDATE = "UPDATE UNIDADEMOVEL SET LATITUDE = ?, LONGITUDE = ?, MEDIDORCO2 = ?, CAMERA = ?, TERMOMETRO = ?, MEDIDORMETANO = ?, TIPOUNIDADE = ? WHERE ID = ?";

		
		public UnidadeSQL() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
			DriverManager.registerDriver((Driver) Class.forName(UnidadeSQL.DRIVE).newInstance());
		} 
		
		private Connection getConnection() throws SQLException {
			Connection conn = DriverManager.getConnection(UnidadeSQL.URI, UnidadeSQL.USER, UnidadeSQL.PWD);
			return conn;
		}
		
		
		@Override
		public void salvar(UnidadeMovel unidade) throws Exception {
			if(unidade instanceof UnidadeManhattan) {
			  this.saveManhattan((UnidadeManhattan)unidade);	
			}else if(unidade instanceof UnidadeEuclidiana) {
			  this.saveEuclidiana((UnidadeEuclidiana)unidade);	
			}
		}
		
		private void saveEuclidiana(UnidadeEuclidiana unidade) throws SQLException {
			PreparedStatement ps = this.getConnection().prepareStatement(UnidadeSQL.SAVE);
			//ps.setInt(1, unidade.getId());
			ps.setFloat(1, unidade.getLatitude());
			ps.setFloat(2, unidade.getLongitude());
			ps.setBoolean(3, unidade.getMedidorCO2());
			ps.setBoolean(4, unidade.getCameraDeVideo());
			ps.setBoolean(5, unidade.getTermometro());
			ps.setBoolean(6, unidade.getMedidorMetano());
			ps.setInt(7, UnidadeSQL.UNIDADE_EUCLIDIANA);
			ps.executeUpdate();
		}
		
		private void saveManhattan(UnidadeManhattan unidade) throws SQLException {
			PreparedStatement ps = this.getConnection().prepareStatement(UnidadeSQL.SAVE);
			//ps.setInt(1, unidade.getId());
			ps.setFloat(1, unidade.getLatitude());
			ps.setFloat(2, unidade.getLongitude());
			ps.setBoolean(3, unidade.getMedidorCO2());
			ps.setBoolean(4, unidade.getCameraDeVideo());
			ps.setBoolean(5, unidade.getTermometro());
			ps.setBoolean(6, unidade.getMedidorMetano());
			ps.setInt(7, UnidadeSQL.UNIDADE_MANHATTAN);
			ps.executeUpdate();
		}

		@Override
		public UnidadeMovel buscar(String idUnidade) throws Exception {
			UnidadeMovel unidade = null;
			PreparedStatement ps = this.getConnection().prepareStatement(UnidadeSQL.RECOVERY_BY_ID);
			ps.setString(1, idUnidade);
			ResultSet rSet = ps.executeQuery();
			if(!rSet.next())
				throw new UnidadeMovelExcepiton();
			int tipo = rSet.getInt("TIPOUNIDADE");
			if(tipo == UnidadeSQL.UNIDADE_EUCLIDIANA)
				unidade = new UnidadeEuclidiana(rSet.getInt("ID"),
					  			rSet.getFloat("LATITUDE"),
					  			rSet.getFloat("LONGITUDE"),
					  			rSet.getBoolean("MEDIDORCO2"),
					  			rSet.getBoolean("CAMERA"),
					  			rSet.getBoolean("TERMOMETRO"),
					  			rSet.getBoolean("MEDIDORMETANO"));
			else if(tipo == UnidadeSQL.UNIDADE_MANHATTAN)
				unidade = new UnidadeManhattan(rSet.getInt("ID"),
			  			rSet.getFloat("LATITUDE"),
			  			rSet.getFloat("LONGITUDE"),
			  			rSet.getBoolean("MEDIDORCO2"),
			  			rSet.getBoolean("CAMERA"),
			  			rSet.getBoolean("TERMOMETRO"),
			  			rSet.getBoolean("MEDIDORMETANO"));
			return unidade;
				
		}
		
		@Override
		public List<UnidadeMovel> buscarTodas() throws Exception {
			List<UnidadeMovel> unidades = new ArrayList<UnidadeMovel>();
			UnidadeMovel unidade = null;
			PreparedStatement ps = this.getConnection().prepareStatement(UnidadeSQL.RECOVERY_ALL);;
			ResultSet rSet = ps.executeQuery();
			while(rSet.next()) {
				unidade = null;
				int tipo = rSet.getInt("TIPOUNIDADE");
				if(tipo == UnidadeSQL.UNIDADE_EUCLIDIANA)
					unidade = new UnidadeEuclidiana(rSet.getInt("ID"),
						  			rSet.getFloat("LATITUDE"),
						  			rSet.getFloat("LONGITUDE"),
						  			rSet.getBoolean("MEDIDORCO2"),
						  			rSet.getBoolean("CAMERA"),
						  			rSet.getBoolean("TERMOMETRO"),
						  			rSet.getBoolean("MEDIDORMETANO"));
				else if(tipo == UnidadeSQL.UNIDADE_MANHATTAN)
					unidade = new UnidadeManhattan(rSet.getInt("ID"),
				  			rSet.getFloat("LATITUDE"),
				  			rSet.getFloat("LONGITUDE"),
				  			rSet.getBoolean("MEDIDORCO2"),
				  			rSet.getBoolean("CAMERA"),
				  			rSet.getBoolean("TERMOMETRO"),
				  			rSet.getBoolean("MEDIDORMETANO"));
				unidades.add(unidade);
			}
			return unidades;
		}
		
		public List<UnidadeDTO> buscarTodasUi() throws Exception {
			List<UnidadeDTO> unidades = new ArrayList<UnidadeDTO>();
			UnidadeDTO unidade = null;
			PreparedStatement ps = this.getConnection().prepareStatement(UnidadeSQL.RECOVERY_ALL);;
			ResultSet rSet = ps.executeQuery();
			while(rSet.next()){
				unidade = null;
				int tipo = rSet.getInt("TIPOUNIDADE");
				if(tipo == UnidadeSQL.UNIDADE_EUCLIDIANA)
					unidade = new UnidadeDTO(rSet.getInt("ID"),
						  			rSet.getFloat("LATITUDE"),
						  			rSet.getFloat("LONGITUDE"),
						  			rSet.getBoolean("MEDIDORCO2"),
						  			rSet.getBoolean("CAMERA"),
						  			rSet.getBoolean("TERMOMETRO"),
						  			rSet.getBoolean("MEDIDORMETANO"),
									rSet.getInt("TIPOUNIDADE"));
				else if(tipo == UnidadeSQL.UNIDADE_MANHATTAN)
					unidade = new UnidadeDTO(rSet.getInt("ID"),
				  			rSet.getFloat("LATITUDE"),
				  			rSet.getFloat("LONGITUDE"),
				  			rSet.getBoolean("MEDIDORCO2"),
				  			rSet.getBoolean("CAMERA"),
				  			rSet.getBoolean("TERMOMETRO"),
				  			rSet.getBoolean("MEDIDORMETANO"),
							rSet.getInt("TIPOUNIDADE"));
				unidades.add(unidade);
			}
			return unidades;
		}


		@Override
		public void atualizar(UnidadeMovel unidade) throws Exception {
			if(unidade instanceof UnidadeManhattan) {
				  this.updateManhattan((UnidadeManhattan)unidade);	
			}else if(unidade instanceof UnidadeEuclidiana) {
				  this.updateEuclidiana((UnidadeEuclidiana)unidade);	
			}
		}

		private void updateManhattan(UnidadeManhattan unidade) throws SQLException {
			PreparedStatement ps = this.getConnection().prepareStatement(UnidadeSQL.UPDATE);
			ps.setFloat(1, unidade.getLatitude());
			ps.setFloat(2, unidade.getLongitude());
			ps.setBoolean(3, unidade.getMedidorCO2());
			ps.setBoolean(4, unidade.getCameraDeVideo());
			ps.setBoolean(5, unidade.getTermometro());
			ps.setBoolean(6, unidade.getMedidorMetano());
			ps.setInt(7, UnidadeSQL.UNIDADE_MANHATTAN);
			ps.setInt(8, unidade.getId());
			ps.executeUpdate();
		}
		
		private void updateEuclidiana(UnidadeEuclidiana unidade) throws SQLException {
			PreparedStatement ps = this.getConnection().prepareStatement(UnidadeSQL.UPDATE);
			ps.setFloat(1, unidade.getLatitude());
			ps.setFloat(2, unidade.getLongitude());
			ps.setBoolean(3, unidade.getMedidorCO2());
			ps.setBoolean(4, unidade.getCameraDeVideo());
			ps.setBoolean(5, unidade.getTermometro());
			ps.setBoolean(6, unidade.getMedidorMetano());
			ps.setInt(7, UnidadeSQL.UNIDADE_EUCLIDIANA);
			ps.setInt(8, unidade.getId());
			ps.executeUpdate();
		}	
		
		
		public void salveOuAtualize(UnidadeMovel unidade) throws Exception {
			try {
				this.buscar(Integer.toString(unidade.getId()));
				this.atualizar(unidade);
			} catch (UnidadeMovelExcepiton e) {
				this.salvar(unidade);
			}
		}
	
}
