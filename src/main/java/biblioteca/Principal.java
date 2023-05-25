package biblioteca;

// @author Diego Ramos

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    Scanner scTexto = new Scanner(System.in);
    Scanner scNumero = new Scanner(System.in);

    public static void main(String[] args) {

        Scanner scTexto = new Scanner(System.in);
        Scanner scNumero = new Scanner(System.in);

        //DECLARAMOS LAS VARIABLES QUE NECESITAMOS PARA EL MENÚ.
        boolean salir = true;
        int opciones;

        //INICIALIZO LAS CLASES
        LibroDigitales lDigital = new LibroDigitales();
        LibroFisicos lFisico = new LibroFisicos();

        //IMPORTAMOS LAS CLASES QUE VAMOS A UTILIZAR ejemlo Nombreclase nombre = new Nombreclase ();
        try {
            while (salir) {

                //OPCIONES DEL MENÚ
                System.out.println("Bienvenido a la Biblioteca municipal.");
                System.out.println("");
                System.out.println("[1].- Registrar un nuevo libro físico.");
                System.out.println("[2].- Registrar un nuevo libro Digital.");
                System.out.println("[3].- Prestar un libro.");
                System.out.println("[4].- Devolver un libro.");
                System.out.println("[5].- Mostrar todos los libros disponibles.");
                System.out.println("[6].- Mostrar Libros reservados.");
                System.out.println("[7].- Salir.");
                System.out.println("");
                System.out.print("Introduce el número de la opción deseada (del 1 al 7):  ");
                System.out.println("");
                opciones = scNumero.nextInt();
                System.out.println("");

                switch (opciones) {

                    case 1:
                        lFisico.agregarLibros();
                        precionarTecla();
                        break;
                    case 2:
                        lDigital.agregarLibros();
                        precionarTecla();
                        break;
                    case 3:
                        System.out.println("Si desea reservar un libro fisico introduzca un 1 si es digital introduzca el 2.");
                        int tipo = scNumero.nextInt();
                        if (tipo == 1) {
                            lFisico.listarLibros();
                            lFisico.prestarLibros();
                        } else if (tipo == 2) {
                            lDigital.listarLibros();
                            lDigital.prestarLibros();
                        } else {
                            System.out.println("El código introducido no es correcto.Introduzca [1] o [2].");
                        }
                        precionarTecla();
                        break;
                    case 4:
                        lDigital.devolverLibros();
                        lFisico.devolverLibros();
                        precionarTecla();
                        break;
                    case 5:
                        lDigital.listarLibros();
                        lFisico.listarLibros();
                        precionarTecla();
                        break;
                    case 6:
                        lDigital.listarReservados();
                        lFisico.listarReservados();
                        precionarTecla();
                        break;
                    case 7:
                        System.out.println("Hasta otra. Nos vemos pronto...");
                        salir = false;
                        break;
                    default:
                        System.out.println("No ha introducido un valor valido. Introduzca un número del 1 al 7.");
                        break;

                }//cierre del switch

            } //cierre del while

            //cierre del try    
        } catch (InputMismatchException e) {
            System.out.println("Error solo es validos los números del 1 al 7");
            scNumero.next();

        }//cierre del cath

    }

    //Metodo de para para que de una mejor visulizaciòn.
    public static void precionarTecla() {

        Scanner sc = new Scanner(System.in);

        sc = new Scanner(System.in);

        System.out.println("");
        System.out.println("Presiona enter para continuar.....");
        sc.nextLine();
        System.out.println("");
    } //cierre del método.

}
