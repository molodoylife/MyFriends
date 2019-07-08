package ru.narod.pricolistov.rememberfriends.presentation.main_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.main_page_fragment.*
import ru.narod.pricolistov.rememberfriends.R

class MainPageFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.main_page_fragment, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mainNext.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_mainPageFragment_to_searchFragment)
        }

        mainPrev.setOnClickListener {
            Navigation.findNavController(view).navigateUp()
        }
    }

}