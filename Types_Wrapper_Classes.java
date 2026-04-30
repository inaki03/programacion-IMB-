/**
 * Programa para ejemplificar
 * los distintos tipos en JAVA y sus
 * wrapped (Encapsulamientos)
 *
 * Autores: Roberto Méndez y Enrique de Jesús
 * Fecha/Edición: 6 Marzo 2026 / 11 Mar 2026
 * Materia: Programación / Actuaría
 * Institución: Facultad de Ciencias UNAM
 *
 * Modificación: Remoción del literal L en la inicialización de Long 
 * para provocar la ArithmeticException solicitada en el inciso 6.
 */

public static void main(String[] args) {
    byte v_b_1 = 100;
    Byte v_b_2 = -120;
    System.out.println("byte: " + v_b_1);
    v_b_1 = v_b_2;
    IO.println("byte = Byte da: " + v_b_1);

    short v_sh_1 = -32768;
    Short v_sh_2 = 32767;
    System.out.println("String short + Short: " + v_sh_1 + v_sh_2);
    System.out.println("Suma short + Short= " + (v_sh_1 + v_sh_2));

    int v_n_1 = Math.powExact(2, 30);
    Integer v_i_1 = 2147483647;
    System.out.println("El máximo entre int e Integer es: %d".formatted(Integer.max(v_i_1, v_n_1)));

    long v_l_1 = 9223372036854775807L;
    // Eliminación de la "L" en el -2, causando evaluación como int y posterior desbordamiento
    Long v_l_2 = Long.MIN_VALUE;
    System.out.println("Long de 2^63-1 es: " + v_l_2);

    float v_f_1 = 673093.1234f;
    Float v_g_1 = (float) (3.4 * Math.pow(10, 38));
    System.out.println("Float de 3.4*10^38 es: " + v_g_1);
    System.out.println("El penúltimo Float es: " + Math.nextDown(v_g_1));

    double v_d_1 = 673093.1234;
    Double v_d_2 = 0.3;
    System.out.printf("Double d2 vale %f and doble d es %f \n", v_d_2, v_d_1);

    char v_amor_1 = '\u2661';  
    Character v_amist_1 = '\u270C'; 
    System.out.println("Feliz día del " + v_amor_1 + " y " + v_amist_1);

    boolean v_tu_puedes_1 = true;
    Boolean v_alcanza_metas_1 = true;
    if (v_tu_puedes_1 == v_alcanza_metas_1) {
        System.out.println("No hay duda ¡alcanzarás tus sueños!");
    }
}