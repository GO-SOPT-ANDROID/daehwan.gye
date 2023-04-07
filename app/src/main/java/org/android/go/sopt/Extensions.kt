package org.android.go.sopt

import android.content.Context
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.android.go.sopt.databinding.ActivitySignUpBinding

fun ActivitySignUpBinding.idSucceed() = (this.etId.text?.length ?: 0) in 6..10
fun ActivitySignUpBinding.pwSucceed() = (this.etPw.text?.length ?: 0) in 8..12
fun EditText.get() = this.text.toString()
fun TextView.plus(value : String) {
    this.setText(this.text.toString() + value)
}
fun Context.toast(message : String) = Toast.makeText(this.applicationContext, message, Toast.LENGTH_SHORT).show()