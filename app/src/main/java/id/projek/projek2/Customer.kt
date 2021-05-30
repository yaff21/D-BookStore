package id.projek.projek2

data class Customer(
    val id : String?,
    val nik : String,
    val nama : String,
    val alamat : String,
    val email : String
){
    constructor(): this("","","","",""){

    }
}