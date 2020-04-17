package com.kotlinpractice.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers : Int = 0
    private var mUserName : String? = null
    private var isCanMoveNextQuestion : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        mUserName=intent.getStringExtra(Constants.USER_NAME)

        mQuestionList = Constants.getQuestions()

        setQuestion()

        tvFirstAnswer.setOnClickListener(this)
        tvSecondAnswer.setOnClickListener(this)
        tvThirdAnswer.setOnClickListener(this)
        tvForthAnswer.setOnClickListener(this)
        btnSubmitAnswer.setOnClickListener(this)


    }

    private fun setQuestion() {
        isCanMoveNextQuestion = false
        val question = mQuestionList!![mCurrentPosition - 1]
        defaultOptionsView()

        if (mCurrentPosition == mQuestionList!!.size){
            btnSubmitAnswer.text = "FINISH"
        }
        else{
            btnSubmitAnswer.text = "SUBMIT"
        }
        progressBar.progress = mCurrentPosition
        tvQuestionCounter.text = "$mCurrentPosition" + "/" + progressBar.max

        tvQuestion.text = question!!.question
        ivFlagImage.setImageResource(question.image)
        tvFirstAnswer.text = question.optionOne
        tvSecondAnswer.text = question.optionTwo
        tvThirdAnswer.text = question.optionThree
        tvForthAnswer.text = question.optionFour
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, tvFirstAnswer)
        options.add(1, tvSecondAnswer)
        options.add(2, tvThirdAnswer)
        options.add(3, tvForthAnswer)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvFirstAnswer -> {
                selectedOptionView(tvFirstAnswer, 1)
            }

            R.id.tvSecondAnswer -> {
                selectedOptionView(tvSecondAnswer, 2)
            }

            R.id.tvThirdAnswer -> {
                selectedOptionView(tvThirdAnswer, 3)
            }

            R.id.tvForthAnswer -> {
                selectedOptionView(tvForthAnswer, 4)
            }

            R.id.btnSubmitAnswer -> {
                if (mSelectedOptionPosition == 0)
                {
                    if (!isCanMoveNextQuestion)
                    {
                        Toast.makeText(this,"Chose your answer",Toast.LENGTH_SHORT).show()
                    }
                    else {
                        mCurrentPosition++
                        when {
                            mCurrentPosition <= mQuestionList!!.size -> {
                                setQuestion()

                            }
                            else -> {
                                val intent = Intent(this, ResultActivity::class.java)
                                intent.putExtra(Constants.USER_NAME, mUserName)
                                intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                                intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                                startActivity(intent)
                                finish()
                            }
                        }
                    }
                }
                else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer,R.drawable.currect_option_border_bg )
                    if (mCurrentPosition == mQuestionList!!.size)
                    {
                        btnSubmitAnswer.text = "finish"
                    }
                    else
                    {
                        btnSubmitAnswer.text = "GO TO NEXT QUESTION"
                    }
                    isCanMoveNextQuestion = true
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNumber
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tvFirstAnswer.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tvSecondAnswer.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tvThirdAnswer.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                tvForthAnswer.background = ContextCompat.getDrawable(this, drawableView)
            }

        }
    }
}
