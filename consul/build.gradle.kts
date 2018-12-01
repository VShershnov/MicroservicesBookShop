  dependencies {
     compile("org.springframework.cloud:spring-cloud-starter-consul-all")

     dependencyManagement {
	imports { mavenBom("org.springframework.cloud:spring-cloud-consul-dependencies:" + ext.get("cloudConsulVersion")) }
     }     

  }
