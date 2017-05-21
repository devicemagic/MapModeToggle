package devicemagic.map.toggle

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.support.annotation.ColorInt
import android.util.TypedValue

/**
 * Created by Joel on 5/20/2017.
 */
class Utils {

    companion object {

        fun generateSquareBorder(@ColorInt borderColor: Int,borderWidth:Int): GradientDrawable {

            var square = GradientDrawable()
            square.shape = GradientDrawable.RECTANGLE
            square.setColor(Color.WHITE)
            square.cornerRadius = 0f
            square.setStroke(borderWidth,borderColor)

            return square
        }

        fun generateSquareBackground(@ColorInt backgroundColor: Int): GradientDrawable {

            var square = GradientDrawable()
            square.shape = GradientDrawable.RECTANGLE
            square.setColor(backgroundColor)

            return square
        }

        fun dipToPixels(context: Context?,dipValue:Int):Int
        {
            var metrics = context?.resources?.displayMetrics
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue.toFloat(),metrics).toInt()
        }
    }
}