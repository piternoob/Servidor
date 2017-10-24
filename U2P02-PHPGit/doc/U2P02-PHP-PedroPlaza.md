###### *Desarrollo Web en Entorno Servidor - Curso 2017/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U2P02 - Fundamentos de PHP
#### Entrega de: *Pedro Plaza Ramos*
----
#### 1. Descripción:

El objetivo de la práctica es familiarizarse con el lenguaje PHP y codificar un programa en el que queden ejemplificados sus componentes y estructuras básicas, sirviendo más adelante como referencia básica.

#### 2. Formato de entrega:

Inserta el código en este documento.

#### 3. Trabajo a realizar:

Crea un proyecto *U2P02-PHP* y codifica un programa PHP en el que incluyas ejemplos propios de los elementos que se van indicando. Incluye estos apartados antes de cada prueba en forma de comentario de línea. Recuerda incluir este archivo en la carpeta `doc` dentro del proyecto:

* Comentarios de los tres tipos
 ```PHP
    // Comentario de una línea
    #  Comentario de una línea
    /*
    * Comentario de varias líneas
    */
 ```
* Sentencias echo con los dos tipos de comillas
```PHP
  echo "<p>Echo con comillas dobles</p>";
  echo "<p>Echo con comillas simples</p>";
```
* Uso de al menos tres operadores de comparación y dos operadores lógicos
```PHP
  $a=8;
  $b=8;
  if($a>=8 and $b==8)
      echo "<p>$a es mayor o igual a 8 y $b es igual a 8/p>";
  if ($a==7 or $b!=7)
      echo "<p>$a es igual 7 o $b no es igual 7</p>";
```
* Uso de un operador de asignación
```PHP
  $a=8;
  echo "<p>a vale $a</p>";
  $a+=8;
  echo "<p>a vale $a</p>";
```
* Declaración y uso de una variable por referencia
```PHP
  $a=8;
  $b=&$a;
  $a+=1;
  echo "<p>$a y $b</p>";
```
* Declaración y uso de dos constantes, una que obligue a respetar las mayúsculas en su uso y otra que no lo haga
```PHP
  define("NOMBRE", "Pedro");
 echo "<p>Mi nombre es " . Nombre . "</p>";
 echo "<p>Mi nombre es " . NOMBRE . "</p>";
 define("APELLIDO", "Plaza", true);
 echo "<p>Mi apellido es " . Apellido . "</p>";
 echo "<p>Mi apellido es " . APELLIDO . "</p>";
```
* Declaración y uso de un variable booleana y otra de tipo double
```PHP
  $boolean=true;
  $double=5.6;
  if (booleano)
      echo "<p>Booleano es $boolean</p>";
  echo "<p>Valor del double: $double</p>";
```
* Uso de is_numeric, is_bool y is_double con estas variables
```PHP
  $boolean=true;
  $double=5.6;
  if(is_numeric($boolean))
      echo "<p>$boolean es numérico.</p>";
  else
      echo "<p>$boolean no es numérico.</p>";
  if (is_bool($boolean))
      echo "<p>$boolean es boolean.</p>";
  else
      echo "<p>$boolean no es boolean .</p>";
  if(is_double($double))
      echo "<p>$double es double.</p>";
  else
      echo "<p>$double no es double.</p>";
```
* Declaración de una variable de tipo string. Pruebas con la función *strlen* y con tres de las funciones indicadas en el enlace.
```PHP
  $cadena="Esto es una cadena.";
  echo "<p>El texto '$cadena' contiene ".strlen($cadena)." caracteres.</p>";
  echo "<p>Primera letra de cada palabra en mayúsculas: ".ucwords($cadena," ")."</p>";
  echo "<p>Orden aleatorio de los cáracteres: ".str_shuffle($cadena)."</p>";
  echo "<p>Cadena invertida: ".strrev($cadena)."</p>";
```
* Declaración de un array escalar y uno asociativo
```PHP
  $escalar = array("Pedro", "Plaza", "Ramos");
  $asociativo=array("Pedro"=>10,"Edu"=>3.5,"Jose"=>7.5);
```
* Ordenación y volcado de información con *var_dump* siguiendo dos criterios de ordenación en cada uno de los arrays
```PHP
  $escalar = array("Plaza", "Ramos", "Pedro");
  $asociativo=array("Pedro"=>10,"Edu"=>3.5,"Jose"=>7.5);
  sort($escalar);
  var_dump($escalar);
  echo "<br/>";
  ksort($asociativo);
  var_dump($asociativo);
```
* Una estructura de control de cada tipo (if-elsif-else, switch, while, do-while, for)
```PHP
  $a=3;
  //if-elseif-else
  if($a>3)
      echo "<p>$a  es mayor que 3.</p>";
  elseif($a<9)
      echo "<p>$a  es menor que 3.</p>";
  else
      echo "<p>$a  es 3.</p>";
  //switch
  switch ($a){
      case 1:
          echo "<p>a vale 1.</p>";
          break;
      case 2:
          echo "<p>a vale 2.</p>";
          break;
      case 3:
          echo "<p>a vale 3.</p>";
          break;
  }
  //while
  while ($a>0){
      $a--;
      echo "<p>$a</p>";
  }
  //do while
  do {
      $a++;
      echo "<p>$a</p>";
  }while($a!=5);
  //for
  for($i=1; $i<10; $i++)
      echo "<p>$i</p>";
```
* Un recorrido por cada uno de los dos arrays utilizando foreach, generando por ejemplo una lista ordenada con sus elementos
```PHP
  $escalar = array("Plaza", "Ramos", "Pedro");
  $asociativo=array("Pedro"=>10,"Edu"=>3.5,"Jose"=>7.5);
  echo "<ol>";
  foreach ($escalar as $valor)
      echo "<li>$valor</li>";
  echo "</ol>";
  echo "<ol>";
  foreach ($asociativo as $valor)
      echo "<li>$valor</li>";
  echo "</ol>";
```
* Dos pruebas con la variable superglobal _SERVER
```PHP
  echo $_SERVER["PHP_SELF"];
  echo "<br/>";
  echo $_SERVER["HTTP_HOST"];
```
* Dos pruebas de funciones: una devolverá algun tipo, la otra no
```PHP
function restar1($a, $b) {
      $resta=$a-$b;
      echo "<p>$a-$b=$resta</p>";
  }
  function restar2($a, $b) {
      $resta=$a-$b;
      return $resta;
  }
  restar1(7, 4);
  echo "<p>7-4=".restar2(7,4)."</p>";
```
* Impresion de la fecha y hora con todo el detalle posible
```PHP
  echo "<p>Hoy es ".date("d-m-y")." y la hora es ".date("h:i-A")."</p>";
```
* Una función que utilice una variable global
```PHP
  $descuento=20;
  function comprar($cantidad) {
      $precio=20;
      global $descuento;
      $coste=$cantidad*($precio-$precio*($descuento/100));
      return $coste;
  }
  echo "<p>Coste de la compra: ".comprar(5)."</p>";
```
* Un formulario que reciba tu nombre y lo muestre por pantalla
```PHP
<html>
<head></head>
<body>
  <?php
  if(!isset($_POST["enviar"])){
  ?>
    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
    Nombre: <input type="text" name="nombre">
    <input type="submit" name="enviar">
    <?php
  } else {
    echo "<p>Bienvenido ".$_POST["nombre"].".</p>";
  }
  ?>
  </form>
</body>
</html>
```
