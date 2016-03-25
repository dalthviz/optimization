package pinterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import world.Optimizer;
import world.Point;

import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

public class Interface extends JFrame implements ActionListener {
	
	
	/*
	 * Constante para el boton de cacular
	 */
	private static final  String CALCULAR = "CALCULAR";
	
	
	/**
	 * Instancia del mundo
	 */
	
	private Optimizer mundo;
	private JLabel lblCoordenadaEnX;
	private JLabel lblCoordenadaEnY;
	private JLabel lblLongitudl;
	private JPanel panelDatos;
	private JTextField txtX;
	private JTextField txtPorcentaje;
	private JTextField txtY;
	private JTextField txtLongitud;
	private JPanel panelDeChart;
	private JPanel panelGrafica;
	private JPanel panelBotones;
	private JButton btnCalcular;
	private JPanel scrollTabla;
	private JScrollPane scrollPane;
	//MAIN
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface() {
		
		
		setTitle("Optimizador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 602);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panelDatos = new JPanel();
		panelDatos.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDatos.setName("Datos");
		getContentPane().add(panelDatos, BorderLayout.NORTH);
		panelDatos.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel label = new JLabel("");
		panelDatos.add(label);
		
		JLabel label_1 = new JLabel("");
		panelDatos.add(label_1);
		
		JLabel label_2 = new JLabel("");
		panelDatos.add(label_2);
		
		JLabel label_3 = new JLabel("");
		panelDatos.add(label_3);
		
		lblCoordenadaEnX = new JLabel("Coordenada en X");
		lblCoordenadaEnX.setHorizontalAlignment(SwingConstants.CENTER);
		panelDatos.add(lblCoordenadaEnX);
		
		txtX = new JTextField();
		panelDatos.add(txtX);
		txtX.setColumns(10);
		
		JLabel lblSigma = new JLabel("Porcentaje \u03C3");
		lblSigma.setHorizontalAlignment(SwingConstants.CENTER);
		panelDatos.add(lblSigma);
		
		txtPorcentaje = new JTextField();
		panelDatos.add(txtPorcentaje);
		txtPorcentaje.setColumns(10);
		
		lblCoordenadaEnY = new JLabel("Coordenada en Y");
		lblCoordenadaEnY.setHorizontalAlignment(SwingConstants.CENTER);
		panelDatos.add(lblCoordenadaEnY);
		
		txtY = new JTextField();
		panelDatos.add(txtY);
		txtY.setColumns(10);
		
		lblLongitudl = new JLabel("Longitud (l)");
		lblLongitudl.setHorizontalAlignment(SwingConstants.CENTER);
		panelDatos.add(lblLongitudl);
		
		txtLongitud = new JTextField();
		panelDatos.add(txtLongitud);
		txtLongitud.setColumns(10);
		
		JLabel label_4 = new JLabel("");
		panelDatos.add(label_4);
		
		JLabel label_5 = new JLabel("");
		panelDatos.add(label_5);
		
		JLabel label_6 = new JLabel("");
		panelDatos.add(label_6);
		
		JLabel label_7 = new JLabel("");
		panelDatos.add(label_7);
		
		panelGrafica = new JPanel();
		
		panelGrafica.setLayout(new GridLayout(1, 2, 0, 0));
		
		panelDeChart = new JPanel();
		panelGrafica.add(panelDeChart);
		panelDeChart.setBorder(new TitledBorder(null, "Gr\u00E1fica", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDeChart.setName("Gr\u00E1fico");
		panelDeChart.setToolTipText("Gr\u00E1fico");
		getContentPane().add(panelGrafica, BorderLayout.CENTER);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		panelGrafica.add(scrollPane);
		
		scrollTabla = new JPanel();
		scrollPane.setViewportView(scrollTabla);
		scrollTabla.setBorder(new TitledBorder(null, "Tabla", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollTabla.setLayout(new BorderLayout(0, 0));
		panelBotones = new JPanel();
		panelBotones.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setActionCommand(CALCULAR);
		btnCalcular.addActionListener(this);
		
		panelBotones.add(btnCalcular);
		
		getContentPane().add(panelBotones, BorderLayout.SOUTH);
		
	}

	public Optimizer darOptimizador() {
		// TODO Auto-generated method stub
		return mundo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		if(CALCULAR.equals(comando))
		{
			panelDeChart.removeAll();
			scrollTabla.removeAll();
			
			double xx = 0;
		double yy = 0;
		double sig = 0 ;
		double longi = 0;
			if(txtX.getText()!=""&&txtX.getText()!=null){
			xx = Double.parseDouble(txtX.getText());
			}
			if(txtY.getText().trim()!=""){
			 yy = Double.parseDouble(txtY.getText().trim());
			}if(txtPorcentaje.getText().trim()!="")
			{ sig = Double.parseDouble(txtPorcentaje.getText().trim());
			}
			if(txtLongitud.getText().trim()!=""){
			 longi = Double.parseDouble(txtLongitud.getText().trim());
			}
			mundo = new Optimizer( );
			mundo.modificadorPuntos(xx, yy, longi);
			DialogGraph g =new DialogGraph("Gráfico", "Vecindario", this, sig);
			g.setVisible(true);
			
			panelDeChart.add(g);
			panelDeChart.validate();
			
			String[] nombreColumna= {"Punto","X","Y"};
			Object [][]dat={{"Punto","X(Km)","Y(Km)"}
			
			};
			
			DefaultTableModel dtm= new DefaultTableModel(dat,nombreColumna);
			JTable table = new JTable(dtm);
			 //Agregar nueva columna
			 
			 double a =  mundo.getPuntos().size()*(sig/100);
				int avance = mundo.getPuntos().size()/(int) Math.round(a);
		        int j = 1;
				for(int i=0; i< mundo.getPuntos().size();i+=avance)
			 {
				 Point p = (Point) mundo.getPuntos().get(i);
				 
				 String index = j+"";
				 String x = p.getX()+"";
				 String y = p.getY()+"";
				 String [] f= {index,x,y};
				 dtm.addRow(f);
				 j++;
			 }
			 
			 
			 table.setPreferredScrollableViewportSize(new Dimension(250, 100));
			 
			 scrollTabla.add(table);
			scrollTabla.validate();
			
		}
	}

}
