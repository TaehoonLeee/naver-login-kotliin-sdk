plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("maven-publish")
    id("com.kezong.fat-aar")
}

group = "com.lidupark"
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

    fun nativeTargetConfig(): org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget.() -> Unit = {
        val nativeFrameworkPaths = projectDir.resolve("src/nativeInterop/cinterop")

        compilations.getByName("main") {
            cinterops.create("NaverThirdPartyLogin") {
                compilerOpts("-F$nativeFrameworkPaths")
            }
        }
    }
    ios(configure = nativeTargetConfig())

    sourceSets {
        val commonMain by getting
        val androidMain by getting {
            dependencies {
                implementation(project(":aos-naver", configuration = "default"))
            }
        }
        val iosMain by getting {
            dependsOn(commonMain)
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