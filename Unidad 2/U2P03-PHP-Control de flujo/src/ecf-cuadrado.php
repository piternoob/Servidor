<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 10</title>
</head>
<body>
<a href="index.php">Volver</a>
<?php
if(!isset($_POST["enviar"])){
?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
	<p>Pedir un número X y generar un cuadrado como el que se muestra en la figura (en este caso X vale 10). Una vez resuelto, mejorarlo para que las filas pares salgan en un color más claro (lightblue por ejemplo) para facilitar la lectura. En la figura se ha usado un “padding” de 3 para los elementos de celda (td).
	</p>
	Numero: <input type="text" name="numero">
    <br/>
    <input type="submit" name="enviar">
    <?php
    } elseif(!empty($_POST["numero"])) {
        $numero=$_POST["numero"];
        if ($numero<0) {
            $numero*=-1;
        }
        
        ?>
		<table cellpadding="3" border="1">
        <?php
    for ($i = 1; $i <= $numero; $i ++) {
        if ($i % 2 == 0) {
            ?>
			<tr bgcolor="lightblue">
        <?php
        } else {
            ?>
        <tr>
			<?php
        }
        for ($j = 1; $j <= $numero; $j ++) {
            ?>
			<td>
        <?php
            echo $i * $j;
            ?>
        </td>
			<?php
        }
        echo "</tr>";
    }
    
    ?>
        </table>        
        <?php
    } else {
        echo "<p>No ha introducido un valor.</p>";
    }
    ?>
</body>
</html>