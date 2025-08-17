plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.ruburger"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.ruburger"
        minSdk = 34
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = false
    }
}

dependencies {
    // Core Android extensions (for findViewById, getString, etc.)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // AppCompatActivity and related widgets
    implementation("androidx.appcompat:appcompat:1.6.1")

    // RecyclerView for your Beverage screen
    implementation("androidx.recyclerview:recyclerview:1.3.0")

    // Material Components (for Buttons, dialogs, etc.)
    implementation("com.google.android.material:material:1.9.0")

    // ConstraintLayout if you choose to use it
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Unit & instrumentation tests
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
