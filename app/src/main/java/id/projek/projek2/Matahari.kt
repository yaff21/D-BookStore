package id.projek.projek2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Matahari : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matahari)
        val buymatahari = findViewById<Button>(R.id.buymatahari)
        val backmatahari = findViewById<Button>(R.id.backmatahari)
        backmatahari.setOnClickListener {
            val intent = Intent(this, activity_list::class.java)
            startActivity(intent)
        }
        buymatahari.setOnClickListener {
            val intent = Intent(this,paypage::class.java)
            startActivity(intent)
        }
    }
}