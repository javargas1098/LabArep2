package edu.escuelaing.arem;

/**
 * Hello world!
 *
 */
import static spark.Spark.*;

public class SparkWebApp {

	public static void main(String[] args) {
		port(getPort());

		get("/index", (req, res) -> "<!DOCTYPE html>\n" + "<html>\n" + "<body>\n" + "\n"
				+ "<h2>Calculadora de medias y desviaciones estandar</h2>\n" + "\n" + "<form action=\"/resp\">\n"
				+ "  Lista de números<br>\n" + "  <input type=\"text\" name=\"numeros\" value=\"\">\n" + "  <br><br>\n"
				+ "  <input type=\"submit\" value=\"Submit\">\n" + "</form> \n" + "\n" + "\n" + "</body>\n"
				+ "</html>");
		get("/resp",
				(req, res) -> "<!DOCTYPE html>\n" + "<html>\n" + "<body>\n" + "\n" + "<h2>Respuesta</h2>\n" + "\n"
						+ "<form action=\"/index\">\n" + "  Media:<br>\n" + media(req.queryParams("numeros"))
						+ "  <br>\n" + "  <br> Desviacion: <br>\n" + desviacion(req.queryParams("numeros"))
						+ "  <br><br>\n" + "  <input type=\"submit\" value=\"Volver\">\n" + "</form> \n" + "\n" + "\n"
						+ "</body>\n" + "</html>" + "\n");
	}

	/**
	 * Este metodo Calcula la desviacion estandar a un conjunto de datos
	 * 
	 * @param LinkedList<float> Son los datos con los que podra calculará la
	 *        desviación estandar
	 * 
	 * @return float Desviación estandar
	 * 
	 */

	private static Double desviacion(String datos) {
		// TODO Auto-generated method stub
		double resultado;
		String[] dato = datos.split(" ");
		int size = dato.length;
		linkedList variablesLinkedList = new linkedList();

		for (int i = 0; i < size; i++) {
			variablesLinkedList.insert(Double.parseDouble(dato[i]));
		}

		double media = media(datos);
		resultado = variablesLinkedList.sum(variablesLinkedList, media);
		return Math.sqrt(resultado / (size - 1));
	}

	/**
	 * Este metodo Calcula la media a un conjunto de datos
	 * 
	 * @param LinkedList<Float> Son los datos con los que se podra calcular la media
	 * 
	 * @return float Media
	 * 
	 */

	private static double media(String datos) {
		// TODO Auto-generated method stub
		Double resultado;
		String[] dato = datos.split(" ");
		int size = dato.length;
		linkedList variablesLinkedList = new linkedList();

		for (int i = 0; i < size; i++) {
			variablesLinkedList.insert(Double.parseDouble(dato[i]));
		}

		resultado = variablesLinkedList.sum(variablesLinkedList);
		return resultado / size;

	}

	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; // returns default port if heroku-port isn't set (i.e. on localhost)
	}
}
