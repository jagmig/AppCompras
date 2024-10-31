import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        menuPrincipal();

    }

    static Scanner sc = new Scanner(System.in);
    static Scanner sc2 = new Scanner(System.in);
    static Scanner sc3 = new Scanner(System.in);
    static Scanner sc4 = new Scanner(System.in);
    static int precio = 0;
    static int precioMax = 0;

        public static void menuPrincipal() {

            System.out.println("****Bienvenido a la App de Compras*****");


            menuCompra();
        }

        public static void menuCompra() {
            System.out.println("¿Cuanto Saldo quieres disponer? ");
            int saldo = sc.nextInt();
            Map<String, Integer> productos = new HashMap<>();


            do {
                System.out.println("Escribe la descripción del producto");
                String descripcion = sc2.nextLine();
                System.out.println("Escribe el Precio del producto");
                precio = sc3.nextInt();
                productos.put(descripcion, precio);
                precioMax += precio;
                if(precioMax > saldo){
                    break;
                }
                System.out.println("Compra Realizada!!");
                System.out.println("Llevas gastado: " + precioMax);
                System.out.println("Elija 0 para salir o 1 para continuar");
                int cont = sc4.nextInt();
                if (cont == 0) {
                    System.out.println("\n***************************");
                    System.out.println("\nCOMPRAS REALIZADAS: ");
                    Map<String, Integer> sortedmap = new TreeMap<>(productos);
                    for (Map.Entry<String, Integer> e : sortedmap.entrySet()) {
                        System.out.println(e.getKey() + " - " + "$" + e.getValue());
                    }
                    System.out.println("\nGastaste: " + "$" + precioMax);
                    System.out.println("Saldo en la tarjeta: " + "$" + (saldo - precioMax));
                    System.out.println("\nGracias por utilizar nuestra app");
                    System.out.println("\n***************************");
                    return;
                }
            }while (precioMax < saldo);
            System.out.println("\nSaldo insuficiente");
            System.out.println("Saldo en la tarjeta: " + "$" + (saldo - precioMax));
            //System.out.println(productos);
        }

        public static void seguir(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Elija 0 para salir o 1 para continuar");
            int opcion = sc.nextInt();

            if(opcion == 0){
                System.out.println("Gracias por utilizar nuestra App de Compras");
            } else if (opcion == 1) {
                menuCompra();
            }
            else{
                System.out.println("Opción no válida");
            }
        }
}

