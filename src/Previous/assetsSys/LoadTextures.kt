package assetsSys

import com.jme3.asset.AssetManager

class LoadTextures {
    companion object{
        fun initTextures(A: AssetManager){
            MyTextures.futuristicTexture = A.loadTexture("Rest\\Texture1.jpg")
            MyTextures.plantTexture = A.loadTexture("WorldObjectsTextures\\plant.jpg")
        }
    }
}