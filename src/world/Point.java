package world;

public class Point {

	//ATRIBUTOS
	
	/**
	 * Coordenada x del punto
	 */
	private double x;
	
	/**
	 * Coordenada y del punto
	 */
	private double y;
	
	
	/**
	 * Si el punto es o no factible
	 */
	private boolean factibilidad;
	
	
	//CONSTRUCTOR
	
		/**Crea el punto segun los parametros de coordenadas dados
	 * @param x coordenada en el eje x
	 * @param y coordenada en el eje y
	 */
	public Point (double x, double y)
	{
	
		this.x = x;
		this.y = y;
	factibilidad = true;	
	}

	//METODOS

	
	/**Retorna factibilidad
	 * @return the factibilidad
	 */
	public boolean isFactibilidad() {
		return factibilidad;
	}

	/**Para modificar la factibilidad
	 * @param factibilidad the factibilidad to set
	 */
	public void setFactibilidad(boolean factibilidad) {
		this.factibilidad = factibilidad;
	}

	/**Retorna la coordenada x
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**Retorna la coordenada y
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Punto [factibilidad=" + factibilidad + ", x=" + x + ", y=" + y
				+ "]";
	}
	
	
	
}
