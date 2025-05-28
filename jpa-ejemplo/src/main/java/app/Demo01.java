package app;
import javax.persistence.*;
import model.Usuario;

public class Demo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysqlconexion");
		
		EntityManager manager = fabrica.createEntityManager();
		
		//instanciamos un nuevo usuario
		Usuario usuario = new Usuario();
		usuario.setNombres("David");
		usuario.setApellidos("Malasquez");
		usuario.setUsuario("Kol");
		usuario.setPassword("12345");
//		usuario.setIdTipo(2);
//		usuario.setEstado(true);
		
		//procesamos
		
		try {
			manager.getTransaction().begin();
			manager.persist(usuario);
			manager.getTransaction().commit();
			System.out.println("Registro existo el usuario");
			
			
			
		} catch (Exception e) {
		System.out.println("Hubo un error en la transacción");
		System.out.println("Error : " + e.getMessage());
		
		}finally {
			fabrica.close();
			manager.close();
		}
	}
	
}
