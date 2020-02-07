package myTest

import com.jme3.app.SimpleApplication
import com.jme3.asset.plugins.ZipLocator
import com.jme3.material.Material
import com.jme3.material.RenderState.BlendMode
import com.jme3.math.ColorRGBA
import com.jme3.math.Vector3f
import com.jme3.renderer.queue.RenderQueue.Bucket
import com.jme3.scene.Geometry
import com.jme3.scene.Node
import com.jme3.scene.shape.Box
import com.jme3.texture.Texture

import akka.actor.ActorRef
import akka.actor.ActorSystem
import com.jme3.asset.plugins.FileLocator
import com.jme3.opencl.Program

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 *
 * @author normenhansen
 */
class First2D : SimpleApplication() {

    fun setFile(name: String) = name + ".png"

    override fun simpleInitApp() {
        assetManager.registerLocator("/home/sardor/IdeaProjects/Working BRS Animation/res/assets/BRS", FileLocator::class.java)

        flyCam.isEnabled = false


        val firstRef = actorSystem.actorOf(PrintMyActorRefActor.props(), "first-actor")
        stand1 = assetManager.loadTexture(setFile("Stand1"))
        stand2 = assetManager.loadTexture(setFile("Stand2"))
        stand3 = assetManager.loadTexture(setFile("Stand3"))

        slash1 = assetManager.loadTexture(setFile("Slash1"))
        slash2 = assetManager.loadTexture(setFile("Slash2"))

        background.localTranslation = Vector3f(0f, 0f, 0f)
        backgroundMat = Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md")
        backgroundMat.setColor("Color", ColorRGBA.White)
        background.material = backgroundMat

        val pivot1 = Node("pivot")
        pivot1.attachChild(background)

        rootNode.attachChild(pivot1)


        blue.localTranslation = Vector3f(0f, 0f, 3f)
        mat1 = Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md")
//        mat1.setTexture("ColorMap",
//                assetManager.loadTexture("Slash1.png"))
        mat1.additionalRenderState.blendMode = BlendMode.Alpha
        blue.queueBucket = Bucket.Transparent
        blue.material = mat1

        val pivot2 = Node("pivot")
        pivot2.attachChild(blue)

        rootNode.attachChild(pivot2)

        firstRef.tell("startAnim", ActorRef.noSender())

    }


    override fun simpleUpdate(tpf: Float) {
        //pivot2.rotate(0.002f,0f,0f);
    }

    companion object {

        val actorSystem = ActorSystem.create("testSystem")

        lateinit var stand1: Texture
        lateinit var stand2: Texture
        lateinit var stand3: Texture

        lateinit var slash1: Texture
        lateinit var slash2: Texture

        var backgroundBox = Box(100f, 100f, 0f)
        internal var background = Geometry("background", backgroundBox)
        lateinit var backgroundMat: Material

        var goAnim = MyThread()

        internal var firstRect = Box(1f, 1f, 0f)
        internal var blue = Geometry("Box", firstRect)
        lateinit var mat1: Material

        var pivot2 = Node("pivot2")
        var rotationX = 0f

        var fullPath = Program::class.java!!.getResource("Stand1.png")




        @JvmStatic
        fun main(args: Array<String>) {
            val app = First2D()
            println("$fullPath")
            app.start()

        }
    }


}

