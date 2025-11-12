package org.example.project.datasource

import android.content.Context
import android.widget.Toast
import org.example.project.domain.Restaurant

class KFC(
    private val context: Context
): Restaurant {
    override fun eat(onEat: (String) -> Unit) {
        onEat("\uD83C\uDF57 Delicious chicken wings")

        Toast.makeText(context, "\uD83C\uDF57 Nyam nyam nyam", Toast.LENGTH_SHORT).show()
    }
}