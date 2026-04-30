/**
 * Autores: Roberto Méndez y Enrique de Jesús
 * Fecha/Edición actual: 30 Abril 2026
 * Materia: Programación / Actuaría
 * Institución: Facultad de Ciencias UNAM
 * Referencias:
 *  - Muller & Brunie et al (2018). Handbook of Floating-Point Arithmetic 2nd Edition pág. 9
 */

import java.math.BigInteger;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SucesionConvergente_v4 {

    public static void main (String[] args) {
        final double EPSILON = 1E-15;
        BigInteger g = new BigInteger("347");
        BigInteger b = new BigInteger("37");
        BigInteger a = new BigInteger("2");
        BigInteger k1 = BigInteger.valueOf(111);
        BigInteger k2 = BigInteger.valueOf(1130);
        BigInteger k3 = BigInteger.valueOf(3000);
        double u_act = 0, u_ant = 0;

        BigInteger tmp;
        int indice = 250;
        int ult_idx_1 = 4;
        
        // Se dimensiona el arreglo asumiendo que arranca en 0 hasta el limite
        double[] arr_res_1 = new double[indice + 1];

        // Primera iteración para i_1 = 4
        tmp = g;
        g = g.multiply(k1).subtract(b.multiply(k2)).add(a.multiply(k3));
        a = b;
        b = tmp;
        u_ant = g.doubleValue()/b.doubleValue();
        arr_res_1[4] = u_ant;
        ult_idx_1 = 4;

        for (int i_1 = 5; i_1 <= indice; i_1++) {
            tmp = g;
            g = g.multiply(k1).subtract(b.multiply(k2)).add(a.multiply(k3));
            a = b;
            b = tmp;

            u_act = g.doubleValue()/b.doubleValue();
            arr_res_1[i_1] = u_act;
            ult_idx_1 = i_1;

            if(Math.abs(u_ant - u_act) <= EPSILON ){
                System.out.println("La sucesión converge a: " + Math.floor(u_act));
                break;
            }
            u_ant = u_act;
        }

        Scanner scn_in_1 = new Scanner(System.in);
        boolean flg_ok_1 = false;
        
        while(!flg_ok_1) {
            try {
                System.out.print("Ingrese la posicion (indice) que desea consultar (4 a " + ult_idx_1 + "): ");
                int idx_req_1 = scn_in_1.nextInt();
                
                if(idx_req_1 >= 4 && idx_req_1 <= ult_idx_1) {
                    System.out.printf("Valor en la posicion %d es %.20f %n", idx_req_1, arr_res_1[idx_req_1]);
                    flg_ok_1 = true;
                } else {
                    System.out.println("Error: El indice proporcionado esta fuera del dominio calculado.");
                }
            } catch (InputMismatchException err_in_1) {
                System.out.println("Error critico: Tipo de dato invalido. Debe ingresar un entero numerico.");
                scn_in_1.next(); // Limpieza del buffer del scanner
            }
        }
        scn_in_1.close();
    }
}