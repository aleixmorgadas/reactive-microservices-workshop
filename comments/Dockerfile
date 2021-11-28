FROM adoptopenjdk/openjdk11
WORKDIR /tmp
COPY . /tmp
RUN ./gradlew build -x test

FROM adoptopenjdk/openjdk11
WORKDIR /tmp/
COPY --from=0 /tmp/build/libs/comments-0.1-all.jar .
CMD java -jar -Dmicronaut.environments=docker comments-0.1-all.jar