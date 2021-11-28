FROM adoptopenjdk/openjdk11
WORKDIR /tmp
COPY . /tmp
RUN ./gradlew build -x test

FROM adoptopenjdk/openjdk11
WORKDIR /tmp/
COPY --from=0 /tmp/build/libs/posts-0.1-all.jar .
CMD java -jar -Dmicronaut.environments=docker posts-0.1-all.jar