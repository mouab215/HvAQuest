package com.mourad.hvaquest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.mourad.hvaquest.R
import kotlinx.android.synthetic.main.fragment_location_clue.*

/**
 * A simple [Fragment] subclass.
 */
class LocationClueFragment : Fragment() {

    private lateinit var viewModel: QuestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(activity as AppCompatActivity).get(QuestViewModel::class.java)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location_clue, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.questionIndex++
        ivLocation.setImageResource(viewModel.getQuestion().clue)
        btnNextQuestion.setOnClickListener {
            findNavController().navigate(R.id.action_locationClueFragment_to_questionFragment)
        }
    }

}
