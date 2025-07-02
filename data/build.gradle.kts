plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.dagger.library)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.data"
    compileSdk = 36

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            buildConfigField("String", "BASE_URL", "\"https://api.gameofthronesquotes.xyz/v1/\"")
        }
        release {
            buildConfigField("String", "BASE_URL", "\"https://api.gameofthronesquotes.xyz/v1/\"")
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_24
        targetCompatibility = JavaVersion.VERSION_24
    }
    kotlinOptions {
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_24
            targetCompatibility = JavaVersion.VERSION_24
        }
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(libs.dagger)
    ksp(libs.daggerCompiler)
    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.ktor)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}