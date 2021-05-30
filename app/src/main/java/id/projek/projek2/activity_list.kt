package id.projek.projek2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class activity_list : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val home = findViewById<ImageButton>(R.id.btnhome)
        val list1 = findViewById<ImageButton>(R.id.matahari)
        val list2 = findViewById<ImageButton>(R.id.laskarpelangi)
        val list3 = findViewById<ImageButton>(R.id.mrestaurant)
        val list4 = findViewById<ImageButton>(R.id.kekang)
        val list5 = findViewById<ImageButton>(R.id.tikungan)
        val list6 = findViewById<ImageButton>(R.id.uburubur)

        list2.setOnClickListener {
            val intent = Intent(this, LaskarPelangi::class.java)
            startActivity(intent)
        }
        home.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        list1.setOnClickListener {
            val intent = Intent(this,Matahari::class.java)
            startActivity(intent)
        }
        list3.setOnClickListener {
            val intent = Intent(this,Restaurant::class.java)
            startActivity(intent)
        }
        list4.setOnClickListener {
            val intent = Intent(this,Kekang::class.java)
            startActivity(intent)
        }
        list5.setOnClickListener {
            val intent = Intent(this,TikunganMaut::class.java)
            startActivity(intent)
        }
        list6.setOnClickListener {
            val intent = Intent(this,UburUbur::class.java)
            startActivity(intent)
        }
    }
}