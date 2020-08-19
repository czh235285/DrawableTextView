# DrawableTextView


use Gradle:

```
repositories {
  maven { url "https://jitpack.io" }
  mavenCentral()
  google()
}
dependencies {
    implementation 'com.github.czh235285:DrawableTextView:1.0.0'
}
```
in xml :

```

    <c.core.widget.DrawableTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableStart="@mipmap/ic_launcher"
        android:drawableTop="@mipmap/ic_launcher"
        android:drawableEnd="@mipmap/ic_launcher"
        android:drawableBottom="@mipmap/ic_launcher"
        android:drawablePadding="10dp"
        android:gravity="center"
        android:text="Hello World!"
        app:drawableBottomHeight="160dp"
        app:drawableBottomWidth="160dp"
        app:drawableLeftHeight="20dp"
        app:drawableLeftWidth="20dp"
        app:drawableRightHeight="80dp"
        app:drawableRightWidth="80dp"
        app:drawableTopHeight="40dp"
        app:drawableTopWidth="40dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
		
```
