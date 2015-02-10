/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;

/**
 *
 * @author introduccion02
 */
public class Biblioteca {

    private String nombre;
    private ArticuloBiblioteca[] articulos;
    private int numarticulos;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        articulos = new ArticuloBiblioteca[1];
        numarticulos = 0;
    }

    public int getNumArticulos() {
        return numarticulos;
    }

    private void expandCapacity() {
        ArticuloBiblioteca[] aux = new ArticuloBiblioteca[articulos.length + 2];
        for (int i = 0; i < articulos.length; i++) {
            aux[i] = articulos[i];

        }
        articulos = aux;
    }

    public void add(String objeto, String nombre, int pag, String director) {
        if (numarticulos >= articulos.length) {
            expandCapacity();
        }
        switch (objeto) {
            case "Libro":
                addLibro(nombre, pag);
                break;
            case "Pelicula":
                addPelicula(nombre, director);
                break;
            case "Revista":
                addRevista(nombre, pag);
                break;
            case "Periodico":
                addPeriodico(nombre, pag);
                break;
            case "Libro Virtual":
                addLibroVirtual(nombre, pag);
                break;
        }

        numarticulos++;
    }

    private void addLibroVirtual(String nombre, int pag) {
        LibroVirtual librovirtual = new LibroVirtual(nombre, pag);
        librovirtual.setid(numarticulos + 1);

        articulos[numarticulos] = librovirtual;
    }

    private void addPeriodico(String nombre, int pag) {
        Periodico periodico = new Periodico(nombre, pag);
        periodico.setid(numarticulos + 1);

        articulos[numarticulos] = periodico;
    }

    /**
     *
     * @param nombre Es el nombre del libro
     * @param pag ES el numero de paginas que tendra el libro
     */
    private void addLibro(String nombre, int pag) {
        Libro libro = new Libro(nombre, pag);
        libro.setid(numarticulos + 1);

        articulos[numarticulos] = libro;
    }

    private void addRevista(String nombre, int pag) {
        Revista Revista = new Revista(nombre, pag);
        Revista.setid(numarticulos + 1);

        articulos[numarticulos] = Revista;
    }

    private void addPelicula(String nombre, String director) {
        Pelicula pelicula = new Pelicula(nombre, director);
        pelicula.setid(numarticulos + 1);

        articulos[numarticulos] = pelicula;
    }

    public boolean prestar(int id) {
        int i = 0;
        boolean res = false;

        while (i < numarticulos && articulos[i].getID() != id) {
            i++;
        }
        if (articulos[i].getID() == id) {
            if (!articulos[i].getPRestado()) {
                articulos[i].setPrestado(true);
                res = true;
            }
        }

        return res;
    }

    public boolean regresar(int id) {
        int i = 0;
        boolean res = false;

        while (i < numarticulos && articulos[i].getID() != id) {
            i++;
        }
        if (articulos[i].getID() == id) {
            articulos[i].setPrestado(false);
            res = true;
        }

        return res;
    }

    public String inventario() {
        StringBuilder cad = new StringBuilder();

        cad.append("Inventario de la Biblioteca:" + nombre + "\n" + "\n");
        for (int i = 0; i < numarticulos; i++) {
            cad.append(articulos[i].toString() + "\n" + "\n");
        }

        return cad.toString();
    }

    public String buscaLibro(String nombre) {
        StringBuilder cad = new StringBuilder();
        String res = "No hay resultado.";

        for (int i = 0; i < numarticulos; i++) {
            if (articulos[i].getNombre().equals(nombre) && articulos[i].getObjeto().equals("Libro")) {
                cad.append(articulos[i].toString());
                res = cad.toString();
            }
        }

        return res;
    }

    public String buscaLibro(int id) {
        StringBuilder cad = new StringBuilder();
        String res = "No hay resultado.";

        for (int i = 0; i < numarticulos; i++) {
            if (articulos[i].getID() == id && articulos[i].getObjeto().equals("Libro")) {
                cad.append(articulos[i].toString());
                res = cad.toString();
            }
        }

        return res;
    }

    public String busca(String nombre) {
        StringBuilder cad = new StringBuilder();
        String res = "No hay resultado.";

        for (int i = 0; i < numarticulos; i++) {
            if (articulos[i].getNombre().equals(nombre)) {
                cad.append(articulos[i].toString());
                res = cad.toString();
            }
        }

        return res;
    }

    public String busca(int id) {
        StringBuilder cad = new StringBuilder();
        String res = "No hay resultado.";

        for (int i = 0; i < numarticulos; i++) {
            if (articulos[i].getID() == id) {
                cad.append(articulos[i].toString());
                res = cad.toString();
            }
        }

        return res;
    }

    public void ordena() {
        Ordenamiento ord = new Ordenamiento();

        ord.selectionSort(articulos, numarticulos);
    }

    public String librosPrestados() {
        StringBuilder cad = new StringBuilder();
        String res = "\nNo hay libros prestados.";

        for (int i = 0; i < numarticulos; i++) {
            if (articulos[i].prestado && articulos[i].getObjeto().equals("Libro")) {
                cad.append(articulos[i].toString());
                res = "\n" + cad.toString();
            }
        }

        return res;
    }

    public String toString() {
        StringBuilder cad = new StringBuilder();

        cad.append("\nNombre: " + nombre);
        cad.append("\nNúmero de Articulos: " + numarticulos + "\n" + "\n");
        for (int i = 0; i < numarticulos; i++) {
            cad.append(articulos[i].toString() + "\n" + "\n");
        }

        return cad.toString();
    }

   public void ordenaEspecial() {
    Ordenamiento ord = new Ordenamiento();
    int peliculas = 0, contador = 0, libros = 0;

    for (int i= contador; i < numarticulos; i++) {
        if (articulos[i].getObjeto().equals("Pelicula")) {
            ord.swap(articulos, i, peliculas);
            peliculas++;

        }
       
    }
    for (int i = peliculas; i < numarticulos; i++) {
        if (articulos[i].getObjeto().equals("Libro")) {
            ord.swap(articulos, i, peliculas + libros);
            libros++;

        }
        
    }
    for (int x = peliculas; x < peliculas + libros - 1; x++) {
        for (int j = peliculas; j < peliculas + libros - 1; j++) {
            if (articulos[j].compareTo(articulos[j + 1]) > 0) {
                ord.swap(articulos, j, j + 1);
            }
        }
    }
    for (int x = peliculas + libros; x < numarticulos - 1; x++) {
        for (int j = peliculas + libros; j < numarticulos - 1; j++) {
            if (articulos[j].getID() - articulos[j + 1].getID() > 0) {
                ord.swap(articulos, j, j + 1);
            }
        }
    }

}
}
