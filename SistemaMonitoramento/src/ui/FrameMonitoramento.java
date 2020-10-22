package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import logica.MonitoramentoLogica;
import logica.UnidadeEuclidiana;
import logica.UnidadeManhattan;
import logica.UnidadeMovel;
import logica.dto.UnidadeDTO;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import java.awt.Color;

public class FrameMonitoramento extends JFrame implements MonitoramentoUI, ActionListener {
	public FrameMonitoramento() {
	}

	private JScrollPane scrollPane;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTable table;
	private JButton btnExcluir;
	private JLabel lblNewLabel;
	private JLabel lblLongitude;
	private JCheckBox chckbxCamera;
	private JCheckBox chckbxMedidorCo2;
	private JCheckBox chckbxTermometro;
	private JCheckBox chckbxMedidorMetano;
	private JButton btnMonitorar;
	private JSeparator separator;
	private JButton btnAdicionar;
	private MonitoramentoLogica monitoramentoLogica;
	private TableModel tableModel;
	private FrameTipoUnidade frameTipoUnidade;
	
	@Override
	public void setLogica(MonitoramentoLogica logica) throws Exception {
		this.monitoramentoLogica = logica;	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			if(arg0.getSource().equals(this.btnMonitorar)) {
				this.onMonitorar();
			}else if(arg0.getSource().equals(this.btnAdicionar)) {
				this.onAdicionar();
			}else if(arg0.getSource().equals(this.btnExcluir)) {
				this.onExcuir();
			}
			this.repaint();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	private void onExcuir() throws Exception {	
		int row = this.table.getSelectedRow();
		int id = (int) this.tableModel.getValueAt(row, 0);
		this.monitoramentoLogica.delete(id);
		JOptionPane.showMessageDialog(null, "A unidade" + " " + id + " " + "Foi Excluida!" ,"ATENÇÂO", JOptionPane.INFORMATION_MESSAGE); 
	}

	private void onAdicionar(){
		try {
			
			float latitude = Float.parseFloat(this.textField.getText());
			float longitude = Float.parseFloat(this.textField_2.getText());
			boolean camera = this.chckbxCamera.isSelected();
			boolean termometro = this.chckbxTermometro.isSelected(); 
			boolean medidorCo2 = this.chckbxMedidorCo2.isSelected();
			boolean medidorMetano = this.chckbxMedidorMetano.isSelected();
			
			this.frameTipoUnidade.setVisible(true);
			if(this.frameTipoUnidade.getTipoUnidade() == 0) {
				UnidadeManhattan unidade = new UnidadeManhattan(latitude, longitude, camera, termometro, medidorCo2, medidorMetano);
				this.monitoramentoLogica.salvarUnidade(unidade);
			}else if(this.frameTipoUnidade.getTipoUnidade() == 1) {
				UnidadeEuclidiana unidade = new UnidadeEuclidiana(latitude, longitude, camera, termometro, medidorCo2, medidorMetano);
				this.monitoramentoLogica.salvarUnidade(unidade);
			}	
		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Esse Campo só aceita números" ,"ATENÇÂO", JOptionPane.INFORMATION_MESSAGE); 
			e.printStackTrace();
		}
	}

	private void onMonitorar() {
		try {
			String retorno;
			float lat = Float.parseFloat(this.textField.getText());
			float lon = Float.parseFloat(this.textField_2.getText());
			retorno = this.monitoramentoLogica.monitorar(lat, lon, this.chckbxCamera.isSelected(), this.chckbxTermometro.isSelected(), 
										  this.chckbxMedidorCo2.isSelected(), this.chckbxMedidorMetano.isSelected());
			JOptionPane.showMessageDialog(null, retorno ,"ATENÇÂO", JOptionPane.INFORMATION_MESSAGE); 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Esse Campo só aceita números" ,"ATENÇÂO", JOptionPane.INFORMATION_MESSAGE); 
			e.printStackTrace();
		}
	}
	
	private void render() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 550);
		this.setTitle("Sistema de Monitoramento");
		this.setVisible(true);
	}
	
	public void run() throws Exception {
		this.initComponents();
		this.initLayout();
		this.render();		
	}
	
	private void setTable(){
		try {		
			List<UnidadeDTO> unidadesBase = monitoramentoLogica.getUnidades();
			this.tableModel = new TableModelMonitoramento(unidadesBase);			
			this.table = new JTable(tableModel);
			this.scrollPane = new JScrollPane();
			this.scrollPane.setBounds(240, 200, 300, 200);
			this.scrollPane.setViewportView(this.table);
		} catch (Exception e) {
			e.printStackTrace();			
		}		
	}

	private void initComponents() throws Exception {
		this.frameTipoUnidade = new FrameTipoUnidade();

	    this.btnExcluir = new JButton("Excluir");
		this.btnExcluir.addActionListener(this);
		this.btnMonitorar = new JButton("Monitorar");
		this.btnMonitorar.addActionListener(this);
		this.btnAdicionar = new JButton("Adicionar");
		this.btnAdicionar.addActionListener(this);
		
		this.lblNewLabel = new JLabel("Latitude");		
		this.textField = new JTextField();
		this.textField.setColumns(10);
		
		this.lblLongitude = new JLabel("Longitude");
		this.textField_2 = new JTextField();
		this.textField_2.setColumns(10);
		
		this.chckbxCamera = new JCheckBox("Camera");
		this.chckbxMedidorCo2 = new JCheckBox("Medidor CO2");
		this.chckbxTermometro = new JCheckBox("Termometro");
		this.chckbxMedidorMetano = new JCheckBox("Medidor Metano");		

		this.separator = new JSeparator();
		
		setTable();
	}
	
	private void initLayout() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelEast = new JPanel();
		contentPane.add(panelEast, BorderLayout.EAST);
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		panelNorth.add(btnExcluir);
		
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		JPanel panelWest = new JPanel();
		contentPane.add(panelWest, BorderLayout.WEST);
		panelWest.setLayout(new GridLayout(12, 3, 0, 0));
		
		panelWest.add(lblNewLabel);		
		panelWest.add(textField);
		panelWest.add(lblLongitude);
		panelWest.add(textField_2);
		panelWest.add(chckbxCamera);		
		panelWest.add(chckbxMedidorCo2);		
		panelWest.add(chckbxTermometro);
		panelWest.add(chckbxMedidorMetano);
		panelWest.add(btnMonitorar);		
		panelWest.add(separator);
		panelWest.add(btnAdicionar);
				
		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelCenter.add(scrollPane);
	}
}
