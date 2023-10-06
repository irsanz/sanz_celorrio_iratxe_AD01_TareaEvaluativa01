package superheroes;

import java.io.*;

public class Peso {

	public static void main(String[] args) throws IOException {
		final int registro = 110;
File fichero = new File ("." + File.separator + "src" + File.separator + 
	"tarea_eva" + File.separator + "personajes.dat"); //se crea el objeto fichero en la ruta
//crea el fichero de acceso aleatorio con permisos de lectura y escritura
RandomAccessFile file = new RandomAccessFile(fichero, "rw");

//variables
String dniConso, dniFich, nombreFich;
int pesoFichero, pesoConsola;
Boolean existeDni = false;
//introduce el DNI mediante el teclado
System.out.println("Introduzca el DNI del personaje:");
dniConso = Consola.readString();

for(int p=0;p<file.length();p+=registro){
file.seek(p); //posiciona en puntero
file.skipBytes(4);//salta bytes
char[] auxDni =new char[9];
for(int i=0;i<9;i++)
{
	auxDni[i]=file.readChar();
}
dniFich = new String(auxDni);
if(dniFich.trim().equalsIgnoreCase(dniConso)){
	existeDni = true;
	file.seek(p);
	file.skipBytes(22);//Salto el c digo
	//Recojo el nombre
	char[] auxNombre =new char[10];
	for(int i=0;i<10;i++)
	{
		auxNombre[i]=file.readChar();
	}
	nombreFich = new String(auxNombre).trim();
	
	file.skipBytes(60);//Salto el codigo 60 bytes
	//Recojo el peso
	pesoFichero= file.readInt();
	
	
	System.out.println("Introduzca el peso actual del personaje:");
	pesoConsola = Consola.readInt();
	
	if(pesoConsola>pesoFichero){
		System.out.println(nombreFich +" ha engordado " + (pesoConsola - pesoFichero));
	} else if (pesoConsola<pesoFichero) {
		System.out.println(nombreFich +" ha adelgazado " + (pesoFichero - pesoConsola));
	} else System.out.println(nombreFich + " se mantiene en su peso anterior");
			
	}
}
if(!existeDni)
System.out.println("El DNI introducido no existe.");
file.close();
}
}
