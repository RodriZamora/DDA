package logica;

import java.util.ArrayList;

public class ControlStock {

    private static ControlStock instancia;
    private int proxIdProd = 1;

    private ArrayList<Producto> productos = new ArrayList();
    private ArrayList<Proveedor> proveedores = new ArrayList();

    public synchronized static ControlStock getInstancia() {
        if (instancia == null) {
            instancia = new ControlStock();
        }
        return instancia;
    }

    private ControlStock() {
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public Producto getProductoMenorPrecio() {
        Producto menor = productos.get(0);
        Producto p;
        for (int x = 1; x < productos.size(); x++) {
            p = productos.get(x);
            if (p.getPrecio() < menor.getPrecio()) {
                menor = p;
            }
        }

        return menor;

    }

    public boolean agregar(Proveedor unProveedor) {
        boolean agregadoOk = false;
        if (unProveedor.validar() && !existeProveedor(unProveedor)) {
            agregadoOk = proveedores.add(unProveedor);
        }
        return agregadoOk;
    }

    public boolean agregar(Producto unProducto) {
        boolean agregadoOk = false;
        if (unProducto.validar()) {
            unProducto.setCodigo(proxIdProd);
            proxIdProd++;
            productos.add(unProducto);
            unProducto.getProveedor().agregar(unProducto);
            agregadoOk = true;
        }
        return agregadoOk;
    }

    public Producto getProducto(int codigoProducto) {
        Producto producto = null;
        for (Producto p : productos) {
            if (p.getCodigo() == codigoProducto) {
                producto = p;
                break;
            }
        }
        return producto;
    }

    public boolean existeProveedor(Proveedor unProveedor) {
        Boolean existe = proveedores.contains(unProveedor);
        return existe;
    }

    public Proveedor getProveedor(int proveedorPos) {
        return proveedores.get(proveedorPos);
    }

}
