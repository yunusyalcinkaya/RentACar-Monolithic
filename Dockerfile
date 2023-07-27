FROM openjdk:17
COPY RentACar-0.0.1-SNAPSHOT.jar rentacar.jar
ENTRYPOINT ["java","-jar","/rentacar.jar"]