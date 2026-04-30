# Programa: inv_bancaria.py
# Autores: Roberto Méndez y Enrique de Jesús
# Fecha/Edición: 6 Marzo 2026 / 11 Mar 2026
# Materia: Programación / Actuaría
# Institución: Facultad de Ciencias UNAM

def sim_inv_banc():
    val_e_1 = 2.71828182845904523536028747135
    cap_act_1 = val_e_1 - 1
    
    print(f"Capital Inicial Año 0: {cap_act_1}")
    
    # Iteración a 20 años para evidenciar la divergencia por error de redondeo
    for an_n_1 in range(1, 21):
        cap_act_1 = (an_n_1 * cap_act_1) - 1
        print(f"Monto al finalizar año {an_n_1}: {cap_act_1}")

if __name__ == "__main__":
    sim_inv_banc()
    