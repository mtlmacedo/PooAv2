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
import logica.UnidadeMovel;
import logica.dto.UnidadeDTO;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
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

public class FrameMonitoramento extends JFrame implements MonitoramentoUI, ActionListener {
	public FrameMonitoramento() {
	}

	private JScrollPane scrollPane;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTable table;
	private JButton btnAtualizar;
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
			}else if(arg0.getSource().equals(this.btnAtualizar)) {
				this.onAtualizar();
			}
			this.repaint();
		}catch (Exception e) {
			
		}
	}	
	
	private void onAtualizar() {
		
		
	}

	private void onAdicionar() {

	}

	private void onMonitorar() throws Exception {
		
		float lat = (float) Double.parseDouble(this.textField.getText());
		float lon = (float) Double.parseDouble(this.textField_2.getText());
		
		monitoramentoLogica.monitorar(lat, lon, this.chckbxCamera.isSelected(), this.chckbxTermometro.isSelected(), 
									  this.chckbxMedidorCo2.isSelected(), this.chckbxMedidorMetano.isSelected());
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
	
	private void setTableData(){
		try {
		
			List<UnidadeMovel> unidadesBase = monitoramentoLogica.getUnidades();
			TableModelMonitoramento tableModel = new TableModelMonitoramento(unidadesBase);			
			this.table = new JTable(tableModel);

		} catch (Exception e) {
			e.printStackTrace();			
		}		
	}

	private void initComponents() {

	    this.btnAtualizar = new JButton("Atualizar");
		this.btnAtualizar.addActionListener(this);
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
		
		setTableData();
		this.scrollPane = new JScrollPane();
		scrollPane.setBounds(240, 200, 300, 200);
		scrollPane.setViewportView(this.table);
			
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
		
		panelNorth.add(btnAtualizar);
		
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
