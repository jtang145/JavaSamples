set QUEST_DEPLOYMENT_DIRECTORY=D:\\Quest_Software\\Foglight\\Fglam580\\agents\\JavaEE
set QUEST_AGENT_HOME=%QUEST_DEPLOYMENT_DIRECTORY%\5.9.10-20170116-1740

java -Xbootclasspath/p:"%QUEST_AGENT_HOME%\bootstrap\DEXvy0F6Um6qvVd\C--Java-jdk1.8.0_51.jar" -javaagent:"%QUEST_AGENT_HOME%\lib\performasure-agent.jar" -Dquest.integrationid=ABCD -Dquest.debug=1 -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5003 -Dquest.agent.appserverinfo=postbankid::: -jar myproject-0.0.1-SNAPSHOT.jar
