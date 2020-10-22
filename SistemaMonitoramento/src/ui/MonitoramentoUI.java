package ui;

import logica.MonitoramentoLogica;

public interface MonitoramentoUI {
	public void setLogica(MonitoramentoLogica logica) throws Exception;
	public void run() throws Exception;
}
