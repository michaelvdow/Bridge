package com.apps.michaeldow.projectdao.mainactivity.chat.messagescreen

import com.google.firebase.Timestamp

class Message {
    var from: Int = 0
    var message: String = ""
    var type: String = "text"
    var timestamp: Timestamp? = null

    constructor() {}
}