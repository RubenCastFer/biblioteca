/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package clases;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main (String [] args) {
    	
    	ArrayList<Libro> catalogo = new ArrayList<Libro>();
    	
    	while(true) {
    		int opcion = menu();
    		switch (opcion) {
			case 1:
				//TODO Alta de Libro
				//titulo:isbn:genero:autor:paginas
				alta(catalogo);
				break;
				
			case 2:
				//TODO Lista de Libros
				listadoLibro(catalogo);
				break;
				
			case 3:
				bajaLibro(catalogo);
				break;
				
			case 4:
				busquedaDeLibros(catalogo);
				break;
				
			case 5:
				ordenarLibros(catalogo);
				break;
				
			case 6: System.exit(0);
				
			default:
				break;
			}
    	}
    }
    
    private static int menu() {
    	int opcion=0;
    	
    	do {
    		System.out.println("Opciones:");
    		System.out.println("1. Alta de Libro");
    		System.out.println("2. Lista de Libros");
    		System.out.println("3. Baja de Libros");
    		System.out.println("4. Búsqueda de Libros");
    		System.out.println("5. Ordenacion de Libros");
    		System.out.println("6. Salir");
    		System.out.println("Introduce la opcion:");
    	
    		opcion = leerOpcion(5);
    		
    	}while(opcion <=0);
    	
    	return opcion;
    }
    
    private static int leerOpcion(int max) {
    	int opcion = -1;
    	try {
    		Scanner teclado = new Scanner(System.in);
    		opcion=teclado.nextInt();
    		if(opcion>max)
    			opcion=-1;
    	}catch (InputMismatchException e) {
			System.out.println("Opción incorrecta");
		}
    	
    	return opcion;
    }
    
    private static void alta(ArrayList<Libro> catalogo) {
    	//Leer de la entrada
    	String datosLibro = obtenerDatosLibro();
    	//titulo:isbn:genero:autor:paginas
    	//Procesar la entrada
    	Libro libro = procesaEntrada(datosLibro);
    	//Crear el libro con los datos de la entrada
    	catalogo.add(libro);
    	//Meter el libro en el catalogo
    }
    
    private static String obtenerDatosLibro() {
    	String datos=null;
    	
    	boolean validado=false;
    	while(!validado) {
    		System.out.println("Introduce los datos de un libro.");
    		System.out.println("Usa el formato \"titulo:isbn:genero:autor:paginas\"");
    		try {
    			datos = leerCadena();
    			if(true)//Supongo de momento que valida siempre
    				validado=true;
    		}catch (InputMismatchException e) {
				System.out.println("Datos de entrada no válidos");
			}
    	}
    	
    	return datos;
    }
    
    private static Libro procesaEntrada(String entrada) {
    	Libro libro = null;
    	
    	String [] datos = entrada.split(":");
    	
    	String titulo = datos[0];
    	String isbn = datos[1];
    	Genero genero = Genero.getGenero(datos[2]);
    	String autor = datos[3];
    	Integer paginas = Integer.parseInt(datos[4],10);
    	libro = new Libro(titulo, isbn, genero, autor, paginas);    	
    	return libro;
    }
    
    private static String leerCadena() {
    	String opcion = null;
    	Scanner teclado = new Scanner(System.in);
        opcion=teclado.nextLine();
    	return opcion;
    }
    
    //recorre uno a uno los objetos de catalogo y muestra todos los datos con toString
    private static void listadoLibro(ArrayList<Libro> catalogo) {
    	for (int fila=0;fila<catalogo.size();fila++) {
    		System.out.println("Libro nº "+ fila +" en el catalogo:\n"+ catalogo.get(fila).toString()+" \n");
    	}
    }
    
    private static void bajaLibro(ArrayList<Libro> catalogo) {
    	Scanner teclado = new Scanner(System.in);
    	System.out.println("Introduzca la posición del Libro que desea dar de baja: ");
    	int opcion=teclado.nextInt();
    	catalogo.remove(opcion);
    	System.out.println("Libro borrado. ");
    }
    
    
    /**
     * Pregunta al usuario el ISBN
     * Usa el método .indexOf de List para ver si está el Libro con el ISBN introducido (Ignora la diferencia entre mayúsculas y minúsculas)
     * Si está muestra todos los datos del libro
     * Si no está muestra un mensaje diciendo que el libro no está en la lista
     * 
     */
    private static void busquedaDeLibros(ArrayList<Libro> catalogo) {
    	Scanner teclado = new Scanner(System.in);
    	System.out.println("Introduzca el ISBN del libro que desea encontrar. ");
    	String buscar = teclado.nextLine();
    	int resultado= Libro.getIsbn().indexOf(buscar);
    	if(resultado!=-1) {
    		System.out.println(catalogo.get(resultado).toString());
    	} else{
    		System.out.println("El libro no esta en el catalogo");
    	}
    }
    
    /**
     * Pide al usuario si desea ordenar por título o por Número de Páginas
     *
     * Para ordenar por título alfabéticamente se debe usar el método 
     * sort de la Clase Collections por orden natural
     * 
     * Para ordenar por número de Páginas se debe usar el método 
     * sort de Collections que recibe un comparator.
     */
    
    private static void ordenarLibros(ArrayList<Libro> catalogo) {
    	Scanner teclado = new Scanner(System.in);

    	System.out.println("De que forma desea ordenar el catalogo, por el título o por el número de páginas. \n(titulo/paginas): ");
    	String respuesta= teclado.next();
    	if (respuesta.equalsIgnoreCase("titulo")) {
    		Collections.sort(catalogo, new Comparator<Libro>() {
    			public int compare(Libro obj1, Libro obj2) {
    			      return obj1.getTitulo().compareTo(obj2.getTitulo());
    			}
			});
    	}
    	
    	if (respuesta.equalsIgnoreCase("paginas")) {
    		Collections.sort(catalogo, new Comparator<Libro>() {
    			public int compare(Libro obj1, Libro obj2) {
    			      return obj1.getPaginas().compareTo(obj2.getPaginas());
    			}
			});
    	}
    }
}
