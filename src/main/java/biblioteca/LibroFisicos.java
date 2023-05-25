package biblioteca;

// @author Diego Ramos

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibroFisicos extends Libros {

    Scanner scTexto = new Scanner(System.in);
    Scanner scNumero = new Scanner(System.in);

    //VARIABLE:
    int numPagina;

    //ARRAYLIST
    List<LibroFisicos> librosF = new ArrayList<LibroFisicos>();

    LibroFisicos libroNuevo;

    public LibroFisicos() {

    }

    public LibroFisicos(int id, String titulo, String autor, int numPagina, boolean disponible) {
        super(id, titulo, autor, disponible);
        this.numPagina = numPagina;
    }

    public int getNumPagina() {
        return numPagina;
    }

    public void setNumPagina(int numPagina) {
        this.numPagina = numPagina;
    }

    @Override
    public void agregarLibros() {

        do {
            System.out.println("Introduce el ID del Libro: ");
            id = scNumero.nextInt();            
        } while (id <= 0);
                        
        do {
            System.out.println("Introduce el nombre del Libro: ");
            titulo = scTexto.nextLine();
           
        } while (titulo.trim().isEmpty());

        do {
            System.out.println("Introduce el nombre del autor del libro: ");
            autor = scTexto.nextLine();
        } while (autor.trim().isEmpty());

        do {
            System.out.println("Introduce el número de páginas del Libro: ");
            numPagina = scNumero.nextInt();
        } while (numPagina <= 0);
        
        disponible = true;
            
        libroNuevo = new LibroFisicos(id, titulo, autor, numPagina, disponible);
        librosF.add(libroNuevo);
 
    }

    public void listarLibros() {
        System.out.println("Libros en Papel:");
        if (librosF.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            int i = 1;
            for (LibroFisicos libro : librosF) {
                if (libro.disponible != false) {
                    System.out.println(i + ".- " + " / id: " + libro.getId() + " / Autor: " + libro.getAutor() + " / Nombre de Libro: " + libro.getTitulo()
                            + " / Número de Página: " + libro.getNumPagina());
                    i++;
                }
            }
        }
    }

    public void prestarLibros() {

        System.out.println("Introduce el ID del Libro que deseas Adquirir: ");
        int reserva = scNumero.nextInt();

        int posicion = 0;
        int tamaño = librosF.size();

        for (int i = 0; i < tamaño; i++) {
            
            //cuando vamos a comparar int en vez de string se usa el == en vez del equals (Libro digital en equals)s
            if (librosF.get(i).getId()==(reserva)) {
                posicion = i;
                librosF.get(i).setDisponible(false);

                System.out.println("El libro esta reservado.");
                break;
            } else if (librosF.size() <= 0) {
                System.out.println("No hay libros disponibles.");
            }
        }
    }

    public void listarReservados() {

        System.out.println("Libros en Papel Reservados:");
        if (librosF.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            int i = 1;
            for (LibroFisicos libro : librosF) {
                if (libro.disponible != true) {
                    System.out.println(i + ".- " + " / id: " + libro.getId() + " / Autor: " + libro.getAutor() + " / Nombre de Libro: " + libro.getTitulo()
                            + " / Número de Página: " + libro.getNumPagina());
                    i++;
                }
            }
        }
    }

    public void devolverLibros() {

        System.out.println("Introduce el Titulo del Libro que deseas Devolver: ");
        String devolucion = scTexto.next();

        int posicion = 0;
        int tamaño = librosF.size();

        for (int i = 0; i < tamaño; i++) {

            if (librosF.get(i).getTitulo().equals(devolucion)) {
                posicion = i;
                librosF.get(i).setDisponible(true);
                System.out.println("Se ha realizado la devolución correctamente.");
                System.out.println("");
                break;
            } else if (librosF.size() <= 0) {
                System.out.println("No hay libros disponibles.");
            }
        }
    }
}
