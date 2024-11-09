package com.example.flashcardapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.flashcardapplication.model.Flashcard

class MainActivity : AppCompatActivity() {

    // Use var for variables that may need reassignment
    private var recyclerView: RecyclerView? = null
    private var flashcardAdapter: FlashcardAdapter? = null
    private var flashcards: MutableList<Flashcard> = mutableListOf() // Make flashcards mutable if you plan to modify it

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView and the adapter
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView?.layoutManager = LinearLayoutManager(this)

        // Initialize adapter and pass callbacks for editing and deleting flashcards
        flashcardAdapter = FlashcardAdapter(flashcards, ::editFlashcard, ::deleteFlashcard)
        recyclerView?.adapter = flashcardAdapter

        // Floating Action Button for adding new flashcards
        val fabAdd = findViewById<FloatingActionButton>(R.id.fab_add_flashcard)
        fabAdd.setOnClickListener {
            // Call the function to add a new flashcard
            addNewFlashcard()
        }
    }

    // Function to handle adding a new flashcard
    private fun addNewFlashcard() {
        // Create a new flashcard and add it to the list
        val newFlashcard = Flashcard(
            id = flashcards.size + 1,
            question = "Sample Question ${flashcards.size + 1}?",
            answer = "Sample Answer"
        )

        // Add the new flashcard to the list and update the adapter
        flashcards.add(newFlashcard)
        flashcardAdapter?.notifyItemInserted(flashcards.size - 1)
    }

    // Function to handle editing a flashcard
    private fun editFlashcard(flashcard: Flashcard) {
        // Show a simple toast for now (replace with actual editing logic)
        Toast.makeText(this, "Editing: ${flashcard.question}", Toast.LENGTH_SHORT).show()
        // Implement actual editing (e.g., show a dialog or navigate to an edit screen)
    }

    // Function to handle deleting a flashcard
    private fun deleteFlashcard(flashcard: Flashcard) {
        // Remove the flashcard from the list and notify the adapter
        val index = flashcards.indexOf(flashcard)
        if (index != -1) {
            flashcards.removeAt(index)
            flashcardAdapter?.notifyItemRemoved(index)
            Toast.makeText(this, "Deleted: ${flashcard.question}", Toast.LENGTH_SHORT).show()
        }
    }
}
