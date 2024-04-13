package com.example.nbc_standard_4_week.adapter.data

data class Dummy (
    val type: ItemType,
    val num1: String,
    val num2: String,
    val num3: String,
    val num4: String,
    val price: String
)

enum class ItemType {
    CARD1,
    CARD2,
    CARD3
}

object DummyData {
    fun generateDummyData(): List<Dummy> {
        val itemList = mutableListOf<Dummy>()

        // Dummy 데이터 생성
        for (i in 1..20) {
            when (i % 3) {
                0 -> itemList.add(Dummy(ItemType.CARD1, "Card1", "Num2", "Num3", "Num4", "10"))
                1 -> itemList.add(Dummy(ItemType.CARD2, "Card2", "Num2", "Num3", "Num4", "20"))
                2 -> itemList.add(Dummy(ItemType.CARD3, "Card3", "Num2", "Num3", "Num4", "30"))
            }
        }

        return itemList
    }
}