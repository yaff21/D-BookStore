package id.projek.projek2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.google.firebase.auth.FirebaseAuth

class MainActivity2 : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        auth = FirebaseAuth.getInstance()
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            auth.signOut()
            Intent(this@MainActivity2,LoginPage::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }

        val listbuku = findViewById<ImageButton>(R.id.listbuku)
        val rate = findViewById<ImageButton>(R.id.rating)
        listbuku.setOnClickListener {
            val intent = Intent(this, activity_list::class.java)
            startActivity(intent)
        }
        rate.setOnClickListener {
            val intent = Intent(this, bugreport::class.java)
            startActivity(intent)
        }
        val map = findViewById<ImageButton>(R.id.location)
        map.setOnClickListener {
            val intent = Intent(this,Location::class.java)
            startActivity(intent)
        }
        val cs = findViewById<ImageButton>(R.id.cs)
        cs.setOnClickListener {
            val intent = Intent(this,CustomerServicee::class.java)
            startActivity(intent)
        }
    }
}