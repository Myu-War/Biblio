/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author introduccion02
 */
public class Revista extends ArticuloBiblioteca {

    public int numeroPaginas;

    public Revista(String nombre) {
        super(nombre);
        numeroPaginas = 0;
    }

    /**
     *
     * @param nombre es el nombre del libro
     * @param num es el numero de paginas
     */

    public Revista(String nombre, int num) {
        super(nombre);
        numeroPaginas = num;
        this.objeto = "Revista";
    }

    /**
     *
     * @return regresa el costo de la copia``
     */
    public String copiado() {
        return "Cuesta 50c la hoja";
    }

    @Override
    public String toString() {
        StringBuilder cad = new StringBuilder();

        cad.append(super.toString());
        cad.append("\nNúmero de Paginas: " + numeroPaginas);

        return cad.toString();
    }
}
