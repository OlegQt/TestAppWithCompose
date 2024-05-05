plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.oleg.testappwithcompose"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.oleg.testappwithcompose"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }

}

dependencies {

    // Fundamental building blocks of Compose programming model and state management,
    // and core runtime for the Compose Compiler Plugin to target.
    implementation("androidx.compose.runtime:runtime:1.0.0")

    // Optional - Integration with activities
    implementation("androidx.activity:activity-compose:1.6.0")

    // Components, the next evolution of Material Design. Material 3
    // includes updated theming and components and Material You personalization
    // features like dynamic color, and is designed to be cohesive with the new
    // Android 12 visual style and system UI.
    implementation("androidx.compose.material3:material3:1.0.0")

    // such as input and measurement/layout
    implementation("androidx.compose.ui:ui:1.0.1")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}