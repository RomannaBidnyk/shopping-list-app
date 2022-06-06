package com.example.shoppinglistapp.presentation

import androidx.lifecycle.ViewModel
import com.example.shoppinglistapp.data.ShopListRepositoryImp
import com.example.shoppinglistapp.domain.DeleteShopItemUseCase
import com.example.shoppinglistapp.domain.EditShopItemUseCase
import com.example.shoppinglistapp.domain.GetShopListUseCase
import com.example.shoppinglistapp.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImp

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(item: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(item)
    }

    fun changeEnabledState(item: ShopItem) {
        val newShopItem = item.copy(enabled = !item.enabled)
        editShopItemUseCase.editShopItem(newShopItem)
    }
}
