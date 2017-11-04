###### *Desarrollo Web en Entorno Servidor - Curso 2017/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U0P01 - Edición de documentos Markdown con Typora
----

#### 1. Descripción:
Vamos a utilizar la aplicación Typora para escribir un documento de muestra en lenguaje Markdown:  después examinaremos alternativas como Atom y MdCharm. Es importante que aprendas a manejar bien Typora y que conozcas el lenguaje Markdown, ya que cada vez se utiliza más en la web. Además, todas las prácticas de este curso se ofrecerán en este formato.

#### 2. Formato de entrega:

En la Parte 2 de este enunciado se te pedirá crear un documento Markdown. Deberás entregar un archivo comprimido en el que estén:
  - El documento Markdown propuesto con su carpeta de imágenes asociada
  - Versión exportada a HTML
  - Versión exportada a PDF

El documento incluirá al menos dos capturas de pantalla, que muestren el uso de MdCharm (parte 3) y de Atom (parte 4)

#### 3. Trabajo a realizar:

##### Parte 1:  Trabajando con Typora

1. Abre este documento con Typora.
2. Despliega la barra lateral de índice pulsando en el círculo situado en la parte inferior izquierda: comprueba que puedes acceder directamente a las diferentes partes de esta práctica, algo que te resultará útil con futuros enunciados
3. Observa que la barra lateral tiene otra funcionalidad: haz clic arriba en *Files* y encontrarás el resto de archivos de la carpeta que puede abrir Typora.
4. Oculta si lo deseas el panel lateral
5. Alterna entre la vista con formato y la vista de código fuente haciendo clic en el símbolo `</>` situadio también en la parte inferior izquierda. Comprueba que algunas opciones de los menús no están disponibles en  la vista de código fuente
6. Examina el menú *Help*, en concreto la referencia del lenguaje Markdown. Te ayudará a escribir tu documento. Observa que la propia referencia es un documento de Markdown
7. Examina el menú *Theme* y escoge el tema que más te guste
8. Examina el menú *View*: ¿qué efecto tiene activar los modos "focus" y "typewriter"?
9. En el mismo menú, averigua el atajo de teclado para alternar entre los diferentes documentos Markdown que tengas abiertos (en este momento son dos: uno es este mismo, el otro es la referencia de Markdown)

##### Parte 2: Creando un documento de ejemplo

A lo largo de esta parte crearás un documento Markdown de temática libre. Si no se te ocurre ninguna, describe tu ciclo formativo

###### Parte 2.1 Sintaxis de Markdown

