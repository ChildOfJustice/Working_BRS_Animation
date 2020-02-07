package by.bkug.akka.sample.Animation

import com.jme3.texture.Texture
import myTest.First2D

class AllElements {
    companion object {
        val standAnim: List<Texture> = listOf(First2D.stand1, First2D.stand2, First2D.stand1, First2D.stand3)
        val slashAnim: List<Texture> = listOf(First2D.slash1, First2D.slash2)
    }
}