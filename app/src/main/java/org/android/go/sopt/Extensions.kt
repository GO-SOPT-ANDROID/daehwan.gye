package org.android.go.sopt

import org.android.go.sopt.databinding.ActivitySignUpBinding

fun ActivitySignUpBinding.idSucceed() = (this.etId.text?.length ?: 0) in 6..10
fun ActivitySignUpBinding.pwSucceed() = (this.etPw.text?.length ?: 0) in 8..12