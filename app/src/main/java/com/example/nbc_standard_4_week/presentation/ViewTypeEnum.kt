package com.example.nbc_standard_4_week.presentation

enum class ViewTypeEnum(val viewType: Int) {
    CARD1(0),
    CARD2(1),
    CARD3(2),
    UNKNOWN(-1)
}

/*
enum class ?
* 관련된 상수들의 집합을 정의하는 특별한 종류의 클래스. 각각의 열거형 상수는 enum 클래스의 인스턴스로 간주된다.
*
* 사용 이유 ?
* 1. 가독성
* 2. 안전성
* 올바른 값만을 가지도록 보장할 수 있다.
* 3. 유연성
* 클래스이기 때문에 다른 클래스와 마찬가지로 메서드, 속성을 가질 수 있다. 활용해서 추가적으로 각 상수의 특징을 정의할 수 있다.*/