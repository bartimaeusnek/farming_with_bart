package com.bartimaeusnek.famingwithbart.api.CropInfo

import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

interface ICropTE{

    fun readFromNBT(compound: NBTTagCompound?)
    fun writeToNBT(compound : NBTTagCompound?):NBTTagCompound

    fun get_below():ItemStack

    fun get_size():Byte

    fun get_climate():IClimate
    fun get_CropInfo():ICropInfo
    fun get_breedingTree():IBreedingTree

    fun get_try_cross():Boolean
    fun get_isolation():Boolean

    fun get_drop():ItemStack
    fun get_seeds():ItemStack

    fun harvest_crop():Boolean
    fun pick_crop():Boolean
    fun pick_weeds():Boolean

    fun water_crop(amount : Byte):Byte //set water
    fun fertilize_crop(amount : Byte):Byte //set nutrients
    fun ventilate_crop(amount : Byte):Byte //set air quality

    fun get_air_quality():Byte
    fun get_nutrients():Byte
    fun get_water():Byte

    fun get_growth():Byte
    fun get_gain():Byte
    fun get_resistance():Byte

    @SideOnly(Side.CLIENT)
    fun getInformation(): List<String>
}