package com.bartimaeusnek.famingwithbart.api.CropInfo

import com.bartimaeusnek.famingwithbart.api.CropInfo.implementations.climates.ClimateRegistry
import net.minecraft.init.Items
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.tileentity.TileEntity
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import java.util.*

open class CropTE(CropInfo : ICropInfo) : TileEntity(), ICropTE {

    var size: Byte = 0
    var climate:IClimate = ClimateRegistry.registry[this.getWorld().getBiome(this.getPos())]!!

    var growquallity: ByteArray = byteArrayOf(-1,-1,-1) //Growth Gain Resistance
    var plantstats: ByteArray = byteArrayOf(-1,-1,-1)
    var playerinfluencedstats:  ByteArray = byteArrayOf(-1,-1,-1)

    var CropInfo : ICropInfo = CropInfo

    var statArray: Array<ByteArray> = arrayOf(growquallity,plantstats,playerinfluencedstats)
    var dirty = true

    constructor(growquallity: ByteArray,plantstats: ByteArray, playerinfluencedstats:  ByteArray, CropInfo:ICropInfo) : this(CropInfo) {
        statArray = arrayOf(growquallity,plantstats,playerinfluencedstats)
    }

    constructor(plantstatArray : Array<ByteArray>,CropInfo : ICropInfo) : this(CropInfo) {
        statArray = plantstatArray

    }

    constructor(Gain :Byte, Growth:Byte, Resistance :Byte,CropInfo : ICropInfo ) : this(CropInfo) {
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


    override fun get_below(): ItemStack = ItemStack(this.getWorld().getBlockState(this.getPos().down(2)).block,1,this.getWorld().getBlockState(this.getPos().down(2)).block.getMetaFromState(this.getWorld().getBlockState(this.getPos().down(2))))

    @SideOnly(Side.CLIENT)
    override fun getInformation(): List<String> {
        val ret : ArrayList<String> = ArrayList<String>()
        ret.add(this.get_CropInfo().get_mod())
        ret.add(this.get_CropInfo().get_author())
        ret.add(this.get_CropInfo().get_displayName())
        ret.add(this.get_CropInfo().get_needed_climate().get_name())
        ret.add(this.get_climate().get_name())
        ret.add(this.get_CropInfo().get_tolerance()[0].toString())
        ret.add(this.get_CropInfo().get_tolerance()[1].toString())
        ret.add(this.get_CropInfo().get_tolerance()[2].toString())
        ret.add(this.get_CropInfo().get_tolerance()[3].toString())
        return ret
    }

    override fun get_size(): Byte = size

    override fun get_climate(): IClimate = climate

    override fun get_CropInfo(): ICropInfo = CropInfo

    override fun get_breedingTree(): IBreedingTree = CropInfo.get_breedingTree()

    override fun get_try_cross(): Boolean = true

    override fun get_isolation(): Boolean = true

    override fun get_drop(): ItemStack = CropInfo.get_drops()[SplittableRandom().nextInt(CropInfo.get_drops().size)]

    override fun get_seeds(): ItemStack = ItemStack.EMPTY

    override fun harvest_crop(): Boolean= true

    override fun pick_crop(): Boolean = true

    override fun pick_weeds(): Boolean = true

    override fun water_crop(amount: Byte): Byte = 0

    override fun fertilize_crop(amount: Byte): Byte = 0

    override fun ventilate_crop(amount: Byte): Byte = 0

    override fun get_air_quality(): Byte = playerinfluencedstats[0]

    override fun get_nutrients(): Byte = playerinfluencedstats[1]

    override fun get_water(): Byte = playerinfluencedstats[2]

    override fun get_growth(): Byte = growquallity[0]

    override fun get_gain(): Byte = growquallity[1]

    override fun get_resistance(): Byte = growquallity[2]


}