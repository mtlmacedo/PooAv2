package logica;
import java.util.ArrayList;
import java.util.List;

public class Area {
	private List<UnidadeMovel> unidades = new ArrayList<UnidadeMovel>();
	
	
	public void AdicionarUnidade(UnidadeMovel unidade) {
		unidades.add(unidade);
	}
	
	public String monitorar(float abcissa, float ordenada, boolean video, boolean termometro, boolean co2, boolean ch4) {
		try {
			List<UnidadeMovel> unidadesCompativeis = new ArrayList<UnidadeMovel>();
			
			if(this.unidades == null || this.unidades.isEmpty())
				throw new Exception("Não a unidades na area!");
			
			for(UnidadeMovel unidade : this.unidades) {
				if(unidade.hasMedidorMetano() == ch4 && unidade.hasCameraDeVideo() == video && unidade.hasTermometro() == termometro && unidade.hasMedidorCO2() == co2) {
					unidadesCompativeis.add(unidade);
				}
			}
			
			if(unidadesCompativeis == null || unidadesCompativeis.isEmpty())
				throw new Exception("Não a unidades compativeis na area!");
			
			UnidadeMovel unidadeProxima = unidadesCompativeis.get(0);
			
			for(UnidadeMovel unidade : unidadesCompativeis) {
				unidadeProxima = unidade.calcularDistancia(abcissa, ordenada) < unidadeProxima.calcularDistancia(abcissa, ordenada) ? unidade : unidadeProxima;
			}
						
			unidadeProxima.setPosicao(abcissa, ordenada);
			
			return "A unidade" + ' ' + unidadeProxima.getId() + ' ' + "Foi designada!";
		
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}		
	}
}
