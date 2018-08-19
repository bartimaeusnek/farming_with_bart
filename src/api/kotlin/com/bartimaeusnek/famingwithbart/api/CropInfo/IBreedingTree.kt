package com.bartimaeusnek.famingwithbart.api.CropInfo

interface IBreedingTree {

    fun get_branch():String
    fun get_tier():Byte
    fun get_mutation():Byte
    fun get_normalisation():Byte

}