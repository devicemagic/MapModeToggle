package devicemagic.map.toggle

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import devicemagic.map.toggle.Utils.Companion.dipToPixels
import devicemagic.map.toggle.Utils.Companion.generateSquareBackground
import devicemagic.map.toggle.Utils.Companion.generateSquareBorder
import kotlinx.android.synthetic.main.toggle_view.view.*

/**
 * Created by Joel on 5/20/2017.
 */
class ToggleView : FrameLayout {

    var strokeColor = 0
    var primaryColor = 0
    var textSize = 0
    var borderWidth = 3
    var toggleModeListener:ToggleListener? = null

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context,attrs,defStyleAttr)
    }

    fun init(context:Context?,attrs: AttributeSet?,defStyleAttr: Int) {

        LayoutInflater.from(getContext()).inflate(R.layout.toggle_view, this, true)

        val array = context?.obtainStyledAttributes(attrs, R.styleable.MapModeToggle, defStyleAttr, 0) ?: return

        textSize = array.getDimensionPixelSize(R.styleable.MapModeToggle_text_size,-1)

        if(textSize==-1) textSize = dipToPixels(context,20)


        strokeColor = array?.getColor(R.styleable.MapModeToggle_stroke_color,-1)

        if(strokeColor==-1) strokeColor = ContextCompat.getColor(context,R.color.toggle_stroke)


        primaryColor = array?.getColor(R.styleable.MapModeToggle_primary_color,-1)

        if(primaryColor==-1) primaryColor = ContextCompat.getColor(context,R.color.toggle_stroke)

        array?.recycle()
    }

    fun setBackground() {
        background = generateSquareBorder(strokeColor, borderWidth)
    }

    fun setupButtonListeners()
    {
        satellite.setOnClickListener{ toggleModeListener?.onSatelliteModeSelected() }
        map.setOnClickListener{ toggleModeListener?.onMapModeSelected() }
    }


    fun setButtonBackground(mode:Mode) {


        if (mode.equals(Mode.Satellite)) {
            satellite.background = generateSquareBackground(primaryColor)
            map.background = null
        } else {
            satellite.background = null
            map.background = generateSquareBackground(primaryColor)
        }
    }

}