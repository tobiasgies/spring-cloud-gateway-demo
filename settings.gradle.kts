pluginManagement {
	repositories {
		gradlePluginPortal()
	}
}
rootProject.name = "spring-cloud-gateway-demo"

include(
	"apigateway",
	"bouquet",
	"business",
	"inventory"
	)