package com.example.musicapp.Activity.Main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.musicapp.Domain.HelperClass
import com.example.musicapp.R
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var signupName = findViewById<EditText>(R.id.signup_name)
        var signupEmail = findViewById<EditText>(R.id.signup_email)
        var signupPassword = findViewById<EditText>(R.id.signup_password)
        var signupSwitch = findViewById<Switch>(R.id.signup_switch)
        var signupButton = findViewById<Button>(R.id.signup_button)
        var loginRedirectText = findViewById<TextView>(R.id.loginRedirectText)

        signupButton.setOnClickListener {
            var database = FirebaseDatabase.getInstance()
            var reference = database.getReference("users")

            var name = signupName.text.toString()
            var email = signupEmail.text.toString()
            var password = signupPassword.text.toString()
            var switch = signupSwitch.isChecked.toString()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                signupButton.error = "Заполните все поля"
            } else {
                signupButton.error = null
                val userId = UUID.randomUUID().toString()
                var helper = HelperClass(name, email, password, switch, userId)
                reference.child(userId).setValue(helper)

                Toast.makeText(applicationContext, "Вы зарегистрировались", Toast.LENGTH_SHORT).show()
                val signupIntent = Intent(applicationContext, LoginActivity::class.java)
                startActivity(signupIntent)
            }
        }

        loginRedirectText.setOnClickListener {
            val signupIntent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(signupIntent)
        }
    }
}