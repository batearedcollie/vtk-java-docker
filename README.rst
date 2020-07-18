-----------
DESCRIPTION
-----------

Docker Image with VTK and Java bindings
 

..

	docker build -t batearedcollie/vtk-java-docker:latest .
	
	docker-compose run jvtk-dev bash
	
	cd /src
	
	java -Djava.library.path=/usr/local/lib/java/vtk-Linux-x86_64/  test/BasicTest1.java