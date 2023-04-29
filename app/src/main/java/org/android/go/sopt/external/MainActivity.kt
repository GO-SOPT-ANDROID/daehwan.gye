package org.android.go.sopt.external

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.android.go.sopt.databinding.ActivityMainBinding
import org.android.go.sopt.external.home.HomeActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        viewSetUp()
        onTouch()
    }

    private fun viewSetUp() {
        setContentView(binding.root)
    }

    private fun onTouch() {
        binding.btnHome.setOnClickListener {
            val toHome = Intent(this, HomeActivity::class.java)
            startActivity(toHome)
        }
    }
}