<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 6</title>
</head>
<body>
<a href="index.php">index.php</a>
<?php
if(!isset($_POST["enviar"])){
?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
    Cadena: <input type="text" name="cadena">
    <input type="submit" name="enviar">
    <?php
    } else {
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
    }
    ?>
</body>
</html>