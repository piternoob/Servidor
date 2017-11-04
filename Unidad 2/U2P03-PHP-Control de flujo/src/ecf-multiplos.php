<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 9</title>
</head>
<body>
<a href="index.php">Volver</a>

<p>Mostrar en pantalla los múltiplosde 3 y 5 entre el 1 y el 1000. A continuación mostrar en pantalla los 20 primeros múltiplos de 3 y 5.</p>
    <?php
        $tres=3;
        $cinco=5;
        $contadorTres=0;
        $contadorCinco=0;
        echo "<p>Múltiplos de 3:</<p>";
        echo "<p>";
        for ($i = 0; 1000>=$tres*$i; $i++) {
            echo $tres*$i." ";
        }
        echo "</p>";
        echo "<p>Múltiplos de 5:</<p>";
        echo "<p>";
        for ($i = 0; 1000>=$cinco*$i; $i++) {
            echo $cinco*$i." ";
        }
        echo "</p>";
        
        echo "<p>20 primeros múltiplos de 3:</<p>";
        echo "<p>";
        for ($i = 0; $contadorTres<20; $i++) {
            $contadorTres++;
            echo $tres*$i." ";
        }
        echo "</p>";
        echo "<p>20 primeros múltiplos de 5:</<p>";
        echo "<p>";
        for ($i = 0; $contadorCinco<20; $i++) {
            $contadorCinco++;
            echo $cinco*$i." ";
        }
        echo "</p>";
    ?>
</body>
</html>