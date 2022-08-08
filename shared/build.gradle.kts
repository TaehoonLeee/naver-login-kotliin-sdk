plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("maven-publish")
}

group = "com.durepark"
version = "1.0.0"

publishing {
    publications.withType<MavenPublication> {
        artifactId = "naver-login-kotlin-sdk"
    }
}

kotlin {
    android {
        publishAllLibraryVariants()
    }
    ios {
        val frameworkPath = projectDir.resolve("src/nativeInterop/cinterop")
        compilations["main"].cinterops.create("NaverLogin").compilerOpts("-F$frameworkPath")
    }

    sourceSets.getByName("androidMain") {
        dependencies {
            implementation("com.navercorp.nid:oauth:5.1.1")
        }
    }
}

android {
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }
}