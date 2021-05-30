package id.projek.projek2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TikunganMaut : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tikungan_maut)
        val buytikungan = findViewById<Button>(R.id.buytikungan)
        val backtikungan = findViewById<Button>(R.id.backtikungan)
        backtikungan.setOnClickListener {
            val intent = Intent(this, activity_list::class.java)
            startActivity(intent)
        }
        buytikungan.setOnClickListener {
            val intent = Intent(this,paypage::class.java)
            startActivity(intent)
        }
    }
}