package com.example.apiintegration

import android.app.TaskStackBuilder
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)
    }

    fun goBackToMainActivity(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        val stackBuilder : TaskStackBuilder = TaskStackBuilder.create(this)
        stackBuilder.addNextIntentWithParentStack(intent)
        stackBuilder.startActivities(Bundle())
    }
    fun startJokeActivity(view: View) {
        val intent = Intent(this, JokeActivity::class.java)
        startActivity(intent)
    }
    fun startWeatherActivity(view: View) {
        val intent = Intent(this, BoredActivity::class.java)
        startActivity(intent)
    }

}