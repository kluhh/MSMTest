plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")

}

android {
    namespace = "com.example.msmtest"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.msmtest"
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
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
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

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui:1.0.0")
    implementation("androidx.compose.ui:ui-graphics:1.0.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.0.0")
    implementation("androidx.compose.material3:material3:1.0.0")
    implementation("androidx.appcompat:appcompat:1.6.1")



    //dagger-hilt
    implementation("com.google.dagger:hilt-android:2.44")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0-alpha01")
//    implementation("androidx.hilt:hilt-navigation-fragment:1.0.0")
    kapt("com.google.dagger:hilt-compiler:2.44")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //Okhttp
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

    //Gson
    implementation("com.google.code.gson:gson:2.10.1")

    //coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    //Glide
    implementation("com.github.bumptech.glide:glide:4.15.1")

    //coil
    implementation ("io.coil-kt:coil-compose:1.3.2")


//    implementation ("androidx.navigation:navigation-compose:2.4.0-alpha06")
//    compose navigation
//    implementation ("androidx.navigation:navigation-compose:1.0.0")

    // navigation animation
    implementation ("com.google.accompanist:accompanist-navigation-animation:0.16.0")

// https://mvnrepository.com/artifact/com.google.accompanist/accompanist-navigation-animation
//    implementation("com.google.accompanist:accompanist-navigation-animation:0.29.1-alpha")


    //room
    val room_version = "2.5.2"
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:$room_version")

    //room testing
    testImplementation("androidx.room:room-testing:$room_version")

    //volley
    implementation("com.android.volley:volley:1.2.1")


    //testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

}