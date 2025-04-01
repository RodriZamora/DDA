/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;

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
    
    private Fachada (){
        
    }
    
    public Producto getProductoMenorPrecio(){
        return controlStock.getProductoMenorPrecio();
    }
    
    public ArrayList<Proveedor> getProveedores(){
        return controlStock.getProveedores();
    }

    public boolean agregar(Proveedor unProveedor) {
        return controlStock.agregar(unProveedor);
    }
}
