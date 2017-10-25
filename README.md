# Getting Started Writing Tests with Appium and Cucumber
## Requirements
***

### Java, Android Studio, and other dependencies

Several other languages can be used with Appium, but Java will be used in this example.

1. Download and install the current [Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk9-downloads-3848520.html)
2. Download and install [Android Studio](https://developer.android.com/studio/index.html?hl=sk).  
In the Android Sudio setup, set the SDK install location to the root directory (C:\android-sdk)
3. Download and install [Visual Studio Emulator for Android](https://www.visualstudio.com/vs/msft-android-emulator/)
4. Download and install [Node JS](https://nodejs.org/en/download/)
5. Download and install [Appium Desktop](https://github.com/appium/appium-desktop)
6. Install Appium command line by opening a command prompt and typing `npm install -g appium`
7. Then enter `npm install -g appium-doctor` and run appium-doctor to see how you're doing.
8. You may need to set some environmental variables. If so, open System Properties and then the Environmental Variables screen. Verify the following are set:
* ANDROID_HOME - location of the Android SDK directory
* ANDROID_SWT - location of Android\sdk\tools\lib\x86_64 directory
* JAVA_HOME - location of Java JDK directory
* Path - %JAVA_HOME%\bin;%ANDROID_HOME%\tools;%ANDROID_HOME%\platform-tools
9. Download and install [IntelliJ Community Edition](https://www.jetbrains.com/idea/download/#section=windows)
***
### Setup and test the Appium server and Android Emulator

**Note:** The reason *Visual Studio Emulator for Android* (VSEA) is being used rather than *Android Emulator* from *Android Studio* or *Genymotion* is VSEA plays nicely with Hyper-V (as it utilises Hyper-V), while the other emulators do not. If you do not require Hyper-V (like for Docker), then these other emulators will work fine.

1. Open Visual Studio Emulator for Android
2. Under *Device Profiles*, Make sure the Android device configuration is downloaded. Keep in mind that some configurations are more resource intensive than others and can affect test performance
3. Make note of the Android version number (4.4, 5.0, etc)
4. Start the emulated device by clicking on the *play* icon
5. Once the emulation is running and the Android interface is displayed, go in to *Settings/About Phone/Status/IP address* and make note of the phone's ip address
6. Open a command prompt enter `adb kill-server`, then `adb start-server`, then `adb connect {phone ip-address}:{port}` (EX: adb connect 192.168.0.105:5555)
7. Enter `adb devices` and you should see the phone's ip address/port in the list of devices
8. Start Appium Desktop and click the *Start Inspector Session* icon
9. Under *Desired Capabilities* set the following data pairs:
```
automationName : Appium
platformName : Android
platformVersion : 4.4 (Android version number)
deviceName : 192.168.0.102:5555 (ip address and port of emulator)
app : C:/ApiDemos-debug.apk (path to apk file to be tested)
```
10. Click *Save* to store settings under *Saved Capability Sets*
11. Click *Start* to load the app and inspect the elements
***
### Configure IDE to write tests

1. In IntelliJ click on "Create New Project"
2. On the "New Project" screen, select "Gradle" and select the Java SDK you wish to use
3. Click on "Next", enter the GroupId (com.test) and ArtifactId (TestAutomation) and click on "Next"
4. Verify the "Use auto-import" is selected and the proper version of Java is in "Gradle JVM" and click on "Next"
5. Open the "build.gradle" file and make sure dependencies contains:
    dependencies {
        testCompile group: 'junit', name: 'junit', version: '4.12'
        compile group: 'info.cukes', name: 'cucumber-java', verison: '1.2.5'
        compile group: 'io.appium', name: 'java-client', version: '5.0.4'
    }
6. Open the "Gradle" tab and click on the refresh icon
7. Open Settings > Plugins and verify "Cucumber for Java" and "Gherkin" are installed
8. Create the folder "app" in the project folder and copy the app (ApiDemos-debug.apk)to the "app" folder
9. Create the directory structure src/test/java/features under the project folder
10. In the folder "features", create a feature file (Test.feature)
11. In the feature file, write the test steps in the following format:
>
    Feature: Checkbox

      Scenario: Manipulate checkbox in App
        As a user I should be able to check and uncheck a checkbox
    
        When I launch the ApiDemos app
        And I select Preference
        And I select 4. Default values
        And I select the checkbox
        Then the checkbox is either checked or unchecked
12. In the 'java' folder, create a 'steps' folder
13. Click to select the "When I launch..." line of the test steps and press "Alt+Enter"
14. The "Create New Step Definition File" will appear and set File name (HomePageSteps) 
and File Location to the "steps" directory you created abd click "OK"