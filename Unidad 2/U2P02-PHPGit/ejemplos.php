<html>
    <head></head>
    <body>
	<?php
    //pregunta 1
    // Comentario de una línea
    #  Comentario de una línea
    /*
     * Comentario de varias líneas
     */

    //pregunta 2
    echo "<p>Echo con comillas dobles</p>";
    echo "<p>Echo con comillas simples</p>";
    
    //pregunta3
    $a=8;
    $b=8;
    if($a>=8 and $b==8)
        echo "<p>$a es mayor o igual a 8 y $b es igual a 8/p>";
    if ($a==7 or $b!=7)
        echo "<p>$a es igual 7 o $b no es igual 7</p>";
    
    //pregunta 4
    $a=8;
    echo "<p>a vale $a</p>";
    $a+=8;
    echo "<p>a vale $a</p>";
    
    //pregunta 5
    $a=8;
    $b=&$a;
    $a+=1;
    echo "<p>$a y $b</p>";
    
    //pregunta 6
    define("NOMBRE", "Pedro");
    echo "<p>Mi nombre es " . Nombre . "</p>";
    echo "<p>Mi nombre es " . NOMBRE . "</p>";
    define("APELLIDO", "Plaza", true);
    echo "<p>Mi apellido es " . Apellido . "</p>";
    echo "<p>Mi apellido es " . APELLIDO . "</p>";
    
    //pregunta 7
    $boolean=true;
    $double=5.6;
    if (booleano)
        echo "<p>Booleano es $boolean</p>";
    echo "<p>Valor del double: $double</p>";
    
    //pregunta 8
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
    
    //pregunta 9
    $cadena="Esto es una cadena.";
    echo "<p>El texto '$cadena' contiene ".strlen($cadena)." caracteres.</p>";
    echo "<p>Primera letra de cada palabra en mayúsculas: ".ucwords($cadena," ")."</p>";
    echo "<p>Orden aleatorio de los cáracteres: ".str_shuffle($cadena)."</p>";
    echo "<p>Cadena invertida: ".strrev($cadena)."</p>";
    
    //pregunta 10
    $escalar = array("Pedro", "Plaza", "Ramos");
    $asociativo=array("Pedro"=>10,"Edu"=>3.5,"Jose"=>7.5);
    
    //pregunta 11
    $escalar = array("Plaza", "Ramos", "Pedro");
    $asociativo=array("Pedro"=>10,"Edu"=>3.5,"Jose"=>7.5);
    sort($escalar);
    var_dump($escalar);
    echo "<br/>";
    ksort($asociativo);
    var_dump($asociativo);
    
    //pregunta 12
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
    
    //pregunta 13
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
    
    //pregunta 14
    echo $_SERVER["PHP_SELF"];
    echo "<br/>";
    echo $_SERVER["HTTP_HOST"];
    
    //pregunta 15
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
    
    //pregunta 16
    echo "<p>Hoy es ".date("d-m-y")." y la hora es ".date("h:i-A")."</p>";
    
    //pregunta 17
    $descuento=20;
    function comprar($cantidad) {
        $precio=20;
        global $descuento;
        $coste=$cantidad*($precio-$precio*($descuento/100));
        return $coste;
    }
    echo "<p>Coste de la compra: ".comprar(5)."</p>";
    ?>
</body>
</html>