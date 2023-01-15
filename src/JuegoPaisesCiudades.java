import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class JuegoPaisesCiudades {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		HashMap<String, String> countries = new HashMap<String, String>();

		try {
			
			FileReader entrada = new FileReader("/Users/agustinaheredia/Documents/eclipse-workspace/S1Tasca3N1Ejercicio3AgustinaHeredia/countries.txt");
		
			BufferedReader mibuffer = new BufferedReader(entrada);
			String linea ="";
			
			while (linea != null )  {
			 	linea = mibuffer.readLine();
				if (linea != null) {
				String[] parts = linea.split(" ");
				String pais = parts[0]; 
				String ciudad = parts[1]; 
				
				countries.put(pais, ciudad);
				}
			}
		entrada.close();
		}catch (IOException e) {
			System.out.println("No se ha encontrado el archivo");
			
		}
		
		String usuario=pedirString("Ingresa el nombre de usuario/a.");
		
		int puntuacion = 0;
		for(int i = 0; i<10; i++) {
			Object[] elementoAleatorio = countries.keySet().toArray();
			Object key = elementoAleatorio[new Random().nextInt(elementoAleatorio.length)];
			  
			String capital = pedirString("Escribe la capital de: " + key );
			  int punto = 0;
			if (capital.equalsIgnoreCase(countries.get(key))) {
				 punto = 1;
				
			}else {
				 punto = 0;
			}
			  
			puntuacion = puntuacion + punto;

		}
		System.out.println("Encontrarás tu puntuación en el archivo clasificación.txt.");
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        	try {
       
            fichero = new FileWriter("/Users/agustinaheredia/Documents/eclipse-workspace/S1Tasca3N1Ejercicio3AgustinaHeredia/clasificacion.txt");
            pw = new PrintWriter(fichero);

            
                pw.println("El nombre de usuario es: " + usuario);
                pw.println("Su puntuación ha sido de : " + puntuacion+" puntos.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           //  aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
              
           }	
		
        }
	}
	
	

	static String pedirString(String texto) {
		System.out.println(texto);
		String nom = input.next();
		return nom;
	} 

	
}
