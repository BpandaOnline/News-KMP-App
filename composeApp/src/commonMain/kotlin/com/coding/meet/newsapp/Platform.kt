package com.coding.meet.newsapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform