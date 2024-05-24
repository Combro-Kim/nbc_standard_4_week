import java.util.Properties

val properties = Properties()
properties.load(project.rootProject.file("local.properties").inputStream())

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-parcelize")
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.nbc_standard_4_week"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.nbc_standard_4_week"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "API_KEY", properties.getProperty("API_KEY"))
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
    viewBinding {
        enable = true
    }
    buildFeatures{
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
//    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
//
//    implementation ("com.google.code.gson:gson:2.10.1")
//    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
//    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
//    implementation ("com.squareup.okhttp3:okhttp:4.10.0")
//    implementation ("com.squareup.okhttp3:logging-interceptor:4.10.0")
//
    //glide
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")

    implementation("androidx.fragment:fragment-ktx:1.6.2")


    // retrofit
    implementation(libs.bundles.retrofit)

    //coil
    implementation(libs.coil)

    //hilt
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)

    //room
    implementation(libs.room.runtime)
    implementation(libs.room.paging)
    ksp(libs.room.compiler)

    //room
//    val room_version = "2.6.1"
//    implementation ("androidx.room:room-runtime:$room_version")
//    annotationProcessor ("androidx.room:room-compiler:$room_version")
//    kapt ("androidx.room:room-compiler:$room_version")
//    // optional - Kotlin Extensions and Coroutines support for Room
//    implementation ("androidx.room:room-ktx:$room_version")
//    // optional - Test helpers
//    testImplementation ("androidx.room:room-testing:$room_version")

    //Hilt
//    implementation ("com.google.dagger:hilt-android-gradle-plugin:2.44")
//    implementation("com.google.dagger:hilt-android:2.44")
//    kapt ("com.google.dagger:hilt-android-compiler:2.44")
//
//    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
//    kapt ("androidx.hilt:hilt-compiler:1.0.0")
//    //ksp


    //bottomNavi
//    implementation ("com.android.support:design:29.0.0")
//    implementation ("com.google.android.material:material:1.11.0")
}
//kapt {
//    correctErrorTypes = true
//}