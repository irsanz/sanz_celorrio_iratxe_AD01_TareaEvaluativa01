import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 */

/**
 * @author iratx
 *
 */
public class palindromas {

	/**
	 * @param args
	 */

		public static void main(String[] args)  throws IOException {

			File fichero = new File ("."+ File.separator + "src" + File.separator + "palin.txt");
			File palinok = new File ("."+ File.separator + "src" + File.separator + "palinok.txt");
			palinok.createNewFile();
			BufferedReader bfr = new BufferedReader(new FileReader (fichero));
			String linea = bfr.readLine();
			System.out.println("El texto original es: " + linea);
			
			BufferedWriter bfw = new BufferedWriter(new FileWriter (palinok));

	            while ((linea = bfr.readLine()) != null) {
	                // Dividir la línea en palabras utilizando espacios como delimitadores
	                String[] palabras = linea.split(" ");

	                for (String palabra : palabras) {
	                      palabra = palabra.toLowerCase(); // Convertir la cadena a minúsculas
	                        int left = 0;
	                        int right = palabra.length() - 1;

	                        while (left < right) {
	                            if (palabra.charAt(left) == palabra.charAt(right)) {
	                    	bfw.write(palabra);}
	           
	            bfw.close();
	            bfr.close();
		
	                     
	                                
	                        }}}}}
