<?php
function comprobarCorreo($param) {
    $valido=false;
    
    if (!filter_var($param, FILTER_VALIDATE_EMAIL) === false) {
        $valido=true;
    }else{
        echo 'Correo no válido';
    }
    return $valido;
}
function comprobarFecha ($param) {
    
    $exp='/(0[1-9]|1[0-9]|2[0-9]|3[01])(-|\/)([1-9]|0[1-9]|1[012]).[0-9]{4}/';
    $valido=true;
    
    if ( !preg_match($exp, $param) ) {
        echo 'Fecha inválida';
        $valido=false;
    }
    return $valido;
}

function comprobarPostal ($param) {
    $regexPostal = '/(0[1-9]|5[0-2]|[0-4][0-9])[0-9]{3}/';
    $valido=true;
    
    if ( !preg_match($regexPostal, $param) ) {
        echo 'CP no válido';
        $valido=false;
    }
    return $valido;
}

function comprobarPass($param){
	$valido=true;
   if(strlen($param) < 8){
	echo 'Contraseña no válida';
	$valido=false;
   }
   if(strlen($param) > 16){
	echo 'Contraseña no válida';
	$valido=false;
   }
   if (!preg_match('`[a-z]`',$param)){
	echo 'Contraseña no válida';
	$valido=false;
   }
   if (!preg_match('`[A-Z]`',$param)){
	echo 'Contraseña no válida';
	$valido=false;
   }
   if (!preg_match('`[0-9]`',$param)){
	echo 'Contraseña no válida';
	$valido=false;
   }
   return $valido;
}

function comprobarTelefono($param){
    $valido=false;
    $min = 600000000;
	$max = 799999999;
    if (!filter_var($param, FILTER_VALIDATE_INT,	array("options" => array("min_range"=>$min, "max_range"=>$max))) === false) 
        $valido=true;
   
    return $valido;
}


function comprobarNombre($param){
	$valido=true;
    if (!preg_match("/^[a-zA-Z ]*$/",$param)) {
		echo "Se han introducido caracteres no validos en el nombre o los apellidos.";
		$valido=false;
	}
	return $valido;
}


?>
