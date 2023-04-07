package org.android.go.sopt.external.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.R
import org.android.go.sopt.databinding.ActivityProfileBinding
import org.android.go.sopt.external.view.SignUpActivity.Companion.SIGN_UP_USER
import org.android.go.sopt.internal.signup.SignUpUser
import org.android.go.sopt.plus

class ProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)

        viewSetUp()
    }

    private fun viewSetUp() {
        setContentView(binding.root)

        val signUpUser = intent.getSerializableExtra(SIGN_UP_USER) as SignUpUser

        binding.tvName.plus(signUpUser.name ?: "이름을 넣어주세요.")
        binding.tvHobby.plus(signUpUser.hobby ?: "취미를 정해주세요.")
    }
}