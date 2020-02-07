package World

import com.jme3.material.Material
import com.jme3.math.Vector3f
import com.jme3.scene.Geometry
import com.jme3.scene.shape.Box
import com.jme3.texture.Texture

import assetsSys.MyTextures

import com.lightbend.akka.sample.Core

class WorldElements {
    companion object {
        var myWorld = Array<Array<Array<WorldObject>>>(myMap.width, {Array<Array<WorldObject>>(myMap.length, {Array<WorldObject>(myMap.height, {WorldObject()})})})

        val cellSize = 1

        lateinit var plantMat: Material

//        box.localTranslation = Vector3f(0f, 0f, 3f)
//        mat1 = Material(assetManager,
//        "Common/MatDefs/Misc/Unshaded.j3md")
//        mat1.setTexture("ColorMap",
//        assetManager.loadTexture("Rest\\Texture1.jpg"))
//        mat1.additionalRenderState.blendMode = BlendMode.Alpha
//        box.queueBucket = Bucket.Transparent
//        box.material = mat1
//        rootNode.attachChild(box)

    }

    open class WorldObject {
        lateinit var img:Texture

        var myBox = Box(cellSize.toFloat(),cellSize.toFloat(),cellSize.toFloat())
        var geom = Geometry("Box", myBox)

        open class plant(): WorldObject() {
            constructor(V: Vector3f, t: Texture) : this() {
                this.img = t
                geom.localTranslation = V
                geom.material = Core.mat1
                geom.material.setTexture("ColorMap", MyTextures.plantTexture)
            }
        }

        open class deadOrganic(): WorldObject() {
            constructor(V: Vector3f, t: Texture) : this() {
                this.img = t
                geom.localTranslation = V
                geom.material = Core.mat1
                geom.material.setTexture("ColorMap", MyTextures.plantTexture)
            }
        }
    }
}