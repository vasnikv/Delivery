package ru.iv.utils

import petrov.delivery.webapi.*
import java.math.BigDecimal

object MockMobileClientApiResponse {
    fun getProducts(): ParamRespProduct {
        return ParamRespProduct(
                listOf(
                        CategoryWithProductList(1, "Роллы",
                                listOf(Product(1, "Пицца", "Четыре сыра", "Тесто, сыр моцарела, сыр пармезан, сыр рикота, сыр фета",
                                        "https://i.imgur.com/J9osDN7.jpeg", BigDecimal(370))
                                        , Product(2, "King Бургер", "Сочный бургер, приготовленный на огне", "Тесто, говядина, помидор, соленый огурец, сырный соус",
                                        "https://i.imgur.com/Oo543iV.jpeg", BigDecimal(180)),
                                        Product(3, "Пицца3", "Четыре сыра", "Тесто, сыр моцарела, сыр пармезан, сыр рикота, сыр фета",
                                                "https://i.imgur.com/J9osDN7.jpeg", BigDecimal(370))
                                        , Product(4, "King Бургер4", "Сочный бургер, приготовленный на огне", "Тесто, говядина, помидор, соленый огурец, сырный соус",
                                        "https://i.imgur.com/Oo543iV.jpeg", BigDecimal(180)),
                                        Product(5, "Пицца5", "Четыре сыра", "Тесто, сыр моцарела, сыр пармезан, сыр рикота, сыр фета",
                                                "https://i.imgur.com/J9osDN7.jpeg", BigDecimal(370))
                                        , Product(6, "King Бургер6", "Сочный бургер, приготовленный на огне", "Тесто, говядина, помидор, соленый огурец, сырный соус",
                                        "https://i.imgur.com/Oo543iV.jpeg", BigDecimal(180))
                                )
                        ),
                        CategoryWithProductList(2, "Пицца",
                                listOf(Product(3, "Шаурма", "Вкуснейшая куриная шаурма", "Курица, морковь, капуста, лук, перец",
                                        "https://i.imgur.com/J9osDN7.jpeg", BigDecimal(140))
                                )
                        )
                )
        )
    }

    fun getCompanyInfo(): ParamRespCompanyInfo {
        return ParamRespCompanyInfo(
                listOf(
                        CompanyPlace(Coords(56.86831,53.27369), "Автозаводская 2а"),
                        CompanyPlace(Coords(56.83746,53.21406), "Пушкинская 165")
                ),
                "Хочу Есть Халяль",
                "8 (84371) 7-00-77",
                "feedback@hochu_halal.ru")
    }
}