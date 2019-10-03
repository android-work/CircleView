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
	        implementation 'com.github.android-work:CircleViewAndDrawGezi:v1.0.3'
	}<br>
  
  ### 圆形图片控件<br>
  #### 布局文件
   <com.ancroid.work.circleview.CircleImageView<br>
        android:layout_marginTop="50dp"<br>
        android:layout_width="180dp"<br>
        android:layout_height="180dp"<br>
        app:resBg="@drawable/ic_default"<-- 如果未指定图片则使用默认的图片!--><br>
        android:id="@+id/circleview"/><br>
   #### 相关方法
   设置圆形头像的轮廓宽度：setStrokeWidth(float strokeWidth)默认4像素<br>
   设置轮廓颜色：setColor(int color)不需要可以设置为透明<br>
   更换图片：setBackground(Bitmap bitmap)未设置会使用系统默认的图片<br>
   
   
   
   ### 画格子控件<br>
   #### 布局文件
   <com.ancroid.work.circleview.DrawGeZiView <br>
        android:layout_marginLeft="5dp" <br>
        android:layout_marginRight="5dp" <br>
        android:layout_width="wrap_content" <br>
        android:layout_height="wrap_content" <br>
        android:id="@+id/gezi"/> <br>
   #### 相关方法
   设置格子线条颜色：setGeZiLinecolor(int color) <br>
   设置填充格子的颜色：setFillColor(int color) <br>
   设置格子线条宽度：setGeZiStroke(int size) <br>
   设置格子的宽度：setGeZiWidth(int geZiWidth) <br>
   设置总共需要画出多少格子：setGeZiCount(int geZiCount) <br>
   设置需要填充的格子:setFillCount(int fillCount) <br>
   设置格子背景色:setGeZiBg(int bgColor) <br>
  
  
  ### 图片描述<br>
   https://github.com/android-work/CircleView/blob/master/IMAGE/340A7B3E-5209-4e80-B2E3-644DC8392476.png
    
   ![图片描述](https://github.com/android-work/CircleView/blob/master/IMAGE/340A7B3E-5209-4e80-B2E3-644DC8392476.png)
