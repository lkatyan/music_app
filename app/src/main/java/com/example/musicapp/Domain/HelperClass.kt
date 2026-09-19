package com.example.musicapp.Domain

class HelperClass {
    lateinit var name: String
    lateinit var email: String
    lateinit var password: String
    lateinit var switch: String
    lateinit var userId: String

    constructor(name: String, email: String, password: String, switch: String, userId: String) {
        this.name = name
        this.email = email
        this.password = password
        this.switch = switch
        this.userId = userId
    }
    constructor()
}