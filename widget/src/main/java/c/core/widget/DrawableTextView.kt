package c.core.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat

class DrawableTextView(context: Context, attributeSet: AttributeSet?) :
    AppCompatTextView(context, attributeSet) {
    private var leftWidth = -1
    private var leftHeight = -1
    private var topWidth = -1
    private var topHeight = -1
    private var rightWidth = -1
    private var rightHeight = -1
    private var bottomWidth = -1
    private var bottomHeight = -1


    init {
        val array = context.obtainStyledAttributes(
            attributeSet,
            R.styleable.DrawableTextView
        )

        leftWidth = array.getDimensionPixelSize(R.styleable.DrawableTextView_drawableLeftWidth, -1)
        leftHeight =
            array.getDimensionPixelSize(R.styleable.DrawableTextView_drawableLeftHeight, -1)

        topWidth = array.getDimensionPixelSize(R.styleable.DrawableTextView_drawableTopWidth, -1)
        topHeight = array.getDimensionPixelSize(R.styleable.DrawableTextView_drawableTopHeight, -1)

        rightWidth =
            array.getDimensionPixelSize(R.styleable.DrawableTextView_drawableRightWidth, -1)
        rightHeight =
            array.getDimensionPixelSize(R.styleable.DrawableTextView_drawableRightHeight, -1)

        bottomWidth =
            array.getDimensionPixelSize(R.styleable.DrawableTextView_drawableBottomWidth, -1)
        bottomHeight =
            array.getDimensionPixelSize(R.styleable.DrawableTextView_drawableBottomHeight, -1)

        array.recycle()

        val arrayHelper = context.obtainStyledAttributes(
            attributeSet,
            androidx.appcompat.R.styleable.AppCompatTextHelper
        )

        var drawableLeft: Drawable? = null
        var drawableTop: Drawable? = null
        var drawableRight: Drawable? = null
        var drawableBottom: Drawable? = null
        var drawableStart: Drawable? = null
        var drawableEnd: Drawable? = null
        arrayHelper.getResourceId(R.styleable.AppCompatTextHelper_android_drawableLeft, -1)
            .takeIf { it != -1 }?.apply {
                drawableLeft = ContextCompat.getDrawable(context, this)
            }
        arrayHelper.getResourceId(R.styleable.AppCompatTextHelper_android_drawableStart, -1)
            .takeIf { it != -1 }?.apply {
                drawableStart = ContextCompat.getDrawable(context, this)
            }
        arrayHelper.getResourceId(R.styleable.AppCompatTextHelper_android_drawableTop, -1)
            .takeIf { it != -1 }?.apply {
                drawableTop = ContextCompat.getDrawable(context, this)
            }
        arrayHelper.getResourceId(R.styleable.AppCompatTextHelper_android_drawableBottom, -1)
            .takeIf { it != -1 }?.apply {
                drawableBottom = ContextCompat.getDrawable(context, this)
            }
        arrayHelper.getResourceId(R.styleable.AppCompatTextHelper_android_drawableEnd, -1)
            .takeIf { it != -1 }?.apply {
                drawableEnd = ContextCompat.getDrawable(context, this)
            }
        arrayHelper.getResourceId(R.styleable.AppCompatTextHelper_android_drawableRight, -1)
            .takeIf { it != -1 }?.apply {
                drawableRight = ContextCompat.getDrawable(context, this)
            }

        arrayHelper.recycle()
        setCompoundDrawablesWithIntrinsicBounds(
            drawableStart ?: drawableLeft,
            drawableTop,
            drawableEnd ?: drawableRight,
            drawableBottom
        )
    }

    override fun setCompoundDrawablesWithIntrinsicBounds(
        left: Drawable?,
        top: Drawable?, right: Drawable?, bottom: Drawable?
    ) {
        left?.setBounds(
            0,
            0,
            if (leftWidth != -1) leftWidth else left.intrinsicWidth,
            if (leftHeight != -1) leftHeight else left.intrinsicHeight
        )
        top?.setBounds(
            0,
            0,
            if (topWidth != -1) topWidth else top.intrinsicWidth,
            if (topHeight != -1) topHeight else top.intrinsicHeight
        )
        right?.setBounds(
            0,
            0,
            if (rightWidth != -1) rightWidth else right.intrinsicWidth,
            if (rightHeight != -1) rightHeight else right.intrinsicHeight
        )
        bottom?.setBounds(
            0,
            0,
            if (bottomWidth != -1) bottomWidth else bottom.intrinsicWidth,
            if (bottomHeight != -1) bottomHeight else bottom.intrinsicHeight
        )
        setCompoundDrawables(left, top, right, bottom)
    }

}