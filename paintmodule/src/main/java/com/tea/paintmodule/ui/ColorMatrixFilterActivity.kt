package com.tea.paintmodule.ui

import android.graphics.ColorMatrix
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tea.paintmodule.R
import com.teaphy.arc.base.BaseSingleActivity

import kotlinx.android.synthetic.main.activity_color_matrix.*
import org.jetbrains.anko.startActivity

class ColorMatrixFilterActivity : BaseSingleActivity() {

    val colorArray = floatArrayOf(
            1f, 0f, 0f, 0f, 50f,
            0f, 1f, 0f, 0f, 50f,
            0f, 0f, 1f, 0f, 50f,
            0f, 0f, 0f, 1f, 0f)

    val colorArrayA = floatArrayOf(
            1f, 0f, 0f, 0f, 75f,
            0f, 1f, 0f, 0f, 75f,
            0f, 0f, 1f, 0f, 75f,
            0f, 0f, 0f, 1f, 0f)

    val colorArrayB = floatArrayOf(
            1f, 0f, 0f, 0f, 100f,
            0f, 1f, 0f, 0f, 100f,
            0f, 0f, 1f, 0f, 100f,
            0f, 0f, 0f, 1f, 0f)

    private val cm = ColorMatrix(colorArray)
    private val cmA = ColorMatrix(colorArrayA)
    private val cmB = ColorMatrix(colorArrayB)

    override fun getLayoutId(): Int {
        return R.layout.activity_color_matrix
    }

    override fun initTitle(): String {
        return "Color Matrix Filter"
    }

    override fun setListener() {
        super.setListener()

        btnSet.setOnClickListener {
            val colorArray = floatArrayOf(
                    1f, 0f, 0f, 0f, 50f,
                    0f, 1f, 0f, 0f, 50f,
                    0f, 0f, 1f, 0f, 50f,
                    0f, 0f, 0f, 1f, 0f)
            cmfv.setColorMatrix(colorArray)
        }

        btnReset.setOnClickListener {
            cmfv.resetColorMatrix()
        }

        btnSetConcat.setOnClickListener {

            Log.i("123", "转换前")
            Log.i("123", "cm: ${cm.array.asList()}")
            Log.i("123", "cmA: ${cmA.array.asList()}")
            Log.i("123", "cmB: ${cmB.array.asList()}")

            cm.setConcat(cmA, cmB)

            Log.i("123", "转换前")
            Log.i("123", "cm: ${cm.array.asList()}")
            Log.i("123", "cmA: ${cmA.array.asList()}")
            Log.i("123", "cmB: ${cmB.array.asList()}")

            cmfv.setColorMatrix(cm)
        }

        btnPostConcat.setOnClickListener {
            Log.i("123", "转换前")
            Log.i("123", "cm: ${cm.array.asList()}")
            Log.i("123", "cmA: ${cmA.array.asList()}")

            cm.postConcat(cmA)

            Log.i("123", "转换前")
            Log.i("123", "cm: ${cm.array.asList()}")
            Log.i("123", "cmA: ${cmA.array.asList()}")

            cmfv.setColorMatrix(cm)
        }

        btnPreConcat.setOnClickListener {

            Log.i("123", "转换前")
            Log.i("123", "cm: ${cm.array.asList()}")
            Log.i("123", "cmA: ${cmA.array.asList()}")

            cm.preConcat(cmA)

            Log.i("123", "转换前")
            Log.i("123", "cm: ${cm.array.asList()}")
            Log.i("123", "cmA: ${cmA.array.asList()}")

            cmfv.setColorMatrix(cm)
        }

        btnSetScale.setOnClickListener {
            Log.i("123", "转换前")
            Log.i("123", "cm: ${cm.array.asList()}")

            cm.setScale(1f, 2f, 0.5f, 1f)

            Log.i("123", "转换前")
            Log.i("123", "cm: ${cm.array.asList()}")

            cmfv.setColorMatrix(cm)
        }

        btnSetRotate.setOnClickListener {
            Log.i("123", "转换前")
            Log.i("123", "cm: ${cm.array.asList()}")

            cm.setRotate(0, 180f)

            Log.i("123", "转换后")
            Log.i("123", "cm: ${cm.array.asList()}")

            cmfv.setColorMatrix(cm)

        }

        btnSetSaturation.setOnClickListener {
            Log.i("123", "转换前")
            Log.i("123", "cm: ${cm.array.asList()}")

            cm.setSaturation(0f)

            Log.i("123", "转换后")
            Log.i("123", "cm: ${cm.array.asList()}")

            cmfv.setColorMatrix(cm)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
