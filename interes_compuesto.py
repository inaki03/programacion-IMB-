"""
===========================================================
Autores: Roberto Méndez y Enrique de Jesús
Fecha/Edición: 6 Marzo 2026 / 11 Mar 2026
Materia: Programación / Actuaría
Institución: Facultad de Ciencias UNAM
Tema: Organización general de un programa
        Entrada -> Proceso -> Salida
===========================================================

OBJETIVO DEL SCRIPT
-----------------------------------------------------------
Programa que calcula el Interés Compuesto
Modelo empleado: M = P x (1 + r/n) ^ (n*t)
"""

print("\n---- CALCULADORA DE INTERÉS COMPUESTO ----")

try:
    cap_in_1 = float(input("Introduzca su capital inicial: $"))
    tsa_an_1 = float(input("Introduzca su tasa de interés anual (%): "))
except ValueError:
    print("Error fatal: Formato numérico incorrecto. Terminando ejecución.")
    exit(1)

an_inv_1 = -1
while an_inv_1 < 0:
    try:
        an_inv_1 = int(input("Introduzca sus años de inversión: "))
        if an_inv_1 < 0:
            print("Error: El valor debe ser un entero positivo.")
    except ValueError:
        print("Error: Formato numérico incorrecto.")
        an_inv_1 = -1

cap_z_1 = -1
while cap_z_1 not in [1, 12]:
    try:
        cap_z_1 = int(input("Introduzca sus capitalizaciones por año (1 = anual, 12 = mensual): "))
        if cap_z_1 not in [1, 12]:
            print("Cometió un error. Introduzca 1 o 12.")
    except ValueError:
        print("Cometió un error. Introduzca 1 o 12.")
        cap_z_1 = -1

tsa_dec_1 = tsa_an_1 / 100
mnt_fn_1 = cap_in_1 * (1 + (tsa_dec_1 / cap_z_1)) ** (cap_z_1 * an_inv_1)

print("\n=== RESULTADOS ===")
print("Capital Inicial:", cap_in_1)
print("Tasa Anual:", tsa_an_1)
print("Periodo:" + str(an_inv_1) + " años")
print("Capitalizaciones por año:", cap_z_1)
print("Monto Final:", mnt_fn_1)
print("Interés Ganado:", mnt_fn_1 - cap_in_1)