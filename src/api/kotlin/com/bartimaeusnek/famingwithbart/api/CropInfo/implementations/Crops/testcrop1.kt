package com.bartimaeusnek.famingwithbart.api.CropInfo.implementations.Crops

import com.bartimaeusnek.famingwithbart.api.CropInfo.CropTE
import com.bartimaeusnek.famingwithbart.api.CropInfo.IBreedingTree
import com.bartimaeusnek.famingwithbart.api.CropInfo.IClimate
import com.bartimaeusnek.famingwithbart.api.CropInfo.ICropInfo
import com.bartimaeusnek.famingwithbart.api.CropInfo.implementations.breedingTrees.GeneralPuropseTree
import com.bartimaeusnek.famingwithbart.api.CropInfo.implementations.climates.TestClimate
import net.minecraft.init.Blocks
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation


class testcrop1 : ICropInfo {

    override fun get_mod(): String = "testcrop"

    override fun get_displayName(): String = "testcrop"

    override fun get_author(): String = "testcrop"

    override fun get_tier(): Byte = 0

    override fun get_drops(): List<ItemStack> = listOf(ItemStack.EMPTY)

    override fun get_needed_below(): ItemStack = ItemStack(Blocks.DIRT)

    override fun get_breedingTree(): IBreedingTree = GeneralPuropseTree("test",0,0,0)

    override fun get_max_size(): Byte = 2

    override fun get_needed_climate(): IClimate = TestClimate()

    override fun get_tolerance(): ByteArray = byteArrayOf(0,0,0,0)

    override fun get_can_grow(crop: CropTE): Boolean = true

    override fun getTexturesLocation(): List<ResourceLocation> = listOf(ResourceLocation(""))
}