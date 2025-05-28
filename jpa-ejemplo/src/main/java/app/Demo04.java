package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;


public class Demo04 {

	public static void main(String[] args) {
		// Instanciamos conexión
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysqlconexion");

		// Implementamos manejador de entidades
		EntityManager manager = fabrica.createEntityManager();
		
		//Inicializamos el código del usuario que queremos actualizar
		 int codigo = 6;
		
		// Procesamos
		try {
			
			Usuario usuario = manager.find(Usuario.class, codigo);
			manager.getTransaction().begin();
			usuario.setFechaNac(LocalDate.parse("1992-05-17"));
			manager.getTransaction().commit();
			System.out.println("Actualizacion exitosa =)");
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("No se pudo realizar la transacción");
		}finally {
			fabrica.close();
			manager.close();
		}
	}

}
