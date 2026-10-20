# BGT App – Gestor de Hábitos y Rutinas de Entrenamiento

Aplicación de escritorio desarrollada en **Java** y **JavaFX** para la monitorización, registro estructurado y análisis de sesiones de entrenamiento físico y hábitos saludables. 

El proyecto fue concebido y desarrollado durante el 1º curso del Ciclo Formativo de Grado Superior en **Desarrollo de Aplicaciones Multiplataforma (DAM)**, siendo seleccionado para su exposición pública en el **Saló de l'Ensenyament** como muestra práctica de desarrollo de software funcional enfocado a la salud y el rendimiento.

---

## Características Principales

* **Planificación y Registro de Sesiones:** Registro en tiempo real de entrenamientos detallando fecha, tipología de sesión y volumen de trabajo.
* **Métricas por Series y Cargas:** Control granular de repeticiones, cargas (kg) y métricas de esfuerzo por cada ejercicio realizado.
* **Catálogo Dinámico de Ejercicios:** Carga y clasificación desacoplada de ejercicios por grupos musculares a partir de fuentes de datos estructuradas.
* **Histórico y Consulta:** Visualización del progreso histórico para evaluación de adherencia y sobrecarga progresiva.
* **Interfaz de Usuario Ergonómica:** UI modular maquetada en JavaFX con estilización personalizada en CSS para facilitar una navegación rápida e intuitiva.

---

## Arquitectura y Decisiones Técnicas

El software sigue una arquitectura modular por capas con estricta separación de responsabilidades:

```text
org.bgtapp
├── app/       # Controladores de interfaz y navegación (JavaFX)
├── dao/       # Capa de persistencia - Patrón Data Access Object (DAO)
├── db/        # Gestión de conexión transaccional JDBC
└── modelo/    # Entidades de dominio y lógica de negocio pura
```

* **Patrón DAO (Data Access Object):** Las clases `SesionDAO` y `SerieDAO` aíslan completamente la lógica de negocio y la interfaz de los detalles de bajo nivel de la base de datos, facilitando el mantenimiento y potenciales migraciones de motor.
* **Persistencia Relacional Local:** Conexión mediante **JDBC** sobre base de datos embebida **SQLite** (`bgt.db`), garantizando funcionamiento autónomo y rápido sin dependencias de red externas.
* **Almacenamiento Híbrido (Relacional + JSON):** Uso de ficheros estructurados `ejercicios.json` gestionados por `GestorJSON` para desacoplar el catálogo base de las transacciones relacionales del usuario.
* **Gestión de dependencias con Maven:** Automatización de compilación, empaquetado y gestión del ciclo de vida de librerías (`pom.xml`).

---

## Stack Tecnológico

| Componente | Tecnología |
| :--- | :--- |
| **Lenguaje principal** | Java 17+ |
| **Interfaz Gráfica (GUI)** | JavaFX + CSS3 |
| **Base de Datos** | SQLite (Embebida) |
| **Acceso a Datos** | JDBC + Patrón DAO |
| **Formato de Configuración** | JSON |
| **Automatización / Build** | Apache Maven |
| **IDE de Desarrollo** | IntelliJ IDEA |

---

## Estructura del Repositorio

```bash
app_rutina_ejercicios_habitos/
├── src/
│   ├── main/
│   │   ├── java/org/bgtapp/
│   │   │   ├── app/                # PantallaMenu, PantallaAgregarSesion, PantallaVerSesiones
│   │   │   ├── dao/                # SesionDAO, SerieDAO
│   │   │   ├── db/                 # ConexionDB (Gestor de conexión SQLite)
│   │   │   ├── modelo/             # Sesion, Serie, Ejercicio, GestorJSON, Catalogo
│   │   │   └── Main.java           # Punto de entrada de la aplicación
│   │   └── resources/
│   │       ├── ejercicios.json     # Catálogo base de ejercicios
│   │       └── styles.css          # Estilización visual de JavaFX
├── bgt.db                          # Esquema y persistencia local SQLite
└── pom.xml                         # Configuración y dependencias de Maven
```

---

## Requisitos e Instalación

### Requisitos previos
* **JDK 17** o superior instalado en el sistema.
* **Apache Maven 3.8+** (o utilizar el wrapper integrado en el IDE).

### Puesta en marcha

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/javiitc/app_rutina_ejercicios_habitos.git
   cd app_rutina_ejercicios_habitos
   ```

2. **Compilar y resolver dependencias:**
   ```bash
   mvn clean compile
   ```

3. **Ejecutar la aplicación:**
   ```bash
   mvn javafx:run
   ```
   *(También se puede ejecutar directamente lanzando la clase `Main.java` o `AppJavaFX.java` desde cualquier IDE como IntelliJ IDEA o Eclipse).*

---

## Autor
* **Javier Tituaña** – [GitHub](https://github.com/javiitc) · [LinkedIn](https://linkedin.com)