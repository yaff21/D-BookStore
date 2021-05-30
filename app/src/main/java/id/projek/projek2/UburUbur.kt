package id.projek.projek2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UburUbur : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubur_ubur)
        val buyubur = findViewById<Button>(R.id.buyubur)
        val backubur = findViewById<Button>(R.id.backubur)
        backubur.setOnClickListener {
            val intent = Intent(this, activity_list::class.java)
            startActivity(intent)
        }
        buyubur.setOnClickListener {
            val intent = Intent(this,paypage::class.java)
            startActivity(intent)
        }
    }
}