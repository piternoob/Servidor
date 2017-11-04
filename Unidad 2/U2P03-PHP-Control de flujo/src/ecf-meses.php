<!doctype html>
<html>
<meta charset="UTF-8"/>
<meta name="author" content="Pedro Plaza Ramos" />
<title>Parte 7</title>
</head>
<body>
<a href="index.php">Volver</a>
<?php
if(!isset($_POST["enviar"])){
?>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>" method="post">
<p>En un formulario se recogerá un valor en un cuadro de texto y un radio group para indicar si el año actual es bisiesto o no. Habrá que comprobar si el valor leído corresponde al número de un mes (de 1 a 12) o a su nombre (“enero”, “febrero”). Si es así se mostrará el número de días que tiene ese mes, y si no es así se mostrará un error. Nota:para comparar String, busca referencia de las funciones strcmp y strcasecmp.</p>
    Mes: <input type="text" name="mes">
    <br/>
    Es bisiesto: <input type="radio" name="bisiesto" value="si">
    <br/>
    No es bisiesto: <input type="radio" name="bisiesto" value="no" checked="checked">
    <br/>
    <input type="submit" name="enviar">
    <?php
    } elseif(!empty($_POST["mes"])) {
        $mes=$_POST["mes"];
        $bisiesto=$_POST["bisiesto"];
        $mes=strtolower($mes);
        switch ($mes) {
            case 1: case "enero":
            case 3: case "marzo":
            case 5: case "mayo":
            case 7: case "julio":
            case 8: case "agosto":
            case 10: case "octubre":
            case 12: case "diciembre":
                echo "<p>El mes tiene 31 días.</p>";
                
            break;
            case 2: case "febrero":
               
                if ($bisiesto=="si") {
                    echo "<p>El mes tiene 29 días.</p>";
                } else {
                   echo "<p>El mes tiene 28 días.</p>";
                }
                
                break;
                
             case 4: case "abril":
             case 6: case "junio":
             case 9: case "septiembre":
             case 11: case "noviembre":
                echo "<p>El mes tiene 30 días.</p>";
                break;
                 
            default:
                echo "<p>No es un mes válido.</p>";
            break;
        }
    } else {
        echo "<p>No ha introducido un valor.</p>";
    }
    ?>
</body>
</html>