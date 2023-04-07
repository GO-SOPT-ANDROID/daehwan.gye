package org.android.go.sopt.external.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.R
import org.android.go.sopt.databinding.ActivitySignUpBinding
import org.android.go.sopt.idSucceed
import org.android.go.sopt.pwSucceed

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_sign_up)

        onClick();
    }

    private fun onClick() {
        btnSignIn()

    }

    private fun btnSignIn() {
        binding.btnSignUp.setOnClickListener {
            with(binding) {
                if (idSucceed() && pwSucceed()) {
                    // do something
                }
            }
        }
    }
}