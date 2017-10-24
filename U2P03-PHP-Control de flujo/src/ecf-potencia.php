<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 3</title>
</head>
<body>
<a href="index.php">index.php</a>
<?php
if(!isset($_POST["enviar"])){
?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
    Número: <input type="text" name="numero">
    Exponente: <input type="text" name="exponente">
    <input type="submit" name="enviar">
    <?php
    } else {
        $potencia=1;
        for ($i=1; $i<=$exponente; $i++){
            $potencia*=$numero;
        }
        echo "<p>La pontencia de $numero al $exponente es: $potencia</p>";
    }
    ?>
</form>
</body>
</html>