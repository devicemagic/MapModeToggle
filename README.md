# Map Mode Toggle in Kotlin 

[ ![JitPack](https://img.shields.io/github/release/devicemagic/MapModeToggle.svg?label=jitpack) ](https://jitpack.io/#devicemagic/MapModeToggle)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)


Map Mode Toggle is a library that allows you to create a widget that allows you to toggle between satellite and map mode when using  [Google Maps](https://developers.google.com/maps/documentation/android-api/).
It is written entirely in Kotlin, nonetheless it can still be used in Java based Android projects :)

<img src="https://github.com/devicemagic/MapModeToggle/raw/master/resources/screenshot.png" height="960" width="540">

---

# Table of Contents

1. [Gradle Dependency](https://github.com/devicemagic/MapModeToggle#gradle-dependency)
   1. [Repository](https://github.com/devicemagic/MapModeToggle#repository)
   2. [Dependency](https://github.com/devicemagic/MapModeToggle#dependency)
2. [Basic Usage](https://github.com/devicemagic/MapModeToggle#basic-usage)
   1. [Map Mode Toggle XML](https://github.com/devicemagic/MapModeToggle#map-mode-toggle-xml)
   2. [Attributes](https://github.com/devicemagic/MapModeToggle#attributes)
3. [Toggle View State](https://github.com/devicemagic/MapModeToggle#toggle-view-state)
4. [Event Listener](https://github.com/devicemagic/MapModeToggle#event-listener)
6. [Coming Soon](https://github.com/devicemagic/MapModeToggle#coming-soon)
6. [Contribution](https://github.com/devicemagic/MapModeToggle#contribution)
7. [License](https://github.com/devicemagic/MapModeToggle#license)

   
---

# Gradle Dependency


#### Repository

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

#### Dependency

Add this to your module's `build.gradle` file:

```gradle
dependencies {
	...
	compile 'com.github.devicemagic:MapModeToggle:1.2'
	}
}
```

---

# Basic Usage

The easiest way to get started with this simple widget is to look inside the app directory that contains example usage in both Kotlin and Java activities.
Below is an overview of how the example project is utilizing the library. 

#### Map Mode Toggle XML

To use this widget in your layout simply copy and paste the xml below. This provides the default functionality. 

```xml
 <devicemagic.map.toggle.ToggleView
        android:layout_width="200dp"
        android:id="@+id/toggle_view"    
        android:layout_height="20dp"
         />
```

#### Attributes

There are several other attributes that can be used to configure the button's behaviour and appearance. Some of these attributes can be set programmatically via the widget itself. 

```xml
 <devicemagic.map.toggle.ToggleView
        android:layout_width="200dp"
        android:id="@+id/toggle_view"
        app:primary_color="@color/colorPrimary"
        app:stroke_color="@color/colorPrimary"
        app:text_size="10dp"
        app:stroke_size="2dp"
         />
```
---

# Toggle View State

To set the inital state of the Toggle view you simply use the set mode functionality via Kotlin or Java.

#### Java


```java

    toggleView.setToggleViewState(Mode mode);

```


#### Kotlin

```kotlin
    toggleView.setToggleViewState(mode: Mode) 

```

---

# Event Listener

To listen to events from your toggle view, simply implement the listener that's triggered once the respective buttons are tapped.
#### Java

```java

toggleView.setToggleModeListener(new ToggleListener() {
            @Override
            public void onMapModeSelected() {
               
            }

            @Override
            public void onSatelliteModeSelected() {
                
            }
        });

```

#### Kotlin


```kotlin
toggle_view.toggleModeListener = this

override fun onMapModeSelected() {
}

override fun onSatelliteModeSelected() {
}

```
---

# Coming Soon
Espresso tests written in Kotlin :) 

---

# Contribution


Please fork repository and contribute using pull requests.

Any contributions, large or small, major features, bug fixes, additional language translations, unit/integration tests are welcomed and appreciated but will be thoroughly reviewed and discussed.


# License

    Copyright 2017 Device Magic

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
