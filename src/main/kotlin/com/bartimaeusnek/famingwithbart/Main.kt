package com.bartimaeusnek.famingwithbart

import com.bartimaeusnek.famingwithbart.proxys.ClientProxy
import com.bartimaeusnek.famingwithbart.proxys.ServerProxy
import net.minecraftforge.fml.common.FMLCommonHandler
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

@Mod(modid = main.MODID, name = main.NAME, version = main.VERSION, modLanguageAdapter="net.shadowfacts.forgelin.KotlinAdapter")
class main{


    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {

        if (FMLCommonHandler.instance().effectiveSide.isClient)
            clientside.preInit(event)
        if (FMLCommonHandler.instance().effectiveSide.isServer)
            serverside.preInit(event)
    }

    @Mod.EventHandler
    fun Init(event: FMLInitializationEvent) {
        if (FMLCommonHandler.instance().effectiveSide.isClient)
            clientside.Init(event)
        if (FMLCommonHandler.instance().effectiveSide.isServer)
            serverside.Init(event)
    }

    @Mod.EventHandler
    fun postInit(event: FMLPostInitializationEvent) {
        if (FMLCommonHandler.instance().effectiveSide.isClient)
            clientside.postInit(event)
        if (FMLCommonHandler.instance().effectiveSide.isServer)
            serverside.postInit(event)
    }

    companion object {

        const val NAME = "Farming with Bart"
        const val MODID = "farmingwithbart"
        const val VERSION = "0.0.1"

        val clientside = ClientProxy()
        val serverside = ServerProxy()

        @Mod.Instance
        var INSTANCE: main? = null
    }


}