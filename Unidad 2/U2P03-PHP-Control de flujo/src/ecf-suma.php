<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 2</title>
</head>
<body>
	<a href="index.php">Volver</a>
	<?php
if (! isset($_POST["enviar"])) {
    ?>
	<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>"
		method="post">
		<p>Pedir un número X y calcular la suma de los X primeros números
			naturales (1 + 2 + 3 + …).</p>
		Número: <input type="text" name="numero"> <br /> <input type="submit"
			name="enviar">
    <?php
} elseif (is_numeric($_POST["numero"])) {
        $numero = $_POST["numero"];
        $suma = 0;
        if ($numero < 0) {
            $numero *= - 1;
        }
        for ($i = 0; $i <= $numero; $i ++) {
            $suma += $i;
        }
        echo "<p>La suma de los $numero primeros números es: $suma</p>";
    } else {
        echo "<p>No has introducido un número.</p>";
    }
    ?>
</form>
</body>
</html>