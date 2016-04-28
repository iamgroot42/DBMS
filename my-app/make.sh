
mvn package

if [ -z "$1" ]
  then
    mvn exec:java -Dexec.mainClass="com.iiitd.dbms.app.App"
  else
  	mvn -X exec:java -Dexec.mainClass="com.iiitd.dbms.app.App"
fi

# export MAVEN_OPTS="-XstartOnFirstThread"