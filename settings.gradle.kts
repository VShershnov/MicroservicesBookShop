rootProject.name = "microservices"
include( "config-server", ":consul", "eureka-server", "monolith", "vault", "zuul")