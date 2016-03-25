package world;

import java.io.File;
import java.util.ArrayList;



import jxl.Sheet;
import jxl.Workbook;

public class Loader {

	
	
	public Loader(String archivoDestino, ArrayList puntos, ArrayList basePuntos) { 

		try { 
		Workbook archivoExcel = Workbook.getWorkbook(new File(archivoDestino)); 
		
		for (int sheetNo = 0; sheetNo < archivoExcel.getNumberOfSheets(); sheetNo++) // Recorre 
		// cada    
		// hoja                                                                                                                                                       
		{ 
		Sheet hoja = archivoExcel.getSheet(sheetNo); 
		int numColumnas = hoja.getColumns(); 
		int numFilas = hoja.getRows(); 
		String[] data = new String [numColumnas]; 
		
		
		for (int fila = 1; fila < numFilas ; fila++) { // Recorre cada 
		// fila de la 
		// hoja 
		for (int columna = 0; columna < numColumnas; columna++) { // Recorre                                                                                
		// cada                                                                                
		// columna                                                                            
		// de                                                                                
		// la                                                                                
		// fila 
			if(hoja.getCell(columna, fila).getContents()!= "") 
		data[columna] = hoja.getCell(columna, fila).getContents(); 
		

		} 
		
		if(data[0]!= null){
		String x = data[0].replace(",", ".");
		data[0]= x;
		
		String y = data[1].replace(",", ".");
		data[1]=y;
		System.out.println(data[0]);
		Point p = new Point (Double.parseDouble(data[0]),Double.parseDouble(data[1]));
		//puntos.add(p);
		basePuntos.add(p);
		System.out.println(p);
		//termina for de la fila
		}
		} 
		} 
		} catch (Exception ioe) { 
		ioe.printStackTrace(); 
		} 

		} 


}
