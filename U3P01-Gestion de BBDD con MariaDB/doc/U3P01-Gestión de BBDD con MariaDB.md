###### *Desarrollo Web en Entorno Servidor - Curso 2017/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U3P01 - Gestión de bases de datos con MariaDB
#### Entrega de: *pon aquí tu nombre*
----
#### 1. Descripción:

El recurso más habitual para almacenar los datos de una aplicación web son los motores de bases de datos. Utilizaremos MariaDB (en la práctica idéntico a MySQL) como base para nuestras aplicaciones PHP y JavaEE. A lo largo de esta actividad repasaremos su funcionamiento, crearemos dos bases de datos de muestra y aprenderemos a administrarlas utilizando herramientas gráficas.

#### 2. Formato de entrega:

Incluye al final el script SQL de tu base de datos *catalogo*.
También puedes incluir capturas de pantalla en este documento, en aquellos puntos en los que creas conveniente para ilustrar el progreso de tu trabajo.

#### 3. Trabajo a realizar:

##### Parte 1: Configuración de phpMyAdmin

* En tu máquina virtual de Windows, abre el panel de control de XAMPP e inicia los componentes *Apache* y *MySQL*. Observa que en XAMPP no se han modificado en muchos casos las referencias al nombre del motor, pero internamente está funcionando MariaDB.
* XAMPP incluye una de las herramientas más utilizadas para administrar bases de datos: phpMyAdmin. Se encuentra en una carpeta con el mismo nombre dentro del directorio de instalación de XAMPP: localízala.
* En teoría, al acceder a `localhost/phpMyAdmin` deberíamos acceder a la aplicación. El problema es que hemos configurado Apache para utilizar nuestra carpeta de repositorio Git como raíz del servidor web, y ahora la carpeta de instalación de XAMPP, con todas sus aplicaciones, queda inaccesible. Apache aporta una solución para este tipo de problemas: los *alias*, que permiten asociar una carpeta de nuestro ordenador a una URL que *parezca* estar dentro de nuestra carpeta raíz.
* Abre el archivo de configuración `httpd-xampp.conf` dentro de la carpeta `/xampp/apache/conf/extra`. Localiza la sección dedicada a phpMyAdmin, que tendrá este aspecto:

```xml
Alias /phpmyadmin "C:/xampp/phpMyAdmin/"
<Directory "C:/xampp/phpMyAdmin">
    AllowOverride AuthConfig
    Require local
    ErrorDocument 403 /error/XAMPP_FORBIDDEN.html.var
</Directory>
```
* Observa que los desarrolladores de XAMPP ya han previsto esta situación y comprueba que accediendo a `http://localhost/phpmyadmin` (las minúsculas deben ser respetadas) podemos tener acceso a la aplicación.
* (Opcional) Si realizaste la configuración de XAMPP para trabajar desde la máquina real, intenta ahora acceder a la aplicación desde la máquina real haciendo uso de la redirección de puertos que teníamos creada: `localhost:8000/phpmyadmin`. En este caso obtendrás un error de seguridad de XAMPP, indicando que no tienes permisos para acceder. La solución es cambiar `Require local` por `Require all granted`. Ten en cuenta que esto hará accesible tu aplicación al resto de compañeros: si esto es un problema para ti, puedes poner una contraseña para el usuario `root` (recuerda que inicialmente no la lleva).
* Reinicia el servidor Apache tras realizar cualquier cambio en la configuración
* Localiza en la sección *Servidor de bases de datos* la versión de MariaDB que estás utilizando.
* En la pestaña *Bases de datos* tienes las bases de datos del motor, que inicialmente son únicamente aquellas que contienen la configuración del motor y de la propia aplicación phpMyAdmin, así como una de prueba (*test*) que se encuentra vacía.
* Accede a la pestaña *Cuentas de usuario* y analiza los permisos: el usuario *root* tiene permisos para manipular la base de datos desde el equipo en el que está instalado el servidor (este) y no necesita contraseña para ello. Mantendremos esta configuración, puesto que resulta cómoda para el entorno de pruebas. Sin embargo, nunca utilizaremos el usuario administrador para acceder desde la aplicación web.

