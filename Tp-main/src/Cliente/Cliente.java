package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		// IP del servidor (localhost en este caso)
		final String HOST = "127.0.0.1";
		// Puerto donde se va a conectar el cliente (el mismo que el servidor)
		final int PUERTO = 5000;
		 // Variables para entrada y salida de datos
		DataInputStream in; // Para leer los datos que envía el servidor
		DataOutputStream out; // Para enviar datos al servidor
		
		try {
			// Crea el socket y se conecta al servidor en la IP y puerto indicados
			Socket sc = new Socket(HOST, PUERTO);
			
			// Inicializa los streams para recibir y enviar datos
			in = new DataInputStream(sc.getInputStream()); // Lee datos del servidor
			out = new DataOutputStream(sc.getOutputStream()); // Envía datos al servidor
			
			// Envía un mensaje al servidor
			out.writeUTF("!Hola soy el el cliente");
			
			// Lee el mensaje que envía el servidor
			String mensaje = in.readUTF();
			// Imprime el mensaje del servidor en la consola
			System.out.println(mensaje);
			
			// Cierra la conexión con el servidor
			sc.close();
			
			
		} catch (IOException e) {
			// Si ocurre algún error, se imprime la excepción en la consola
			e.printStackTrace();
		}
	}

}
