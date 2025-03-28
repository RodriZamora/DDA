/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author magda
 */
public class ControlFacturas {

    private static ControlFacturas instancia;

    private ArrayList<Factura> facturas = new ArrayList();

    public synchronized static ControlFacturas getInstancia() {
        if (instancia == null) {
            instancia = new ControlFacturas();
        }
        return instancia;
    }

    private ControlFacturas() {

    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void agregar(Factura unaFactura) {
        facturas.add(unaFactura);
    }

    public boolean clienteComproProducto(Cliente c, Producto p) {
        boolean ret = false;
        for (Factura f : facturas) {
            if (f.getCliente().equals(c) && f.tieneProducto(p)) {
                ret = true;
            }
        }

        return ret;
    }
}
