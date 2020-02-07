package com.lightbend.akka.sample

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

import assetsSys.*
import World.*
import World.myMap.Companion.attachElementsToRootNode
import systemInterface.DrawSystemDialog
import javax.swing.JFrame

class Core : SimpleApplication(){
    companion object{
        lateinit var mat1:Material

        @JvmStatic
        fun main(args: Array<String>) {
            val app = Core()
            app.start()

//            var myFrame = JFrame("System Dialog")
//
//            myFrame.add(DrawSystemDialog.DrawPanel())
//            myFrame.isVisible = true
//            myFrame.setBounds(0, 0, 500, 400)
//            myFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
//            myFrame.isUndecorated = true
        }
    }

    override fun simpleInitApp() {
        assetManager.registerLocator("C:\\Users\\Andy\\Desktop\\DEVELOPMENT\\My Own Development and Education\\Kotlin\\BIO {AIS - 78}\\kotlin-akka-master\\kotlin-akka-sample\\assets", FileLocator::class.java)
        mat1 = Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md")

        flyCam.moveSpeed = 50f

        //println(rootNode.javaClass)
        LoadTextures.initTextures(assetManager)
        myMap.initMap()
        attachElementsToRootNode(rootNode)


    }

    override fun simpleUpdate(tpf: Float) {
        //pivot2.rotate(0.002f,0f,0f);
    }




}