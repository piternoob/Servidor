<?php 
class Animal{
    private $chip;
    private $nombre;
    private $especie;
    private $imagen;
    
    public function __toString(){
        return "<p>Datos del animal: chip=".$this->chip.", nombre=".$this->nombre.", especie=".$this->especie.", imagen=<img src='/U3P02-Acceso%20a%20BBDD%20en%20PHP/img/".$this->image."' height=200px width=200px></p>";
    }
    
    public function getChip(){
        return $this->chip;
    }
    
    public function getNombre(){
        return $this->nombre;
    }
    
    public function getEspecie(){
        return $this->especie;
    }
    
    public function getImagen(){
        return "<img src='/U3P02-Acceso%20a%20BBDD%20en%20PHP/img/".$this->imagen."' height=200px width=200px>";
    }
    
}
?>