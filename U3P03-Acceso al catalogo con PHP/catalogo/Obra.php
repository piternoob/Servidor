<?php 
class Obra{
    private $idObra;
    private $idAutor;
    private $nombre;
    private $imagenObra;
    private $nomAutor;
    private $imagenAutor;
    
    public function getIdObra(){
        return $this->idObra;
    }
    public function getIdAutor(){
        return $this->idAutor;
    }
    public function getNombre(){
        return $this->nombre;
    }
    
    public function getImagenObra(){
        return "<img src='/U3P03-Acceso%20al%20catalogo%20con%20PHP/img/".$this->imagenObra."'height=200px width=200px>";
    }
    
    public function getNomAutor(){
        return $this->nomAutor;
    }

    public function getImagenAutor(){
        return "<img src='/U3P03-Acceso%20al%20catalogo%20con%20PHP/img/".$this->imagenAutor."'height=200px width=200px>";
    }
}
?>