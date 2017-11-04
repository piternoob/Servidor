<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 3</title>
</head>
<body>
<a href="index.php">Volver</a>
<?php
if(!isset($_POST["enviar"])){
?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
<p>Pedir dos números A y B y calcular la potencia A elevado a B utilizando iteraciones (no una función matemática predefinida).</p>
    Número: <input type="text" name="numero">
    <br/>
    Exponente: <input type="text" name="exponente">
    <br/>
    <input type="submit" name="enviar">
    <?php
} elseif (is_numeric($_POST["numero"]) && is_numeric($_POST["exponente"])) {
        $numero = $_POST["numero"];
        $exponente = $_POST["exponente"];
        $potencia = 1;
        for ($i = 1; $i <= $exponente; $i ++) {
            $potencia *= $numero;
        }
        echo "<p>La pontencia de $numero al $exponente es: $potencia</p>";
    } else {
        echo "<p>No has introducido dos números.</p>";
    }
?>
</form>
</body>
</html>