##### Parte 2: Instalación de HeidiSQL
* HeidiSQL es sólo uno de los clientes gráficos para administrar bases de datos, pero es probablemente el más popular y viene incluido con la instalación estándar de MariaDB. Puesto que nosotros no hemos instalado MariaDB manualmente (sino a través de XAMPP) no lo tenemos, así que accede a [www.heidisql.com](www.heidisql.com) y descarga el instalador
* Instala HeidiSQL en tu máquina Windows y ejecútalo
* Conéctate con los siguientes datos:
  * Tipo de red: MySQL (TCP/IP)
  * No pedir credenciales
  * Nombre del host / IP: 127.0.0.1 o localhost
  * Usuario: root
  * Sin contraseña
* Observa las bases de datos, que aquí aparecen en la ventana izquierda.
* Accede a la sesión de cuentas de usuario con el icono situado en la parte superior y comprueba que vemos los mismos permisos que con phpMyAdmin

A partir de ahora realizaremos acciones de administración sobre el motor de bases de datos. Puedes realizarlas indistintamente utilizando phpMyAdmin, HeidiSQL o, si lo prefieres, una combinación de ambos. En los apuntes se asumirá el uso de phpMyAdmin, únicamente porque hay que elegir uno, y este presenta la ventaja de ser multiplataforma al funcionar como aplicación web. HeidiSQL puede instalarse en Linux, pero para ello requiere utilizar [Wine](https://wiki.winehq.org/FAQ#Is_Wine_an_emulator.3F_There_seems_to_be_disagreement).

##### Parte 3: Creación de usuarios en MariaDB

* Hac clic en la pestaña *Cuentas de usuarios* de phpMyAdmin. Vamos a crear dos cuentas de usuario para utilizar desde nuestras aplicaciones web: una tendrá permisos de lectura y escritura, y otra sólo de lectura. Se aconseja que sólo se utilice la cuenta con permiso de escritura cuando sea necesario: el motivo es que si se descubre nuestra contraseña, será menos dañino si el usuario descubierto no puede modificar la base de datos. En realidad podríamos afinar mucho más y crear usuarios específicos para manejar determinadas tablas o bases de datos, pero vamos a simplificar y utilizar simplemente esos dos.
* Haz clic en *Nuevo > Agregar cuentas de usuario* dentro de la sección *Cuentas de usuarios*
* En la sección *Información de la cuenta*, introduce los datos de usuario (**alumno**) y contraseña (alumno), y en *Nombre de host* debes seleccionar *Local* o escribir manualmente *localhost*. De lo contrario no funcionarán los privilegios que apliques.
* En la sección *Privilegios globales* marca únicamente *SELECT*.
* Comprueba en el panel de control de usuarios la aparición de la nueva cuenta.
* Repite los pasos para crear la cuenta **alumno_rw**, con contraseña *dwes*. En este caso marca en privilegios todas las casillas de *Datos* y *Estructura* para el usuario *alumno_rw*. Observa que estamos dando a este usuario muchos más permisos de los que necesitará, pero el objetivo es simplificar las pruebas.
* Profesor y alumnos utilizaremos estos usuarios en todas nuestras prácticas y exámenes. No cambies por tanto los nombres o contraseñas, de esta forma el profesor podrá poner en marcha tus aplicaciones usando las mismas credenciales

##### Parte 4: Creación de bases de datos

* Utilizando phpMyAdmin o HeidiSQL, crea una base de datos **catalogoXX**, siendo XX tu número de equipo. Ten mucho cuidado ya que el juego de caracteres por defecto es *latin1_swedish_ci*, seguramente por provenir MySQL y MariaDB de Suecia. Debes cambiarlo a UTF8 internacional (*utf8mb4_unicode_ci*) o español (*utf8mb4_spanish_ci*)
* Dentro de la nueva base de datos crea una tabla con el nombre **usuario** (en singular) que tendrá cinco campos (columns):
  * login: tipo VARCHAR, máximo 10 caracteres. Índice PRIMARY (clave primaria)
  * password: tipo VARCHAR, máximo 15 caracteres
  * nombre: tipo VARCHAR, máximo 25 caracteres
  * admin: tipo BOOLEAN, valor predeterminado personalizado: *false*
  * descripcion: tipo TEXT, marcar *nulo* para que sea opcional rellenarlo.
    Si te faltan campos en la plantilla, puedes añadirlos haciendo clic en *Add 1 column* en la parte superior
* Ahora haz clic en la tabla *usuario* en el menú de la izquerda, y haz clic en la pestaña *Insertar* del menú superior. Ten en cuenta estas indicaciones para añadir valores a tu base de datos:
  * Incluye un usuario administrador, que llevará tu nombre
  * Para evitar olvidos, la contraseña será la misma que el login, aunque sepamos que esa es una práctica muy poco recomendable
  * Ten en cuenta que los valores booleanos en SQL se indican como un bit (0=false, 1=true)

  Ejemplo de datos (adáptalos como quieras):
  * admin, Alberto Ruiz, cuenta de administrador
  * lenamorado, Luis Enamorado
  * ariego, Almudena Riego
* Ahora crea dos nuevas tablas, **obra** y **autor**. Aquí incluirás los datos para las aplicaciones de ejemplo que desarrollarás en el resto del curso. Puedes elegir algún tema que te guste: películas, series, discos, libros, comics, videojuegos... Las obras tendran un campo que contendra el identificador del autor (clave ajena). Puedes cambiar el nombre y la temática de las tablas si no encaja con tu contenido, siempre que haya dos tablas relacionadas. Consulta al profesor si tienes dudas o si quieres plantear un tipo de contenido diferente.

* Incluye un campo para almacenar una imagen por cada elemento del catálogo y opcionalmente por cada autor. Observa que únicamente almacenaremos en este campo el nombre del archivo de la imagen: más adelante situaremos todas las imágenes en una carpeta *img* dentro del contexto de nuestra aplicación, y construiremos la ruta a la imagen concatenando esa ruta de la carpeta con el nombre del archivo incluido en este campo de la base de datos.

*  Puedes hacer ahora una primera versión de tu base de datos e irla depurando y ampliando más adelante.

##### Parte 5: Importación y exportación de bases de datos

Si trabajas con Git, estarás pensando que necesitaremos una forma de traspasar nuestras bases de datos entre una máquina y otra. La forma de hacerlo será utilizar scripts SQL, generados de forma inmediata por los gestores de administración (phpMyAdmin o HeidiSQL). Existen aplicaciones de terceros para trabajar con Git y bases de datos, pero nosotros utilizaremos únicamente los scripts, que por otra parte puedes compartir en Git como archivos de texto.

* En phpMyAdmin, haz clic en la base de datos *catalogo*. Ahora selecciona *Exportar* en el menú superior. Haz clic en *Continuar* sin modificar ninguna opción y obtendrás el archivo con todas las órdenes SQL necesarias para restaurar la base de datos.
* Ahora escoge *Operaciones* en el menú superior, y elimina la base de datos completamente.
* En la pestaña *Importar* carga el archivo y comprueba que surge un error al no existir la base de datos *catalogo*
* Crea manualmente la base de datos *catalogo* (recuerda escoger correctamente el juego de caracteres) y repite la importación del script SQL: todo debería salir bien.
* Vuelve a realizar el proceso de exportación, pero esta vez selecciona *Método de exportación: personalizado*. Analiza las opciones que aparecen, y marca la casilla que indica *Agregar sentencia CREATE DATABASE / USE*. Exporta la basde de datos.
* Elimina de nuevo la base de datos e importa el script. Ahora habrá salido bien, ya que el script incorpora la creación de la propia base de datos.
* Importa ahora la base de datos *animales* a partir del script proporcionado en la carpeta de Recursos de esta unidad.
* Añade un campo a la base de datos para incluir las imágenes de los animales.

En phpMyAdmin tienes una pestaña SQL en la que puedes ejecutar cualquier código SQL, incluido el de los scripts. Esto es una alternativa a cargar el fichero, y sirve también para realizar todo tipo de consultas.

Recuerda que puedes probar a realizar todas estas acciones con el cliente gráfico HeidiSQL.

A partir de ahora en nuestras prácticas y exámenes incluiremos una carpeta `sql ` dentro de la estructura de nuestros proyectos, en la que incluiremos el script con la base de datos necesario para hacer funcionar la aplicación.

#### 4. Resultado final:  

Código del script generado al exportar tu base de datos **catalogo**:

```sql

```
