package com.bartimaeusnek.famingwithbart.api.CropInfo

import net.minecraft.world.biome.Biome

interface IClimate {

    fun get_name():String
    fun get_humidity():Byte
    fun get_solar_level():Byte
    fun get_nutrient_level():Byte
    fun get_windlevel():Byte

    fun get_biomes():ArrayList<Biome>

    fun get_special():ArrayList<Boolean>

}