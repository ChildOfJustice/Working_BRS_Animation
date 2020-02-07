package World

import assetsSys.MyTextures
import com.jme3.math.Vector3f
import com.jme3.scene.Node


class myMap {
    companion object {
        const val width = 10
        const val height = 10
        const val length = 10

        fun initMap() {
            for (i in 0 until width) {
                for (j in 0 until length) {
                    for (k in 0 until height) {
                        WorldElements.myWorld[i][j][k] = WorldElements.WorldObject.plant(Vector3f(i.toFloat()*2*WorldElements.cellSize, j.toFloat()*2*WorldElements.cellSize, k.toFloat()*2*WorldElements.cellSize), MyTextures.plantTexture)
                    }
                }
            }
        }

        fun attachElementsToRootNode(N: Node) {
            for (i in 0 until width) {
                for (j in 0 until length) {
                    for (k in 0 until height) {
                        N.attachChild(WorldElements.myWorld[i][j][k].geom)
                    }
                }
            }
        }
    }
}