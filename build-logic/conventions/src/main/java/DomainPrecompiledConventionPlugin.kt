
import com.android.build.api.dsl.LibraryExtension
import com.multi.module.convention.configureKotlinAndroid
import com.multi.module.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class DomainPrecompiledConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.compose")
                apply("com.google.devtools.ksp")
                apply("com.google.dagger.hilt.android")

            }

            extensions.configure<LibraryExtension> {
                defaultConfig {
                    targetSdk = libs.findVersion("projectTargetSdkVersion").get().toString().toInt()
                }

                configureKotlinAndroid(this)
            }

            dependencies {
                "api"(libs.findBundle("core-implementation").get())
                "api"(libs.findBundle("hilt").get())
                "api"(libs.findBundle("hilt-jetpack").get())
                "ksp"(libs.findBundle("hilt-ksp").get())
            }
        }
    }
}