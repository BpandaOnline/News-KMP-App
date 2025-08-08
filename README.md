To Download Direct Zip File
Hit in browser || Install The Zip File, Extract/Rename/Change Package and Go Start Your Dream Project ;-)

https://github.com/BpandaOnline/News-KMP-App/archive/refs/heads/KMPTemplateBaseMaster.zip


As want to add Lib Versions I have for All Supproted Devices.

[versions]
agp = "8.11.1"
android-compileSdk = "36"
android-minSdk = "24"
android-targetSdk = "36"
androidx-activityCompose = "1.10.1"
androidx-appcompat = "1.7.1"
androidx-constraintlayout = "2.2.1"
androidx-core-ktx = "1.16.0"
androidx-espresso-core = "3.7.0"
androidx-material = "1.12.0"
androidx-test-junit = "1.3.0"
compose-plugin = "1.8.2"
junit = "4.13.2"
kotlin = "2.2.0"
coil3 = "3.3.0"
ktor = "3.2.3"
lifecycleViewmodel = "2.9.1"
navigationCompose = "2.9.0-beta03"
coroutines = "1.10.2"
ksp = "2.2.0-2.0.2"
sqlite = "2.5.2"
androidx-room = "2.7.2"
kotlinx-serialization = "1.9.0"
kermit = "2.0.6"
buildkonfig = "0.17.1"
androidx-data-store = "1.1.7"
coreSplashscreen = "1.0.1"
size = "0.5.0"
koin = "4.1.0"
composeHotReload = "1.0.0-beta04"

[libraries]
androidx-lifecycle-viewmodel = { module = "org.jetbrains.androidx.lifecycle:lifecycle-viewmodel", version.ref = "lifecycleViewmodel" }
androidx-lifecycle-runtimeCompose = { module = "org.jetbrains.androidx.lifecycle:lifecycle-runtime-compose", version.ref = "lifecycleViewmodel" }
kotlinx-coroutines-swing = { module = "org.jetbrains.kotlinx:kotlinx-coroutines-swing", version.ref = "coroutines" }
androidx-core-splashscreen = { module = "androidx.core:core-splashscreen", version.ref = "coreSplashscreen" }


kotlin-test = { module = "org.jetbrains.kotlin:kotlin-test", version.ref = "kotlin" }
kotlin-test-junit = { module = "org.jetbrains.kotlin:kotlin-test-junit", version.ref = "kotlin" }
junit = { group = "junit", name = "junit", version.ref = "junit" }
androidx-core-ktx = { group = "androidx.core", name = "core-ktx", version.ref = "androidx-core-ktx" }
androidx-test-junit = { group = "androidx.test.ext", name = "junit", version.ref = "androidx-test-junit" }
androidx-espresso-core = { group = "androidx.test.espresso", name = "espresso-core", version.ref = "androidx-espresso-core" }
androidx-appcompat = { group = "androidx.appcompat", name = "appcompat", version.ref = "androidx-appcompat" }
androidx-material = { group = "com.google.android.material", name = "material", version.ref = "androidx-material" }
androidx-constraintlayout = { group = "androidx.constraintlayout", name = "constraintlayout", version.ref = "androidx-constraintlayout" }
androidx-activity-compose = { module = "androidx.activity:activity-compose", version.ref = "androidx-activityCompose" }

koin-android = { module = "io.insert-koin:koin-android", version.ref = "koin" }
koin-androidx-compose = { module = "io.insert-koin:koin-androidx-compose", version.ref = "koin" }
koin-core = { module = "io.insert-koin:koin-core", version.ref = "koin" }
koin-compose = { module = "io.insert-koin:koin-compose", version.ref = "koin" }
koin-composeVM = { module = "io.insert-koin:koin-compose-viewmodel", version.ref = "koin" }
koin-test = { module = "io.insert-koin:koin-test", version.ref = "koin" }

ktor-core = { module = "io.ktor:ktor-client-core", version.ref = "ktor" }
ktor-negotiation = { module = "io.ktor:ktor-client-content-negotiation", version.ref = "ktor" }
ktor-json = { module = "io.ktor:ktor-serialization-kotlinx-json", version.ref = "ktor" }
ktor-logging = { module = "io.ktor:ktor-client-logging", version.ref = "ktor" }
ktor-client-okhttp = { module = "io.ktor:ktor-client-okhttp", version.ref = "ktor" }
ktor-client-android = { module = "io.ktor:ktor-client-android", version.ref = "ktor" }
ktor-client-darwin = { module = "io.ktor:ktor-client-darwin", version.ref = "ktor" }
kotlinx-serialization-json = { module = "org.jetbrains.kotlinx:kotlinx-serialization-json", version.ref = "kotlinx-serialization" }
kermit = { module = "co.touchlab:kermit", version.ref = "kermit" }
androidx-data-store-core = { module = "androidx.datastore:datastore-preferences-core", version.ref = "androidx-data-store" }
screen-size = { module = "dev.chrisbanes.material3:material3-window-size-class-multiplatform", version.ref = "size" }

coil-compose = { module = "io.coil-kt.coil3:coil-compose", version.ref = "coil3" }
coil-compose-core = { module = "io.coil-kt.coil3:coil-compose-core", version.ref = "coil3" }
coil-network-ktor3 = { module = "io.coil-kt.coil3:coil-network-ktor3", version.ref = "coil3" }
coil-mp = { module = "io.coil-kt.coil3:coil", version.ref = "coil3" }

navigation-compose = { module = "org.jetbrains.androidx.navigation:navigation-compose", version.ref = "navigationCompose" }
androidx-room-compiler = { group = "androidx.room", name = "room-compiler", version.ref = "androidx-room" }
androidx-room-runtime = { group = "androidx.room", name = "room-runtime", version.ref = "androidx-room" }
sqlite-bundled = { module = "androidx.sqlite:sqlite-bundled", version.ref = "sqlite" }

[plugins]
androidApplication = { id = "com.android.application", version.ref = "agp" }
androidLibrary = { id = "com.android.library", version.ref = "agp" }
composeHotReload = { id = "org.jetbrains.compose.hot-reload", version.ref = "composeHotReload" }
jetbrainsCompose = { id = "org.jetbrains.compose", version.ref = "compose-plugin" }
compose-compiler = { id = "org.jetbrains.kotlin.plugin.compose", version.ref = "kotlin" }
kotlinMultiplatform = { id = "org.jetbrains.kotlin.multiplatform", version.ref = "kotlin" }
kotlinx-serialization = { id = "org.jetbrains.kotlin.plugin.serialization", version.ref = "kotlin" }
ksp = { id = "com.google.devtools.ksp", version.ref = "ksp" }
buildkonfig = { id = "com.codingfeline.buildkonfig", version.ref = "buildkonfig" }
room = { id = "androidx.room", version.ref = "androidx-room" }



This is a Kotlin Multiplatform project targeting Android, iOS, Desktop (JVM).

* [/composeApp](./composeApp/src) is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - [commonMain](./composeApp/src/commonMain/kotlin) is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    the [iosMain](./composeApp/src/iosMain/kotlin) folder would be the right place for such calls.
    Similarly, if you want to edit the Desktop (JVM) specific part, the [jvmMain](./composeApp/src/jvmMain/kotlin)
    folder is the appropriate location.

* [/iosApp](./iosApp/iosApp) contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
