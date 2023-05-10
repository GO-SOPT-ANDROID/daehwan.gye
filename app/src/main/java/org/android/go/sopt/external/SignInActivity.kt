package org.android.go.sopt.external

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.databinding.ActivitySignInBinding
import org.android.go.sopt.toast
import retrofit2.Call
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onClick()
    }

    private fun onClick() {
        btnSignIn()
    }

    private fun btnSignIn() {
        binding.btnSignIn.setOnClickListener {
            if(binding.tvSignInId.text.isNotBlank() && binding.tvSignInPw.text.isNotBlank()) {
                val id = binding.tvSignInId.text.toString()
                val pw = binding.tvSignInPw.text.toString()

                ApiPool.signInService.signIn(SignInService.Request(id = id, password = pw)).enqueue(object : retrofit2.Callback<SignInService.Response> {
                    override fun onResponse(
                        call: Call<SignInService.Response>,
                        response: Response<SignInService.Response>
                    ) {
                        if(response.isSuccessful) {
                            Toast.makeText(this@SignInActivity, "로그인이 정상적으로 이루어졌습니다.", Toast.LENGTH_SHORT).show()

                            toast("안녕하세요! ${response.body()?.data?.name}")

                        } else {
                            Toast.makeText(this@SignInActivity, "로그인이 정상적으로 처리되지 않았습니다.", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<SignInService.Response>, t: Throwable) {
                        Toast.makeText(this@SignInActivity, "네트워크 통신이 원활하지 못합니다.", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}