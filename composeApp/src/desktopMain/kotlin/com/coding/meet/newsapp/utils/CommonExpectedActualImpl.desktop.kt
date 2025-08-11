package com.coding.meet.newsapp.utils

import java.util.UUID

actual fun getType(): Type {
   return Type.Desktop
}

actual fun getRandomId(): String {
    return UUID.randomUUID().toString()
}