import java.net.URI
import java.io.FileOutputStream

plugins {
    kotlin("multiplatform") version "1.7.10"
}

repositories {
    mavenCentral()
}

val exposedVersion: String by project
val mysqlJdbcVersion: String by project

kotlin {
    jvm {

    }

    sourceSets {
        @Suppress("UNUSED_VARIABLE") val jvmMain by getting {
            dependencies {

            }
        }

        @Suppress("UNUSED_VARIABLE") val jvmTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

tasks {
    fun buildCount(key: String) = System.getenv("BUILD_COUNT_SERVER").takeIf { it != null }?.apply {
        try
        {
            val input = URI("$this/$key").toURL().openConnection().getInputStream()
            val output = FileOutputStream(File("$projectDir/build_$key.txt"))
            input.copyTo(output)
        } catch (e: java.net.UnknownHostException)
        {
            System.err.println("Unknown host: $e")
        }
    } ?: File("$projectDir/build_$key.txt").writeText("LOCAL")

    val buildCount = register("buildCount-webapi") {
        buildCount("GBuilder-webapi")
    }.get()

    getByName("build").dependsOn(buildCount)
}
