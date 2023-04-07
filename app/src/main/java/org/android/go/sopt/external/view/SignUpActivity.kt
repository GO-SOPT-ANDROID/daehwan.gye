package org.android.go.sopt.external.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.*
import org.android.go.sopt.databinding.ActivitySignUpBinding
import org.android.go.sopt.internal.signup.SignUpUser

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_sign_up)

        onClick()
    }

    private fun onClick() {
        btnSignIn()
    }

    private fun btnSignIn() {
        binding.btnSignUp.setOnClickListener {
            with(binding) {
                if (idSucceed() && pwSucceed()) {
                    val toProfile = Intent(this@SignUpActivity, ProfileActivity::class.java)
                    toProfile.putExtra(
                        "SignUpUser",
                        SignUpUser(
                            id = binding.etId.get(),
                            password = binding.etPw.get(),
                            name = binding.etName.get(),
                            hobby = binding.etHobby.get()
                        )
                    )
                    toast("안녕하세요!")
                    finish()
                } else {
                    toast("id 혹은 password 가 정상적으로 입력되지 않았습니다.")
                }
            }
        }
    }

    companion object {
        const val SIGN_UP_USER = "signUpUser"
    }
}