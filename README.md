# CircleView
自定义的一个展示圆形图片的框架
## 1、导入仓库<br>
  allprojects {<br>
		repositories {<br>
			...<br>
			maven { url 'https://jitpack.io' }<br>
		}<br>
	}<br>
  
## 2、导入依赖<br>
  dependencies {<br>
	        implementation 'com.github.android-work:CircleView:v1.0.1'
	}<br>
  
  ### 相关的动画调用方法<br>
   ### 布局文件
   <com.ancroid.work.circleview.CircleImageView<br>
        android:layout_marginTop="50dp"<br>
        android:layout_width="180dp"<br>
        android:layout_height="180dp"<br>
        app:resBg="@drawable/ic_default"<-- 如果未指定图片则使用默认的图片!--><br><br>
        android:id="@+id/circleview"/><br>
   ### 相关方法
   设置圆形头像的轮廓宽度：setStrokeWidth(float strokeWidth)默认4像素<br>
   设置轮廓颜色：setColor(int color)不需要可以设置为透明<br>
   更换图片：setBackground(Bitmap bitmap)未设置会使用系统默认的图片<br>
  
  
  ### 图片描述<br>
   https://github.com/android-work/CircleView/blob/master/IMAGE/53661197-D9C3-4ca0-908F-676BC9ABF6B3.png
    
   ![图片描述](https://github.com/android-work/CircleView/blob/master/IMAGE/53661197-D9C3-4ca0-908F-676BC9ABF6B3.png)
