package ui;

import java.io.FileInputStream;
import java.util.Properties;

import logica.Monitoramento;
import logica.MonitoramentoLogica;
import persistencia.UnidadeDAO;
import persistencia.UnidadeSQL;

public class App {
	private FrameMonitoramento ui;
	private Monitoramento logica;
	private UnidadeDAO persistencia;
	

	public void  loadClasses(String fileConfName) throws ClassNotFoundException, Exception  {
		Properties prop = new Properties();
		prop.load(new FileInputStream(fileConfName));
		System.out.println();
				
		this.persistencia = (UnidadeSQL) (Class.forName((String)prop.get("PERSISTENCIA")).newInstance());
		this.logica = (Monitoramento) (Class.forName((String)prop.get("LOGICA")).newInstance());
		this.ui = (FrameMonitoramento) (Class.forName((String)prop.get("UI")).newInstance());		
	}

	
	public void asm(String fileConfName) throws ClassNotFoundException, Exception  {
		this.loadClasses(fileConfName);
		this.logica.setPersistencia(this.persistencia);
		this.ui.setLogica(this.logica);
		this.ui.run();
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, Exception  {
		(new App()).asm(args[0]);
	}

}
