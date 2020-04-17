package com.kotlinpractice.quizapp

import java.util.*
import kotlin.collections.ArrayList

object Constants {

    const val USER_NAME:String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val que1 = Question (1,"What country dose this flag belongs to?"
            ,R.drawable.ic_flag_of_argentina,"Argentina"
            ,"lima"
            ,"Dubai"
            ,"Israel"
            ,1)
        val que2 = Question (2,"What country dose this flag belongs to?"
            ,R.drawable.ic_flag_of_australia,"Uruguay"
            ,"Australia"
            ,"South Korea"
            ,"Panama"
            ,2)
        val que3 = Question (3,"What country dose this flag belongs to?"
            ,R.drawable.ic_flag_of_belgium,"Estonia","Chile"
            ,"Libya"
            ,"Belgium"
            ,4)
        val que4 = Question (4,"What country dose this flag belongs to?"
            ,R.drawable.ic_flag_of_brazil,"Brazil","Chile"
            ,"Belgium"
            ,"Mexico"
            ,1)
        val que5 = Question (5,"What country dose this flag belongs to?"
            ,R.drawable.ic_flag_of_denmark,"Denmark","Paraguay"
            ,"Romania"
            ,"Serbia"
            ,1)
        val que6 = Question (6,"What country dose this flag belongs to?"
            ,R.drawable.ic_flag_of_fiji,"Philippines","Portugal"
            ,"Fiji"
            ,"Qatar"
            ,3)
        val que7 = Question (7,"What country dose this flag belongs to?"
            ,R.drawable.ic_flag_of_germany,"Sweden","Germany"
            ,"Singapore"
            ,"Slovenia"
            ,2)
        val que8 = Question (8,"What country dose this flag belongs to?"
            ,R.drawable.ic_flag_of_kuwait,"Malaysia","Netherlands"
            ,"New Zealand"
            ,"Kuwait"
            ,4)
        val que9 = Question (9,"What country dose this flag belongs to?"
            ,R.drawable.ic_flag_of_new_zealand,"Macedonia","Portugal"
            ,"Malta"
            ,"New Zealand"
            ,4)
        val que10 = Question (10,"What country dose this flag belongs to?"
            ,R.drawable.ic_flag_of_india,"Latvia","India"
            ,"Norway"
            ,"Morocco"
            ,2)
        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)
        return questionsList
    }
}