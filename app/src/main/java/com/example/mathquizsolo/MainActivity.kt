package com.example.mathquizsolo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mathquizsolo.ui.theme.MathQuizSoloTheme

class MainActivity : AppCompatActivity() {
    private lateinit var rv : RecyclerView
    private var listData : ArrayList<Quiz> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        rv = findViewById(R.id.rv)
        rv.setHasFixedSize(true)

        listData.addAll(QuizData.listData)
        showRecyclerView()
    }

    private fun showRecyclerView() {
        rv.layoutManager = LinearLayoutManager(this)
        val rvAdapter = rvAdapter(listData)
        rv.adapter = rvAdapter
    }
}