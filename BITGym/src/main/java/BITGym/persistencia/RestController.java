package BITGym.persistencia;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class RestController {

	public static void post(String nombre, String apellido, int dni, String comercio, long cuit, long tarjeta,
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
				System.out.println("rompio post write (out)");
				System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
			}
			// Do something with http.getInputStream()
		} catch (Exception e) {
			System.out.println("rompio post tarjeta A");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
	}

}
