package com.example.musicalapp.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicalapp.MainActivity
import com.example.musicalapp.R
import com.example.musicalapp.database.TitresModel

//il faut ajouter des methodes à surcharger
class TitreAdapter (
                    private val context : MainActivity,
                    private val titreList: List<TitresModel>,
                    private val layouId :Int,)
: RecyclerView.Adapter<TitreAdapter.ViewHolder>() {
//La classe servira à donner à notre recycler view pour adapter a chaque titre son image



    //boite pour ranger tout les compoants à controller
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){//quand on crée notre view holder on lui passe la vue
        //on récupére l'image du titre -> ajouter à notre image
        val titreImage = view.findViewById<ImageView>(R.id.image_titre)
    }

    //elle permet d'injecter le layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(layouId, parent, false) //on a crèe le composant
        return ViewHolder(view) //le on create attend un view holder donc on le passe dns les parametres
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //récuperer les informations et mettre a jour chaque modèle
        val currentTitre = titreList[position]
        //utiliser glide pour récupérer l'image à partie de son lien (composant)
        Glide.with(context).load(Uri.parse(currentTitre.imageTitre)).into(holder.titreImage)
        //holder.itemView.setOnClickListener { listener.onItemClicked(position) }



    }

    override fun getItemCount(): Int = titreList.size
        //ce qui permet de renvoyer combien d'item il faut afficher (avec kotlin on peut getItemCount(): Int Int = la valeur
}

interface OnItemClickedListener{

    fun onItemClicked(position: Int)
}