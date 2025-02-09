Playground to create Message generation with protobuf to be used in Java Project. <br />
Starts up a zookeper, single kafka broker, kafka ui and service registry.  <br />
To restart kafka cluster use `docker-compose down --volumes` and then `docker-compose up` again. <br />
To connect to kafka broker add this mapping to /etc/hosts file: `127.0.0.1 kafka1` <br />
To generate message code run `mvn clean compile` <br />
