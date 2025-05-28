val LOG4J_VERSION = "2.13.0"

plugins {
    java
    war
}

repositories {
    mavenCentral()
}

dependencies {
//    compileOnly("org.postgresql:postgresql:42.2.9")
    implementation("com.example:project1:0.0.1")
    implementation("org.apache.logging.log4j:log4j-api:$LOG4J_VERSION")
    compileOnly("javax.servlet:javax.servlet-api:4.0.1")
}

tasks.war {
    webInf {
        from("src/web")
    }
    metaInf {
        from("src/meta")
    }
}
