import numpy as np
import matplotlib.pyplot as plt

# Parámetros del sistema
r, a, b, c, d = 4, 1, 4, 1, 1

# Configuración de la malla temporal
n_p = 1000
t_f = 5
t_v = np.linspace(0, t_f, n_p)
dt_v = t_v[1] - t_v[0]

# Arreglos para variables de estado
# vb_m[0] = Volumen del Tumor, vb_m[1] = Densidad de Vasos
vb_m = np.zeros((2, n_p))

# Condiciones iniciales (Asumidas por falta de dato en PDF)
vb_m[0][0] = 0.5
vb_m[1][0] = 1.0

# Implementación de Euler hacia adelante
for i in range(n_p - 1):
    v_a = vb_m[0][i]
    b_a = vb_m[1][i]
    t_a = t_v[i]
    
    g_t = t_a**2
    
    # Sistema de EDOs
    dv_dt = r * v_a * (1 - (v_a / b_a))
    db_dt = -a * b_a + b * v_a - c * b_a * (v_a**(2/3)) - d * b_a * g_t
    
    vb_m[0][i+1] = v_a + dv_dt * dt_v
    vb_m[1][i+1] = b_a + db_dt * dt_v

# Visualización
plt.figure(figsize=(10, 5))
plt.plot(t_v, vb_m[0], label='Volumen V(t)', color='red')
plt.plot(t_v, vb_m[1], label='Densidad Vasos B(t)', color='blue')
plt.title('Dinámica de Crecimiento Tumoral')
plt.xlabel('Tiempo (t)')
plt.ylabel('Magnitud')
plt.legend()
plt.grid(True, linestyle='--')
plt.show()