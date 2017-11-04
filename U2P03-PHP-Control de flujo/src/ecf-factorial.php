<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 4</title>
</head>
<body>
<a href="index.php">Volver</a>
<?php
if(!isset($_POST["enviar"])){
?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
	<p>Pedir un número X y calcular su factorial utilizando iteraciones.</p>
    Número: <input type="text" name="numero">
    <br/>
    <input type="submit" name="enviar">
    <?php
    } elseif(is_numeric($_POST["numero"])) {
        $numero=$_POST["numero"];
        $factorial=1;
        if ($numero<0){
            $numero*=-1;
        }
        for($i=1; $i<=$numero; $i++){
            $factorial*=$i;
        }
        echo "<p>El factorial del número $numero es: $factorial</p>";
    } else {
        echo "<p>No se ha introducido un número.</p>";
    }
    ?>
</form>
</body>
</html>