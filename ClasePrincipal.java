package paqueteclienteproducto;

import java.util.List;

public class ClasePrincipal {
	public static void main(String[] args) {
		AccesoBD.conectar();
		int opcion=EntradaSalida.pedirMenu();
		while(opcion!=5) {
			switch (opcion) {
			case 1:
				//Insertar cliente
				Cliente c=EntradaSalida.pedirDatosCliente();
				AccesoBD.grabarCliente(c);
				break;
			case 2:
				//Insertar producto
				Producto p=EntradaSalida.pedirDatosProducto();
				AccesoBD.grabarProducto(p);
				break;
			case 3:
				//Comprar
				List<Cliente> lista_clientes=AccesoBD.recuperarClientes();
				int id_cliente=EntradaSalida.seleccionarCliente(lista_clientes);
				List<Producto> lista_productos=AccesoBD.recuperarProductor();
				String id_productos=EntradaSalida.seleccionarProductos(lista_productos);
				AccesoBD.compraClienteProductos(id_cliente,id_productos);
				break;
			case 4:
				//Buscar cliente por nombre
				String nombre=EntradaSalida.pedirNombreCliente();
				List<Cliente> lista_cliente=AccesoBD.listarClientes(nombre);
				EntradaSalida.extraerDatosCliente(lista_cliente);
				break;
			}
			opcion=EntradaSalida.pedirMenu();
		}
	}
}
