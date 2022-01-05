package fr.hzadev.myapplication.adaptor

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.hzadev.myapplication.MainActivity
import fr.hzadev.myapplication.R
import fr.hzadev.myapplication.model.ProduitModel

class ProduitAdaptor(
    private val context : MainActivity,
    private val produitList: List<ProduitModel>,
    private val layoutId: Int
) : RecyclerView.Adapter<ProduitAdaptor.ViewHolder>() {

    // boite pour ranger tous les composants à controler
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // image du produit
        val produitImage = view.findViewById<ImageView>(R.id.item_produit_image)
        val produitNom:TextView? = view.findViewById(R.id.item_vertical_produit_nom)
        val produitDescription:TextView? = view.findViewById(R.id.item_vertical_produit_description)
        val etoileIcon = view.findViewById<ImageView>(R.id.item_etoile_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // récupérer les information du produit à la postion indiqué
        val monProduit = produitList[position]

        // Récupérer l'image à partir de son lien via la librairie Glide
        Glide.with(context).load(Uri.parse(monProduit.imageUrl)).into(holder.produitImage)

        // MAJ le nom du produit
        holder.produitNom?.text = monProduit.nom

        // MAJ le nom du produit
        holder.produitDescription?.text = monProduit.description

        // etoile
        if(monProduit.liked) {
            holder.etoileIcon.setImageResource(R.drawable.ic_etoile_rempli)
        } else {
            holder.etoileIcon.setImageResource(R.drawable.ic_etoile_vide)
        }
    }

    override fun getItemCount(): Int {
        return produitList.size;
    }
}