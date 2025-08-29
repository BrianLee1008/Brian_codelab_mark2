
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