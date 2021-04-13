# EMA

**EMA** is a library based on MVVM architecture (Navigation and Android Architecture components), Kotlin coroutines, and dependency injection based on **KODEIN**.

This way you can create by a very easy and fast way robust and maintainable apps due to **EMA** support, which handles lots of classes that helps the developer to develop new features respecting the MVVM architecture.

You can see the documentation [here](https://github.com/babel-cdm/EMA/wiki).

# USE IT

To use the library add the following dependencies to Gradle:

Add the maven repository:
  >
      allprojects {
		    repositories {
			    ...
			    maven { url 'https://jitpack.io' }
    	  }
      }

Add the **EMA** dependencies
  >

    dependencies {
          implementation 'com.github.babel-cdm.EMA:ema-android:2.4.2'
    }

To use **test support library** add the following ones:

  >

    dependencies {
          implementation  'com.github.babel-cdm.EMA:ema-testing-core:2.4.2'
          implementation  'com.github.babel-cdm.EMA:ema-testing-android:2.4.2'
    }
