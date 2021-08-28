IP_ADDR=$(ipconfig getifaddr en0)
java -jar stubby4j-7.0.0.jar -s 8080 -d stubs.yml -l "$IP_ADDR"
