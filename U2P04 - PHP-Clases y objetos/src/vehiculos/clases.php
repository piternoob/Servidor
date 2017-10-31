<?php
class Vehiculo{
    private $matricula;
    private $color;
    private $marca;
    private $modelo;
    
    public function __construct($matricula, $color, $marca, $modelo){
        $this->matricula=$matricula;
        $this->color=$color;
        $this->marca=$marca;
        $this->modelo=$modelo;
    }
    
    public function __toString(){
        foreach($this as $clave => $valor){
            echo "<p>$clave => $valor</p>";
        }
    }
    
}

class Coche extends Vehiculo{
    private $ruedas=4;
    
    public function __construct($matricula, $color, $marca, $modelo){
        parent::__construct();
    }
    
    public function __toString(){
        echo "<p>Es un coche de cuatro ruedas.</p>";
        parent::__toString();
    }
}

?>