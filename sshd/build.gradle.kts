import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
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
    implementation("com.fasterxml.jackson.core:jackson-databind:2.9.6")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.6")
    implementation("org.apache.kafka:kafka-clients:2.0.0")
    implementation("ch.qos.logback:logback-classic:1.1.3")
    implementation("ch.qos.logback:logback-core:1.1.3")
    testImplementation(kotlin("test-junit"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "12"
}
