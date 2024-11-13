package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		ServerSocket servidor = null; // Socket del servidor para escuchar conexiones
		Socket sc = null; // Socket para interactuar con el cliente
		DataInputStream in; // Para leer los datos que envía el cliente
		DataOutputStream out; // Para enviar datos al cliente
		
		// Puerto donde el servidor escucha conexiones
		final int PUERTO = 5000; 
		
		try {
			// Crea el servidor en el puerto especificado
			servidor = new ServerSocket(PUERTO);
			
			// Imprime que el servidor está listo para aceptar clientes
			System.out.println("Servidor iniciado");
			
			// Bucle infinito para que el servidor acepte múltiples conexiones de clientes
			while (true) {
				// Espera a que un cliente se conecte y lo acepta
				sc = servidor.accept();
				System.out.println("Cliente conectado");
				
				// Inicializa los streams para recibir y enviar datos al cliente
				in = new DataInputStream(sc.getInputStream()); // Recibe datos
				out = new DataOutputStream(sc.getOutputStream()); // Envía datos 
				
				// Lee el mensaje enviado por el cliente
				String mensaje = in.readUTF();
				// Imprime el mensaje del cliente en la consola del servidor
				System.out.println(mensaje);
				
				// Responde al cliente mandandole un mensaje
				out.writeUTF("!Hola desde el servidor");
				
				sc.close();
				System.out.println("Cliente desconectado");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