1. Crea un nuevo archivo utilizando el menú *File*, y guárdalo con vuestros nombres, por ejemplo: *U0P01-LucíaPérez-JavierRuiz*. Utilizaremos este formato para futuras prácticas. Si lo deseas, por mayor claridad, incluye el título de la práctica en el nombre, por ejemplo: *U0P01-Markdown-LucíaPérez-JavierRuiz*
2. Utiliza el documento para probar las posibilidades del lenguaje. Examina el menú *Paragraph* y prueba a incluir elementos como títulos, negrita, cursiva, subrayado... Utiliza la referencia para averiguar cómo utilizar estos elementos 
3. Incluye algún bloque de código fuente de cualquier lenguaje: Java, PHP, HTML... Observa que debes incluir el nombre del lenguaje después del símbolo de inicio de bloque, por ejemplo ````java`.
4. Comprueba que una vez seleccionas un fragmento de texto, con el menú contextual (botón secundario del ratón) puedes acceder cómodamente a opciones de formato habituales. 
5. Incluye algún enlace a una web externa en el documento, por ejemplo a la normativa oficial del ciclo formativo de la Comunidad de Madrid. 
   1. El menú *Format* y el menú contextual te permiten hacerlo cómodamente. 
   2. Comprueba que si has copiado una URL en el portapapeles, al crear el enlace Typora la utilizará como destino de forma automática.
   3. Para abrir un enlace hay que utilizar la combinación Control+clic
6. Las listas son uno de los elementos más utilizados en Markdown. Crea listas no numeradas y no numeradas, y también listas anidadas (por ejemplo lista de objetivos del curso y listado de asignaturas agrupadas por curso para probar la anidación). Typora corrige automáticamente los números en las listas numeradas: compruébalo "estropeando" la numeración voluntariamente y cambiando después de código fuente a vista con formato. 
   1. Comprueba cómo con el tabulador puedes iniciar listas anidadas como esta
7. Las tablas son quizá el elemento más complejo: observa que el menú *Paragraph* te ayuda a crear una tabla cómodamente. Representa por ejemplo tu horario de clases en Markdown, e intenta conseguir el justificado que desees.

###### Parte 2.2 Imágenes

Las imágenes son el elemento más difícil de gestionar en Markdown: a diferencia de un archivo de Word o LibreOffice, la imagen no va incluida en el documento. En Markdown, al igual que en HTML, las imágenes se referencian, y por tanto si compartes el documento con alguien tienes que tener cuidado de incluir las imágenes y de escribir bien la ruta. Typora nos lo pone bastante fácil, puesto que nos permite diferentes formas de enlazarlas: 

1. Primero prueba a referenciar una imagen escribiendo el código Markdown:  `![alt](src) ` . Observa que puedes dejar la parte de texto alternativo en blanco, quedando:  `![](src) ` 
2. Ahora prueba a insertar una imagen mediante el menú *Format*.
3. Existe una sección de la ayuda dedicada a imágenes: ábrela y observa que se explican todas las posibilidades de trabajo con imágenes.
4. En esa sección verás que para permitir arrastrar imágenes a Typora o pegar una imagen desde el portapapeles, es necesario realizar un paso previo: accede a  `File` →  `Preferences` → `Image insert`  y marca la opción *Permitir copiar imágenes a carpetas*. Aprovechando que estamos aquí, marca también la opción que fuerza el uso de rutas relativas (interesante para compartir archivos con otras personas)
5. Asegúrate de haber guardado tu archivo: de lo contrario será imposible para Typora generar rutas relativas, al no saber dónde se encuentra.
6. Selecciona el menú `Edit` → `Image Tools` → `When Insert Local Images` → `Copy Image File to Folder` . Esto hará que cuando arrastres una imagen situada en cualquier parte de tu equipo, se copie a tu carpeta de trabajo: observa que esto facilita la compartición de tu documento con otras personas.
7. Comprueba ahora que puedes añadir imágenes situadas en cualquier parte o copiadas en tu portapapeles (por ejemplo un recorte de captura de pantalla). Utiliza por ejemplo imágenes relacionadas con la informática, el ciclo formativo o [el instituto](https://www.flickr.com/photos/98165337@N02/albums/).

###### Parte 2.3 Exportando el documento

Todos los editores de Markdown permiten exportar el documento como HTML, que es el formato al que mejor se adapta: recuerda que el uso principal de Markdown es la documentación, que se consulta directamente en la web. Algunos editores, como Typora, ofrecen además múltiples formatos paginados incluyendo PDF, OpenOffice o Word.

1. Exporta tu documento a HTML y comprueba las siguientes cuestiones:
   1. ¿Cómo se referencian las imágenes?
   2. ¿Cómo se mantienen los estilos?
   3. Si cambias de tema, ¿afecta a los estilos de la web generada? Prueba al menos dos temas distintos
   4. ¿En qué casos crees que resulta interesante la opción de exportación sin estilos?
2. Exporta tu documento a PDF y comprueba si hay diferencia según el tema utilizado
3. Intenta exportar el documento a formato OpenDocument (utilizado por OpenOffice y LibreOffice) o a formato de Microsoft Word: verás que se te solicita la instalación del convertidor Pandoc. Deberás reiniciar el sistema una vez instalado.
4. Convierte ahora el documento a OpenDocument y a documento de Word, comprobando si en estos casos se respetan los temas elegidos.
5. Recuerda que los editores cada vez son más versátiles y pueden manejar formatos diferentes. Abre el archivo HTML generado anteriormente con LibreOffice Writer y con Microsoft Word, comprobando que puedes editarlo con formato. 
6. El problema es que con cada una de estas conversiones se van añadiendo reglas de estilo que complican innecesariamente el documento: abre Word, crea un documento sencillo con algunos estilos o temas, y guárdalo como página web: observa el sorprendente número de reglas de estilo que se han introducido.



##### Parte 3: Alternativa: MdCharm

MdCharm es una alternativa sencilla a Typora. Si bien resulta menos satisfactoria en prácticamente todos los aspectos, es interesante que pruebes un editor de pantalla dividida (a la izquierda el código fuente, a la derecha el resultado con formato): hay usuarios que prefieren este tipo de editor, aunque a la larga es probable que acabes mirando sólo una de las dos pantallas. 

1. Descarga el editor de texto MdCharm  [desde su página web](http://www.mdcharm.com/) e instálalo en Windows o Linux (si estás realizando la práctica en un equipo de clase, escoge mejor Windows para no requerir permiso de administración)

2. Para descargarlo e instalarlo en Ubuntu (64 bits):

   ```
   sudo apt-get install libhunspell-dev
   wget https://github.com/zhangshine/MdCharm/releases/download/1.2.0/mdcharm_1.2_amd64.deb;
   sudo dpkg -i mdcharm_1.2_amd64.deb;
   sudo apt-get -f install
   ```

3. Crea un nuevo archivo Markdown (con
  extensión `.md`) y practica las posibilidades del lenguaje. Recuerda utilizar **siempre** rutas relativas para enlazar imágenes locales.

4. Localiza la *chuleta* de Markdown (*cheat sheet* en inglés) en el menú *Ayuda*

5. Examina las opciones de exportación de archivos a HTML, PDF y ODT en el menú *File*.

6. Incluye en el documento Markdown que vas a entregar una captura que muestre el uso de este editor

##### Parte 4: Alternativa: Atom

Atom es el editor más potente que vamos a probar. Es ampliamente utilizado por programadores de todo tipo de lenguajes, y gracias a sus múltiples plugins se puede personalizar muchísimo. Resulta interesante probarlo porque se utiliza en empresa como editor o para programar directamente en él, pero no lo utilizaremos en clase porque consume demasiados recursos.

1. Descarga el editor de texto Atom  [desde su página web](https://atom.io/) e instálalo en la máquina virtual con Windows 7.
2. Para instalarlo en Ubuntu (32 ó 64 bits):
```
sudo add-apt-repository ppa:webupd8team/atom
sudo apt-get update
sudo apt-get install atom
```
3. Examina los distintos temas del editor hasta encontrar el que te resulte más cómodo para trabajar.
4. Prueba y memoriza los siguientes atajos de teclado:
   * `Ctrl+May+m`: abrir la vista previa del documento actual	
   * `Ctrl+,`: abrir los ajustes de Atom
5. Instala los siguientes plugins accediendo a `Settings > Install`. Pulsando sobre el nombre del plugin puedes ir a su página web, en la que podrás averiguar su utilidad:
   * **markdown-writer**: accede después a *Packages > Markdown Writer > Open Cheat Sheet* para comprobar su instalación
   * **markdown-themeable-pdf**: convierte después a PDF pulsando en el documento con el botón secundario y escogiendo *Markdown to PDF*. Accede a los ajustes para deshabilitar la cabecera y el pie de los documentos.
   * **pdf-view**: complemento opcional interesante para visualizar los PDF recién convertidos
   * **markdown-scroll-sync**: abre después la previsualización de este documento con `Ctrl+May+m`y comprueba que al desplazarte verticalmente por él la previsualización se va desplazando también
   * **tool-bar** y **tool-bar-markdown-writer**: comprueba la aparición de la barra de botones en la parte superior (puedes cambiar su ubicación)
   * **tool-bar-main**: *(opcional)* para añadir iconos básicos de archivos.
6. *(opcional)*: si deseas utilizar los atajos de teclado indicados en la chuleta (u otros diferentes) sigue las instrucciones indicadas al inicio de la misma. Solicita ayuda al profesor si tienes dudas sobre cómo hacerlo.
7. Comprueba las opciones de exportación:
   * Exportación a PDF: botón secundario sobre el documento, `Markdown to PDF`
   * Exportación a HTML: botón secundario sobre vista previa, `Save as HTML`. Importante: las rutas de imágenes en el archivo HTML resultante serán absolutas.
   * Exportación a HTML (alternativa): accede a *Configuración > Packages > markdown-themeable-pdf > Settings* y configura la exportación a HTML. En este caso las rutas a las imágenes locales se generarán correctamente.
   * Incluye en el documento Markdown que vas a entregar una captura que muestre el uso de este editor

##### Parte 5: (opcional): Investigación de alternativas

1. Busca información y/o prueba otros plugins de Atom, comentando en clase tu experiencia con ellos. Ejemplos: `markdown-preview-plus`, `markdown-image-helper`.
2. Localiza alternativas a Typora, Atom y MdCharm y pruébalas. Ejemplos: ReText (Linux), MarkdownPad2 (Windows, versión gratuita con funcionalidad limitada), Haroopad (multiplataforma). Al elegir una aplicación, es interesante comprobar si el proyecto continúa activo o ha sido abandonado.
3. Utiliza este [proyecto de Notepad++](https://github.com/Edditoria/markdown_npp_zenburn) para añadir a este editor el resaltado de sintaxis en los archivos Markdown.

##### Nota final

Todas las prácticas del curso (y algunos temas de apuntes) se entregarán en Markdown o en HTML generado a partir de Markdown. Muchas de las prácticas requieren responder preguntas en el propio enunciado y añadir fragmentos de código o capturas de pantalla: te animamos a trabajar directamente en Markdown (con Typora, Atom o MdCharm), pero si lo prefieres (por ejemplo porque una determinada práctica requiera muchas imágenes) puedes exportar el documento para trabajar con LibreOffice Writer o Microsoft Word. En este caso convierte siempre el documento a PDF antes de entregarlo.