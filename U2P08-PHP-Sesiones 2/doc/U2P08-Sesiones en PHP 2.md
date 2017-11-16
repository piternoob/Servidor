###### *Desarrollo Web en Entorno Servidor - Curso 20176/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U2P08 - Sesiones en PHP 2
----
#### 1. Descripción:

Vamos a aplicar nuestros conocimientos de sesiones en PHP para resolver dos problemas.

#### 2. Formato de entrega:

Incluye el código generado y capturas de la ejecución, o bien muestra tu trabajo al profesor.

#### 3. Trabajo a realizar:

Crea un proyecto PHP para esta actividad. Cada parte se resolverá en una carpeta: 'saludo' y 'test'

##### Parte 1: Saludo

1. Crea un archivo `saludo.php` y codifica un único archivo PHP con el siguiente comportamiento:
   * Si no hay sesión iniciada, se mostrará un formulario para pedir nuestro nombre. Al enviar el formulario se iniciará una sesión almacenando el nombre como variable de sesión
   * Si hay sesión iniciada, se mostrará un texto como este: *Damos la bienvenida a Alberto*

Se sugiere el siguiente esquema para el archivo. Recuerda que todo el código relativo a cookies, sesiones y redirecciones se debe incluir antes de emitir código HTML:

* Antes de escribir la cabecera HTML
    * Recuperar la sesión actual o crear una nueva
    * Inicializar vacía una variable de mensaje de error
    * Si el usuario ha enviado el formulario...
      * ¿El campo de usuario del formulario está vacío?
          * Sí: Actualizar la variable de error con un mensaje explicativo
          * No: Crear una variable de sesión con el nombre del usuario
* Después de la cabecera HTML
    * ¿Tiene valor la variable de sesión que contiene al usuario?
        * Sí: Mostrar el saludo al usuario
        * No: Mostrar un formulario para introducir tu nombre

    * Si el mensaje de error no está vacío, escribirlo

        ​

Cuando lo tengas funcionando, añade un enlace de "cerrar sesión" para "olvidar" al usuario. El enlace se construirá con un parámetro *cerrarSesion=true*. El posible procesamiento de este parámetro será ahora lo primero que hagas en tu programa.


##### Parte 2: Test

En este caso vamos a trabajar con varias páginas. El objetivo es presentar al usuario un test con tres preguntas: una de cine o televisión, otra de música y otra de literatura. Tú escoges las preguntas: cada una ofrecerá tres posibilidades de respuesta. Te puede ayudar poner un fondo de colores diferentes para cada pregunta.

En esta práctica se incluye un plan, pero menos detallado. Se trata de una práctica importante porque vemos una aplicación compleja, compuesta por más de una página, en la que intervienen varios formularios. 

Pista: para saber en qué fase del juego está el usuario, tienes dos alternativas que puedes combinar:

* Llevar una variable de sesión que indique en qué fase del juego estás
* Tener una variable para almacenar la respuesta de cada fase: consultando si tienen valor sabrás en qué fase estamos

Debes crear los siguientes archivos:

* `index.php`: Si no hay sesión redirigimos a `registro.php`. Si la hay, obtenemos su nombre de la sesión, le damos la bienvenida con su nombre, y aportamos un enlace para comenzar el test. Este enlace accede a `test1.php`.
* `registro.php`: Si ya hay sesión iniciada se redirige directamente a `index.php`. En caso contrario se muestra un formulario pidiendo nuestro nombre. El formulario es procesado por este mismo archivo: su misión será iniciar la sesión y crear una variable para almacenar el nombre del usuario.
* `test1.php`: si no hay sesión iniciada se redirige a `registro.php`. Si la hay, se muestra la pregunta. El formulario será procesado por esta misma página: se almacenará el acierto o fallo de esta pregunta en sesión (sin decirle aún nada al usuario) y se redirigirá a la siguiente página de test.
* `test2.php`: Igual que la anterior, pero se debe comprobar no sólo que estemos registrados sino que hayamos respondido ya la primera pregunta, en otro caso seremos redireccionados a la página adecuada.
* `test3.php`: Igual que la anterior (podrías añadir más páginas de preguntas si lo deseas). En este caso al procesar la respuesta se redirigirá a `resultados.php`
* `resultados.php`: Como siempre, si no hay sesión o nos faltan preguntas por responder, seremos redireccionados. En otro caso mostraremos el número de respuestas acertadas al usuario. Incluiremos un enlace para comenzar de nuevo (en este caso borraremos la sesión y redireccionaremos a `registro.php`)

