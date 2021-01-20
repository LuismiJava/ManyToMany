package paqueteclienteproducto;

import java.util.List;
import java.util.Scanner;

public class EntradaSalida {

	public static int pedirMenu() {
		System.out.println("1-Insertar comprador");
        System.out.println("2-Insertar productos");
        System.out.println("3-Comprar");
        System.out.println("4-Buscar por nombre");
        System.out.println("5-Salir");
        Scanner sc=new Scanner(System.in);
        int opcion=sc.nextInt();
        return opcion;
	}

	public static Cliente pedirDatosCliente() {
		System.out.println("Insertar el nombre del comprador");
		Scanner sc=new Scanner(System.in);
		String nombre=sc.next();
		Cliente c=new Cliente(nombre);
		return c;
	}

	public static Producto pedirDatosProducto() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduzca el nombre del producto:");
		String nombre=sc.next();
		System.out.println("Introduzca el precio del producto: ");
		float precio=sc.nextFloat();
		Producto p=new Producto(nombre, precio);
		return p;
	}

	public static int seleccionarCliente(List<Cliente> lista_clientes) {
		for (Cliente cliente : lista_clientes) {
			System.out.println(cliente.getId()+". "+cliente.getNombre());
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("Cual es el id de su cliente: ");
		int id=sc.nextInt();
		return id;
	}

	public static String seleccionarProductos(List<Producto> lista_productos) {
		for (Producto producto : lista_productos) {
			System.out.println(producto.getId()+". "+producto.getNombre()+"( "+producto.getPrecio()+" €)");
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("Cuales son los id de los productos que quiere seleccionar (introduzcalo separado por coma): ");
		String productos=sc.next();
		return productos;
	}

	public static String pedirNombreCliente() {
		System.out.println("Buscar por nombre del cliente: ");
		Scanner sc=new Scanner(System.in);
		String nombre=sc.next();
		return nombre;
	}

	public static void extraerDatosCliente(List<Cliente> lista_cliente) {
		for (Cliente cliente : lista_cliente) {
			System.out.println("id: "+cliente.getId()+", nombre: "+cliente.getNombre()+" y productos: "+cliente.getProducto());
		}
	}

}
