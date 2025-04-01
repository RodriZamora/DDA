/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author ASUS
 */
public class Fachada {

    private static Fachada instancia = new Fachada();

    private ControlClientes controlClientes = ControlClientes.getInstancia();

    private ControlStock controlStock = ControlStock.getInstancia();

    private ControlFacturas controlFacturas = ControlFacturas.getInstancia();

    public static Fachada getInstancia() {
        return instancia;
    }

    private Fachada() {

    }

    public Producto getProductoMenorPrecio() {
        return controlStock.getProductoMenorPrecio();
    }

    public ArrayList<Proveedor> getProveedores() {
        return controlStock.getProveedores();
    }

    public boolean agregar(Proveedor unProveedor) {
        return controlStock.agregar(unProveedor);
    }

    public boolean agregar(Cliente unCliente) {
        return controlClientes.agregar(unCliente);
    }

    public Collection<Cliente> getClientes() {
        return controlClientes.getClientes();
    }

    public Proveedor getProveedor(int posicionProveedor) {
        return controlStock.getProveedor(posicionProveedor);
    }

    public boolean agregar(Producto unProducto) {
        return controlStock.agregar(unProducto);
    }

    public ArrayList<Producto> getProductos() {
        return controlStock.getProductos();
    }
}
