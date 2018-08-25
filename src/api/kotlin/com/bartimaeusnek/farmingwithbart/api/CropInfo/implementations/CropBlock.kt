package com.bartimaeusnek.farmingwithbart.api.CropInfo.implementations

import com.bartimaeusnek.farmingwithbart.main
import com.bartimaeusnek.farmingwithbart.registries.ItemSeedsRegistry
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class CropBlock: Block {

    constructor() : super(Material.WOOD){
        this.creativeTab=main.CTAB
    }

    lateinit var te:CropTE

    override fun hasTileEntity(state: IBlockState?): Boolean {
        return super.hasTileEntity(state)
    }

    override fun createTileEntity(world: World?, state: IBlockState?): TileEntity? {
        this.te=CropTE(null)
        return te
    }

    override fun onBlockActivated(worldIn: World?, pos: BlockPos?, state: IBlockState?, playerIn: EntityPlayer?, hand: EnumHand?, facing: EnumFacing?, hitX: Float, hitY: Float, hitZ: Float): Boolean {
        var isih:ItemStack? = when(hand){
            EnumHand.MAIN_HAND -> playerIn!!.heldItemMainhand
            EnumHand.OFF_HAND -> playerIn!!.heldItemOffhand
            else -> playerIn!!.activeItemStack
        }
        if(te!!.CropInfo==null){
            if(ItemSeedsRegistry().get_crop(isih)!=null){
                te!!.CropInfo=ItemSeedsRegistry().get_crop(isih)
                return true
            }
        }
        return false
    }
}