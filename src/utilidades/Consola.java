package utilidades;

import java.io.*;
import java.util.*;

public class Consola {

    protected static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void print(String s) {
        System.out.print(s);

    }

    public static void println(String s) {

        System.out.println(s);

    }

    public static void print(int i) {
        System.out.print(i);

    }

    public static void println(int i) {
        System.out.println(i);
    }

    public static String leer() {

        try {
            return in.readLine();
        } catch (Exception e) {
            return null;
        }

    }

    public static String leer(String s) {
        print(s);
        return leer();
    }

    public static int leerInt() {
        return leerInt(null);
    }

    public static int leerInt(String msg) {
        int num = -1;
        boolean ok = false;
        while (!ok) {
            try {
                if (msg != null) {
                    print(msg);
                }
                num = Integer.parseInt(leer());
                ok = true;
            } catch (Exception e) {
            }
        }
        return num;
    }

    public static int menu(ArrayList opciones) {

        for (int x = 0; x < opciones.size(); x++) {
            println((x + 1) + "-" + opciones.get(x).toString());
        }
        int opcion;
        do {
            opcion = leerInt("opcion:") - 1;

        } while (opcion < 0 || opcion >= opciones.size());

        return opcion;
    }

}
