/**
 * 
 */

/**
 * @author iratx
 *
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Invertir {

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws IOException {

		File fichero = new File ("."+ File.separator + "src" + File.separator + "invertirtexto.txt");
		BufferedReader bfr = new BufferedReader(new FileReader (fichero));
		String linea = bfr.readLine();
		String textoInvertido = invertirTexto(linea);
		bfr.close();
		System.out.println(textoInvertido);
	}
		
		public static String invertirTexto(String linea) {
			 return new StringBuilder(linea).reverse().toString();
	    }
		
	}
	

