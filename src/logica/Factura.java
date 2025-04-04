/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author magda
 */
public class Factura {

    private Cliente cliente;
    private ArrayList<LineaFactura> lineas = new ArrayList();
    private Date fecha;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;

    }

    public ArrayList<LineaFactura> getLineas() {
        return lineas;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public Boolean agregar(int cantidad, Producto p) {

        Boolean productoOk = p.tieneStock(cantidad);

        if (tieneProducto(p)) {
            for (LineaFactura l : lineas) {
                if (l.tieneProducto(p)) {
                    productoOk = p.tieneStock(cantidad + l.getCantidad());
                    if (productoOk) {
                        l.setCantidad(cantidad + l.getCantidad());
                    }
                    break;
                }
            }
        } else {
            productoOk = lineas.add(new LineaFactura(p, cantidad));
        }
        return productoOk;
    }

    public boolean tieneProducto(Producto unP) {
        boolean ret = false;
        for (LineaFactura l : lineas) {
            if (l.tieneProducto(unP)) {
                ret = true;
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Factura{cliente=");
        sb.append(cliente);

        for (LineaFactura lineaFc : lineas) {
            sb.append(System.getProperty("line.separator"));
            sb.append(lineaFc.toString());
        }

        sb.append(System.getProperty("line.separator"));
        sb.append("Total=");
        sb.append(getTotal());
        sb.append("}");

        return sb.toString();
    }

    public float getTotal() {
        float total = 0;
        for (LineaFactura lf : lineas) {
            total = total + lf.getTotal();
        }
        return total;
    }

    public LineaFactura getLinea(Producto p) {
        for (LineaFactura lf : lineas) {
            if (lf.equals(lf)) {
                return lf;
            }
        }
        return null;
    }

}
