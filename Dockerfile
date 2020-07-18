
FROM ubuntu:20.04

ENV DEBIAN_FRONTEND=noninteractive

# Java 11 is default for Ubuntu 20.04 
RUN apt-get update && \
    apt-get install -y --no-install-recommends  \
    libc6-dev-i386 build-essential gcc g++ gfortran \
    openjdk-11-jdk  \
    cmake wget && \
    rm -rf /var/lib/apt/lists/  


####################################################################
# VTK
####################################################################
RUN wget https://www.vtk.org/files/release/9.0/VTK-9.0.1.tar.gz --no-check-certificate && \
	tar xvf VTK-9.0.1.tar.gz && \
	mkdir VTK-build	&& \
	cd VTK-build/ && \
	cmake \
		-DCMAKE_BUILD_TYPE=Release \
		-DBUILD_SHARED_LIBS:BOOL=ON \
		-DCMAKE_INSTALL_PREFIX=/usr/local \
		-DVTK_WRAP_PYTHON:BOOL=FALSE \
		-DVTK_USE_X=OFF \
		-DBUILD_TESTING=OFF \
		-DVTK_WRAP_JAVA:BOOL=TRUE \
		-DVTK_GROUP_ENABLE_Web=NO \
		-DVTK_GROUP_ENABLE_Views=NO \
		-DVTK_GROUP_ENABLE_Rendering=NO \
		-DVTK_GROUP_ENABLE_Qt=NO \
		-DVTK_GROUP_ENABLE_MPI=NO \
		-DVTK_GROUP_ENABLE_Imaging=NO \
		-DVTK_GROUP_ENABLE_StandAlone=DONT_WANT \
		/VTK-9.0.1/ && \
	make -j 4 install && \
	cd / && \
	rm -r VTK-build/ /VTK-9.0.1/
