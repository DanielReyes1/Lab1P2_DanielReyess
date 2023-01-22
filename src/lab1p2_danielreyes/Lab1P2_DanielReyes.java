package lab1p2_danielreyes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author alema
 */
public class Lab1P2_DanielReyes {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {

        int resp = 0;
        do {
            System.out.println("MENU");
            System.out.println("1- Torres de Hanói");
            System.out.println("2- Fecha String");
            System.out.println("3- Sumatoria");
            System.out.println("4- Salir del sistema");
            System.out.println("Ingrese una opción: ");
            resp = leer.nextInt();

            switch (resp) {
                case 1:
                    System.out.println("Ingresó la primera opción");
                    System.out.println("Número de discos: ");
                    int discos = leer.nextInt();
                    int ori = 1,
                     aux = 2,
                     des = 3,
                     cont = 1;
                    hanoi(discos, ori, aux, des, cont);

                    break;
                case 2:
                    System.out.println("Ingresó la segunda opción");
                    System.out.println("Ingrese una cadena que incluya una fecha: ");
                    String cadena = leer.next();
                    String[] datos = cadena.split(",");
                    Date fecha = new Date();
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    for (int i = 0; i < datos.length; i++) {
                        if (datos[i].charAt(2) == '/' && datos[i].charAt(5) == '/') {
                            if (datos[i].length() == 10) {
                                fecha = df.parse(datos[i]);
                                System.out.println(fecha);
                            }
                        }
                    }

                    break;
                case 3:
                    System.out.println("Ingresó la tercera opción");
                    System.out.println("Ingrese el limite de la sumatoria: ");
                    int limite = leer.nextInt();
                    int n= 0; 
                    double acum = 0;
                    double total = sumatoria(limite, n, acum);
                    System.out.println("La sumatoria es: "+total);
                    break;
            }

        } while (resp != 4);
        System.out.println("Salió del sistema adecuadamente");

    }

    public static void hanoi(int n, int origen, int auxiliar, int destino, int contador) {

        if (n == 1) {
            
            System.out.println(contador + " mover disco " + n + " de " + origen + " a " + destino);
            contador++;
            
            contador = contador + contador;
            return;
        } else {
            
            hanoi(n - 1, origen, destino, auxiliar, contador);
            
        }
        contador++;
        System.out.println(contador + " mover disco " + n + " de " + origen + " a " + auxiliar);
        
        hanoi(n - 1, auxiliar, origen, destino, contador);
        
    }
    public static double sumatoria(int limit, int n, double acumulador){
        double total = 0, numerador = 0, denominador= 0;
        
        if(n == limit){
            return acumulador * 4;
        }
        else{
            numerador = Math.pow(-1,n);
            denominador =(2*n) + 1;
            total = numerador / denominador;
            acumulador = acumulador + total;
            return sumatoria(limit, n+1, acumulador);
        }
    }
}
