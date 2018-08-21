package com.bartimaeusnek.famingwithbart.registries

import com.bartimaeusnek.famingwithbart.api.CropInfo.ICropInfo


class CropRegistry {
    companion object{
        @JvmStatic
        var registry : HashMap<String, HashMap<String,ICropInfo>> = HashMap<String, HashMap<String,ICropInfo>>()
    }

    fun register_crop(crop:ICropInfo){
        if (registry[crop.get_mod()] == null)
            registry[crop.get_mod()] = HashMap<String,ICropInfo>()
        registry[crop.get_mod()]!![crop.get_displayName()] = crop
    }
}