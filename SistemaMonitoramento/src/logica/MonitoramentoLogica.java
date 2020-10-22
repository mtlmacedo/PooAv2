package logica;

import java.util.List;

import logica.dto.UnidadeDTO;
import persistencia.UnidadeDAO;

public interface MonitoramentoLogica {
	public void setPersistencia(UnidadeDAO persistencia) throws Exception;
	public String monitorar(float latitude, float longitude, boolean video, boolean termometro, boolean co2, boolean ch4) throws Exception;
	public List<UnidadeDTO> getUnidades() throws Exception;
	public void salvarUnidade(UnidadeMovel unidade) throws Exception;
}
