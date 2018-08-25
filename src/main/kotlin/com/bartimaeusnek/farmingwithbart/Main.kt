package com.bartimaeusnek.farmingwithbart

/**
 *
 * MIT License
 *
 * Copyright (c) 2018
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

import com.bartimaeusnek.farmingwithbart.proxys.ClientProxy
import com.bartimaeusnek.farmingwithbart.proxys.ServerProxy
import com.bartimaeusnek.farmingwithbart.util.CreativeTab
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

        @JvmStatic
        var CTAB = CreativeTab()

        const val NAME = "Farming with Bart"
        const val MODID = "farmingwithbart"
        const val VERSION = "0.0.1"

        val clientside = ClientProxy()
        val serverside = ServerProxy()

        @Mod.Instance
        var INSTANCE: main? = null
    }


}