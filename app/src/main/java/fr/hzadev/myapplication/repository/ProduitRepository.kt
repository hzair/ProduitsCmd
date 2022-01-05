package fr.hzadev.myapplication.repository

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import fr.hzadev.myapplication.model.ProduitModel

class ProduitRepository {

    // créer un singleton
    object Singleton {

        // Se connecter à la reference Produit
        val databaseref = FirebaseDatabase.getInstance("https://achatproduit-1c3e7-default-rtdb.europe-west1.firebasedatabase.app")
            .getReference("produits")

        // Creer une liste contenant les produits
        val produitList = arrayListOf<ProduitModel>()
    }

    fun updateData(callback:() -> Unit) {
        Singleton.databaseref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // retirer les ancienne
                Singleton.produitList.clear()

                // recolter la liste
                for (ds in snapshot.children) {
                    // construir un objet Produit
                    val produit = ds.getValue(ProduitModel::class.java)

                    if(produit != null) {
                        // Ajouter le produit à la liste
                        Singleton.produitList.add(produit)
                    }
                }

                // actionner le callback
                callback()

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

}