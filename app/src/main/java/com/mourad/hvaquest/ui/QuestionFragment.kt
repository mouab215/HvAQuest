package com.mourad.hvaquest.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.mourad.hvaquest.R
import kotlinx.android.synthetic.main.fragment_question.*

/**
 * A simple [Fragment] subclass.
 */
class QuestionFragment : Fragment() {

    private lateinit var viewModel: QuestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(activity as AppCompatActivity).get(QuestViewModel::class.java)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvQuestion.text = viewModel.getQuestion().question
        tvQuestionNumber.text = "${viewModel.questionIndex + 1}/${viewModel.getQuestions().size}"

        rb1.text = viewModel.getQuestion().choices[0]
        rb2.text = viewModel.getQuestion().choices[1]
        rb3.text = viewModel.getQuestion().choices[2]

        btnConfirm.setOnClickListener {
            val selectedAnswer = view.findViewById<RadioButton>(rgAnswers.checkedRadioButtonId)
            if (viewModel.isAnswerCorrect(selectedAnswer.text.toString())) {
                Toast.makeText(context, "Correct answer!", Toast.LENGTH_LONG).show()

                if ((viewModel.getQuestions().size) == viewModel.questionIndex + 1) {
                    findNavController().navigate(R.id.action_questionFragment_to_questCompletedFragment)
                }
                else {
                    findNavController().navigate(R.id.action_questionFragment_to_locationClueFragment)
                }
            } else {
                Toast.makeText(context, "Wrong answer!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
