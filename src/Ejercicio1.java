import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author introduccion02
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        Biblioteca RB = new Biblioteca("RB");
        Scanner lec = null;
        Scanner lec2 = new Scanner(System.in);
        File ent = new File("Libros.txt");
        int paginas;
        String linea, objeto, nombre, director;
        String datosArticulo[];

        try {
            lec = new Scanner(ent);
        } catch (FileNotFoundException fnfe) {
            System.err.println("ERROR" + fnfe);
            System.exit(-1);
        }
        linea = "";
        while (lec.hasNextLine()) {
            linea = lec.nextLine();
            datosArticulo = linea.split("\\+");
            if (datosArticulo.length == 4) {
                objeto = datosArticulo[0];
                nombre = datosArticulo[1];
                paginas = Integer.parseInt(datosArticulo[2]);
                director = datosArticulo[3];
                RB.add(objeto, nombre, paginas, director);
            }
        }
        System.out.println(RB.toString());
       // RB.ordenaEspecial();
        System.out.println("¿Quiéres agregar un nuevo objeto?");
        linea = lec2.nextLine();
        while (linea.equals("si") || linea.equals("SI") || linea.equals("Si") || linea.equals("sI")) {
            System.out.println("¿Qué objeto es?");
            objeto = lec2.nextLine();
            System.out.println("¿Cuál es su nombre?");
            nombre = lec2.nextLine();
            System.out.println("¿Quién es el director?");
            director = lec2.nextLine();
            System.out.println("¿Cuántas paginas tiene?");
            paginas = lec2.nextInt();
            RB.add(objeto, nombre, paginas, director);
            Ejercicio1.guardaDatos(objeto, nombre, paginas, director);

            System.out.println("¿Quiéres agregar un nuevo objeto?");
            linea = lec2.nextLine();
        }
        System.out.println(RB.toString());
    }

    public static void guardaDatos(String objeto, String nombre, int pag, String director) {

        try {
            File ent = new File("Libros.txt");
            FileWriter TextOut = new FileWriter(ent, true);
            TextOut.write("\n" + objeto + "+" + nombre + "+" + pag + "+" + director);
            TextOut.close();
        } catch (IOException e) {
        }
        ;
    }
}
