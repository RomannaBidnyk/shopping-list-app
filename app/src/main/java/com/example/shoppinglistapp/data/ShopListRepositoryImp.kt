package com.example.shoppinglistapp.data

import com.example.shoppinglistapp.domain.ShopItem
import com.example.shoppinglistapp.domain.ShopListRepository

object ShopListRepositoryImp : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementedId = 0

    init {
        for (i in 0 until 10) {
            val item = ShopItem("Name $i", i, true)
            addShopItem(item)
        }
    }

    override fun addShopItem(item: ShopItem) {
        if (item.id == ShopItem.UNDEFINED_ID) {
            item.id = autoIncrementedId++
        }
        shopList.add(item)
    }

    override fun deleteShopItem(item: ShopItem) {
        shopList.remove(item)
    }

    override fun editShopItem(item: ShopItem) {
        val oldElement = getShopItemById(item.id)
        deleteShopItem(oldElement)
        addShopItem(item)
    }

    override fun getShopItemById(id: Int): ShopItem {
        return shopList.find {
            it.id == id
        } ?: throw RuntimeException("Element with id $id not found")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}
