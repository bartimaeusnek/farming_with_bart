package com.bartimaeusnek.famingwithbart.api.CropInfo.implementations.breedingTrees

import com.bartimaeusnek.famingwithbart.api.CropInfo.IBreedingTree

class GeneralPuropseTree(branch : String, tier :Byte, mutationrate :Byte, normalised :Byte) : IBreedingTree {

    val branch=branch
    val tier=tier
    val mutationrate=mutationrate
    val normalised=normalised

    override fun get_branch(): String = branch
    override fun get_tier(): Byte = tier
    override fun get_mutation(): Byte = mutationrate
    override fun get_normalisation(): Byte = normalised

}