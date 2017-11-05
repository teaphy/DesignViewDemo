package com.tea.paintmodule.ui

import android.graphics.Shader
import android.view.View
import com.tea.paintmodule.R
import com.teaphy.arc.base.BaseSimpleActivity

import kotlinx.android.synthetic.main.activity_shader.*

class ShaderActivity : BaseSimpleActivity() {


    var mTileY: Shader.TileMode = Shader.TileMode.CLAMP


    override fun getLayoutId(): Int {
        return R.layout.activity_shader
    }

    override fun initTitle(): String {
        return "Shader"
    }

    override fun setListener() {
        btnCircle.setOnClickListener {
            llBitmapMode.visibility = View.VISIBLE
            rgTileX.check(R.id.rbClampX)
            rgTileY.check(R.id.rbClampY)
            shaderView.typeShader = 0
        }

        btnBitMap.setOnClickListener {
            llBitmapMode.visibility = View.VISIBLE
            rgTileX.check(R.id.rbClampX)
            rgTileY.check(R.id.rbClampY)
            shaderView.typeShader = 1
        }

        btnLinearGradient.setOnClickListener {
            llBitmapMode.visibility = View.GONE
            shaderView.typeShader = 2
        }

        btnRadialGradient.setOnClickListener {
            llBitmapMode.visibility = View.GONE
            shaderView.typeShader = 3
        }

	    btnSweepGradient.setOnClickListener {
		    llBitmapMode.visibility = View.GONE
		    shaderView.typeShader = 4
	    }

	    btnComposeShader.setOnClickListener {
		    llBitmapMode.visibility = View.GONE
		    shaderView.typeShader = 5
	    }

        rgTileX.setOnCheckedChangeListener { _, checkedId ->
            val tileX = when (checkedId) {
                R.id.rbClampX -> Shader.TileMode.CLAMP
                R.id.rbMirrorX -> Shader.TileMode.MIRROR
                R.id.rbRepeatX -> Shader.TileMode.REPEAT
                else -> Shader.TileMode.CLAMP
            }
            shaderView.mTileX = tileX
        }

        rgTileY.setOnCheckedChangeListener { _, checkedId ->
            val tileY = when (checkedId) {
                R.id.rbClampY -> Shader.TileMode.CLAMP
                R.id.rbMirrorY -> Shader.TileMode.MIRROR
                R.id.rbRepeatY -> Shader.TileMode.REPEAT
                else -> Shader.TileMode.CLAMP
            }
            shaderView.mTileY = tileY
        }
    }

}
