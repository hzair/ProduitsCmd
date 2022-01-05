package fr.hzadev.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.hzadev.myapplication.fragments.HomeFragment
import fr.hzadev.myapplication.repository.ProduitRepository

class MainActivityOld : MainActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // charger le produitRepository
        val produitRepo = ProduitRepository()
        produitRepo.updateData {
            // intecter le fragment dans notre boite (fragment_container)
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, HomeFragment(this))
            transaction.addToBackStack(null)
            transaction.commit()
        }


    }
}