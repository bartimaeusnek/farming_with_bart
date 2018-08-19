package com.bartimaeusnek.famingwithbart.proxys

import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

class ClientProxy : CommonProxy{

    constructor(): super()

    override fun preInit(event: FMLPreInitializationEvent) {
        super.preInit(event)
    }

    override fun Init(event: FMLInitializationEvent) {
        super.Init(event)
    }

    override fun postInit(event: FMLPostInitializationEvent) {
        super.postInit(event)
    }
}