package world;

import java.util.ArrayList;

public class Optimizer {

	
	/**
	 * Puntos iniciales base de puntos dada
	 */
	private ArrayList basePuntos;
	
	/**
	 * Lista con todos los puntos que componen el vecindario
	 */
	private ArrayList puntos;
	
	/**
	 * instancia de la clase para cargar del archivo xmls
	 */
	private Loader cargador;
	
	/**
	 * Lista de puntos factibles
	 */
	private ArrayList pFactibles;
	/**
	 * Lista de puntos infactibles
	 */
	
	private ArrayList pInfactibles;
	
	/**
	 * El mejor punto que encuentra en una iteracion
	 */
	
	private Point mPunto;
		
	//CONSTRUTOR
	
	/**
	 * Constructor de la aplicación crea la instacia que maneja la vecindad de puntos, y determina su factibilidad asi como la mejor opción de un vecindario
	 * Además crea los puntos por medio del cargador la ruta del archivo != null &&  != ""
	 */
	public Optimizer ()
	{basePuntos = new ArrayList();
		puntos = new ArrayList ();
		pFactibles = new ArrayList ();
		pInfactibles = new ArrayList ();
	cargador = new Loader("./data/vecindario.xls", puntos, basePuntos);
	
	}

	/**
	 * @return the pFactibles
	 */
	public ArrayList getpFactibles() {
		return pFactibles;
	}

	/**
	 * @param pFactibles the pFactibles to set
	 */
	public void setpFactibles(ArrayList pFactibles) {
		this.pFactibles = pFactibles;
	}

	/**
	 * @return the pInfactibles
	 */
	public ArrayList getpInfactibles() {
		return pInfactibles;
	}

	/**
	 * @param pInfactibles the pInfactibles to set
	 */
	public void setpInfactibles(ArrayList pInfactibles) {
		this.pInfactibles = pInfactibles;
	}

	/**
	 * @return the mPunto
	 */
	public Point getmPunto() {
		return mPunto;
	}

	/**
	 * @param mPunto the mPunto to set
	 */
	public void setmPunto(Point mPunto) {
		this.mPunto = mPunto;
	}

	/**
	 * @return the puntos
	 */
	public ArrayList getPuntos() {
		return puntos;
	}

	/**
	 * @return the cargador
	 */
	public Loader getCargador() {
		return cargador;
	}
	
	/**
	 * Modifica los puntos segun parametros dados (longitud de la vecindad, punto inicial (x, y), sigma de porcentaje de puntos a mostrar
	 *@param x coordenada x del punto inicial
	 *@param y coordenada y del punto inicial
	 *@param sigma porcentaje de puntos a mostrar
	 *@param longitud tamaño del vecindario
	 *NOTA: la distribución de puntos de manera uniforme es realizada por la clase DialogoGrafica (caracteristica referente al sigma porcentaje)
	 */
	
	public void modificadorPuntos (double x, double y, double longitud){
		
		//NOTA
		
		
		for (int i = 0; i<basePuntos.size();i++)
		{
			
			double xs = (double)((Point) basePuntos.get(i)).getX();
			double ys = (double)((Point) basePuntos.get(i)).getY();
			Point agre = new Point(xs, ys); 
			//if (!agre.isSeleccionado())
			puntos.add(agre);
			
			Point p = (Point) puntos.get(i);
			double corx = (double) ((double) (p.getX()*(longitud/5)+x));
			p.setX(corx);
			double cory = (double) ((double) (p.getY()*(longitud/5)+y));
			p.setY(cory);
			
		}
		
		
		
	}

	/**
	 * Prueba la factibilidad de los puntos para las retricciones del problema
	 *MODIFICA las lista de puntos factibles y no factibles
	 */
	
	public void setFactibilidad ()
	{
		
	}
	
}
