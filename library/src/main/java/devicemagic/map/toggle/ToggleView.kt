package devicemagic.map.toggle

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import devicemagic.map.toggle.Utils.Companion.generateSquareBorder

/**
 * Created by Joel on 5/20/2017.
 */
class ToggleView : FrameLayout {

    var toggleViewStroke: Int = ContextCompat.getColor(context, R.color.toggle_stroke)
    var borderWidth = 3

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    fun init() {
        LayoutInflater.from(getContext()).inflate(R.layout.toggle_view, this, true)
    }

    fun setBackground() {
        background = generateSquareBorder(toggleViewStroke, borderWidth)
    }

}