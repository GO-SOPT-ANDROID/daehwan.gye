package org.android.go.sopt.external

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.databinding.ActivitySignUpBinding
import org.android.go.sopt.get
import org.android.go.sopt.idSucceed
import org.android.go.sopt.internal.signup.SignUpUser
import org.android.go.sopt.pwSucceed
import org.android.go.sopt.toast
import retrofit2.Call
import retrofit2.Response

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

                ApiPool.signUpService.signUp(SignUpService.Request(
                    id = binding.etId.get(),
                    password = binding.etPw.get(),
                    name = binding.etName.get(),
                    skill = binding.etHobby.get()
                )).enqueue(object : retrofit2.Callback<SignUpService.Response> {
                    override fun onResponse(
                        call: Call<SignUpService.Response>,
                        response: Response<SignUpService.Response>
                    ) {
                        if(response.isSuccessful) {
                            Toast.makeText(this@SignUpActivity, "회원가입이 정상적으로 이루어졌습니다.", Toast.LENGTH_SHORT).show()

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
                            Toast.makeText(this@SignUpActivity, "회원가입이 정상적으로 처리되지 않았습니다.", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<SignUpService.Response>, t: Throwable) {
                        Toast.makeText(this@SignUpActivity, "네트워크 통신이 원활하지 못합니다.", Toast.LENGTH_SHORT).show()
                    }
                })


            } else {
                toast("id 혹은 password 가 정상적으로 입력되지 않았습니다.")
            }

        }
    }

    companion object {
        const val SIGN_UP_USER = "signUpUser"
    }
}