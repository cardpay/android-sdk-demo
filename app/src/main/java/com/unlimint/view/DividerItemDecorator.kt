package com.unlimint.view

import android.graphics.Canvas
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.unlimint.utils.px

class DividerItemDecorator(@DrawableRes val dividerRes: Int) : RecyclerView.ItemDecoration() {

    override fun onDrawOver(c: Canvas, parent: RecyclerView) {
        val divider = ContextCompat.getDrawable(parent.context, dividerRes) ?: return

        val dividerLeft = parent.paddingLeft + DIVIDER_LEFT_MARGIN.px()
        val dividerRight = parent.width - parent.paddingRight
        val childCount = parent.childCount

        repeat(childCount - 1) {
            val child = parent.getChildAt(it)
            val params = child.layoutParams as? RecyclerView.LayoutParams ?: return
            val dividerTop = child.bottom + params.bottomMargin
            val dividerBottom = dividerTop + divider.intrinsicHeight
            divider.setBounds(dividerLeft.toInt(), dividerTop, dividerRight, dividerBottom)
            divider.draw(c)
        }
    }

    private companion object {
        const val DIVIDER_LEFT_MARGIN = 12f
    }
}