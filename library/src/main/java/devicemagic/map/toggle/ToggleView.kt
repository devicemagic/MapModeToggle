package devicemagic.map.toggle

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

/**
 * Created by Joel on 5/20/2017.
 */
class ToggleView : FrameLayout {

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

}