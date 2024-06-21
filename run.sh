clear
export JAVA_HOME="/usr/lib/jvm/java-21-openjdk-amd64"
export PATH=$JAVA_HOME/bin:$PATH
# mvn clean compile test && mvn spring-boot:run
mvn clean compile test
# mvn clean compile test
# mvn clean && mvn install