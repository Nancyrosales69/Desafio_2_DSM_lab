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

class signupActivity : AppCompatActivity() {

    private lateinit var uname: EditText
    private lateinit var pword: EditText
    private lateinit var cpword: EditText
    private lateinit var signupbtn: Button
    private lateinit var db: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        uname = findViewById(R.id.editTextText)
        pword = findViewById(R.id.editTextTextPassword)
        cpword = findViewById(R.id.editTextTextPassword2)
        signupbtn = findViewById(R.id.button3)
        db = DBHelper(this)

        signupbtn.setOnClickListener{
            val unametext = uname.text.toString()
            val pwordtext = pword.text.toString()
            val cpwordtext = cpword.text.toString()
            val savedata = db.insertdata(unametext, pwordtext)

            if (TextUtils.isEmpty(unametext) || TextUtils.isEmpty(pwordtext) || TextUtils.isEmpty(cpwordtext)){
                Toast.makeText(this, "Por favor llene los campos", Toast.LENGTH_SHORT).show()
            }
            else{
                if (pwordtext.equals(cpwordtext)){
                    if (savedata==true){
                        Toast.makeText(this, "Cuenta Creada", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, loginActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this, "Usuario existe ya", Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}