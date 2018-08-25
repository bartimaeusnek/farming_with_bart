package com.bartimaeusnek.farmingwithbart.api.CropInfo

import net.minecraft.world.biome.Biome

interface IClimate {

    fun get_name():String
    fun get_humidity():Byte
    fun get_solar_level():Byte
    fun get_nutrient_level():Byte
    fun get_windlevel():Byte
    fun get_climate_as_Array():ByteArray
    fun get_biomes():List<Biome>
    fun get_special():List<Boolean>

}