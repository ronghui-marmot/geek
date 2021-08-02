.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
.\bin\windows\kafka-server-start.bat .\config\server9001.properties
.\bin\windows\kafka-server-start.bat .\config\server9002.properties
.\bin\windows\kafka-server-start.bat .\config\server9003.properties

.\bin\windows\kafka-topics.bat --zookeeper localhost:2181 --list
.\bin\windows\kafka-topics.bat --zookeeper localhost:2181 --create --topic marmot --partitions 3 --replication-factor 2

.\bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9003 --topic marmot
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9001 --from-beginning --topic marmot

.\bin\windows\kafka-producer-perf-test.bat --topic marmot --num-records 100000 --record-size 1000 --throughput 2000 --producer-props bootstrap.servers=localhost:9002
.\bin\windows\kafka-consumer-perf-test.bat --bootstrap-server localhost:9002 --topic marmot --fetch-size 1048576 --messages 100000 --threads 1


.\bin\windows\kafka-topics.bat --zookeeper localhost:2181 --describe --topic marmot