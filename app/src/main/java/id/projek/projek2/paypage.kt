package id.projek.projek2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.*

class paypage : AppCompatActivity(), View.OnClickListener {

    private lateinit var etnik : EditText
    private lateinit var etnama : EditText
    private lateinit var etalamat : EditText
    private lateinit var etemail : EditText
    private lateinit var btnsave : Button
    private lateinit var listCst : ListView
//    private lateinit var btnback : Button
    private lateinit var ref : DatabaseReference
    private  lateinit var cst : MutableList<Customer>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paypage)

        ref = FirebaseDatabase.getInstance().getReference("customer")

        etnik = findViewById(R.id.et_nik)
        etnama = findViewById(R.id.et_nama)
        etalamat = findViewById(R.id.et_address)
        etemail = findViewById(R.id.et_email)
        listCst = findViewById(R.id.lv_cst)
        btnsave = findViewById(R.id.btn_save)
//        btnback = findViewById(R.id.btnback)

        btnsave.setOnClickListener(this)

        cst = mutableListOf()

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){
                    for(x : DataSnapshot in p0.children){
                        val customer : Customer? = x.getValue(Customer::class.java)
                        if (customer != null){
                            cst.add(customer)
                        }
                    }
                    val adapter = csthistory(applicationContext,R.layout.activity_history,cst)
                    listCst.adapter = adapter
                }
            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented")
            }

        })
    }
    override fun onClick(v: View?) {
        saveData()
    }

    private fun saveData(){
        val nik = etnik.text.toString().trim()
        val nama = etnama.text.toString().trim()
        val alamat = etalamat.text.toString().trim()
        val email = etemail.text.toString().trim()

        if (nik.isEmpty()){
            etnik.error = "Nik Salah!"
            return
        }
        if(nama.isEmpty()){
            etnama.error = "Nik Salah"
            return
        }
        if (alamat.isEmpty()){
            etalamat.error = "Isi Alamat Anda"
            return
        }
        if (email.isEmpty()){
            etemail.error = "Isi Email Anda"
            return
        }

        val idbook :String? = ref.push().key

        val cst = Customer(idbook,nik,nama,alamat,email)

        if (idbook != null){
            ref.child(idbook).setValue(cst).addOnCompleteListener {
                Toast.makeText(applicationContext,"Pembelian Berhasil Diajukan",Toast.LENGTH_SHORT).show()
            }
        }
    }

}