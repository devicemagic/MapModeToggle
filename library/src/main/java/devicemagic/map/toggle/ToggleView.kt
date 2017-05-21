package devicemagic.map.toggle

import android.content.Context
import android.graphics.Color
import android.support.annotation.ColorInt
import android.support.annotation.Dimension
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.FrameLayout
import devicemagic.map.toggle.Utils.Companion.generateSquareBackground
import devicemagic.map.toggle.Utils.Companion.generateSquareBorder
import kotlinx.android.synthetic.main.toggle_view.view.*

/**
 * Created by Joel on 5/20/2017.
 */
class ToggleView : FrameLayout {

    var strokeColor = 0
    var primaryColor = 0
    var textSize = 0f
    var strokeSize = 0f
    var toggleModeListener: ToggleListener? = null
    lateinit var toggleMode: Mode

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs, defStyleAttr)
    }

    fun init(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) {

        LayoutInflater.from(getContext()).inflate(R.layout.toggle_view, this, true)

        val array = context?.obtainStyledAttributes(attrs, R.styleable.ToggleView, defStyleAttr, 0) ?: return

        textSize = array.getFloat(R.styleable.ToggleView_text_size, -1f)

        if (textSize == -1f) textSize = 10f


        strokeSize = array.getFloat(R.styleable.ToggleView_stroke_size, -1f)

        if (strokeSize == -1f) strokeSize = 1f


        strokeColor = array.getColor(R.styleable.ToggleView_stroke_color, -1)

        if (strokeColor == -1) strokeColor = ContextCompat.getColor(context, R.color.toggle_stroke)


        primaryColor = array.getColor(R.styleable.ToggleView_primary_color, -1)

        if (primaryColor == -1) primaryColor = ContextCompat.getColor(context, R.color.toggle_stroke)

        array.recycle()

        setLayoutStrokeBorder(strokeColor, strokeSize)
        setupButtonListeners()
        setFontSize(textSize)
        setToggleViewState(Mode.Map)

    }

    fun setFontSize(@Dimension sizeSp: Float) {
        satellite_text.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizeSp)
        map_text.setTextSize(TypedValue.COMPLEX_UNIT_SP, sizeSp)
    }

    fun setLayoutStrokeBorder(@ColorInt strokeColor: Int, strokeSize: Float) {

        var size = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, strokeSize, resources.displayMetrics))
        main.setPadding(size, size, size, size)
        main.background = generateSquareBorder(strokeColor, size)
    }

    fun setupButtonListeners() {
        satellite.setOnClickListener {
            toggleModeListener?.onSatelliteModeSelected()
            setToggleViewState(Mode.Satellite)
        }
        map.setOnClickListener {
            toggleModeListener?.onMapModeSelected()
            setToggleViewState(Mode.Map)
        }
    }

    fun setToggleViewState(mode: Mode) {
        toggleMode = mode

        if (mode.equals(Mode.Satellite)) {
            satellite_text.setTextColor(Color.WHITE)
            map_text.setTextColor(primaryColor)

            satellite.background = generateSquareBackground(primaryColor)
            map.setBackgroundColor(Color.WHITE)
        } else {
            satellite_text.setTextColor(primaryColor)
            map_text.setTextColor(Color.WHITE)

            map.background = generateSquareBackground(primaryColor)
            satellite.setBackgroundColor(Color.WHITE)
        }
    }

}