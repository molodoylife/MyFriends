package ru.narod.pricolistov.rememberfriends.presentation.main_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.main_page_fragment.*
import ru.narod.pricolistov.rememberfriends.R

class MainPageFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.main_page_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mainNext.setOnClickListener {
            findNavController().navigateUp()
        }

        mainPrev.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}