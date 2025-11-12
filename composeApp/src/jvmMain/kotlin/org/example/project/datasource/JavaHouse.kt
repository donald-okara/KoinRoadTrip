package org.example.project.datasource

import org.example.project.domain.Restaurant

class JavaHouse: Restaurant {
    override fun eat(onEat: (String) -> Unit) {
        onEat("☕ \uD83E\uDD6A Sips coffee")
    }
}