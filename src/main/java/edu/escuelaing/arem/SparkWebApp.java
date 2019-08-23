package edu.escuelaing.arem;

/**
 * Hello world!
 *
 */
import static spark.Spark.*;

public class SparkWebApp {

	public static void main(String[] args) {
		port(getPort());

		get("/index", (req, res) -> "<!doctype html>\r\n" + "<html lang=\"en\">\r\n" + "  <head>\r\n"
				+ "    <!-- Required meta tags -->\r\n" + "    <meta charset=\"utf-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n"
				+ "\r\n" + "    <!-- Bootstrap CSS -->\r\n"
				+ "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n"
				+ "\r\n" + "    <title>Hello, world!</title>\r\n" + "  </head>\r\n" + "  <body>\r\n"
				+ "    <h1>Hello, world!</h1>\r\n" + "\r\n" + "    <!-- Optional JavaScript -->\r\n"
				+ "    <!-- jQuery first, then Popper.js, then Bootstrap JS -->\r\n"
				+ "    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n"
				+ "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\r\n"
				+ "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\r\n"
				+ "  </body>\r\n" + "</html>");
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
	 *                          desviación estandar
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
