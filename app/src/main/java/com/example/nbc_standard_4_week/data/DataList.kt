package com.example.nbc_standard_4_week.data

//DataMode
const val item_card1 = 1
const val item_card2 = 2
const val item_card3 = 3

/*enum class ViewType(type: String) {
    CARD1("card1"),
    CARD2("card2"),
    CARD3("card3")
}*/

fun dataList(): MutableList<Data> {
    return mutableListOf(
        Data(
            type = item_card1,
            tvName = "Anderson",
            num1 = 2423,
            num2 = 3581,
            num3 = 9503,
            num4 = 2412,
            YM = "21/24",
            price = 3100.30
        ),
        Data(
            type = item_card2,
            tvName = "John",
            num1 = 1234,
            num2 = 5678,
            num3 = 9876,
            num4 = 5432,
            YM = "21/24",
            price = 2459.60
        ),
        Data(
            type = item_card3,
            tvName = "Mash",
            num1 = 4564,
            num2 = 4564,
            num3 = 7895,
            num4 = 4125,
            YM = "21/24",
            price = 4567.20
        ),
    )
}