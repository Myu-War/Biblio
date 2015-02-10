/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author introduccion02
 */
public class Libro extends ArticuloBiblioteca {

    public int numeroPaginas;

    public Libro(String nombre) {
        super(nombre);
        numeroPaginas = 0;
    }

    /**
     *
     * @param nombre es el nombre del libro
     * @param num es el numero de paginas
     */
    public Libro(String nombre, int num) {
        super(nombre);
        numeroPaginas = num;
        this.objeto = "Libro";
    }

    /**
     *
     * @return regresa el costo de la copia``
     */
    public String copiado() {
        return "Cuesta 50c la hoja";
    }

    public String toString() {
        StringBuilder cad = new StringBuilder();

        cad.append(super.toString());
        cad.append("\nNúmero de Paginas: " + numeroPaginas);

        return cad.toString();
    }

    public int compareTo(Libro otro) {
        int res = -1;
        if (this.nombre.compareTo(otro.nombre) > 0) {
            res = 1;
        }

        return res;
    }
}
