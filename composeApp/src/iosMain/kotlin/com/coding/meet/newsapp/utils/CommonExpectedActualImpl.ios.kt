package com.coding.meet.newsapp.utils

import platform.Foundation.NSUUID

actual fun getType(): Type {
    return Type.Mobile
}

actual fun getRandomId() : String{
    return NSUUID().UUIDString()

}