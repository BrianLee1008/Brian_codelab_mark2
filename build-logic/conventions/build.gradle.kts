
plugins {
    `kotlin-dsl`
}

group = "com.multi.module.buildlogic"

dependencies {
    compileOnly(libs.android.tools.common)
    compileOnly(libs.android.tools)
    compileOnly(libs.kotlin)
    compileOnly(libs.ksp)
    compileOnly(libs.room)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "multi.module.android.application.convention"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("uiPrecompiled") {
            id = "multi.module.ui.precompiled.convention"
            implementationClass = "UiPrecompiledConventionPlugin"
        }
        register("domainPrecompiled") {
            id = "multi.module.domain.precompiled.convention"
            implementationClass = "DomainPrecompiledConventionPlugin"
        }
    }
}
