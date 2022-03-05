package com.example.musicalapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicalapp.MainActivity
import com.example.musicalapp.R
import com.example.musicalapp.adapter.TitreAdapter
import com.example.musicalapp.adapter.TitreItemDecoration
import com.example.musicalapp.database.TitresModel

class RechercheFragment(
    private val context : MainActivity
) : Fragment(){ //la creation du fragment appelle le oncreatView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view =  inflater?.inflate(R.layout.fragment_recherche, container, false)//injecter le fragment dans la page

        //crée la liste pour stocker la liste des albums
        val albumsList = arrayListOf<TitresModel>()
        // enregistrer un premier titre dans la liste
        albumsList.add(
            TitresModel(
                "Unstoppable",
                "Sia",
               "https://cdn.pixabay.com/photo/2018/07/21/03/55/woman-3551832_1280.jpg"
            ))
        //seconde plante
        albumsList.add(
            TitresModel(
                "She Wolf",
                "Sia",
                "https://cdn.pixabay.com/photo/2018/10/09/11/58/fantasy-3734810_1280.jpg"
            ))

        //récuperer le composant recyclerview
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = TitreAdapter(context, albumsList, R.layout.item_vertical_details_titre) //charger les titres
        horizontalRecyclerView.addItemDecoration(TitreItemDecoration())

        val verticaldetailsRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticaldetailsRecyclerView.adapter = TitreAdapter(context,albumsList, R.layout.item_vertical_details_titre) //charger les titres
        verticaldetailsRecyclerView.addItemDecoration(TitreItemDecoration())

        return view
    }

}