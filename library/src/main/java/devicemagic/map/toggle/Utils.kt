package devicemagic.map.toggle

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.support.annotation.ColorInt

/**
 * Created by Joel on 5/20/2017.
 */
class Utils {

    companion object {

        fun generateSquareBorder(@ColorInt borderColor: Int,borderWidth:Int): GradientDrawable {

            var square = GradientDrawable()
            square.shape = GradientDrawable.RECTANGLE
            square.cornerRadii = floatArrayOf( 8f, 8f, 8f, 8f, 0f, 0f, 0f, 0f )
            square.setColor(Color.TRANSPARENT)
            square.setStroke(borderColor,borderWidth)

            return square
        }
    }
}