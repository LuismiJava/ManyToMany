package paqueteclienteproducto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class AccesoBD {
	
	static StandardServiceRegistry s=null;
	static SessionFactory sf=null;
	
	public static void conectar() {
		s=new StandardServiceRegistryBuilder().configure().build();
		sf=new MetadataSources(s).buildMetadata().buildSessionFactory();
	}
	
	public static void grabarCliente(Cliente c) {
		Session sesion=sf.openSession();
		 Transaction t=sesion.beginTransaction();
		 sesion.save(c);
		 t.commit();
	}
	
	public static void grabarProducto(Producto p) {
		Session sesion=sf.openSession();
		 Transaction t=sesion.beginTransaction();
		 sesion.save(p);
		 t.commit();
	}
	
	public static List<Cliente> recuperarClientes() {
		Session s=sf.openSession();
    	Query q=s.createQuery("FROM Cliente");
    	List<Cliente> lista_clientes=q.getResultList();
		return lista_clientes;
	}

	public static List<Producto> recuperarProductor() {
		Session s=sf.openSession();
    	Query q=s.createQuery("FROM Producto");
    	List<Producto> lista_productos=q.getResultList();
		return lista_productos;
	}

	public static void compraClienteProductos(int id_cliente, String id_productos) {
		Session s=sf.openSession();
		Cliente c=obtenerIdCliente(id_cliente);
        String query = "FROM Producto WHERE id in (:ids)";
        String []ids=id_productos.split(",");
        List<Integer> lista_ids=new ArrayList();
        for (String id: ids)
        {
            lista_ids.add(Integer.valueOf(id));
        }
        Query q = s.createQuery(query);
        q.setParameter("ids", lista_ids);
        List<Producto> productos=q.getResultList();
        //p.setLista_productos(productos);
        c.setProducto(productos);
        Transaction t=s.beginTransaction();
        s.update(c);
        t.commit();
	}

	private static Cliente obtenerIdCliente(int id_cliente) {
		Session s=sf.openSession();
		Query q=s.createQuery("FROM Cliente WHERE id="+id_cliente);
		return (Cliente)q.getSingleResult();
	}

	public static List<Cliente> listarClientes(String nombre) {
		Session s=sf.openSession();
		Query q=s.createQuery("FROM Cliente WHERE nombre LIKE '%"+nombre+"%'");
		List<Cliente> lista_cliente=q.getResultList();
		return lista_cliente;
	}

	
}
