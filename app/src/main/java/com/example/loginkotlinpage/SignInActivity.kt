package com.example.loginkotlinpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginkotlinpage.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.loginbtn.setOnClickListener{
            val Loginemail = binding.edemail.text.toString()
            val Loginpassword = binding.edpassword.text.toString()


            if(Loginemail.isNotEmpty() && Loginpassword.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(Loginemail,Loginpassword)
                    .addOnCompleteListener {task->
                        if (task.isSuccessful){

                            startActivity(Intent(this,MainActivity::class.java))
                            Toast.makeText(this,"Login Sucessfully",Toast.LENGTH_SHORT).show()

                        }else{
                            Toast.makeText(this,"Login Failed", Toast.LENGTH_SHORT).show()
                        }
                    }
            }else{
                Toast.makeText(this,"Please the Fill Info First", Toast.LENGTH_SHORT).show()
            }

        }
        binding.txtsignup.setOnClickListener{
            startActivity(Intent(this,SignUpActivity::class.java))
        }
    }
}