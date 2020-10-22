package logica;

import java.util.ArrayList;
import java.util.List;

import persistencia.*;
import exception.UnidadeMovelExcepiton;
import logica.dto.UnidadeDTO;

public class Monitoramento implements MonitoramentoLogica {
	private List<UnidadeMovel> unidades;
	private List<UnidadeDTO> unidadeDTO;
	private UnidadeDAO unidadeDAO;
	private UnidadeSQL unidadeSQL;
	
	public void AdicionarUnidade(UnidadeMovel unidade) throws Exception {
		unidadeDAO.salvar(unidade);
		unidades.add(unidade);
	}
	
	public void setPersistencia(UnidadeDAO persistencia) throws Exception {
		this.unidadeDAO = persistencia;
	}
	
	@Override
	public void monitorar(float latitude, float longitude, boolean video, boolean termometro, boolean co2, boolean ch4)
			throws Exception {
		try {
			this.unidadeSQL = new UnidadeSQL();
			this.unidades = this.unidadeSQL.buscarTodas();
			List<UnidadeMovel> unidadesCompativeis = new ArrayList<UnidadeMovel>();
			
			if(this.unidades == null || this.unidades.isEmpty())
				throw new Exception("Não a unidades na area!");
			
			for(UnidadeMovel unidade : this.unidades) {
				if(unidade.getMedidorMetano() == ch4 && unidade.getCameraDeVideo() == video && unidade.getTermometro() == termometro && unidade.getMedidorCO2() == co2) {
					unidadesCompativeis.add(unidade);
				}
			}
			
			if(unidadesCompativeis == null || unidadesCompativeis.isEmpty())
				throw new UnidadeMovelExcepiton("Não a unidades compativeis na area!");
			
			UnidadeMovel unidadeProxima = (UnidadeMovel)unidadesCompativeis.get(0);
			
			for(UnidadeMovel unidade : unidadesCompativeis) {
				unidadeProxima = unidade.calcularDistancia(latitude, longitude) < unidadeProxima.calcularDistancia(latitude, longitude) ? unidade : unidadeProxima;
			}
						
			unidadeProxima.setLatitude(latitude);
			unidadeProxima.setLongitude(longitude);
			
			this.unidadeSQL.atualizar(unidadeProxima);
		
		}catch(Exception e){
			System.out.println(e.getMessage());
		}		
		
	}

	@Override
	public List<UnidadeMovel> getUnidades() throws Exception {	
		this.unidadeSQL = new UnidadeSQL();
		this.unidades = this.unidadeSQL.buscarTodas();
		return this.unidades;
	}
}
