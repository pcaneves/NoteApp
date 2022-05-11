package br.senac.noteapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import br.senac.noteapp.data.AppDatabase
import br.senac.noteapp.data.Note
import br.senac.noteapp.data.Notes
import br.senac.noteapp.databinding.ActivityListNotesBinding
import br.senac.noteapp.databinding.CardNoteBinding

class ListNotesActivity : AppCompatActivity() {
    lateinit var binding: ActivityListNotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
            var i = Intent(this, NewNoteActivity::class.java)
            startActivity(i)
        }
    }

    override fun onResume() {
        super.onResume()
        updateNotes()
    }

    fun updateNotes() {
        Thread {
            val db = Room.databaseBuilder(this, AppDatabase::class.java, "db").build()
            val list = db.noteDao().listAll()
            runOnUiThread {
                updateUi(list)
            }
        }.start()
    }

    fun updateUi(notes: List<Note>) {
        binding.container.removeAllViews()

        notes.forEach {
            val card = CardNoteBinding.inflate(layoutInflater)

            card.textDesc.text = it.desc
            card.textTitle.text = it.title

            binding.container.addView(card.root)
        }
    }
}