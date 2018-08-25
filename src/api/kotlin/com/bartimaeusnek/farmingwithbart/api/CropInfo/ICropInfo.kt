package com.bartimaeusnek.farmingwithbart.api.CropInfo

import com.bartimaeusnek.farmingwithbart.api.CropInfo.implementations.CropTE
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

interface ICropInfo {

    fun get_mod(): String
    fun get_displayName(): String
    fun get_author(): String
    fun get_tier():Byte
    fun get_drops():List<ItemStack>
    fun get_needed_below():ItemStack
    fun get_breedingTree(): IBreedingTree
    fun get_max_size():Byte
    fun get_needed_climate(): IClimate
    fun get_tolerance():ByteArray

    fun get_can_grow(crop : CropTE):Boolean


    @SideOnly(Side.CLIENT)
    fun getTexturesLocation(): List<ResourceLocation>


}