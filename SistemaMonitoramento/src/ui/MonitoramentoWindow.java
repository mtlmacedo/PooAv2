package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.MonitoramentoLogica;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import java.awt.Font;

import persistencia.*;
import logica.MonitoramentoLogica;
public class MonitoramentoWindow extends JFrame implements MonitoramentoUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLatitude;
	private JTextField txtLongitude;
	private MonitoramentoLogica monitoramentoLogica;
	private static JButton btnMonitorar;
	private static JButton btnSalvar;
	
	/**
	 * Launch the application.
	 */

	
	public void setLogica(MonitoramentoLogica logica) throws Exception{
		this.monitoramentoLogica = logica;
	}
	
	public void run() {
		try {
			MonitoramentoWindow frame = new MonitoramentoWindow();
			frame.setVisible(true);
			btnMonitorar.grabFocus();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public MonitoramentoWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Sistema de Monitoramento");
		setBounds(100, 100, 622, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{28, 123, 16, 28, 0};
		gbl_contentPane.rowHeights = new int[]{14, 50, 0, 0, 0, 0, 0, 0, 0, 28, 0, 28, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		txtLatitude = new JTextField();
		txtLatitude.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(txtLatitude.getText().equals("Latitude")) {
					txtLatitude.setText("");
				}
			}
			public void focusLost(FocusEvent e) {
				if(txtLatitude.getText().isEmpty()) {
					txtLatitude.setText("Latitude");
				}
			}
		});
		
		JLabel lblMonitoramento = new JLabel("MONITORAMENTO");
		lblMonitoramento.setFont(new Font("Javanese Text", Font.PLAIN, 12));
		GridBagConstraints gbc_lblMonitoramento = new GridBagConstraints();
		gbc_lblMonitoramento.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonitoramento.gridx = 1;
		gbc_lblMonitoramento.gridy = 1;
		contentPane.add(lblMonitoramento, gbc_lblMonitoramento);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 11;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		
		JLabel lblLatitude = new JLabel("Latitude");
		GridBagConstraints gbc_lblLatitude = new GridBagConstraints();
		gbc_lblLatitude.anchor = GridBagConstraints.WEST;
		gbc_lblLatitude.insets = new Insets(0, 0, 5, 5);
		gbc_lblLatitude.gridx = 1;
		gbc_lblLatitude.gridy = 2;
		contentPane.add(lblLatitude, gbc_lblLatitude);
		GridBagConstraints gbc_txtLatitude = new GridBagConstraints();
		gbc_txtLatitude.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLatitude.insets = new Insets(0, 0, 5, 5);
		gbc_txtLatitude.gridx = 1;
		gbc_txtLatitude.gridy = 3;
		contentPane.add(txtLatitude, gbc_txtLatitude);
		txtLatitude.setColumns(10);
		
		txtLongitude = new JTextField();
		txtLongitude.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(txtLongitude.getText().equals("Longitude")) {
					txtLongitude.setText("");
				}
			}
			public void focusLost(FocusEvent e) {
				if(txtLongitude.getText().isEmpty()) {
					txtLongitude.setText("Longitude");
				}
			}
		});
		
		JLabel lblLongitude = new JLabel("Longitude");
		GridBagConstraints gbc_lblLongitude = new GridBagConstraints();
		gbc_lblLongitude.anchor = GridBagConstraints.WEST;
		gbc_lblLongitude.insets = new Insets(0, 0, 5, 5);
		gbc_lblLongitude.gridx = 1;
		gbc_lblLongitude.gridy = 4;
		contentPane.add(lblLongitude, gbc_lblLongitude);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 5;
		contentPane.add(separator_1, gbc_separator_1);
		GridBagConstraints gbc_txtLongitude = new GridBagConstraints();
		gbc_txtLongitude.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLongitude.insets = new Insets(0, 0, 5, 5);
		gbc_txtLongitude.gridx = 1;
		gbc_txtLongitude.gridy = 5;
		contentPane.add(txtLongitude, gbc_txtLongitude);
		txtLongitude.setColumns(10);
		
		JCheckBox chckbxMedidorDeCo = new JCheckBox("Medidor de CO2");
		chckbxMedidorDeCo.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxMedidorDeCo = new GridBagConstraints();
		gbc_chckbxMedidorDeCo.anchor = GridBagConstraints.WEST;
		gbc_chckbxMedidorDeCo.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxMedidorDeCo.gridx = 1;
		gbc_chckbxMedidorDeCo.gridy = 6;
		contentPane.add(chckbxMedidorDeCo, gbc_chckbxMedidorDeCo);
		
		JCheckBox chckbxCamera = new JCheckBox("Camera");
		chckbxCamera.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxCamera = new GridBagConstraints();
		gbc_chckbxCamera.anchor = GridBagConstraints.WEST;
		gbc_chckbxCamera.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxCamera.gridx = 1;
		gbc_chckbxCamera.gridy = 7;
		contentPane.add(chckbxCamera, gbc_chckbxCamera);
		
		JCheckBox chckbxTermometro = new JCheckBox("Termometro");
		GridBagConstraints gbc_chckbxTermometro = new GridBagConstraints();
		gbc_chckbxTermometro.anchor = GridBagConstraints.WEST;
		gbc_chckbxTermometro.fill = GridBagConstraints.VERTICAL;
		gbc_chckbxTermometro.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxTermometro.gridx = 1;
		gbc_chckbxTermometro.gridy = 8;
		contentPane.add(chckbxTermometro, gbc_chckbxTermometro);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Medidor de Metano");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 1;
		gbc_chckbxNewCheckBox.gridy = 9;
		contentPane.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.DARK_GRAY);
		separator.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 0, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 11;
		contentPane.add(separator, gbc_separator);
		
		MonitoramentoWindow.btnMonitorar = new JButton("Monitorar");
		MonitoramentoWindow.btnMonitorar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		GridBagConstraints gbc_btnMonitorar = new GridBagConstraints();
		gbc_btnMonitorar.insets = new Insets(0, 0, 0, 5);
		gbc_btnMonitorar.gridx = 1;
		gbc_btnMonitorar.gridy = 10;
		contentPane.add(btnMonitorar, gbc_btnMonitorar);		
				
		MonitoramentoWindow.btnSalvar = new JButton("Salvar");
		MonitoramentoWindow.btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
			}
		});
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.gridx = 1;
		gbc_btnSalvar.gridy = 11;
		contentPane.add(btnSalvar, gbc_btnSalvar);		
		}

}
