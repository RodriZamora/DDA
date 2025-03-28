
package logica;

public class Cliente {

    private String nombre;
    private String cedula;

    public Cliente(String cedula, String nombre) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public Cliente() {

    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String unaCedula) {

        cedula = unaCedula;

    }

    private boolean verificarCedula() {
        boolean ok = false;
        if (cedula != null) {
            //ToDo: se puede mejorar usando una expresion regular
            int digitos = cedula.length();
            String numeros = "0123456789";
            boolean soloNumeros = true;
            cedula = cedula.toLowerCase();
            for (int x = 0; x < cedula.length() && soloNumeros; x++) {
                String d = cedula.charAt(x) + "";
                if (!numeros.contains(d)) {
                    soloNumeros = false;
                }
            }

            if (soloNumeros && digitos >= 6 && digitos <= 8) {
                ok = true;
            }
        }
        return ok;

    }

    private boolean verificarNombre() {
        return this.getNombre() != null && !this.getNombre().trim().equals("");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", cedula=" + cedula + '}';
    }

    public boolean validar() {
        return verificarCedula() && verificarNombre();
    }

}
