<?php
function comprobarEmail($param) {
    $valido=false;
    if (!filter_var($param, FILTER_VALIDATE_EMAIL) === false) {
        $valido=true;
    }else{
        echo 'Fecha no válida';
    }
    
    return $valido;
}
function comprobarFecha ($param) {
    $regexFecha = '/^([0-2][0-9]|3[0-1])(\/|-)(0[1-9]|1[0-2])\2(\d{4})(\s)([0-1][0-9]|2[0-3])(:)([0-5][0-9])$/';
    $valido=true;
    
    if ( !preg_match($regexFecha, $param) ) {
        echo 'Fecha no válida';
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

function comprobarFrase($param){
    /*
     * <?php
     $v = "kahdsf kjlahdskjf aldsh fkjhas djlfh asgf ias uih";
     if(preg_match("|^[a-zA-Z]+(\s*[a-zA-Z]*)*[a-zA-Z]+$|",$v) && strlen($v) <= 50){
     echo "Es correcta la información.";
     }
     */
   $regexFrase='//';
   $valido=true;
   
   if ( !preg_match($regexFrase, $param) ) {
       echo 'Campo inválido.';
       $valido=false;
   }
   return $valido;
}
function comprobarPalabra($param){
    $regexPalabra='//';
    $valido=true;
   
    
    if ( !preg_match($regexPalabra, $param) ) {
        echo 'Campo inválido.';
        $valido=false;
    }
    return $valido;
}
/*function comprobarNecesario ($param){
    $valido=true;
    if(trim($param) == ''){
        $valido=false;
        echo 'No se ha introducido ningun valor.<br>';
    }
    return  $valido;
    
}*/

/*function validarEntero($param){
    $valido;
    if(filter_var($param, FILTER_VALIDATE_INT) === FALSE){
        $valido=false;
        echo "No es un numero";
    }else{
        $valido=true;
    }
    return  $valido;
}*/
function validarPass($param){
    $valido;
    if (preg_match("/*\w*\c/", $param)) {
        $valido=false;
        echo "No es un numero";
    }else{
        $valido=true;
    }
    return  $valido;
}
?>
<!--      <label for="password"> 
         Password: <input type="password" placeholder="Min 6 characters" 
         id="password" name="password"/> 
         </label>   
         http://fernando-gaitan.com.ar/aprendiendo-php-parte-18-validar-formularios/        -->
