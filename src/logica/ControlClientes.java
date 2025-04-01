package logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

class ControlClientes {

    private static ControlClientes instancia;

    private final HashMap<String, Cliente> clientes = new HashMap();

    public synchronized static ControlClientes getInstancia() {
        if (instancia == null) {
            instancia = new ControlClientes();
        }
        return instancia;
    }

    private ControlClientes() {

    }

    public Collection<Cliente> getClientes() {
        return clientes.values();
    }

    public ArrayList clientesNoCompraronProductoMenorPrecio() {
        Producto menor = ControlStock.getInstancia().getProductoMenorPrecio();
        ArrayList<Cliente> retorno = new ArrayList<>();

        for (Cliente c : getClientes()) {
            if (!ControlFacturas.getInstancia().clienteComproProducto(c, menor)) {
                retorno.add(c);
            }
        }
        return retorno;

    }

    public boolean existeCliente(String unaCedula) {
        return clientes.containsKey(unaCedula);
    }

    public boolean agregar(Cliente c) {
        boolean ok = false;
        if (c.validar() && !this.existeCliente(c.getCedula())) {
            clientes.put(c.getCedula(), c);
            ok = true;
        }

        return ok;
    }

}
