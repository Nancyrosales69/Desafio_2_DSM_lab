package edu.udb.desafio2dsmnancy

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


data class Producto(val nombre: String, val precio: Double)

class homeActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductoAdapter
    private lateinit var totalTextView: TextView
    private lateinit var pagarButton: Button

    private val productosSeleccionados = mutableListOf<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        recyclerView = findViewById(R.id.recyclerView)
        totalTextView = findViewById(R.id.textView7)
        pagarButton = findViewById(R.id.button5)

        adapter = ProductoAdapter(productosSeleccionados)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val checkBoxTacos: CheckBox = findViewById(R.id.checkBox)
        val checkBoxQuesadillas: CheckBox = findViewById(R.id.checkBox2)
        val checkBoxEnchiladas: CheckBox = findViewById(R.id.checkBox3)
        val checkBoxTortas: CheckBox = findViewById(R.id.checkBox4)
        val checkBoxChilaquiles: CheckBox = findViewById(R.id.checkBox5)
        val checkBoxAguaHorchata: CheckBox = findViewById(R.id.checkBox6)
        val checkBoxAguaJamaica: CheckBox = findViewById(R.id.checkBox7)
        val checkBoxMichelada: CheckBox = findViewById(R.id.checkBox9)
        val checkBoxCerveza: CheckBox = findViewById(R.id.checkBox10)

        val checkboxes = listOf(
            Pair(checkBoxTacos, Producto("Tacos", 3.50)),
            Pair(checkBoxQuesadillas, Producto("Quesadillas", 1.50)),
            Pair(checkBoxEnchiladas, Producto("Enchiladas", 2.00)),
            Pair(checkBoxTortas, Producto("Tortas", 2.50)),
            Pair(checkBoxChilaquiles, Producto("Chilaquiles", 1.75)),
            Pair(checkBoxAguaHorchata, Producto("Agua de Horchata", 0.75)),
            Pair(checkBoxAguaJamaica, Producto("Agua de Jamaica", 1.75)),
            Pair(checkBoxMichelada, Producto("Michelada", 2.50)),
            Pair(checkBoxCerveza, Producto("Cerveza", 1.75))
            )

        for (pair in checkboxes) {
            pair.first.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    productosSeleccionados.add(pair.second)
                } else {
                    productosSeleccionados.remove(pair.second)
                }
                actualizarTotal()
                adapter.notifyDataSetChanged()
            }
        }

        pagarButton.setOnClickListener {
            productosSeleccionados.clear()
            for (pair in checkboxes) {
                pair.first.isChecked = false
            }
            adapter.notifyDataSetChanged()
            totalTextView.text = "Total a pagar: $0.00"
        }
    }

    private fun actualizarTotal() {
        val total = productosSeleccionados.sumOf { it.precio }
        totalTextView.text = "Total a pagar: $$total"
    }
}