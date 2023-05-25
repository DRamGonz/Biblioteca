package biblioteca;

// @author Diego Ramos

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibroDigitales extends Libros {

    Scanner scTexto = new Scanner(System.in);
    Scanner scNumero = new Scanner(System.in);

    //VARIABLE
    double tamano;

    //ARRAYLIST
    List<LibroDigitales> librosD = new ArrayList<LibroDigitales>();

    LibroDigitales libroNuevo;
    Libros datos;

    public LibroDigitales() {
    }

    public LibroDigitales(int id, String titulo, String autor, double tamano, boolean disponible) {
        super(id, titulo, autor, disponible);
        this.tamano = tamano;
    }

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public List<LibroDigitales> getLibrosD() {
        return librosD;
    }

    public void setLibrosD(List<LibroDigitales> librosD) {
        this.librosD = librosD;
    }

    @Override
    public String toString() {
        return "LibroDigitales: " + ", tamano=" + tamano + ", librosD=" + librosD + ", libroNuevo=" + libroNuevo + '}';
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
            System.out.println("Introduce el tamaño en mega del Libro: ");
            tamano = scNumero.nextInt();
        } while (tamano <= 0);
        
        disponible = true;
                  
        libroNuevo = new LibroDigitales(id, titulo, autor, tamano, disponible);
        librosD.add(libroNuevo);
    }

    public void listarLibros() {

        System.out.println("Libros Digitales:");
        if (librosD.isEmpty()) {
            System.out.println("No hay Libros disponibles.");
        } else {
            int i = 1;

            for (LibroDigitales libro : librosD) {
                if (libro.disponible != false) {
                    System.out.println(i + ".- " + " / id: " + libro.getId() + " / Autor: " + libro.getAutor() + " / Nombre de Libro: " + libro.getTitulo()
                            + " / Tamaño: " + libro.getTamano() + " Mb.");
                    i++;
                }
            }
        }
    }

    public void prestarLibros() {

        System.out.println("Introduce el Titulo del Libro que deseas Adquirir: ");
        String reserva = scTexto.next();

        int posicion = 0;
        int tamaño = librosD.size();

        for (int i = 0; i < tamaño; i++) {

            if (librosD.get(i).getTitulo().equals(reserva)) {
                posicion = i;
                librosD.get(i).setDisponible(false);
                System.out.println("El libro esta reservado.");
                System.out.println("");
                break;
            } else if (librosD.size() <= 0) {
                System.out.println("No hay libros disponibles.");
            }
        }

    }

    public void listarReservados() {

        System.out.println("Libros Digitales Reservados:");
        if (librosD.isEmpty()) {
            System.out.println("No hay Libros disponibles.");
        } else {
            int i = 1;

            for (LibroDigitales libro : librosD) {
                if (libro.disponible != true) {
                    System.out.println(i + ".- " + " / id: " + libro.getId() + " / Autor: " + libro.getAutor() + " / Nombre de Libro: " + libro.getTitulo()
                            + " / Tamaño: " + libro.getTamano() + " Mb.");
                    i++;
                }
            }
        }
    }

    public void devolverLibros() {

        System.out.println("Introduce el Titulo del Libro que deseas Devolver: ");
        String devolucion = scTexto.next();

        int posicion = 0;
        int tamaño = librosD.size();

        for (int i = 0; i < tamaño; i++) {

            if (librosD.get(i).getTitulo().equals(devolucion)) {
                posicion = i;
                librosD.get(i).setDisponible(true);
                System.out.println("Se ha realizado la devolución correctamente.");
                System.out.println("");
                break;
            } else if (librosD.size() <= 0) {
                System.out.println("No hay libros disponibles.");
            }
        }
    }
}
