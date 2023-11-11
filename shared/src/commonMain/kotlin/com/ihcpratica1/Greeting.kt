package com.ihcpratica1

import kotlin.random.Random

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): List<String> = buildList{
        add(if (Random.nextBoolean()) "Hello" else "Heya");
        add(" ${platform.name}!");
    }
}