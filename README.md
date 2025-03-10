# Blood Pressure Monitor App

## 📌 Descripción
Esta es una aplicación de Android que permite registrar, visualizar y analizar mediciones de presión arterial y pulsaciones. La app guarda cada medición con fecha y hora, calcula el promedio de todas las mediciones y clasifica la presión arterial como baja, normal o alta.

## 🚀 Características
- 📋 **Registro de mediciones**: Ingreso de presión arterial sistólica, diastólica y pulsaciones.
- 📅 **Guardado con fecha y hora**.
- 📜 **Lista de mediciones**: Visualización en un `ListView` con opción de eliminar mediciones.
- 📊 **Cálculo del promedio** de todas las mediciones.
- 🔍 **Clasificación de la presión arterial** (baja, normal o alta).


## 🛠️ Tecnologías Utilizadas
- **Kotlin** - Lenguaje de programación principal.
- **Android SDK** - Desarrollo para Android.
- **XML** - Diseño de la interfaz de usuario.
- **ListView y BaseAdapter** - Para mostrar y gestionar las mediciones.

## 📂 Estructura del Proyecto
```
BloodPressureMonitor/
│── app/
│   ├── src/main/java/com/example/app/
│   │   ├── MainActivity.kt
│   │   ├── MeasurementAdapter.kt
│   │   ├── Measurement.kt
│   ├── src/main/res/layout/
│   │   ├── activity_main.xml
│   ├── src/main/AndroidManifest.xml
│── README.md
```

