



import java.io.*;
import java.util.Arrays;
	
public class Eszip {

		 public static void main(String[] args) {
		    	File fic = new File ("." + File.separator + "src" + File.separator + "Eszip.zip");
		    	
		        byte[] zipcabecero = {80,75,3,4}; //cabecero de zip
		 
		        try (
		            InputStream ficzip = new FileInputStream(fic);
		        ) {
		            byte[] cabarchivo = new byte[4];
		            ficzip.read(cabarchivo);
		            //Guarda los 4 primeros bytes del cabecero del archivo de la ruta especificada anteriormente
		            if (!Arrays.equals(cabarchivo, zipcabecero)) {
		                System.out.println("No se trata de un archivo zip");
		                System.exit(-1);
		            } else System.out.println("Es un archivo zip.");
		            //Los dos arrays deben de coincidir para ser un zip
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
		    }

}

	
