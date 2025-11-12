package org.example.project.datasource

import org.example.project.domain.Restaurant

class Kempinski: Restaurant {
    override fun eat(onEat: (String) -> Unit) {
        onEat("\uD83C\uDF71\uD83E\uDD57 Eats in rich person")
    }
}