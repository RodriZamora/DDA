/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author magda
 */
class ControlFacturas {

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
        //Si me lo pidieran en el CU, debiera ajustar el stock en base a la FC que se agrega.
        facturas.add(unaFactura);
        unaFactura.setFecha(new Date());
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
