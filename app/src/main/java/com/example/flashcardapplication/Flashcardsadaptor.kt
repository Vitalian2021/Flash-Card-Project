package com.example.flashcardapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.flashcardapplication.model.Flashcard

class FlashcardAdapter(
    private val flashcards: MutableList<Flashcard>,
    private val onEditClick: (Flashcard) -> Unit,
    private val onDeleteClick: (Flashcard) -> Unit
) : RecyclerView.Adapter<FlashcardAdapter.FlashcardViewHolder>() {

    inner class FlashcardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val questionTextView: TextView = itemView.findViewById(R.id.flashcard_question)
        val editButton: Button = itemView.findViewById(R.id.edit_button)
        val deleteButton: Button = itemView.findViewById(R.id.delete_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashcardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_flashcard, parent, false)
        return FlashcardViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlashcardViewHolder, position: Int) {
        val flashcard = flashcards[position]
        holder.questionTextView.text = flashcard.question

        holder.editButton.setOnClickListener {
            onEditClick(flashcard)  // Trigger the edit action
        }

        holder.deleteButton.setOnClickListener {
            onDeleteClick(flashcard)  // Trigger the delete action
        }
    }

    override fun getItemCount(): Int {
        return flashcards.size
    }

    fun addFlashcard(flashcard: Flashcard) {
        flashcards.add(flashcard)
        notifyItemInserted(flashcards.size - 1)
    }

    fun removeFlashcard(flashcard: Flashcard) {
        val position = flashcards.indexOf(flashcard)
        if (position != -1) {
            flashcards.removeAt(position)
            notifyItemRemoved(position)
        }
    }
}
