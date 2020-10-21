package logica;

import java.util.ArrayList;
import java.util.List;

import persistencia.*;
import exception.UnidadeMovelExcepiton;

public class Area implements AreaLogica {
	private List<UnidadeMovel> unidades = new ArrayList<UnidadeMovel>();
	private UnidadeDAO unidadeDAO;
	
	public void AdicionarUnidade(UnidadeMovel unidade) {
		unidades.add(unidade);
	}
	
	public void setPersistencia(UnidadeDAO persistencia) throws Exception {
		this.unidadeDAO = persistencia;
	}
	public String monitorar(float latitude, float longitude, boolean video, boolean termometro, boolean co2, boolean ch4) {
		try {
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
			
			unidadeDAO.salvar(unidadeProxima);
			
			return "A unidade" + ' ' + unidadeProxima.getId() + ' ' + "Foi designada!";
		
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}		
	}
}
