package pinterface;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.Rotation;

import world.Point;



public class DialogGraph extends JPanel {

	  private static final long serialVersionUID = 1L;


	  private static Interface principal;
	  
	  private static double porcentaje;
	  public DialogGraph(String applicationTitle, String chartTitle, Interface interfaz, double porcentaje) {
	        setName(applicationTitle);
	        principal = interfaz;
	        this.porcentaje = porcentaje-5;
	        setLayout(new BorderLayout());
	        // This will create the dataset 
	        XYDataset dataset = createDataset();
	        // based on the dataset we create the chart
	        JFreeChart chart = createChart(dataset, chartTitle);
	        // we put the chart into a panel
	        ChartPanel chartPanel = new ChartPanel(chart);
	        // default size
	        chartPanel.setPreferredSize(new java.awt.Dimension(350, 350));
	        // add it to our application
	        add(chartPanel, BorderLayout.CENTER);

	    }
	    
	    
	/**
	     * Creates a sample dataset 
	     */

	      private static XYDataset createDataset() {
	        XYSeriesCollection result = new XYSeriesCollection();
	        XYSeries series = new XYSeries("Vecindario");
	      //  XYSeries serieF =  new XYSeries("Factibles");
	        //XYSeries serieI =  new XYSeries("Infactibles");
	        
	        ArrayList ptos = principal.darOptimizador().getPuntos();
	        double a = ptos.size()*(porcentaje/100);
			int avance = ptos.size()/(int) Math.round(a);
	        
	               //serieF.add(((Punto) ptos.get(0)).getX() ,((Punto) ptos.get(0)).getY());
			
	       //SELECCIONA LOS PUNTOS PARA GRAFICAR SEGUN UN SIGMA DADO
			
			for(int i=0; i< ptos.size();i+=avance)
			{
//				int posicion = (int) (Math.random()*avance+1);
//				double xs = (double)((Punto) basePuntos.get(i)).getX();
//				double ys = (double)((Punto) basePuntos.get(i)).getY();
//				Punto agre = new Punto(xs, ys); 
//				//if (!agre.isSeleccionado())
//				puntos.add(agre);
				
			//	agre.setSeleccionado(true);
				 Point p = (Point) ptos.get(i);
		            series.add(p.getX() ,p.getY());
		            // serieF.add(p.getX() ,p.getY());
				
			}
			
	        result.addSeries(series);
	        //result.addSeries(serieI);
	        //result.addSeries(serieF);
	        return result;
	    }
	    
	    
	/**
	     * Creates a chart
	     */

	    private JFreeChart createChart(XYDataset dataset, String title) {
	        
	        JFreeChart chart = ChartFactory.createScatterPlot(title,          // chart title
	            "X", //label eje x
	            "Y",  	//label eje y 
	            dataset,                // data
	            PlotOrientation.VERTICAL, 
	            true,                   // include legend
	            true,					//tooltips
	            false   		//URLS
	            );

	        
	        return chart;
	        
	    }
	  
	} 
