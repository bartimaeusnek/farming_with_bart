package com.bartimaeusnek.farmingwithbart.util

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

class CreativeTab : CreativeTabs("Farming with Bart") {
    @SideOnly(Side.CLIENT)
    override fun createIcon(): ItemStack = ItemStack(Items.STICK)


}