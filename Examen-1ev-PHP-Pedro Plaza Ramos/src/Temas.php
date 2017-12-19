<?php
class Temas{
    private $id;
    private $idDisco;
    private $numero;
    private $nombreIs;
    private $nombreEs;
    private $minutos;
    private $segundos;
    private $nombreDisco;
    private $ano;
    private $tipo;
    private $sec;
    private $imagen;
    private $discografica;
    private $web;
    private $soporte;
    private $texto;
    
    public function getIdObra(){
        return $this->id;
    }
    public function getIdDisco(){
        return $this->idDisco;
    }
    public function getNumero(){
        return $this->numero;
    }
    
    public function getImagen(){
        return "<img src='/Examen-1ev-PHP-Pedro%20Plaza%20Ramos/img/discografia/".$this->imagen.".jpg' height=200px width=200px>";
    }
    
    public function getNombreIs(){
        return $this->nombreIs;
    }
    
    public function getNombreEs(){
        return $this->nombreEs;
    }
    
    public function getMinutos(){
        return $this->minutos;
    }
    
    public function getSegundos(){
        return $this->segundos;
    }
    
    public function getNombreDisco(){
        return $this->nombreDisco;
    }
    
    public function getAno(){
        return $this->ano;
    }
    
    public function getTipo(){
        return $this->tipo;
    }
    
    public function getSec(){
        return $this->sec;
    }
    
    public function getWeb(){
        return $this->web;
    }
    
    public function getDiscografica(){
        return $this->discografica;
    }
    
    public function getSoporte(){
        return $this->soporte;
    }
    
    public function getTexto(){
        return $this->texto;
    }
    
}
?>