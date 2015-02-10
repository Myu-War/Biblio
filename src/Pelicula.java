

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author introduccion02
 */
public class Pelicula extends ArticuloBiblioteca {

    private String director;

    public Pelicula(String nombre, String director) {
        super(nombre);
        this.director = director;
        this.objeto = "Pelicula";
    }

    public String copiado() {
        return "No se puede copiar";
    }

    @Override
    public String toString() {
        StringBuilder cad = new StringBuilder();

        cad.append(super.toString());
        cad.append("\nDirector: " + director);

        return cad.toString();
    }
}
