
## Getting Started
A simple movie app example using Dagger 2 for my blog post about [Dagger 2 — Dependency Injection basics in Android].

## Prerequisites

1. [Android Studio]
2. JDK 8

## Installation
Clone this repository and import into **Android Studio**

```bash
git https://github.com/murielK/movies-dagger2-example.git
```
## Configuration

### SDK and Tools

1. Run the Android SDK Manager by pressing the SDK Manager toolbar button
   in Android Studio.

2. In the Android SDK Manager, ensure that the following are installed,
   and are updated to the latest available version:
       - Platform > Android 9 (Pie, API Level 28) or above
       - Tools > Android SDK Tools (rev 26.1.1 or above)
       - Tools > Android SDK Platform-tools (rev 26.1.1 or above)
       - Tools > Android Support Library (latest)

3. Create a file in your working directory called local.properties,
   and add the path to your Android SDK._(On Windows, use a double-backslash (`\\`) as a path separator!)_

4. Get your api key at https://developers.themoviedb.org/3/getting-started/introduction

5. Add the key in your local.properties file as follow **API_KEY="mykey"**  

6. Run the command **./gradlew installDebug** to install the app in your device
   


[Android Studio]:http://developer.android.com/sdk/installing/studio.html
[How to set up signature keys]:https://bitbucket.org/ag04/android-how-to-sign-apk/src/master/
[Dagger 2 — Dependency Injection basics in Android]:https://medium.com/agency04/dagger-2-dependency-injection-basics-in-android-be229d99a0a
