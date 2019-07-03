package ru.narod.pricolistov.rememberfriends.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.search_page_fragment.*
import ru.narod.pricolistov.rememberfriends.R

class SearchFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.search_page_fragment, container, false)

//        searchNext.setOnClickListener {
//            Navigation.findNavController(view).navigate(R.id.action_searchFragment_to_mainPageFragment)
//        }
        return view
    }

}