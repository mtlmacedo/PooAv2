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
	
	public void salvarUnidade(UnidadeMovel unidade) throws Exception {
		unidadeDAO.salvar(unidade);
	}
	
	public void setPersistencia(UnidadeDAO persistencia) throws Exception {
		this.unidadeDAO = persistencia;
	}
	
	@Override
	public String monitorar(float latitude, float longitude, boolean video, boolean termometro, boolean co2, boolean ch4) throws Exception {
		String retorno;	
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
		retorno = "A unidade" + " " + Integer.toString(unidadeProxima.getId()) + " " + "foi desisgnada! \r\n" + "Distancia: " + unidadeProxima.calcularDistancia(latitude, longitude);			
		unidadeProxima.setLatitude(latitude);
		unidadeProxima.setLongitude(longitude);
			
		this.unidadeDAO.atualizar(unidadeProxima);
		return retorno;
	}

	@Override
	public List<UnidadeDTO> getUnidades() throws Exception {	
		this.unidadeSQL = new UnidadeSQL();
		this.unidadeDTO = this.unidadeSQL.buscarTodasUi(); 
		return this.unidadeDTO;
	}
}
