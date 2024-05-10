package com.example.nbc_standard_4_week.presentation.main

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

data class FragmentTabModel(
    @StringRes val title: Int,
    val fragment: Fragment
)
//리소스 아이디 관련 애너테이션
//요소의 값이 이 애너테이션들이 의미하는 리소스 타입에 해당하는 리소스의 아이디임을 의미한다.
//Android 모든 리소스는 R 클래스에 의해 int 타입의 아이디로 관리