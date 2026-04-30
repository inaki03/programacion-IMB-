/**
 * Programa que Calcula el Interés Compuesto
 *
 * Tema:  1.3 y 1.4 Organización general de un Programa
 *         y Normas de estilo
 *
 *  Fórmula empleada:
 *              M = P * (1 + r/n)^(n*t)
 *
 * Software:
 *     JDK 25
 *     IDE IntelliJ IDEA 2025.3.1
 *
 * Autores: Roberto Méndez y Enrique de Jesús
 * Fecha/Edición: 6 Marzo 2026 / 11 Mar 2026
 * Materia: Programación / Actuaría
 * Institución: Facultad de Ciencias UNAM
 */
import java.text.DecimalFormat;
import java.util.Scanner;

public class InteresCompuestoSimple {

    public static void main(String[] args) {
        Scanner scan_1 = new Scanner(System.in);
        DecimalFormat fmt_1 = new DecimalFormat("#,##0.00");

        System.out.println("=== CALCULADORA DE INTERÉS COMPUESTO ===");

        double cap_in_1 = 0;
        double tsa_int_1 = 0;
        int an_inv_1 = -1;
        int cap_z_1 = -1;

        try {
            System.out.print("Capital inicial: $");
            cap_in_1 = scan_1.nextDouble();

            System.out.print("Tasa de interés anual (%): ");
            tsa_int_1 = scan_1.nextDouble();
        } catch (Exception e) {
            System.out.println("Error fatal en la entrada de datos. El programa terminará.");
            System.exit(1);
        }

        while (an_inv_1 < 0) {
            try {
                System.out.print("Años de inversión: ");
                an_inv_1 = Integer.parseInt(scan_1.next());
                if (an_inv_1 < 0) {
                    System.out.println("Error: El valor debe ser un entero positivo.");
                }
            } catch (NumberFormatException exc_1) {
                System.out.println("Error: Formato numérico incorrecto.");
            }
        }

        while (cap_z_1 != 1 && cap_z_1 != 12) {
            try {
                System.out.print("Capitalizaciones por año (1=anual, 12=mesual): ");
                cap_z_1 = Integer.parseInt(scan_1.next());
                if (cap_z_1 != 1 && cap_z_1 != 12) {
                    System.out.println("Cometió un error. Ingrese Capitalización (1 o 12): ");
                }
            } catch (NumberFormatException exc_2) {
                System.out.println("Cometió un error. Ingrese Capitalización (1 o 12): ");
            }
        }

        double tsa_dec_1 = tsa_int_1 / 100;
        double mnt_fn_1 = cap_in_1 * Math.pow(1 + (tsa_dec_1 / cap_z_1), cap_z_1 * an_inv_1);

        System.out.println("\n=== RESULTADOS ===");
        System.out.println("Capital inicial: $" + fmt_1.format(cap_in_1));
        System.out.println("Tasa anual: " + tsa_int_1 + "%");
        System.out.println("Periodo: " + an_inv_1 + " años");
        System.out.println("Capitalizaciones por año: " + cap_z_1);
        System.out.println("Monto final: $" + fmt_1.format(mnt_fn_1));
        System.out.println("Interés ganado: $" + fmt_1.format(mnt_fn_1 - cap_in_1));

        scan_1.close();
    }
}