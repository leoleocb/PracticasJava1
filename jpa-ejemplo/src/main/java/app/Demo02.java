package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {

	public static void main(String[] args) {
		// Instanciamos conexión
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysqlconexion");

		// Implementamos manejador de entidades
		EntityManager manager = fabrica.createEntityManager();

		// Inicializamos el código que deseamos actualizar
		int codigo = 6;

		// Instanciamos un usuario
		Usuario usuario = new Usuario();
		usuario.setCodigo(codigo);
		usuario.setNombres("David");
		usuario.setApellidos("Malasques");
		usuario.setUsuario("arbchumer");
		usuario.setPassword("4321");
		usuario.setIdTipo(2);
		usuario.setEstado(false);

		// Procesamos
		try {
			manager.getTransaction().begin();
			manager.merge(usuario);
			manager.getTransaction().commit();
			System.out.println("Actualizaciòn exitosa");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("No se pudo realizar la transacción");
		} finally {
			fabrica.close();
			manager.close();
		}
	}

}
