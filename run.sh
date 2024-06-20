clear
export JAVA_HOME="/usr/lib/jvm/java-21-openjdk-amd64"
export PATH=$JAVA_HOME/bin:$PATH
mvn clean && mvn spring-boot:run
# mvn clean && mvn install