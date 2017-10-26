<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 6</title>
</head>
<body>
<a href="index.php">Volver</a>
<?php
if(!isset($_POST["enviar"])){
?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
<p>Pedir una cadena de texto y mostrarla varias veces: en cada línea se mostrará un carácter menos que en la anterior. Sólo se puede usar una función de strings: “strlen()”</p>
    Cadena: <input type="text" name="cadena">
    <br/>
    <input type="submit" name="enviar">
    <?php
} elseif(!empty ($_POST["cadena"])  || $_POST["cadena"]==0) {
        $cadena=$_POST["cadena"];
        $aux;
        for ($i = 0; $i < strlen($cadena); $i++) {
            $aux;
            echo "<p>";
            for ($j = 0; $j < (strlen($cadena)-$i); $j++) {
                echo "$cadena[$j]";
            }
            echo "</p>";
        }
    } else {
        echo "<p>No se ha introducido una cadena.</p>";
    }
    ?>
</body>
</html>