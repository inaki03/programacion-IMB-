/**
 * Autores: Roberto Méndez y Enrique de Jesús
 * Fecha/Edición actual: 30 Abril 2026
 * Materia: Programación / Actuaría
 * Institución: Facultad de Ciencias UNAM
 * Referencias:
 *  - Alsuwaiyel (2022). Algorithms Design Techniques and Analysis. 2nd edition World Scientific.
 *  - Uehara (2026). First Course in Algorithms Through Puzzles, 2nd edition, Springer.
 */

public class Estructura_ManejoDatos {
    private int[] data;
    private int size;

    public Estructura_ManejoDatos() {
        this.data = new int[0];
        this.size = 0;
    }

    public Estructura_ManejoDatos(int[] arr) {
        this.data = arr.clone();
        this.size = arr.length;
    }

    public void setData(int[] arr) {
        this.data = arr.clone();
        this.size = arr.length;
    }

    public int[] getData() {
        return data.clone();
    }

    public void bubbleSort() {
        for (int i_1 = 0; i_1 < data.length - 1; i_1++) {
            for (int j_1 = 0; j_1 < data.length - 1 - i_1; j_1++) {
                if (data[j_1] > data[j_1 + 1]) {
                    int aux_val_1 = data[j_1];
                    data[j_1] = data[j_1 + 1];
                    data[j_1 + 1] = aux_val_1;
                }
            }
        }
    }

    public void insertionSort() {
        for (int i_1 = 1; i_1 < data.length; i_1++) {
            int val_cur_1 = data[i_1];
            int j_1 = i_1 - 1;
            while (j_1 >= 0 && data[j_1] > val_cur_1) {
                data[j_1 + 1] = data[j_1];
                j_1 = j_1 - 1;
            }
            data[j_1 + 1] = val_cur_1;
        }
    }

    public void selectionSort() {
        for (int i_1 = 0; i_1 < data.length - 1; i_1++) {
            int idx_min_1 = i_1;
            for (int j_1 = i_1 + 1; j_1 < data.length; j_1++) {
                if (data[j_1] < data[idx_min_1]) {
                    idx_min_1 = j_1;
                }
            }
            int val_tmp_1 = data[idx_min_1];
            data[idx_min_1] = data[i_1];
            data[i_1] = val_tmp_1;
        }
    }

    public int max() {
        if (size == 0) return 0;
        int val_max_1 = data[0];
        for (int i_1 = 1; i_1 < size; i_1++) {
            if (data[i_1] > val_max_1) val_max_1 = data[i_1];
        }
        return val_max_1;
    }

    public int min() {
        if (size == 0) return 0;
        int val_min_1 = data[0];
        for (int i_1 = 1; i_1 < size; i_1++) {
            if (data[i_1] < val_min_1) val_min_1 = data[i_1];
        }
        return val_min_1;
    }

    public double average() {
        if (size == 0) return 0.0;
        double sum_tot_1 = 0.0;
        for (int i_1 = 0; i_1 < size; i_1++) {
            sum_tot_1 += data[i_1];
        }
        return sum_tot_1 / size;
    }

    public void displayArray() {
        System.out.print("➤ Estructura actual: [ ");
        for (int i_1 = 0; i_1 < size; i_1++) {
            System.out.print(data[i_1]);
            if (i_1 < size - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println(" ]");
    }

    public void sortAndDisplay(String method) {
        switch (method.toLowerCase()) {
            case "bubble":
                bubbleSort();
                System.out.println(">> Ordenamiento aplicado: BubbleSort");
                break;
            case "insertion":
                insertionSort();
                System.out.println(">> Ordenamiento aplicado: InsertionSort");
                break;
            case "selection":
                selectionSort();
                System.out.println(">> Ordenamiento aplicado: SelectionSort");
                break;
            default:
                System.out.println(">> Metodo desconocido. Recurriendo a fallback: BubbleSort.");
                bubbleSort();
                break;
        }
        displayArray();
    }
}