<html>
	<head>
		<meta charset="UTF-8" />
		<meta name="author" content="Pedro Plaza Ramos" />
		<title>Pruebas PHP</title>
	</head>
	<body>
		<?php
            //Ejemplo echo
            /*$nombre = "Pedro";
            $apellido = "Plaza";
            echo "<h1>Funciona</h1>\n";
            echo "<h3>Comillas dobles: Mi nombre $nombre y mi apellido $apellido</h3>";
            echo '<h2>Comillas simples: Mi nombre $nombre y mi apellido $apellido</h2>';*/
            
            //Constantes
            /*define("NOMBRE", "Pedro Plaza");
            echo "<p>Mi nombre es " . Nombre . "</p>";
            define("NOMBRE", "Pedro Plaza", true);
            echo "<p>Mi nombre es " . Nombre . "</p>";*/
            
            //Operadores matemáticos
    		/*$a = 10;
    		$b = 1;
            $a += $b;
            echo "<p>Suma: $a</p>";
            $a -= $b;
            echo "<p>Resta: $a</p>";
            $a *= $b;
            echo "<p>Multiplicación: $a</p>";
            $a /= $b;
            echo "<p>División: $a</p>";
            $a .= $b;
            echo "<p>Concatenar: $a</p>";*/
            
            //If
            /*$a = 10;
		    $b = 1;
            if($a>$b):
                echo "<p>Hola</p>";
                echo "<p>Hi</p>";
            elseif ($a<$b):
                echo "<p>Adios</p>";
            else:
                echo "<p>Hola y adios</p>";
            endif;
            
            if ($a > $b) {
                echo "<p>Hola</p>";
                echo "<p>Hi</p>";
            } elseif ($a < $b)
                echo "<p>Adios</p>";
            else
                echo "<p>Hola y adios</p>";*/
		    
		    //for
		    /*for ($i=0; $i<10; $i++){
		        echo "<p>$i</p>";
		    }
		    for ($i=0; $i<10; $i++):
		        echo "<p>$i$i</p>";
		    endfor;*/
		
		    //isset
		    /*$a=7;
		    $b="";
		    $c=null;
		    $d;
		    if(isset($a)){
		        echo "<p>Hola A</p>";
		    } else {
		        echo "<p>Adios A</p>";
		    }
		    if(isset($b)){
		        echo "<p>Hola B</p>";
		    } else {
		        echo "<p>Adios B</p>";
		    }
		    if(isset($c)){
		        echo "<p>Hola C</p>";
		    } else {
		        echo "<p>Adios C</p>";
		    }
		    if(isset($d)){
		        echo "<p>Hola D</p>";
		    } else {
		        echo "<p>Adios D</p>";
		    }*/
		
		    //strlen
		    /*$cadena="Esto es una cadena.";
		    $longitud="a";
		    echo "<p>El texto '$cadena' contiene ".strlen($cadena)." caracteres.</p>";
		    echo "<h3>Primer carácter: ".$cadena[0]."</h3>";
		    echo "<h3>Último carácter: ".$cadena[strlen($cadena)-1]."</h3>";
		    echo "<h3>Primera letra de cada palabra en mayúsculas: ".ucwords($cadena," ")."</h3>";
		    echo "<h3>Orden aleatorio de los cáracteres: ".str_shuffle($cadena)."</h3>";*/
		
		    //arrays
		    $array1 = array("Pedro", "Plaza", "Ramos");
		    $array2 = array(0=>"Pedro", 1=>"Plaza", 4=>"Ramos");
		    $array3[0]="Pedro";
		    $array3[1]="Plaza";
		    $array3[4]="Ramos";
		    echo "<p>Tamaños de los arrays con sizeof: 1- ".sizeof($array1).", 2- ".sizeof($array2).", 3- ".sizeof($array3).".</p>";
		    echo "<p>Tamaños de los arrays con count: 1- ".count($array1).", 2- ".count($array2).", 3- ".count($array3).".</p>";
		    for($i=0; $i<sizeof($array1); $i++){
		        echo "<p>$array1[$i]</p>";
		    }
		    for($i=0, $contador=0; $contador<sizeof($array2); $i++){
		        if(isset($array2[$i])){
		          echo "<p>$array2[$i]</p>";
		          $contador++;
		        }
		    }
        ?>
	</body>
</html>