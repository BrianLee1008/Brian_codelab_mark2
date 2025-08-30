
import com.android.build.api.dsl.LibraryExtension
import com.multi.module.convention.configureKotlinAndroid
import com.multi.module.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class UiPrecompiledConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("com.android.library") // application plugin 아니므로 library 설정
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.compose")
                apply("com.google.devtools.ksp")
                apply("com.google.dagger.hilt.android")
            }

            extensions.configure<LibraryExtension> { // application plugin 아니므로 library 설정
                defaultConfig {
                    targetSdk = libs.findVersion("projectTargetSdkVersion").get().toString().toInt()
                }

                configureKotlinAndroid(this)
            }

            dependencies {
                "implementation"(libs.findBundle("core-implementation").get())
                "implementation"(libs.findBundle("compose-ui-package-implementation").get())
                "implementation"(libs.findBundle("androidTestImplementation").get())
                "implementation"(libs.findBundle("debugImplementation").get())
                "implementation"(libs.findBundle("hilt").get())
                "implementation"(libs.findBundle("hilt-jetpack").get())
                "ksp"(libs.findBundle("hilt-ksp").get())
            }
        }
    }
}