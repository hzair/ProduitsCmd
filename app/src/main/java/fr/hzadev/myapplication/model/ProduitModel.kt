package fr.hzadev.myapplication.model

class ProduitModel(

    val nom : String = "nom du produit",
    val description : String = "description du produit",
    val imageUrl : String = "http://graven.yt/plante.jpg",
    var liked : Boolean = false
)