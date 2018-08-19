package com.bartimaeusnek.famingwithbart.api.CropInfo

import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.tileentity.TileEntity
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

open class CropTE(CropInfo : ICropInfo) : TileEntity(), ICropTE {

    var growquallity: ByteArray = byteArrayOf(-1,-1,-1)
    var plantstats: ByteArray = byteArrayOf(-1,-1,-1)
    var playerinfluencedstats:  ByteArray = byteArrayOf(-1,-1,-1)
    var CropInfo : ICropInfo = CropInfo

    var statArray: Array<ByteArray> = arrayOf(growquallity,plantstats,playerinfluencedstats)
    var dirty = true

    constructor(growquallity: ByteArray,plantstats: ByteArray, playerinfluencedstats:  ByteArray, CropInfo:ICropInfo) : this() {
        statArray = arrayOf(growquallity,plantstats,playerinfluencedstats)
        this.CropInfo = CropInfo
    }

    constructor(plantstatArray : Array<ByteArray>) : this() {
        statArray = plantstatArray

    }

    constructor(Gain :Byte, Growth:Byte, Resistance :Byte ) : this() {
        growquallity = byteArrayOf(Gain,Growth,Resistance)
    }

    lateinit var tag : NBTTagCompound

    override fun writeToNBT(ftag : NBTTagCompound?):NBTTagCompound{
        super.writeToNBT(ftag)
        tag = when (ftag) {
            null -> NBTTagCompound()
            else -> ftag
        }

        val subtag = NBTTagCompound()
        subtag.setByteArray("growquallity",statArray[0])
        subtag.setByteArray("plantstats",statArray[1])
        subtag.setByteArray("playerinfluencedstats",statArray[2])
        tag!!.setTag("statArray",subtag)
        return tag!!
    }

    override fun readFromNBT(compound: NBTTagCompound?) {
        super.readFromNBT(compound)
        val subtag = compound!!.getCompoundTag("statArray")
        growquallity=subtag.getByteArray("growquallity")
        plantstats=subtag.getByteArray("plantstats")
        playerinfluencedstats=subtag.getByteArray("playerinfluencedstats")
        statArray = arrayOf(growquallity,plantstats,playerinfluencedstats)
    }


    override fun get_below(): ItemStack = ItemStack(this.getWorld().getBlockState(this.getPos().down(2)).block,1,this.getWorld().getBlockState(this.getPos().down(2)).block.getMetaFromState())

    @SideOnly(Side.CLIENT)
    override fun getInformation(): List<String> {
        val ret : ArrayList<String> = ArrayList<String>()
        ret.add(this.get_CropInfo().get_mod())
        ret.add(this.get_CropInfo().get_author())
        ret.add(this.get_CropInfo().get_displayName())
        ret.add(this.get_CropInfo().get_needed_climate().get_name())
        ret.add(this.get_climate().get_name())

    }

}