plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("kotlin-kapt")

    
}

android {
    namespace = "com.example.careerhub"
    compileSdk = 34


    buildFeatures {
        dataBinding = true
    }
    defaultConfig {
        applicationId = "com.example.careerhub"
        minSdk = 29
        targetSdk = 34
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
}

dependencies {


    implementation("com.google.firebase:firebase-auth:22.3.1")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("com.google.firebase:firebase-firestore-ktx:24.10.3")
    kapt("com.github.bumptech.glide:compiler:4.16.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-database:20.3.1")
    implementation("com.firebaseui:firebase-ui-database:8.0.2")
    implementation ("com.firebaseui:firebase-ui-firestore:8.0.0")
    implementation("com.google.firebase:firebase-storage:20.3.0")
    implementation("com.firebaseui:firebase-ui-storage:8.0.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}