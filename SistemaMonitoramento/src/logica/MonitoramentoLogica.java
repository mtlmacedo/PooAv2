package logica;

import java.util.List;

import persistencia.UnidadeDAO;

public interface MonitoramentoLogica {
	public void setPersistencia(UnidadeDAO persistencia) throws Exception;
	public void Monitorar(float latitude, float longitude, boolean video, boolean termometro, boolean co2, boolean ch4) throws Exception;
	public List<UnidadeMovel> getUnidades() throws Exception;
}
