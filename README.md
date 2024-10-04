Práctica 5: RecyclerView - Reproductor de Música
Descripción
Este proyecto implementa un reproductor de música simple utilizando RecyclerView en Android. La aplicación muestra una lista de audios y permite al usuario reproducirlos, pausarlos y detenerlos.
Características principales

Lista de audios utilizando RecyclerView
Reproducción de audio con controles (reproducir, pausar, detener)
Navegación entre la lista de audios y el reproductor

Estructura del proyecto
Fragmentos

AudioListFragment: Muestra la lista de audios usando RecyclerView
PlayerControlFragment: Permite controlar la reproducción del audio seleccionado

Adaptador

AudioAdapter: Maneja la visualización de los elementos en el RecyclerView

Layouts

activity_main.xml: Layout principal que contiene el FrameLayout para los fragmentos
fragment_audio_list.xml: Layout para el RecyclerView
fragment_player_control.xml: Layout para el control de reproducción

Recursos

Archivos de audio en la carpeta res/raw
Imágenes representativas de los audios en res/drawable

Implementación
1. AudioListFragment

Implementa un RecyclerView que muestra al menos 5 audios diferentes
Cada ítem del RecyclerView incluye:

Nombre del audio
Imagen representativa
Duración



2. PlayerControlFragment

Muestra la imagen del audio seleccionado
Incluye botones para reproducir, pausar y detener
Utiliza MediaPlayer para manejar la reproducción

3. Navegación

Al seleccionar un ítem en AudioListFragment, se navega a PlayerControlFragment
Se pasa la información del audio seleccionado entre fragmentos

4. Reproducción de audio

Utiliza MediaPlayer para cargar y reproducir audio desde res/raw
Implementa la lógica para los botones de reproducción, pausa y detención

Configuración del proyecto

Asegúrate de tener Android Studio instalado
Clona este repositorio
Abre el proyecto en Android Studio
Sincroniza el proyecto con los archivos Gradle
Ejecuta la aplicación en un emulador o dispositivo Android

Notas adicionales

Los archivos de audio deben estar en formato compatible (por ejemplo, MP3)
Asegúrate de que los nombres de los recursos (drawables, raw) coincidan con los utilizados en el código
