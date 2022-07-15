package br.com.alura.todo.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.todo.R
import br.com.alura.todo.dao.NotaDao
import br.com.alura.todo.databinding.ListaNotasActivityBinding
import br.com.alura.todo.model.Nota
import br.com.alura.todo.ui.fragment.FormularioNotaFragment
import br.com.alura.todo.ui.recyclerview.adapter.ListaNotasAdapter
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class ListaNotasActivity : AppCompatActivity() {

    private val adapter by lazy {
        ListaNotasAdapter(this)
    }

    private val binding by lazy{
        ListaNotasActivityBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerview = binding.listaNotasActivityRecyclerview

        recyclerview.adapter = adapter
        configuraFab()
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(NotaDao().notas)
    }

    private fun configuraFab() {
        val fab = binding.listaNotasActivityFab
        fab.setOnClickListener {
            Intent(this, FormularioNotasActivity::class.java)
                .run {
                    startActivity(this)
                }
        }
    }

}