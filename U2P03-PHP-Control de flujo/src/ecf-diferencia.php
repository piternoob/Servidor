<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 1</title>
</head>
<body>
<a href="index.php">Volver</a>
<?php
if(!isset($_POST["enviar"])){
?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
	<p>Pedir al usuario dos números A y B entre el 1 y el 10. Escribir en pantalla tantos asteriscos 
	como diferencia haya entre los números (resolviéndolo con while, mientras uno sea menor que otro 
	se escribe asterisco) y repetir con almohadillas (resolviéndolo con for utilizando la diferencia 
	entre a y b como número de repeticiones).</p>
    Número A: <input type="text" name="menor">
    <br/>
    Número B: <input type="text" name="mayor">
    <br/>
    <input type="submit" name="enviar">
    <?php
    } elseif (is_numeric($_POST["menor"]) && is_numeric($_POST["mayor"])) {
            $menor = $_POST["menor"];
            $mayor = $_POST["mayor"];
            $aux;
            $auxMenor;
            $auxMayor;
            echo "<p>Numeros elegidos: $menor y $mayor.</p>";
            if ($menor < 1 || $menor > 10 || $mayor < 1 || $mayor > 10) {
                echo "<p>Los números tienen que estar comprendidos entre 1 y 10.</p>";
            } else {
                if ($mayor < $menor) {
                    $aux = $menor;
                    $menor = $mayor;
                    $mayor = $aux;
                }
                $auxMenor = $menor;
                $auxMayor = $mayor;
                echo "<p>";
                while ($mayor != $menor) {
                    echo "*";
                    $mayor --;
                }
                echo "</p>";
                echo "<p>";
                for ($i = $auxMenor; $i < $auxMayor; $i ++) {
                    echo "#";
                }
                echo "</p>";
            }
        } else {
            echo "<p>No has introducido dos números.</p>";
        }
?>
</form>
</body>
</html>