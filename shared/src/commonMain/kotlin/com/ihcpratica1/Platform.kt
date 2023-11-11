package com.ihcpratica1

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform