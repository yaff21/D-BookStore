package id.projek.projek2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Location : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        val btnmap = findViewById<Button>(R.id.btn_map)
        btnmap.setOnClickListener {
            val intent = Intent(this, LocationStore::class.java)
            startActivity(intent)
        }
    }
}