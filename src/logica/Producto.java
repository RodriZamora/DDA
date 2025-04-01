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
        int unidadesAnteriores = this.unidades;
        this.unidades = unidades;
        Boolean unidadesOk = validarStock();

        if (!unidadesOk) {
            this.unidades = unidadesAnteriores;
        }

        return unidadesOk;
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

    public Boolean setPrecio(int precio) {
        int precioAnterior = this.precio;
        this.precio = precio;
        Boolean precioOk = validarPrecio();
        if (!precioOk) {
            this.precio = precioAnterior;
        }
        return precioOk;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean setNombre(String nombre) {
        String nombreAnterior = this.nombre;
        this.nombre = nombre;
        Boolean esNombreValido = validarNombre();

        if (!esNombreValido) {
            this.nombre = nombreAnterior;
            //return false;
        }
        return esNombreValido;
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

    public boolean validar() {
        return validarNombre() && validarStock() && validarPrecio();
    }

    private boolean validarNombre() {
        return this.nombre != null && !this.nombre.isBlank();
    }

    private boolean validarStock() {
        return this.unidades > 0;
    }

    private boolean validarPrecio() {
        return this.precio >= 0;
    }

}
