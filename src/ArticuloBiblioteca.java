
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author introduccion02
 */
public class ArticuloBiblioteca implements Comparable<ArticuloBiblioteca> {

    protected String nombre;
    protected int id;
    protected String objeto = "Articulo de Biblioteca.";
    public boolean prestado = false;

    public ArticuloBiblioteca(String nombre) {
        this.nombre = nombre;
    }

    protected boolean setid(int id) {
        this.id = id;
        return true;
    }

    public int getID() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getObjeto() {
        return objeto;
    }

    public boolean setPrestado(boolean pres) {
        this.prestado = pres;
        return true;
    }

    public boolean getPRestado() {
        return prestado;
    }

    public String copiado() {
        return "Cuesta $100 la hora";
    }

    @Override
    public int compareTo(ArticuloBiblioteca otro) {
        int res = -1;
        if (this.nombre.compareTo(otro.nombre) > 0) {
            res = 1;
        }
        //this.id-otro.id
        return res;
    }

    @Override
    public String toString() {
        StringBuilder cad = new StringBuilder();

        cad.append("ID: " + id);
        cad.append("\nObjeto: " + objeto);
        cad.append("\nNombre: " + nombre);
        cad.append("\nPrestado: " + prestado);

        return cad.toString();
    }
}
