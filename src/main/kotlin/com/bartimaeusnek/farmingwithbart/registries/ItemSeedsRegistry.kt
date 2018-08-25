package com.bartimaeusnek.farmingwithbart.registries

import com.bartimaeusnek.farmingwithbart.api.CropInfo.ICropInfo
import net.minecraft.item.ItemStack

class ItemSeedsRegistry {
    companion object {
        @JvmStatic
        val ItemStackregistry:HashMap<ItemStack,ICropInfo> = HashMap<ItemStack,ICropInfo>()
    }

    fun register_ItemSeed(IS:ItemStack,icte:ICropInfo):Boolean{
        ItemStackregistry[IS]=icte
        return true
    }

    fun get_crop(IS: ItemStack?):ICropInfo? = ItemStackregistry[IS]
}