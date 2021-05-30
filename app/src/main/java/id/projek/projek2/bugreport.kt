package id.projek.projek2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast

class bugreport : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bugreport)

        val kirim = findViewById<Button>(R.id.kirim)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar2)
        val viewrate = findViewById<TextView>(R.id.viewrate)
        ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            viewrate.setText("Rate =$rating ")
        }
        kirim.setOnClickListener(){
            Toast.makeText(applicationContext,"Terimakasih Masukannya", Toast.LENGTH_SHORT).show()
        }
    }
}