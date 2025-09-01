import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.util.*
import com.codingfeline.buildkonfig.compiler.FieldSpec

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.composeHotReload)
    alias(libs.plugins.buildkonfig)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
}

kotlin {
    sourceSets.commonMain {
        kotlin.srcDir("build/generated/ksp/metadata")
    }
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    jvm("desktop")

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
            // Required when using NativeSQLiteDriver
            linkerOpts.add("-lsqlite3")
        }
    }

    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)

            //Coil
            implementation(libs.coil.network.okhttp)

            // Ktor
            implementation(libs.ktor.client.android)

            // Splash API
            implementation(libs.androidx.core.splashscreen)

            implementation("androidx.media3:media3-exoplayer:1.1.1")   // core ExoPlayer functionality

            // Optional: UI components
            implementation("androidx.media3:media3-ui:1.1.1")           // PlayerView, controls

            // Optional: media session support
            implementation("androidx.media3:media3-session:1.1.1")
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            implementation(compose.material3)
            implementation(compose.materialIconsExtended)

            // Navigation & ViewModel
            implementation(libs.navigation.compose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            // Coil core for all platforms
            implementation(libs.coil.compose)

            implementation(libs.androidx.lifecycle.viewmodel)

            //dataStore
            implementation(libs.androidx.data.store.core)

            implementation("org.jetbrains.kotlinx:atomicfu:0.24.0")

            // Ktor
            implementation(libs.ktor.core)
            implementation(libs.ktor.json)
            implementation(libs.ktor.logging)
            implementation(libs.ktor.negotiation)
            implementation(libs.kotlinx.serialization.json)

            // Kermit  for logging
            implementation(libs.kermit)
            implementation("com.kizitonwose.calendar:compose-multiplatform:2.8.0")

            // Room + Sqlite
            implementation(libs.androidx.room.runtime)
            implementation(libs.sqlite.bundled)
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)

            //Coil
            implementation(libs.coil.network.okhttp)
            // ktor
            implementation(libs.ktor.client.okhttp)
            implementation(libs.kotlinx.coroutines.swing)
            implementation("uk.co.caprica:vlcj:4.7.0")
        }
        iosMain.dependencies {
            //Coil
            implementation(libs.coil.network.ktor)
            implementation(libs.ktor.client.darwin)

            // Ktor
            implementation(libs.ktor.client.darwin)
        }
        dependencies {
            ksp(libs.androidx.room.compiler)
        }
    }
}

android {
    namespace = "com.coding.meet.newsapp"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.coding.meet.newsapp"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }

    dependencies {
        debugImplementation(compose.uiTooling)
    }

}


room {
    schemaDirectory("$projectDir/schemas")
}

compose.desktop {
    application {
        mainClass = "com.coding.meet.newsapp.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.coding.meet.newsapp"
            packageVersion = "1.0.0"
        }
    }
}

buildkonfig {
    packageName = "com.coding.meet.newsapp"

    val localProperties =
        Properties().apply {
            val propsFile = rootProject.file("local.properties")
            if (propsFile.exists()) {
                load(propsFile.inputStream())
            }
        }

    defaultConfigs {
        buildConfigField(
            FieldSpec.Type.STRING,
            "API_KEY",
            localProperties["API_KEY"]?.toString() ?: "",
        )
    }
}