package com.example.heart2heart.components

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

object HeartShape : Shape{
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: androidx.compose.ui.unit.Density
    ): Outline {
        val width = size.width
        val height = size.height

        val path = Path().apply {
            moveTo(width / 2f, height * 0.75f)


            cubicTo(
                width * 1.2f, height * 0.35f,
                width * 0.8f, height * 0.05f,
                width / 2f, height * 0.25f
            )

            cubicTo(
                width * 0.2f, height * 0.05f,
                width * -0.2f, height * 0.35f,
                width / 2f, height * 0.75f

            )
        }

        return Outline.Generic(path)
    }
}
