package com.bartimaeusnek.farmingwithbart.proxys

import com.bartimaeusnek.farmingwithbart.api.CropInfo.implementations.CropBlock
import com.bartimaeusnek.farmingwithbart.api.CropInfo.implementations.CropTE
import com.bartimaeusnek.farmingwithbart.api.CropInfo.implementations.climates.ClimateRegistry
import com.bartimaeusnek.farmingwithbart.api.CropInfo.implementations.climates.TestClimate
import net.minecraft.block.Block
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.registry.ForgeRegistries
import net.minecraftforge.fml.common.registry.GameRegistry

open class CommonProxy{

    lateinit var testcrop: Block

    open fun preInit(event: FMLPreInitializationEvent) {
        ClimateRegistry().register_climate(TestClimate())
        GameRegistry.registerTileEntity(CropTE::class.java, ResourceLocation("CropTE"))
        testcrop = CropBlock()
        testcrop.setRegistryName("CropTEBlock")
        ForgeRegistries.BLOCKS.register(testcrop)
    }

    open fun Init(event: FMLInitializationEvent) {

    }

    open fun postInit(event: FMLPostInitializationEvent) {

    }
}