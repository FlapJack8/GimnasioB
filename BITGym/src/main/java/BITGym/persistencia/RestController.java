package BITGym.persistencia;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Base64;

import BITGym.modelo.Factura;


public class RestController {

	private static RestController instancia;
	private static Vector<Factura> vFacturas;

	private RestController() {

	}

	// Singleton
	public static RestController getInstance() {
		if (instancia == null)
			instancia = new RestController();
		return instancia;
	}

	public void postFacturarTarjeta(String nombre, String apellido, int dni, String comercio, long cuit, long tarjeta,
			Date vencimiento, int cvc, Float monto, int cuotas) {

		try {
			URL url = new URL("https://african-express.us-e2.cloudhub.io/api/core/transacciones");
			URLConnection con = url.openConnection();
			HttpURLConnection http = (HttpURLConnection) con;
			http.setRequestMethod("POST");
			http.setDoOutput(true);

			/*
			 * EJEMPLO
			 * 
			 * { "nombre":"cliente", "apellido":"Nuevo", "dni":5647687,
			 * "comercio":"nombreComercio", "cuit":125292058, "tarjeta":3652235632381571,
			 * "vencimiento":"2021-07-18", "cvc":176, "monto":35245.90, "cuotas":0 }
			 */

			Map<String, String> arguments = new HashMap<>();
			arguments.put("nombre", nombre);
			arguments.put("apellido", apellido);
			arguments.put("dni", Integer.toString(dni));
			arguments.put("comercio", comercio);
			arguments.put("cuit", Long.toString(cuit));
			arguments.put("tarjeta", Long.toString(tarjeta));
			arguments.put("vencimiento", vencimiento.toString());
			arguments.put("cvc", Integer.toString(cvc));
			arguments.put("monto", Float.toString(monto));
			arguments.put("cuotas", Integer.toString(cuotas));

			StringJoiner sj = new StringJoiner("&");
			for (Map.Entry<String, String> entry : arguments.entrySet())
				sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
			byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
			System.out.println(sj);
			int length = out.length;

			http.setFixedLengthStreamingMode(length);
			http.setRequestProperty("Content-Type", "application/JSON; charset=UTF-8");
			http.connect();
			try (OutputStream os = http.getOutputStream()) {
				os.write(out);
			} catch (Exception e) {
				System.out.println("rompio post facturar write (out)");
				System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
			}
			// Do something with http.getInputStream()
		} catch (Exception e) {
			System.out.println("rompio post tarjeta A");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
	}

	public void postLiquidarSueldoBanco(String cuentaEmpleado, String cuentaGym, String detalle, Float total,
			String nombreEmpleado, String nombreGym) {
		
		String usrPassApi = Base64.getEncoder().encodeToString(("20301234563:triana").getBytes());

		try {
			URL url = new URL("https://integracion-app-backend.herokuapp.com/usuarios/transferencias");
			URLConnection con = url.openConnection();
			HttpURLConnection http = (HttpURLConnection) con;
			http.setRequestMethod("POST");
			http.setDoOutput(true);

			/*
			 * EJEMPLO
			 * 
			 * { 
			 * "cuentaDestino": "02345671", 
			 * "cuentaOrigen": "30025253", 
			 * "detalle": "prueba gym b postman", 
			 * "montoTransaccion": 500, 
			 * "usuarioDestino": "Antonio Ruiz", 
			 * "usuarioOrigen": "BIT Gym"
			 * }
			 * 
			 */

			Map<String, String> arguments = new HashMap<>();
			arguments.put("cuentaDestino", cuentaEmpleado);
			arguments.put("cuentaOrigen", cuentaGym);
			arguments.put("detalle", detalle);
			arguments.put("montoTransaccion", Float.toString(total));
			arguments.put("usuarioDestino", nombreEmpleado);
			arguments.put("usuarioOrigen", nombreGym);

			/*
			 * Como le agregamos los headers de autenticacion?
			 * 
			 * headers:{
			 * 'Authorization': 'Basic' + usrPassApi,
			 * }
			 */
			
			StringJoiner sj = new StringJoiner("&");
			for (Map.Entry<String, String> entry : arguments.entrySet())
				sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
			byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
			System.out.println(sj);
			int length = out.length;

			http.setFixedLengthStreamingMode(length);
			http.setRequestProperty("Content-Type", "application/JSON; charset=UTF-8");
			http.connect();
			try (OutputStream os = http.getOutputStream()) {
				os.write(out);
			} catch (Exception e) {
				System.out.println("rompio post liquidar write (out)");
				System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
			}
			// Do something with http.getInputStream()
		} catch (Exception e) {
			System.out.println("rompio post banco A");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
	}

	public void testPostLiquidarSueldoBanco(String cuentaEmpleado, String cuentaGym, String detalle, Float total,
			String nombreEmpleado, String nombreGym) {

		String inline = "";
		try {
			URL url = new URL("https://integracion-app-backend.herokuapp.com/usuarios/transferencias");
			// Parse URL into HttpURLConnection in order to open the connection in order to
			// get the JSON data
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// Set the request to GET or POST as per the requirements
			conn.setRequestMethod("POST");
			// Use the connect method to create the connection bridge
			conn.connect();
			// Get the response status of the Rest API
			int responsecode = conn.getResponseCode();
			System.out.println("Response code is: " + responsecode);

			// Iterating condition to if response code is not 200 then throw a runtime
			// exception
			// else continue the actual process of getting the JSON data
			if (responsecode != 200)
				throw new RuntimeException("HttpResponseCode: " + responsecode);
			else {
				// Scanner functionality will read the JSON data from the stream
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				System.out.println("\nJSON Response in String format");
				System.out.println(inline);
				// Close the stream when reading the data has been finished
				sc.close();
			}

			// JSONParser reads the data from string object and break each data into key
			// value pairs
			JSONParser parse = new JSONParser();
			// Type caste the parsed json data in json object
			JSONObject jobj = (JSONObject) parse.parse(inline);
			// Store the JSON object in JSON array as objects (For level 1 array element i.e
			// Results)
			JSONArray jsonarr_1 = (JSONArray) jobj.get("results");
			// Get data for Results array
			for (int i = 0; i < jsonarr_1.size(); i++) {
				// Store the JSON objects in an array
				// Get the index of the JSON object and print the values as per the index
				JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);
				// Store the JSON object in JSON array as objects (For level 2 array element i.e
				// Address Components)
				JSONArray jsonarr_2 = (JSONArray) jsonobj_1.get("address_components");
				System.out.println("Elements under results array");
				System.out.println("\nPlace id: " + jsonobj_1.get("place_id"));
				System.out.println("Types: " + jsonobj_1.get("types"));
				// Get data for the Address Components array
				System.out.println("Elements under address_components array");
				System.out.println("The long names, short names and types are:");
				for (int j = 0; j < jsonarr_2.size(); j++) {
					// Same just store the JSON objects in an array
					// Get the index of the JSON objects and print the values as per the index
					JSONObject jsonobj_2 = (JSONObject) jsonarr_2.get(j);
					// Store the data as String objects
					String str_data1 = (String) jsonobj_2.get("long_name");
					System.out.println(str_data1);
					String str_data2 = (String) jsonobj_2.get("short_name");
					System.out.println(str_data2);
					System.out.println(jsonobj_2.get("types"));
					System.out.println("\n");
				}

			}
			// Disconnect the HttpURLConnection stream
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
