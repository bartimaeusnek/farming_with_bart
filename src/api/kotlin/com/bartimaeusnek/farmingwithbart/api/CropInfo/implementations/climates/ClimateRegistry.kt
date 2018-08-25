package com.bartimaeusnek.farmingwithbart.api.CropInfo.implementations.climates

import com.bartimaeusnek.farmingwithbart.api.CropInfo.IClimate
import net.minecraft.world.biome.Biome

class ClimateRegistry {
    companion object{
        @JvmStatic
        var registry : HashMap<Biome, IClimate> = HashMap<Biome, IClimate>()
    }

    fun register_climate(climate : IClimate) : Boolean{
        for (b:Biome in climate.get_biomes()) {
            registry[b] = climate
        }
        return true
    }

    fun get_climate(biome : Biome) : IClimate?  = registry[biome]

}