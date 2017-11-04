###### *Desarrollo Web en Entorno Servidor - Curso 2017/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U2P05 - Validación de formularios
#### Entrega de: *Pedro Plaza Ramos*
----
#### 1. Descripción:

El objetivo de la práctica es investigar en grupo las posibilidades de validación de formularios desde el servidor. Ten en cuenta que existen muchos otros métodos para validar directamente en cliente, ahorrando el envío y respuesta de información al servidor.

#### 2. Formato de entrega:

Rellena el apartado Memoria situado al final de este enunciado.

#### 3. Trabajo a realizar:

Codifica una aplicación web que recoja los datos de alta de un alumno, incluyendo nombre, apellidos, password, email, fecha de nacimiento, dirección, teléfono y ciclo formativo. El formulario se muestra y se procesa en el mismo archivo. Puedes incluir más datos si lo deseas.

Si el usuario introduce correctamente los datos, se mostrarán en pantalla. Si no los introduce correctamente, se volverá a mostrar el formulario pero:

* Si en un campo ha habido un problema, se mostrará un mensaje de error explicándolo, a ser posible junto al propio campo
* Se recordarán los datos que sí introdujimos correctamente

Indicaciones:

* Utiliza tipos de campos HTML 5 para el email, el teléfono, la contraseña y la fecha de nacimiento. ¿Pueden ayudar a hacer validación en cliente?
* Tú decides los criterios de seguridad que debe cumplir la contraseña para considerarse válida. Sugerencia: mínimo ocho caracteres, y que utilice minúsculas, mayúsculas y algún símbolo de puntuación



* Para recordar los valores, tendrás que recoger lo que escribió el usuario en un campo, e incluirlo como valor inicial de ese mismo campo al mostrar el formulario


* Para ver si un campo está relleno, podemos usar la función booleana *empty()*.
* Aunque la función *isset()* no sirve para campos de texto, sí es útil para botones de radio o de selección

##### Etapa 1: Formación de grupos
Esta práctica la realizaréis en grupos de dos.

##### Etapa 2: Ideas previas
Sin utilizar Internet, discutid posibles ideas para la validación y mejora de los formularios, sin llegar a implementarlas. Tomad nota de las ideas. Intentad plantear la lógica del programa (la estructura del procesamiento)

##### Etapa 3: Investigación
Utilizad Internet para investigar formas aceptadas de validación en PHP. Hablamos de técnicas sencillas, y en ningún caso de técnicas o lenguajes de cliente. A la hora de buscar fuentes, tened en cuenta:
1. La credibilidad de la fuente
2. La fecha de escritura de la información
3. La versión de PHP utilizada


##### Etapa 4: Codificación
Aplicad vuestras ideas para diseñar una aplicación en PHP que recoja datos, algunos de ellos obligatorios, y se comporte de la forma más amigable y útil posible para el usuario.

##### Etapa 5: Resultado
Código del archivo php generado:

```php+HTML

```

Captura o capturas de pantalla mostrando su funcionamiento:
