<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
</head>
<body>
<?php 
if (!isset($_POST["enviar"])){
    $nombre="";
    $apellidos="";
    $edad="";
    $telefono="";
    $municipio="";
    $postal="";
    $correo="";
  
    
} else {
    $nombre=$_POST["nombre"];
    $apellidos=$_POST["apellidos"];
    $edad=$_POST["edad"];
    $telefono=$_POST["telefono"];
    
    $expresion = '/^[9|6|7][0-9]{8}$/';
    
    if(preg_match($expresion, $telefono)){
        echo 'El telefono es correcto';
    }else{
        $telefono="";
    }
    
    
    
    $municipio=$_POST["municipio"];
    $postal=$_POST["postal"];
    $correo=$_POST["correo"];
    

}
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
				<td>ContraseñaEDUFELIX: <input type="password" name="pass" required></td>
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

?>
   
</body>
</html>