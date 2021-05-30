package id.projek.projek2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginPage : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        auth = FirebaseAuth.getInstance()

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isEmpty()) {
                etEmail.error = "Email Harus Diisi"
                etEmail.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Email Tidak Valid"
                etEmail.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty() || password.length < 6) {
                etPassword.error = "Password Harus Lebih Dari 6 Karakter"
                etPassword.requestFocus()
                return@setOnClickListener
            }
            loginUser(email, password)
        }

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener {
            Intent(this@LoginPage, RegisPage::class.java).also {
                startActivity(it)
            }
        }

    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Intent(this@LoginPage, MainActivity2::class.java).also {
                        it.flags =
                            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }

    }

    //Jika user telah login maka akan menuju ke halaman MainActivity2
    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null) {
            Intent(this@LoginPage, MainActivity2::class.java).also { intent ->
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }
    }


}