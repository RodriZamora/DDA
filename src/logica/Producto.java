/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author magda
 */
public class Producto {

    private String nombre;
    private int precio;
    private int unidades;
    private Proveedor proveedor;
    private int codigo;

    public Producto() {
    }

    public Producto(String nombre, int precio, int stock, Proveedor proveedor) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = stock;
        this.proveedor = proveedor;

        proveedor.agregar(this);
    }

    public int getUnidades() {
        return unidades;
    }

    public boolean setUnidades(int unidades) {
        this.unidades = unidades;
        return true;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean setNombre(String nombre) {
        this.nombre = nombre;
        return true;
    }

    @Override
    public String toString() {
        return "Producto{codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", unidades=" + unidades + ", proveedor=" + proveedor + ", codigo=" + codigo + '}';
    }

    public void setCodigo(int cod) {
        codigo = cod;
    }

    public int getCodigo() {
        return codigo;
    }
}
