package com.example.mathquizsolo

object QuizData {
    private val data = arrayOf(
        arrayOf(
            "https://cdn-icons-png.flaticon.com/512/7794/7794550.png",
            "addition"
        ),
        arrayOf(
            "https://images.saymedia-content.com/.image/t_share/MTc0MTUwNTI0OTMyMDA3MTk3/writing-tips-how-to-use-hyphens.jpg",
            "subtraction"
        ),
        arrayOf(
            "https://w7.pngwing.com/pngs/773/321/png-transparent-computer-icons-letter-x-miscellaneous-text-graphical-user-interface.png",
            "multiplication"
        ),
        arrayOf(
            "https://w7.pngwing.com/pngs/159/144/png-transparent-obelus-long-division-mathematics-multiplication-sign-divide-text-rectangle-logo.png",
            "division"
        )
    )

        val listData : ArrayList<Quiz>
        get() {
            val list = arrayListOf<Quiz>()
            for (aData in data) {
                val quiz = Quiz()
                quiz.image = aData[0]
                quiz.name = aData[1]

                list.add(quiz)
            }

            return list
        }
}