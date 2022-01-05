package fr.hzadev.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.hzadev.myapplication.MainActivity
import fr.hzadev.myapplication.R
import fr.hzadev.myapplication.adaptor.ProduitAdaptor
import fr.hzadev.myapplication.adaptor.ProduitItemDecoration
import fr.hzadev.myapplication.model.ProduitModel
import fr.hzadev.myapplication.repository.ProduitRepository.Singleton.produitList

class HomeFragment(
    private val context: MainActivity
) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)

        // recupérer le recycler view
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horisental_recycle_view)
        horizontalRecyclerView.adapter =
            ProduitAdaptor(context, produitList, R.layout.item_horisental_produit)

        // recupérer le second recycler view
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycle_view)
        verticalRecyclerView.adapter =
            ProduitAdaptor(context, produitList, R.layout.item_vertical_produit)
        verticalRecyclerView.addItemDecoration(ProduitItemDecoration())

        return view
    }

}