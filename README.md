自定义View是Android开发的基础。看到各种绚丽色彩的控件，满满的一顿羡慕。一直想系列的学习自定义View的实现，也就是这一系列文章的起源。

# Paint #

- [基础](http://blog.csdn.net/IO_Field/article/details/78460246)
	- 常用API
	- Flag:标志位
	- Color：画笔颜色设置
	- 辅助类
		- Paint.Cap：用于指定了针对线条和路径的开始和结束的处理方式
		- Paint.Join：用于指定线条和曲线在描边路径的处理方式
		- Paint.Style：用于指定画笔绘制图形时的样式
		- Paint.Align
- [Text(文本)：绘制文本](http://blog.csdn.net/IO_Field/article/details/78460278)
- [ColorFilter:颜色过滤器](http://blog.csdn.net/IO_Field/article/details/78460422)
	- ColorMatrixColorFilter：颜色矩阵过滤器
	- LightingColorFilter：模拟照明效果的过滤器
	- PorterDuffColorFilte：混合模式的色彩过滤器
- [MaskFilter：MaskFilter用来实现滤镜的效果，如滤化，浮雕，立体等](http://blog.csdn.net/IO_Field/article/details/78460438)
	- BlurMaskFilter：模糊效果
	- EmbossMaskFilter：浮雕效果 
- [PathEffect：用来指定Path展现的样式](http://blog.csdn.net/io_field/article/details/78464095)
	- CornerPathEffect：将Path的各个连接线段之间的夹角用指定半径的圆
	- DashPathEffect：将Path的线段虚线化
	- DiscretePathEffect：将路径切成segmentLength的行，随机偏离原始路径。
	- SumPathEffect：实现两个PathEffect的叠加效果
	- ComposePathEffect：实现两个PathEffect的组合效果
	- PathDashPathEffect：使用指定路径Path的图像作为间隔线来绘制Path
- [Shader:着色器](http://blog.csdn.net/IO_Field/article/details/78460469)
	- [BitmapShader：将位图作为纹理，以平铺的模式填充图形](http://blog.csdn.net/IO_Field/article/details/78460469)
	- [LinearGradient：线性渲染，其意味着着色器使用线性变化的颜色来进行渲染](http://blog.csdn.net/IO_Field/article/details/78460482)
	- [RadialGradient：放射性渐变，由中心点向四周逐渐渐变，其颜色渐变是由中心点向四周以线性变化](http://blog.csdn.net/IO_Field/article/details/78460490)
	- [SweepGradient：扫描渐变，类似于雷达，颜色绕着中心点，初始颜色从0度到360度线性渐变到边缘颜色](http://blog.csdn.net/IO_Field/article/details/78460503)
	- [ComposeShader：实现两个颜色渐变效果的叠加](http://blog.csdn.net/IO_Field/article/details/78460519)
- [Xfermode：过渡模式，也可以称之为图像混合模式](http://blog.csdn.net/io_field/article/details/78222527)
	- AvoidXfermode：从API 26以后过期
	- PixelXorXfermode：从API 26以后过期
	- PorterDuffXfermode：用于图形合成时的图像过渡模式计算
- [PorterDuff.Mode：图片合成模式，又分为Alpha合成模式和混合模式](http://blog.csdn.net/io_field/article/details/78222527)

<font color="red" size = 5>
未完待续....下一站 --> Canvas 
</font>
