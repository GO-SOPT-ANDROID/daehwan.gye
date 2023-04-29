package org.android.go.sopt.external

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.databinding.ActivitySignUpBinding
import org.android.go.sopt.get
import org.android.go.sopt.idSucceed
import org.android.go.sopt.internal.signup.SignUpUser
import org.android.go.sopt.pwSucceed
import org.android.go.sopt.toast

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClick()
    }

    private fun onClick() {
        btnSignIn()
    }

    private fun btnSignIn() {
        binding.btnSignUp.setOnClickListener {
            if (binding.idSucceed() && binding.pwSucceed()) {
                val toProfile = Intent(this@SignUpActivity, ProfileActivity::class.java)
                toProfile.putExtra(
                    SIGN_UP_USER,
                    SignUpUser(
                        id = binding.etId.get(),
                        password = binding.etPw.get(),
                        name = binding.etName.get(),
                        hobby = binding.etHobby.get()
                    )
                )
                toast("안녕하세요!")
                startActivity(toProfile)
                finish()
            } else {
                toast("id 혹은 password 가 정상적으로 입력되지 않았습니다.")
            }

        }
    }

    companion object {
        const val SIGN_UP_USER = "signUpUser"
    }
}