package superheroes;

import java.io.*;
public class Tipo {

public static void main(String[] args) throws IOException {
	
	final int registro = 110;
	File fichero = new File ("." + File.separator + "src" + File.separator + 
			"main" + File.separator + "java"+ File.separator + "superheroes"+ File.separator + "personajes.dat"); //se crea el objeto fichero en la ruta
	//crea el fichero de acceso aleatorio con permisos de lectura y escritura
	RandomAccessFile file = new RandomAccessFile(fichero, "rw");
	String tipoConsola, tipoFichero, dniFichero, nombreFichero, idenFichero;
	int pesoFichero, altFichero;
	Boolean existeTipo = false;

	//introduce el tipo de personaje mediante el teclado
	System.out.println("Introduzca el tipo de personaje:");
	tipoConsola = Consola.readString();
	
		for(int p=0;p<file.length();p+=registro){
		file.seek(p); //posiciona el puntero
		file.skipBytes(82);// salta 82 bytes
		char[] auxTipo =new char[10];
		for(int i=0;i<10;i++)
		{
			auxTipo[i]=file.readChar();
		}
		tipoFichero = new String(auxTipo);
		
		if(tipoFichero.trim().equalsIgnoreCase(tipoConsola)){
			existeTipo = true;
			file.seek(p);
			file.skipBytes(4);//Salto el c digo
			//Recojo el dni
			char[] auxDni =new char[9];
			for(int i=0;i<9;i++)
			{
				auxDni[i]=file.readChar();
			}
			dniFichero = new String(auxDni).trim();
			
			//Recojo el nombre
			char[] auxNombre =new char[10];
			for(int i=0;i<10;i++)
			{
				auxNombre[i]=file.readChar();
			}
			nombreFichero = new String(auxNombre).trim();
			//Recojo la identidad
			char[] auxIden =new char[20];
			for(int i=0;i<20;i++)
			{
				auxIden[i]=file.readChar();
			}
			idenFichero = new String(auxIden).trim();
			//Recojo el tipo
			char[] auxTip =new char[10];
			for(int i=0;i<10;i++)
			{
				auxTip[i]=file.readChar();
			}
			tipoFichero = new String(auxTipo).trim();
			//Recojo el peso
			pesoFichero= file.readInt();
			//Recojo la altura
			altFichero= file.readInt();
			
			//Muestra los valores de los personajes por pantalla			
			System.out.print("DNI: "+dniFichero);
			System.out.print("  Nombre: "+nombreFichero);
			System.out.print("  Identidad: "+idenFichero);
			System.out.print("  Tipo: "+tipoFichero);
			System.out.print("  Peso: "+pesoFichero);
			System.out.println("  Altura: "+altFichero);
			
		
		}
	}
	if(!existeTipo)
		System.out.println("El tipo introducido no existe.");
	file.close();
}

}