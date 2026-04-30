/**
 * Programa que modela la poliza de un seguro de vida temporal
 *   - calcula la "Prima neta nivelada",
 *   - imprime la póliza
 *   - Calcula la "Reserva matemática"
 *
 * Define una Clase interna llamada "Beneficiario"
 * que calcula el porcentaje de beneficio de un beneficiario
 *
 * Autores: Roberto Méndez y Enrique de Jesús
 * Fecha/Edición: 6 Marzo 2026 / 11 Mar 2026
 * Materia: Programación / Actuaría
 * Institución: Facultad de Ciencias UNAM
 * 
 * Modificación: Valores del método calcularProbabilidadMuerte() ajustados
 * a estimaciones demográficas de México.
 */

import java.text.DecimalFormat;
import java.time.LocalDate;

/**
 * CLASE
 */
public class SeguroVidaTemporal {

    // Variables privadas (Mantenidas según estándar JavaBeans)
    private String asegurado;
    private int edad;
    private int duracionSeguro;
    private double sumaAsegurada;
    private double tasaInteres;

    // Variable protegida - accesible en subclases
    protected String numeroPoliza;

    // CONSTRUCTOR
    public SeguroVidaTemporal(String asegurado, int edad, int duracionSeguro,
                              double sumaAsegurada, double tasaInteres) {
        this.asegurado = asegurado;
        this.edad = edad;
        this.duracionSeguro = duracionSeguro;
        this.sumaAsegurada = sumaAsegurada;
        this.tasaInteres = tasaInteres;
        this.numeroPoliza = generarNumeroPoliza();
    }

    /* MÉTODOS */

    // MÉTODO privado para generar número de póliza
    private String generarNumeroPoliza() {
        return "POL-" + LocalDate.now().getYear() + "-" +
                (int)(Math.random() * 10000);
    }

    // Método cálculo actuarial - Prima Neta Nivelada
    public double calcularPrimaNeta() {
        double qx = calcularProbabilidadMuerte(edad);
        double px = 1 - qx;
        
        if (tasaInteres <= 0 || qx <= 0) {
            return 0;
        }
        
        double prima = (sumaAsegurada * qx) / (1 + tasaInteres - px);
        return prima;
    }

    // Método protegido para calcular probabilidad de muerte (Tabla México estimada)
    protected double calcularProbabilidadMuerte(int edd_act_1) {
        if (edd_act_1 >= 0 && edd_act_1 <= 14) {
            return 0.00085; 
        } else if (edd_act_1 >= 15 && edd_act_1 <= 29) {
            return 0.00130; 
        } else if (edd_act_1 >= 30 && edd_act_1 <= 59) {
            return 0.00580; 
        } else if (edd_act_1 >= 60) {
            return 0.02450; 
        }
        return 0.00100; // Valor por defecto en caso de anomalía
    }

    // Método público para calcular la reserva matemática (simplificado)
    public double calcularReservaMatematica(int ans_trs_1) {
        if (ans_trs_1 <= 0 || ans_trs_1 > duracionSeguro) {
            return 0;
        }

        double prm_pgd_1 = calcularPrimaNeta();
        double qx_1 = calcularProbabilidadMuerte(edad + ans_trs_1);

        double res_mat_1 = prm_pgd_1 * ans_trs_1 *
                Math.pow(1 + tasaInteres, ans_trs_1) *
                (1 - qx_1);

        return res_mat_1;
    }

    // Métodos getters y setters para variables privadas
    public String getAsegurado() {
        return asegurado;
    }

    public void setAsegurado(String asegurado) {
        this.asegurado = asegurado;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad > 0 && edad < 120) {
            this.edad = edad;
        }
    }

    public int getDuracionSeguro() {
        return duracionSeguro;
    }

    public double getSumaAsegurada() {
        return sumaAsegurada;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    // Método para mostrar información de la póliza
    public void mostrarInformacionPoliza() {
        DecimalFormat df_1 = new DecimalFormat("#,##0.00");

        System.out.println("\n=== INFORMACIÓN DE LA PÓLIZA ===");
        System.out.println("Número de Póliza: " + numeroPoliza);
        System.out.println("Asegurado: " + asegurado);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Duración del Seguro: " + duracionSeguro + " años");
        System.out.println("Suma Asegurada: $" + df_1.format(sumaAsegurada));
        System.out.println("Tasa de Interés: " + (tasaInteres * 100) + "%");
        System.out.println("Prima Neta Anual: $" + df_1.format(calcularPrimaNeta()));
        System.out.println("===============================\n");
    }

    // CLASE INTERNA para ejemplo de composición
    public class Beneficiario {
        private String nombre;
        private String parentesco;
        private double porcentajeBeneficio;

        public Beneficiario(String nombre, String parentesco, double porcentajeBeneficio) {
            this.nombre = nombre;
            this.parentesco = parentesco;
            this.porcentajeBeneficio = porcentajeBeneficio;
        }

        public double calcularBeneficio() {
            return sumaAsegurada * (porcentajeBeneficio / 100);
        }
    }

    // Método main para demostrar la funcionalidad de la clase
    public static void main(String[] args) {
        // Crear una instancia de SeguroVidaTemporal
        SeguroVidaTemporal seguro = new SeguroVidaTemporal("Juan Pérez", 35, 20, 500000, 0.05);
        
        // Mostrar información de la póliza
        seguro.mostrarInformacionPoliza();
        
        // Calcular y mostrar la reserva matemática para diferentes años
        System.out.println("=== RESERVA MATEMÁTICA POR AÑO ===");
        for (int año = 1; año <= 5; año++) {
            double reserva = seguro.calcularReservaMatematica(año);
            DecimalFormat df = new DecimalFormat("#,##0.00");
            System.out.println("Año " + año + ": $" + df.format(reserva));
        }
        System.out.println("===============================\n");
        
        // Crear un beneficiario usando la clase interna
        Beneficiario beneficiario = seguro.new Beneficiario("Maria Pérez", "Esposa", 50);
        System.out.println("Beneficiaria: Maria Pérez");
        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println("Beneficio (50%): $" + df.format(beneficiario.calcularBeneficio()));
    }
}