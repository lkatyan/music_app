package com.example.musicapp.Activity.Main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.musicapp.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var loginEmail = findViewById<EditText>(R.id.login_email)
        var loginPassword = findViewById<EditText>(R.id.login_password)
        var loginButton = findViewById<Button>(R.id.login_button)
        var signupRedirectText = findViewById<TextView>(R.id.signupRedirectText)

        loginButton.setOnClickListener {

//            val email = loginEmail.text.toString()
//            val password = loginPassword.text.toString()
            val email = "tati@mail.ru"
            val password = "123"

            if (email.isEmpty()) {
                loginEmail.error = "Введите почту"
            } else if (password.isEmpty()) {
                loginPassword.error = "Введите пароль"
            } else {
//////////////////////////////////
                val loginIntent = Intent(applicationContext, MainActivity::class.java)
                startActivity(loginIntent)
//////////////////////////////////
///////////// начало нужного фрагмента
//                var database = FirebaseDatabase.getInstance()
//                var reference = database.getReference("users")
/////////////
//
//                var checkUserDatabase: Query = reference.orderByChild("email").equalTo(email)
//
//                checkUserDatabase.addListenerForSingleValueEvent(object : ValueEventListener {
//                    override fun onCancelled(error: DatabaseError) {
//                    }
//                    override fun onDataChange(snapshot: DataSnapshot) {
//
//                        if (snapshot.exists()) {
//                            for (userSnapshot in snapshot.children) {
//                                val userData = userSnapshot.getValue(HelperClass::class.java)
//                                if (userData!=null && userData.password == password) {
//                                    val loginIntent = Intent(applicationContext, MainActivity::class.java)
//                                    startActivity(loginIntent)
//                                } else {
//                                    loginPassword.error = "Неверный пароль"
//                                    loginPassword.requestFocus()
//                                }
//                            }
//
//                        } else {
//                            loginEmail.error = "Такого пользователя не существует"
//                            loginEmail.requestFocus()
//                        }
//                    }
//                })
                //конец нужного фрагмента

//                var checkUserDatabase: Query = reference.orderByChild("name").equalTo(name)
//
//                checkUserDatabase.addListenerForSingleValueEvent(object : ValueEventListener {
//                    override fun onCancelled(error: DatabaseError) {
//                    }
//                    override fun onDataChange(snapshot: DataSnapshot) {
//
//                        if (snapshot.exists()) {
//                            loginName.error = null
//                            var passwordFromDB = snapshot.child(name).child("password").value
//
//                            if (passwordFromDB == password) {
//                                loginName.error = null
//                                val loginIntent = Intent(applicationContext, MainActivity::class.java)
////                                loginIntent.putExtra("name", nameFromDB);
////                                loginIntent.putExtra("email", emailFromDB);
////                                loginIntent.putExtra("password", passwordFromDB);
//                                startActivity(loginIntent)
//                            } else {
//                                loginPassword.error = "Неверный пароль"
//                                loginPassword.requestFocus()
//                            }
//                        } else {
//                            loginName.error = "Такого пользователя не существует"
//                            loginName.requestFocus()
//                        }
//                    }
//                })
            }
        }

        signupRedirectText.setOnClickListener {
            val loginIntent = Intent(applicationContext, SignUpActivity::class.java)
            startActivity(loginIntent)
        }
    }
}