package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo06 {

	public static void main(String[] args) {
		// Instanciamos conexión
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysqlconexion");

		// Implementamos manejador de entidades
		EntityManager manager = fabrica.createEntityManager();

		try {
			
			String jpql = "select u from Usuario u";
			
			List<Usuario>lstUsuario = manager.createQuery(jpql, Usuario.class).getResultList();
			
			for (Usuario usuario : lstUsuario) {
				
				StringBuilder sb = new StringBuilder();
				sb.append("codigo: "+usuario.getCodigo()+"\n");
				sb.append("nombres: "+usuario.getNombres()+" " + usuario.getApellidos() +"\n");
				sb.append("idTipo: "+usuario.getIdTipo()+"\n");
				sb.append("------------------------------------------------------------------");
				System.out.println(sb);
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("No se pudo listar los usuarios");
		} finally {
			fabrica.close();
			manager.close();
		}
	}

}
