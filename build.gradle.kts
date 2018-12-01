plugins { 
  java
  eclipse
  id("org.springframework.boot") version "2.1.0.RELEASE" apply false
  id("io.spring.dependency-management") version "1.0.6.RELEASE"
}

allprojects {
   group = "it.discovery"
}

subprojects {  
   apply(plugin = "java")
   apply(plugin = "io.spring.dependency-management")
   apply(plugin = "org.springframework.boot")

   java.sourceCompatibility = JavaVersion.VERSION_1_8
   java.targetCompatibility = JavaVersion.VERSION_1_8

   val cloudStarterVersion = "Finchley.SR2"
  
   ext {
      set("cloudConsulVersion", "2.0.1.RELEASE")
   } 

  repositories {
     jcenter()
   } 

  dependencies {
     compile("org.springframework.boot:spring-boot-devtools")
     compileOnly("org.projectlombok:lombok:1.18.4")
     annotationProcessor("org.projectlombok:lombok:1.18.4")

     dependencyManagement {
	imports { mavenBom("org.springframework.cloud:spring-cloud-starter-parent:$cloudStarterVersion") }
     }         
  }

}

