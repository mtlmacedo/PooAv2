package ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import logica.UnidadeMovel;
import logica.dto.UnidadeDTO;

public class TableModelMonitoramento extends AbstractTableModel {   

	private static final long serialVersionUID = 1L;
	private List<UnidadeDTO> unidades;
	private String[] colunas = {"ID", "Latitude", "Longitude", "Camera", "Termometro", "Medidor de CO2", "Medidor de Metano", "Tipo Unidade"};
	

	public TableModelMonitoramento() {
		unidades = new ArrayList<UnidadeDTO>();
	}

	public TableModelMonitoramento(List<UnidadeDTO> lista) {
		this();
		unidades.addAll(lista);
	}

	@Override
	public Class<?> getColumnClass(int coluna) {
		return String.class;
	}

	@Override
	public int getColumnCount() {		
		return 8;
	}
	
	@Override
	public String getColumnName(int coluna) {
		return this.colunas[coluna];
	}

	@Override
	public int getRowCount() {
		
		return this.unidades.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		
		UnidadeDTO unidade = unidades.get(linha);
		
		switch (coluna) {
		case 0:
			return unidade.getId(); 
		case 1:
			return unidade.getLatitude();
		case 2:
			return unidade.getLongitude();
		case 3:
			return unidade.isCameraDeVideo(); 
        case 4:
			return unidade.isTermometro();
        case 5:
    		return unidade.isMedidorCO2();
        case 6:
    		return unidade.isMedidorMetano();
        case 7:
    		return unidade.getTipoUnidadeTratado();
        default:
			return null;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {		
		return false;
	}

	@Override
	public void setValueAt(Object valor, int linha, int coluna) {
		
		UnidadeDTO unidade = unidades.get(linha);
		switch (coluna) {
		case 0:
			unidade.setId(Integer.parseInt(valor.toString()));
			break;
		case 1:
			unidade.setLatitude(Float.parseFloat(valor.toString())); 
			break;
		case 2:
			unidade.setLongitude(Float.parseFloat(valor.toString())); 
			break;
		case 3:
			unidade.setCameraDeVideo(Boolean.parseBoolean(valor.toString()));
			break;
		case 4:
            unidade.setTermometro(Boolean.parseBoolean(valor.toString()));
			break;
		case 5:
            unidade.setMedidorCO2(Boolean.parseBoolean(valor.toString()));
			break;
		case 6:
            unidade.setMedidorMetano(Boolean.parseBoolean(valor.toString()));
			break;
		case 7:
            unidade.setTipoUnidade(Integer.parseInt(valor.toString()));
			break;

		}
		fireTableDataChanged(); 
	}
	
	public void adiciona(UnidadeDTO unidade) {
		this.unidades.add(unidade);
		
		fireTableRowsInserted(this.unidades.size() - 1, this.unidades.size() - 1);
	}

	
	public void remove(int indice) {
		this.unidades.remove(indice);
		fireTableRowsDeleted(indice, indice);
	}

	
	public int getIndice(UnidadeMovel cb) {
		return this.unidades.indexOf(cb);
	}

	public void adicionaLista(List<UnidadeDTO> lista) {
		int i = this.unidades.size();
		this.unidades.addAll(lista);
		fireTableRowsInserted(i, i + lista.size());
	}

	
	public void limpaLista() {
		int i = this.unidades.size();
		this.unidades.clear();
		fireTableRowsDeleted(0, i - 1);
	}
	
	public void atualizaLista(List<UnidadeDTO> lista) {
		this.limpaLista();
		adicionaLista(lista);
	}

}