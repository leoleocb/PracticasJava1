package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {

	public static void main(String[] args) {
		// Instanciamos conexión
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysqlconexion");

		// Implementamos manejador de entidades
		EntityManager manager = fabrica.createEntityManager();
		
		//Inicializamos el código a obtener
		int codigo = 6;
		
		// Procesamos
		try {
			
			Usuario usuario = manager.find(Usuario.class, codigo);
			
			StringBuilder sb = new StringBuilder();
			
			sb.append("Nombres...... "+ usuario.getNombres() + "\n");
			sb.append("Apellidos...... "+ usuario.getApellidos() + "\n");
			sb.append("idTipo...... "+ usuario.getIdTipo() + "\n");
			sb.append("Estado...... "+ usuario.getEstado() + "\n");
			
			
			System.out.println(sb);
			

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("No se pudo obtener al usuario");
		}finally {
			fabrica.close();
			manager.close();
		}
	}

}
