package id.projek.projek2

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class csthistory(val mCtx : Context, val layoutCstId : Int, val cst: List<Customer>) :ArrayAdapter<Customer>(mCtx,layoutCstId, cst){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)

        val view : View = layoutInflater.inflate(layoutCstId, null)

        val nik : TextView = view.findViewById(R.id.tv_nik)
        val nama : TextView = view.findViewById(R.id.tv_nama)
        val alamat : TextView = view.findViewById(R.id.tv_address)
        val email : TextView = view.findViewById(R.id.tv_email)

        val customer : Customer = cst[position]

        nik.text = customer.nik
        nama.text = customer.nama
        alamat.text = customer.alamat
        email.text = customer.email

        return view
    }
}