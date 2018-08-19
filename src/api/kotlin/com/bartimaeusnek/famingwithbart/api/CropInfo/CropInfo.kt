package com.bartimaeusnek.famingwithbart.api.CropInfo

import net.minecraftforge.fml.common.Loader
import net.minecraftforge.fml.common.ModContainer
import net.minecraftforge.fml.relauncher.SideOnly
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.Side.CLIENT

abstract class CropInfo : ICropInfo{

    constructor(name:String,discovered:String,resourceLocationList: List<ResourceLocation>, climate : IClimate, breedingtree : IBreedingTree){
        this.name=name
        this.author=discovered
        this.re=resourceLocationList
        this.climate= climate
        this.breedingtree=breedingtree
    }

    @SideOnly(CLIENT)
    override fun getTexturesLocation(): List<ResourceLocation>{
        return re
    }

    var climate : IClimate
    var name : String
    var author : String
    var re : List<ResourceLocation>
    var breedingtree : IBreedingTree


    override fun get_mod(): String = getModId()

    override fun get_displayName(): String= name

    override fun get_author(): String = author

    override fun get_tier():Byte = breedingtree.get_tier()

    override fun get_needed_climate(): IClimate = climate

    private fun getModId():String{
        val modContainer : ModContainer? = Loader.instance().activeModContainer()
        if (modContainer != null) {
            return modContainer.modId
        }
        return ""
    }

    override fun get_can_grow(crop : CropTE): Boolean
            =  crop.get_below().equals(this.get_needed_below())
            && crop.get_size() < this.get_max_size()
            && get_needed_climate().equals(crop.get_climate())


}