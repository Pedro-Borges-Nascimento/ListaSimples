package com.example.listasimples

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etnovatarefa = findViewById<EditText>(R.id.etnovatarefa)
        val btadd = findViewById<Button>(R.id.btadd)
        val tvtitulo = findViewById<TextView>(R.id.tvtitulo)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        val lvtarefas = findViewById<ListView>(R.id.lvtarefas)

        fab.setOnClickListener {
            tvtitulo.isVisible = false
            etnovatarefa.isVisible = true
            etnovatarefa.isEnabled = true
            btadd.isVisible = true
        }

        tvtitulo.isVisible = false
        etnovatarefa.isVisible = true
        etnovatarefa.isEnabled = true
        btadd.isVisible = true

        val listaTarefas: ArrayList<String> = ArrayList()
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaTarefas)
        lvtarefas.adapter = adapter

        btadd.setOnClickListener{
            if (etnovatarefa.text.isNullOrEmpty()) {
                Toast.makeText(this, "digite uma tarefa...", Toast.LENGTH_SHORT).show()
            } else{
                listaTarefas.add(etnovatarefa.text.toString())
                adapter.notifyDataSetChanged()
                etnovatarefa.setText("")
                etnovatarefa.isVisible = false
                etnovatarefa.isEnabled = false
                btadd.isVisible = false
                tvtitulo.isVisible = true
            }
        }
        lvtarefas.setOnItemLongClickListener{ _, _, position, _ ->

            val alerta = AlertDialog.Builder(this)
            alerta.setTitle("Atenção")
            alerta.setMessage("Quer excluir este item?")
            alerta.setPositiveButton("Confirmar") {dialog, _ ->

                listaTarefas.removeAt(position)
                adapter.notifyDataSetChanged()
                dialog.dismiss()            }
                alerta.setNegativeButton("Cancelar") {dialog, _ ->
                    dialog.dismiss()        }
                    alerta.create().show()
                    true
                }
            }
        }



/*class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etnovatarefa = findViewById<EditText>(R.id.edtNovaTarefa)
        val btadd = findViewById<Button>(R.id.btnAdd)
        val lvtarefas = findViewById<ListView>(R.id.lvTarefas)
        val tvtitulo = findViewById<TextView>(tvtitulo)

        val listaTarefas: ArrayList<String> = ArrayList()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaTarefas)

        lvtarefas.adapter = adapter

        btadd.setOnClickListener{
            if (etnovatarefa.text.isNullOrEmpty()) {
                Toast.makeText(this, "digite uma tarefa...", Toast.LENGTH_SHORT).show()
            }else {
                listaTarefas.add(etnovatarefa.text.toString())
                //notificamos ao adapter que tivemos alteração da lista
                //notificado, ele atualiza os novos elemento da lista na tela
                adapter.notifyDataSetChanged()
                etnovatarefa.setText("")
            }
            lvtarefas.setOnItemLongClickListener{ _, _, position, _ ->
                //aqui montamos a caixa de dialogo
                val alerta = AlertDialog.Builder(this)
                alerta.setTitle("Atenção")
                alerta.setMessage("Quer mesmo excluir?")
                alerta.setPositiveButton("confirmar"){dialog, _ ->

                            //caso clicado
                        listaTarefas.removeAt(position)
                    adapter.notifyDataSetChanged()
                    dialog.dismiss()                }
                    alerta.setNegativeButton("cancelar") {dialog, _ ->
                            dialog.dismiss()        }
                        alerta.create().show()
                        true
                    }
                }
            }
        }
 */