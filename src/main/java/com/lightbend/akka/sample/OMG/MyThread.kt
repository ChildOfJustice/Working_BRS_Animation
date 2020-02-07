package myTest

import by.bkug.akka.sample.Animation.AllElements
import com.jme3.math.ColorRGBA

class MyThread : Thread() {
    val materialParameter = "ColorMap"
    val delay: Long = 400
    fun go() {
        start()
    }

    override fun run() {
        var i = 1
        while (i < 10) {
            for (frame in AllElements.standAnim){
                First2D.mat1.setTexture(materialParameter, frame)

                if (frame != First2D.stand3) {
                    sleep(delay)
                } else sleep(delay*2)
            }

           for (frame in AllElements.slashAnim){
               First2D.mat1.setTexture(materialParameter, frame)
                sleep(100)
           }
            i++
        }
        First2D.actorSystem.terminate()
    }
}
