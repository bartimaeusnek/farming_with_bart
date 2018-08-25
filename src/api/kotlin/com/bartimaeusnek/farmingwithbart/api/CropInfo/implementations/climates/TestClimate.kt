package com.bartimaeusnek.farmingwithbart.api.CropInfo.implementations.climates

import com.bartimaeusnek.farmingwithbart.api.CropInfo.IClimate
import net.minecraft.world.biome.Biome

class TestClimate : IClimate {
    override fun get_name(): String = "test"

    override fun get_humidity(): Byte = 0

    override fun get_solar_level(): Byte= 0

    override fun get_nutrient_level(): Byte = 0

    override fun get_windlevel(): Byte = 0

    override fun get_climate_as_Array(): ByteArray = byteArrayOf(0,0,0,0)

    override fun get_biomes(): List<Biome> {
        var ret : ArrayList<Biome> = ArrayList<Biome>()
        for (b : Biome in net.minecraft.world.biome.Biome.REGISTRY)
            ret.add(b)
        return ret
    }

    override fun get_special(): List<Boolean> = listOf<Boolean>(false)
}