package com.example.apiintegration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class JokeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)
        val textView = findViewById<TextView>(R.id.jokeText)
        val button = findViewById<Button>(R.id.jokeBtn)
        val rq: RequestQueue = Volley.newRequestQueue(this)
        val url = "https://italian-jokes.vercel.app/api/jokes"

        val r = StringRequest(
            Request.Method.GET, url,
            { res -> Log.d("Markus", res.toString()) },
            { err -> Log.e("Markus", err.toString()) }
        )
        button.setOnClickListener {
            val j = JsonObjectRequest(url,
                { res -> textView.text = res.get("joke").toString() },
                { err -> Log.e("Markus", err.toString()) })
            rq.add(j)
        }
        rq.add(r)
    }

    fun goBackToMainActivity(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun goBackToSelectionActivity(view: View) {
        val intent = Intent(this, SelectionActivity::class.java)
        startActivity(intent)
    }
}