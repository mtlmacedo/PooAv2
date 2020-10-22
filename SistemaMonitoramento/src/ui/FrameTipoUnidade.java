package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameTipoUnidade extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnEnviar;
	private JComboBox comboBox;
	private JButton btnCancelar;
	private JLabel lblSelecioneOTipo;
	private int tipoUnidade;
	
	public int getTipoUnidade() {
		return tipoUnidade;
	}

	private void initComponents() {
		
		this.lblSelecioneOTipo = new JLabel("Selecione o tipo da unidade");
		this.lblSelecioneOTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		this.btnEnviar = new JButton("Enviar");
		this.btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.btnEnviar.addActionListener(this);
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.btnCancelar.addActionListener(this);
		
		this.comboBox = new JComboBox();
		this.comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.comboBox.setModel(new DefaultComboBoxModel(EnumTipoUnidade.values()));
	}
	public FrameTipoUnidade() {
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 147);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		contentPane.add(this.lblSelecioneOTipo);
		
		contentPane.add(this.comboBox);
		
		contentPane.add(this.btnEnviar);
		
		contentPane.add(this.btnCancelar);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(this.btnEnviar)) {
			this.onEnviar();
		}else if(arg0.getSource().equals(this.btnCancelar)) {
			this.onCancelar();
		}
		this.repaint();		
	}
	private void onCancelar() {
		this.dispose();		
	}
	private void onEnviar() {
		this.tipoUnidade = this.comboBox.getSelectedIndex();
		this.dispose();
	}
	
	

}
