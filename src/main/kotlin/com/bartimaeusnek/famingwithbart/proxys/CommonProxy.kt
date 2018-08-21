package com.bartimaeusnek.famingwithbart.proxys

import com.bartimaeusnek.famingwithbart.api.CropInfo.implementations.climates.ClimateRegistry
import com.bartimaeusnek.famingwithbart.api.CropInfo.implementations.climates.TestClimate
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

open class CommonProxy{

    open fun preInit(event: FMLPreInitializationEvent) {
        ClimateRegistry().register_climate(TestClimate())
    }

    open fun Init(event: FMLInitializationEvent) {

    }

    open fun postInit(event: FMLPostInitializationEvent) {

    }
}