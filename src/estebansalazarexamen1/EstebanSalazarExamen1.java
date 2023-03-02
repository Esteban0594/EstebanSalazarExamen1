package estebansalazarexamen1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class EstebanSalazarExamen1 {
    
    public static final int SOL_NORTE_SUR = 1;
    public static final int SOMBRA_ESTE_OESTE = 2;
    public static final int PREFERENCIAL = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Bienvenido al sistema de venta de entradas");

        ArrayList<String> ventasRealizadas = new ArrayList<String>();

        for(int i = 1; i <= 10; i++) {
    System.out.println("\nIngrese el número de entradas a comprar:");
    int cantidadEntradas = scanner.nextInt();

    if(cantidadEntradas > 4) {
        System.out.println("No puede comprar más de 4 entradas");
        continue;
    }

            System.out.println("Elija la localidad deseada:");
            System.out.println("1. Sol Norte/Sur el precio es de: 10500 colones \n");
            System.out.println("2. Sombra Este/Oeste el precio es de: 20500 colones \n");
            System.out.println("3. Preferencial el precio es de: 25500 colones \n");
            int localidadSeleccionada = scanner.nextInt();

            int precioEntrada;
            String nombreLocalidad;

            switch (localidadSeleccionada) {
                case SOL_NORTE_SUR:
                    precioEntrada = 10500;
                    nombreLocalidad = "Sol Norte/Sur ";
                    break;
                case SOMBRA_ESTE_OESTE:
                    precioEntrada = 20500;
                    nombreLocalidad = "Sombra Este/Oeste ";
                    break;
                case PREFERENCIAL:
                    precioEntrada = 25500;
                    nombreLocalidad = "Preferencial ";
                    break;
                default:
                    System.out.println("Localidad inválida.");
                    continue;
            }

            int totalVenta = precioEntrada * cantidadEntradas;
            int numeroFactura = random.nextInt(1000000) + 1;

            System.out.println("Ingrese el nombre del comprador:");
            String nombre = scanner.next();

            System.out.println("Ingrese la cédula del comprador:");
            String cedula = scanner.next();
            


            System.out.println("Detalle de la venta:");
            System.out.println("Número de factura: " + numeroFactura);
            System.out.println("Nombre del comprador: " + nombre);
            System.out.println("Cédula del comprador: " + cedula);
            System.out.println("Localidad: " + nombreLocalidad);
            System.out.println("Cantidad de entradas: " + cantidadEntradas);
            System.out.println("Precio por entrada: " + precioEntrada + " colones");
            System.out.println("Cargo por servicio: 1000 colones");
            System.out.println("Subtotal: " + (totalVenta) + " colones");
            System.out.println("Total a pagar: " + (totalVenta + 1000) + " colones");

            String venta = "Venta #" + i + ": " + nombre + " - " + cedula + " - " + nombreLocalidad + " - " + cantidadEntradas + " entradas - " + totalVenta + " colones";
            ventasRealizadas.add(venta);

            if(i == 10) {
                System.out.println("\nHa superado el máximo de solicitudes de ventas");
            }
        }
        
        // Variables acumuladoras para llevar el conteo de la cantidad de entradas y el dinero acumulado en cada localidad
int cantidadSol = 0;
int cantidadSombra = 0;
int cantidadPreferencial = 0;
int dineroSol = 0;
int dineroSombra = 0;
int dineroPreferencial = 0;

// Recorrer el ArrayList ventasRealizadas para obtener la información necesaria y mostrarla en el reporte
System.out.println("\nReporte de ventas realizadas:");
for (String venta : ventasRealizadas) {
    String[] datosVenta = venta.split(" - ");

    int cantidadEntradas = Integer.parseInt(datosVenta[3].split(" ")[0]);
    int precioEntrada = Integer.parseInt(datosVenta[4].split(" ")[0]);
    int totalVenta = cantidadEntradas * precioEntrada;
    String nombreLocalidad = datosVenta[2].split(" ")[0];

    switch (nombreLocalidad) {
        case "Sol":
            cantidadSol += cantidadEntradas;
            dineroSol += totalVenta;
            break;
        case "Sombra":
            cantidadSombra += cantidadEntradas;
            dineroSombra += totalVenta;
            break;
        case "Preferencial":
            cantidadPreferencial += cantidadEntradas;
            dineroPreferencial += totalVenta;
            break;
    }
}

// Mostrar el reporte
System.out.println("Cantidad Entradas Localidad Sol Norte/Sur: " + cantidadSol);
System.out.println("Acumulado Dinero Localidad Sol Norte/Sur: " + dineroSol + " colones");
System.out.println("Cantidad Entradas Localidad Sombra Este/Oeste: " + cantidadSombra);
System.out.println("Acumulado Dinero Localidad Sombra Este/Oeste: " + dineroSombra + " colones");
System.out.println("Cantidad Entradas Localidad Preferencial: " + cantidadPreferencial);
System.out.println("Acumulado Dinero Localidad Preferencial: " + dineroPreferencial + " colones");
System.out.println("\nPresione cualquier tecla para salir...");
scanner.next();

    
    }
}

