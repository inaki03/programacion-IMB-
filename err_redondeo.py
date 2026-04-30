# Programa: err_redondeo.py
# Autores: Roberto Méndez y Enrique de Jesús
# Fecha/Edición: 6 Marzo 2026 / 11 Mar 2026
# Materia: Programación / Actuaría
# Institución: Facultad de Ciencias UNAM
# Referencias: Muller et al. (2018). Handbook of Floating-Point Arithmetic.

def eval_aritmetica():
    var_a_1 = (1 / 947) * 947
    var_b_1 = 1
    
    # Evaluación de la pérdida de precisión en aritmética de punto flotante
    if var_a_1 != var_b_1:
        print("Wrong result!")
    else:
        print("Right result!")

if __name__ == "__main__":
    eval_aritmetica()