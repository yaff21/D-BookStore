package id.projek.projek2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Kekang : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kekang)
        val buykekang = findViewById<Button>(R.id.buykekang)
        val backkekang = findViewById<Button>(R.id.backkekang)
        backkekang.setOnClickListener {
            val intent = Intent(this, activity_list::class.java)
            startActivity(intent)
        }
        buykekang.setOnClickListener {
            val intent = Intent(this,paypage::class.java)
            startActivity(intent)
        }
    }
}