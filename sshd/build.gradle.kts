import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.0"
}

group = "me.frank"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.sshd:sshd-core:2.7.0")
    implementation("org.apache.sshd:sshd-scp:2.7.0")
    implementation ("org.apache.sshd:sshd-sftp:2.7.0")
    implementation ("org.apache.sshd:sshd-common:2.7.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation(kotlin("test-junit"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
