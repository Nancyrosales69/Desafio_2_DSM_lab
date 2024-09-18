package edu.udb.desafio2dsmnancy

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class loginActivity : AppCompatActivity() {

    private lateinit var loginbtn: Button
    private lateinit var edituser: EditText
    private lateinit var editpword: EditText
    private lateinit var dbh: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginbtn = findViewById(R.id.button4)
        edituser = findViewById(R.id.editTextText2)
        editpword = findViewById(R.id.editTextTextPassword3)
        dbh = DBHelper(this)

        loginbtn.setOnClickListener{
            val userdtx = edituser.text.toString()
            val passedtx = editpword.text.toString()

            if(TextUtils.isEmpty(userdtx) || TextUtils.isEmpty(passedtx)){
                Toast.makeText(this, "Porfavor rellana los campos", Toast.LENGTH_SHORT).show()
            }
            else{
                val checkuser = dbh.checkuserpass(userdtx, passedtx)
                if (checkuser==true) {
                    Toast.makeText(this, "Exito", Toast.LENGTH_SHORT).show()
                    val intent = Intent(applicationContext, homeActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}