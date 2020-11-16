import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
	val kotlinVersion = "1.3.72"
	kotlin("jvm") version kotlinVersion
	kotlin("kapt") version kotlinVersion
	kotlin("plugin.allopen") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion
	kotlin("plugin.jpa") version kotlinVersion
	id("org.springframework.boot") version "2.3.4.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
}

group = "saro.example"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	val queryDslVersion = "4.4.0"

	// DB
	implementation("com.zaxxer:HikariCP")
	runtimeOnly("mysql:mysql-connector-java")
	runtimeOnly("com.h2database:h2")

	// jpa / querydsl
	implementation("com.querydsl:querydsl-jpa")
	implementation("com.querydsl:querydsl-apt")
	implementation("com.querydsl:querydsl-sql:$queryDslVersion")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.6.2")
	kapt("com.querydsl:querydsl-apt:$queryDslVersion:jpa")

	// lib
	implementation("me.saro:kit-ee:0.0.7.2")
	implementation("org.jsoup:jsoup:1.13.1")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.springframework.boot:spring-boot-starter-mail")
	implementation("io.lettuce:lettuce-core")
	implementation("org.apache.lucene:lucene-analyzers-nori:8.6.3")

	// logger
	implementation("org.slf4j:slf4j-api")
	implementation("ch.qos.logback:logback-classic")

	// basic
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.boot:spring-boot-starter-validation")

	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("joda-time:joda-time:2.10.6")
	kapt("org.springframework.boot:spring-boot-configuration-processor")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
}


allprojects {
	sourceSets {
		main {
			resources {
				srcDir("src/main/resources")
			}
		}
	}
}

buildscript {
	dependencies {
		classpath ("org.jetbrains.kotlin:kotlin-noarg")
	}
}

tasks.getByName<BootRun>("bootRun") {
	sourceResources(sourceSets["main"])
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<JavaCompile> {
	options.encoding = "UTF-8"
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "13"
	}
}
