# 🐾👤 Taller Unidad 2 - Clasificador de Animales y Gestión de Personas en Java

## 📚 Descripción del Proyecto

Este proyecto en Java está dividido en dos partes:

1. **Clasificador de Animales**: Permite al usuario ingresar distintos animales, clasificarlos según su tipo (terrestre, aéreo, acuático) y mostrarlos organizadamente.
2. **Gestión de Personas**: Permite registrar personas con sus datos personales y laborales. Luego se realizan operaciones estadísticas y de filtrado utilizando la API de Streams y Lambdas de Java.

---

## 🐾 Parte 1: Clasificador de Animales

### ✅ Funcionalidad
- Solicita al usuario ingresar animales uno a uno desde consola.
- Clasifica cada animal como `terrestre`, `aéreo` o `acuático`.
- Muestra todos los animales agrupados por tipo usando un `TreeMap`.

---

## 👤 Parte 2 y 3: Gestión de Personas

### ✅ Datos que se ingresan por persona:
- Nombre
- Apellido
- Edad
- Género (`M` o `F`)
- Sueldo por hora
- Cargo

### 🧠 Operaciones realizadas usando Streams y Lambdas:

#### Parte 2:
- Cantidad total de personas ingresadas
- Promedio de edades
- Cantidad de mayores de edad
- Personas cuyos nombres empiezan con “A”
- Personas cuyos apellidos contienen la letra “M”

#### Parte 3:
- Mostrar el sueldo por 8 horas de los directores masculinos (`M`)
- Mostrar la **primera mujer** con cargo de desarrollador
- Mostrar el desarrollador que **más gana por hora**
- Listar a todas las mujeres ordenadas por su nombre
