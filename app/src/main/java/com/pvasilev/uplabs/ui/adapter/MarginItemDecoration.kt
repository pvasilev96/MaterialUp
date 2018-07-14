package com.pvasilev.uplabs.ui.adapter

import android.graphics.Rect
import android.support.annotation.DimenRes
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

class MarginItemDecoration(@DimenRes private val margin: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val layoutManager = parent.layoutManager as GridLayoutManager
        val itemCount = parent.adapter!!.itemCount
        val itemPosition = parent.getChildAdapterPosition(view)
        val spanCount = layoutManager.spanCount
        val rowCount = itemCount / spanCount
        val (left, right) = computeHorizontalMargin(itemPosition, spanCount)
        val (top, bottom) = computeVerticalMargin(itemPosition, spanCount, rowCount)
        outRect.left = left
        outRect.right = right
        outRect.top = top
        outRect.bottom = bottom
    }

    private fun computeHorizontalMargin(itemPosition: Int, spanCount: Int): Pair<Int, Int> =
            when (itemPosition % spanCount) {
                0 -> Pair(margin, margin / 2)
                spanCount - 1 -> Pair(margin / 2, margin)
                else -> Pair(margin / 2, margin / 2)
            }


    private fun computeVerticalMargin(itemPosition: Int, spanCount: Int, rowCount: Int): Pair<Int, Int> =
            when (itemPosition / spanCount) {
                0 -> Pair(margin, margin / 2)
                rowCount - 1 -> Pair(margin / 2, margin)
                else -> Pair(margin / 2, margin / 2)
            }
}