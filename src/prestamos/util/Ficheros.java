package prestamos.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Ficheros {
	/**
	 * Lee un archivo de texto línea por línea y devuelve una lista de objetos de tipo T creados a partir de cada línea, utilizando una función dada. Si se especifica un encabezado, se omite la primera línea del archivo. Si no se especifica un encabezado, se procesan todas las líneas del archivo.
	 *
	 * @param filePath La ruta del archivo de texto a leer.
	 * @param f        La función que se utiliza para crear objetos de tipo T a partir de cada línea del archivo.
	 * @param header   Un booleano que indica si se debe omitir la primera línea del archivo.
	 * @param <T>      El tipo de objeto que se devuelve en la lista.
	 * @return Una lista de objetos de tipo T creados a partir de las líneas del archivo de texto.
	 */
	public static <T> List<T> parse(String filePath, Function<String, T> f, Boolean header) {
		Boolean h = header;
		List<T> lines = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = br.readLine()) != null) {
				if (!h) {
					lines.add(f.apply(line));
				} else {
					h = false;
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

}
