val androidXCore: String by project
val androidXLifecycle: String by project
val androidXActivityCompose: String by project
val androidXNavComposeVersion: String by project
val composeBomVersion: String by project
val timberVersion: String by project

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.jianastrero.templateandroidapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.jianastrero.templateandroidapp"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isDebuggable = true
        }
        release {
            isDebuggable = false // Disable this if you want to debug
            isMinifyEnabled = true // Disable this if you want to debug
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Main AndroidX Dependencies
    implementation("androidx.core:core-ktx:$androidXCore")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$androidXLifecycle")
    implementation("androidx.activity:activity-compose:$androidXActivityCompose")

    // Compose Dependencies
    implementation(platform("androidx.compose:compose-bom:$composeBomVersion"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // Timber
    implementation("com.jakewharton.timber:timber:$timberVersion")

    // Unit Test Dependencies
    testImplementation("junit:junit:4.13.2")

    // Android Test Dependencies
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    // Debug Dependencies
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
