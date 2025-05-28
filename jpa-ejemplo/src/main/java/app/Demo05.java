package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {

	public static void main(String[] args) {
		// Instanciamos conexión
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysqlconexion");

		// Implementamos manejador de entidades
		EntityManager manager = fabrica.createEntityManager();
		
		//Inicializamos el código a eliminar
		int codigo = 6;
		
		// Procesamos
		try {
			Usuario usuario = manager.find(Usuario.class, codigo);
			manager.getTransaction().begin();
			manager.remove(usuario);
			manager.getTransaction().commit();
			System.out.println("Eliminacion exitosa =)");			
			
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("No se pudo realizar la transacción");
		}finally {
			fabrica.close();
			manager.close();
		}
	}

}
