package interfaz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import logica.Cliente;
import logica.Fachada;
import logica.Factura;
import logica.Producto;
import logica.Proveedor;
import utilidades.Consola;

public class IuConsola {

    /**
     * Ejecuta la consola
     */
    public void mostrarConsola() {
        boolean salir;
        do {

            int opcion = imprimirMenu();
            salir = procesarOpcion(opcion);

        } while (!salir);
    }

    /**
     * Imprime el menú y sus opciones a pantalla
     */
    private int imprimirMenu() {
        System.out.println("MENU");
        System.out.println("====");

        ArrayList<String> opciones = new ArrayList();
        opciones.add("Alta de Cliente");
        opciones.add("Alta de Proveedor");
        opciones.add("Alta de Producto");
        opciones.add("Salir del menú");
        return Consola.menu(opciones);
    }

    /**
     * Captura la opción seleccionada por el usuario y ejecuta la acción
     * correspondiente
     */
    private boolean procesarOpcion(int opcion) {
        boolean salir = false;

        switch (opcion) {
            case 0:
                this.nuevoCliente();
                break;
            case 1:
                this.nuevoProveedor();
                break;
            case 2:
                this.nuevoProducto();
                break;
            case 3:
                salir = true;
                break;

        }
        return salir;
    }

    private void nuevoCliente() {

        System.out.println("ALTA DE CLIENTE");
        System.out.println("===============");

        Cliente unCliente = new Cliente();
        unCliente.setCedula(Consola.leer("Cedula:"));
        unCliente.setNombre(Consola.leer("Nombre:"));
        if (Fachada.getInstancia().agregar(unCliente)) {
            mostrarClientes();
        } else {
            System.out.println("EL CLIENTE NO FUE INGRESADO");
        }

    }

    private void mostrarClientes() {
        System.out.println("=================");
        System.out.println("CLIENTES ACTUALES");
        System.out.println("=================");
        Collection<Cliente> clientes = Fachada.getInstancia().getClientes();
        for (Cliente c : clientes) {
            System.out.println(c.getCedula() + " - " + c.getNombre());
        }
    }

    private void nuevoProveedor() {
        System.out.println("ALTA DE PROVEEDOR");
        System.out.println("===============");

        String nombre = Consola.leer("Nombre: ");
        Proveedor unProveedor = new Proveedor(nombre);

        if (Fachada.getInstancia().agregar(unProveedor)) {
            mostrarProveedores();
        } else {
            System.out.println("EL PROVEEDOR NO FUE INGRESADO");
        }
    }

    private void mostrarProveedores() {
        System.out.println("=================");
        System.out.println("PROVEEDORES ACTUALES");
        System.out.println("=================");
        Collection<Proveedor> proveedores = Fachada.getInstancia().getProveedores();
        for (Proveedor p : proveedores) {
            System.out.println(p.getNombre() + " - ");
        }
    }

    private void nuevoProducto() {
        System.out.println("ALTA DE PRODUCTO");
        System.out.println("===============");

        /*String nombreProducto;
        do {
            nombreProducto = Consola.leer("Nombre: ");
        } while (nombreProducto.isBlank());*/
        Producto producto = new Producto();
        while (!producto.setNombre(Consola.leer("Nombre: "))) {
            System.out.println("Nombre invalido, intenta nuevamente.");
        }

        boolean productoOk = false;
        //Integer cantidad = Consola.leerInt("Stock: ");
        if (producto.setUnidades(Consola.leerInt("Unidades: "))) {
            Proveedor proveedor = mostrarProveedoresYObtenerProveedor();
            producto.setProveedor(proveedor);

            int precio = Consola.leerInt("Precio: ");
            if (producto.setPrecio(precio)) {
                productoOk = Fachada.getInstancia().agregar(producto);
                mostrarProductos();
            }
        } 
        
        if(!productoOk){
            Consola.println("No se pudo dar de alta el producto");
        }

        /*int posicionProveedor = Consola.menu(Fachada.getInstancia().getProveedores());
        Proveedor proveedorElegido = Fachada.getInstancia().getProveedor(posicionProveedor);
         */
        //int precio = Consola.leerInt("Precio: ");

        /*Producto unProducto = new Producto(producto.getNombre(), precio, producto.getUnidades(), proveedorElegido);

        if (Fachada.getInstancia().agregar(unProducto)) {
            mostrarProductos();
        } else {
            System.out.println("EL PRODUCTO NO FUE INGRESADO");
        }*/
    }

    private void mostrarProductos() {
        System.out.println("=================");
        System.out.println("PRODUCTOS ACTUALES");
        System.out.println("=================");
        Collection<Producto> productos = Fachada.getInstancia().getProductos();
        for (Producto p : productos) {
            System.out.println(p.getNombre() + " - " + p.getPrecio());
        }
    }

    private Proveedor mostrarProveedoresYObtenerProveedor() {
        ArrayList<Proveedor> proveedores = Fachada.getInstancia().getProveedores();
        int posicionProveedorElegido = Consola.menu(proveedores);
        return proveedores.get(posicionProveedorElegido);
    }
}
