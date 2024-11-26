spring:
application:
name: ingredients-manage-service
profiles:
active: local
config:
import: "configserver:"
cloud:
config:
uri: http://localhost:8888
request-connect-timeout: 5000
request-read-timeout: 5000

      fail-fast: false
      retry:
        max-attempts: 6
        initial-interval: 1000
        max-interval: 2000
        multiplier: 1.1

management:
endpoints:
web:
exposure:
include: refresh
