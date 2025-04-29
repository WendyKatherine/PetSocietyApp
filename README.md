<h1 align="center">🐾 PetSocietyApp</h1>

![image](https://github.com/user-attachments/assets/fe3ec4be-4b17-428d-9e7b-ee9d6a1942e0)

<p align="center">
  App de mascotas desarrollada en Android Studio 🐶<br>
  <strong>By Grupo 9</strong> · Abril 2025
</p>

<h2>📖 Descripción</h2>
PetSocietyApp es una aplicación Android modular (Kotlin + Fragments) que permite:
<ul>
  <li>👤 Ver el perfil de una mascota con foto, descripción y datos (peso, color, socialidad, vacunas).  </li>
  <li>🖼️ Explorar una galería de fotos con bordes redondeados y descripciones ocultas que aparecen al tocar.</li>
  <li>🎥 Reproducir un video vertical con controles.  </li>
  <li>🌐 Navegar a una URL ingresada dentro de un WebView.  </li>
  <li>🎮 Interactuar con botones dinámicos: cambiar color, mostrar mensajes y desactivar.</li>
</ul>

<h2>🛠️ Tecnologías  </h2>
<ul>
  <li>Lenguaje: Kotlin</li>
  <li>IDE: Android Studio </li>
  <li>Arquitectura: Fragments + Activity</li>
  <li>UI: XML layouts, `Drawable` Shape, Material Components</li>
  <li>Testing: JUnit4, Espresso, FragmentScenario</li>
</ul>

<h2>📂 Estructura del Proyecto </h2>

```
app/
├─ src/
│  ├─ main/
│  │  ├─ java/com/example/petapp/
│  │  │  ├─ MainActivity.kt
│  │  │  ├─ MenuFragment.kt
│  │  │  └─ ContentFragment.kt
│  │  ├─ res/
│  │  │  ├─ layout/
│  │  │  │  ├─ activity_main.xml
│  │  │  │  ├─ fragment_menu.xml
│  │  │  │  └─ fragment_content.xml
│  │  │  ├─ drawable/ (round_button_bg.xml, rounded_image_bg.xml, edittext_bg.xml, íconos…)
│  │  │  └─ values/ids.xml (txtPerfilNombre, imgFoto1, txtDesc1, …)
│  │  └─ AndroidManifest.xml
│  ├─ androidTest/ (tests de integración)
│  └─ test/ (tests unitarios)
└─ build.gradle.kts
```


<h2>✔️ Cómo usar</h2>
<ul>
  <li>
    1. Al arrancar, se muestra por defecto la Sección: Perfil.
  </li>
  <li>
    2. Usa los botones redondos de la izquierda para cambiar entre:
    <ul>
       <li>
      Perfil ▶ Datos de la mascota
    </li>
    <li>
      Fotos ▶ Galería interactiva
    </li>
      <li>
      Video ▶ Reproductor integrado
    </li>
    <li>
      Web ▶ Navegador con campo de URL
    </li>
      <li>
      Botones ▶ Acciones dinámicas
    </li>
    </ul>  
</ul>

<h2>🧪 Pruebas</h2>
<ul>
  <li>Unitarias:</li>
  <ul>
    <li>Validación de cambio de sección sin crash.</li>
  </ul>
</ul>
<ul>
  <li>Instrumentadas (Espresso):</li>
  <ul>
    <li>Clic en btnPerfil muestra txtPerfilNombre.</li>
    <li>Clic en btnFotos, imgFoto1 despliega txtDesc1.</li>
  </ul>
  Some basic Git commands are:
</ul>

Para ejecutar todas las pruebas:

```
./gradlew testDebugUnitTest   # Unitarias
./gradlew connectedAndroidTest # Instrumentadas
```

<h2>📦 Descarga la APK</h2>

Puedes descargarte la última versión de la APK desde la sección de [Descargar APK v1.0](https://github.com/WendyKatherine/PetSocietyApp/releases/tag/kotlin)
























