<!DOCTYPE html>
<?php 
/*Alberto Ruiz [14:18]
Propuesta de plan para el tratamiento de formulario:


[14:18]
completado = false
si se ha pulsado Enviar (hay datos)
> Anotar los datos recibidos en variables
> Validar: si todo está bien, completado = true

si completado == true
> Mostrar datos, continuar con la aplicación
en otro caso
> Mostrar el formulario, teniendo en cuenta:
* Recordar los campos que el usuario ya había rellenado (esto es muy apreciado por el usuario)
* Mostrar los mensajes de error correspondientes


[14:18]
Conviene hacer la validación en funciones, para poder reutilizarlas en futuros programas*/
?>
<html>
<head>
	<meta charset="UTF-8" />
</head>
<body>
<?php 
$completado=false;
if(isset($_POST["enviar"])){
    $nombre=$_POST["nombre"];
    $apellidos=$_POST["apellidos"];
    $edad=$_POST["edad"];
    $fecha=$_POST["fecha"];
    $correo=$_POST["correo"];
    $telefono=$_POST["telefono"];
    $municipio=$_POST["municipio"];
    $postal=$_POST["postal"];
    $pass=$_POST["pass"];
    $ciclo=$_POST["ciclo"];
    $direccion=$_POST["direccion"];
    /*if(validar) completado=true;*/
}
if ($completado){
    echo "<p>Datos:</p>";
    echo "<ul>";
    echo "<li>Nombre: $nombre</li>";
    echo "<li>Apellidos: $apellidos</li>";
    if (! empty($edad))
        echo "<li>Edad: $edad</li>";
    echo "<li>Fecha: $fecha</li>";
    echo "<li>Correo: $correo</li>";
    if (! empty($telefono))
        echo "<li>Telefono: $telefono</li>";
    if (! empty($municipio))
        echo "<li>Municipio: $municipio</li>";
    if (! empty($postal))
        echo "<li>Postal: $postal</li>";
    echo "<li>Pass: $pass</li>";
    echo "<li>Ciclo: $ciclo</li>";
    if (! empty($direccion))
        echo "<li>Direccion: $direccion</li>";
    echo "</ul>";
} else {
    ?>
    <h2>Introduzca sus datos personales.</h2>
    <form
    action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"], ENT_QUOTES, "UTF-8");?>"
        method="post">
        <table border="1">
        <tr>
        <td>Nombre: <input type="text" name="nombre" value="<?php echo $nombre; ?>" required>
        </td>
        <td>Apellidos: <input type="text" name="apellidos" value="<?php echo $apellidos; ?>"required>
        
        </td>
        </tr>
        <tr>
        <td>Edad: <input type="number" max="120" name="edad" value="<?php echo $edad; ?>">
        
        </td>
        <td>Fecha de Nacimiento: <input type="date" name="nacimiento" required></td>
        </tr>
        <tr>
        <td>Correo: <input type="text" name="correo" value="<?php echo $correo; ?>" required>
        <?php
        if(filter_var($correo, FILTER_VALIDATE_EMAIL)==false){
            echo "El email es incorrecto";
    }
    ?>
                </td>
				<td>Telefono: <input type="number" name="telefono" value="<?php 
				if(preg_match($expresion, $telefono)){
				    echo $telefono;
				}
				 ?>">
				</td>
			</tr>
			<tr>
				<td>Municipio: <input type="text" name="municipio" value="<?php echo $municipio; ?>"></td>
				<td>Codigo Postal: <input type="number" min="9999" max="99999" name="postal"value="<?php echo $postal; ?>"></td>
			</tr>
			<tr>
				<td>Contraseña: <input type="password" name="pass" required>
                <?php 
                if(strlen($pass)>9 || strlen($pass)<3){
                    echo "La contraseña debe tener entre 4 y 8 digitos";
                }
                ?></td>
				<td>Ciclo Formativo: <select name="ciclo">
               <option value="nini" selected="selected ">Sin estudios</option>
               <option value="galacticos">Diseño y desarrollo de apps web</option>
               <option value="niñeras">Formación Infantil</option>
               <option value="modernos">Diseño</option>
               <option value="tochos">Dietética</option></td>
			</tr>
			<tr>
				<td colspan="2">Dirección: <input type="text" name="direccion"></td>
			</tr>
		</table>
		<input type="submit" name="enviar" value="Enviar Datos">
    </form>
    <?php 
}
?>
</body>
</html>