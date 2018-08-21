package com.bartimaeusnek.famingwithbart.api.CropInfo.implementations.climates

import com.bartimaeusnek.famingwithbart.api.CropInfo.IClimate
import net.minecraft.world.biome.Biome

class ClimateRegistry {
    companion object{
        @JvmStatic
        var registry : LinkedHashMap<Biome,IClimate> = LinkedHashMap<Biome,IClimate>()
    }


    fun register_climate(climate : IClimate) : Boolean{
        for (b:Biome in climate.get_biomes()) {
            ClimateRegistry.registry[b] = climate
        }
        return true
    }


}