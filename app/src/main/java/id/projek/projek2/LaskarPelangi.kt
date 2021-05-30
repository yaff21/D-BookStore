package id.projek.projek2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class LaskarPelangi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laskar_pelangi)
        val btnlaskar = findViewById<Button>(R.id.buylaskar)
        val backlaskar = findViewById<Button>(R.id.backlaskar)
        backlaskar.setOnClickListener {
            val intent = Intent(this, activity_list::class.java)
            startActivity(intent)
        }
        btnlaskar.setOnClickListener {
            val intent = Intent(this,paypage::class.java)
            startActivity(intent)
        }
    }
}