package superheroes;

import java.io.*;

public class personajes {

	public static void main(String[] args) throws IOException {
		final int registro = 110; //longitud de cada registro
		File fichero = new File ("." + File.separator + "src" + File.separator + 
				"main" + File.separator + "java" + File.separator + "superheroes" + File.separator + "Marvel.dat" ); 
		//ruta para guardar los personajes
		
		
		if (fichero.exists()){//Si el fichero existe, se borra 
			fichero.delete();
		}
		try {
				//crea el fichero 
			RandomAccessFile file = new RandomAccessFile(fichero, "rw"); 
	
		//Arrays con los datos
			int [] ids= {1, 2, 3, 4, 5, 6, 7};
			String[] dnis= {"01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D", "06060606F"};
			String[] noms= {"Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin"};
			String[] identidades = {"Peter Parker", "Norman Osborn", "Ororo Munroe","James Howlett", "Raven Darkholme", "Tony Stark", "Zhang Tong"};
			String[] tipos = {"heroe","villano","heroe","heroe","villano","heroe","villano"};
			int[] pesos = {76,84,66,136,78,102,70};
			int[] alturas = {178,183,156,152,177,182,188};
		
		StringBuffer bufferdnis = null; //Buffers para guardar los datos
		StringBuffer buffernom = null; 
		StringBuffer buffferidenti = null; 
		StringBuffer buffertipo = null; 

		int n = ids.length; //elementos del array
		int posicion = 0;
		
		for (int i=0; i<n; i++){
			posicion = i*registro;
			file.seek(posicion);
			file.writeInt(ids[i]);//con ids se identifica al personaje
			
			bufferdnis = new StringBuffer(dnis[i]); //guardamos el dato del dni
			bufferdnis.setLength(9);//9 caracteres para el dni
			file.writeChars(bufferdnis.toString());//inserta el dni
			
			buffernom = new StringBuffer(noms[i]); //guardamos el dato del nombre
			buffernom.setLength(10);//15 caracteres para el nombre
			file.writeChars(buffernom.toString());//inserta el nombre
			
			buffferidenti = new StringBuffer(identidades[i]); //guardamos el datos de la identidad
			buffferidenti.setLength(20);//15 caracteres para la identidad
			file.writeChars(buffferidenti.toString());//inserta la identidad
			
			buffertipo = new StringBuffer(tipos[i]); //guardamos el dato del tipo
			buffertipo.setLength(10);//7 caracteres para el tipo
			file.writeChars(buffertipo.toString());//inserta el tipo
			
			file.writeInt(pesos[i]);//se inserta el peso
			
			file.writeInt(alturas[i]);//se inserta la altura
		}
					
		file.close();
		System.out.println("La carga de los personajes ha terminado correctamente");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}

