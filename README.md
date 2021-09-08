# microservice_poc
Microservice POC

Steps to execute this project: -

Clone the Repository in the local system.
Import all the maven projects to the Eclipse.
At first, Run service-registry as Java Application and access it through browser(eg. Chrome) and the uri - localhost://8761
Run cloud-config-server as Java Application.
Run cloud-gateway as Java Application.
Run department-service as Java Application.
Run student-service as Java Application.
Steps to access the endpoints: -

Download Postman in the local system.
Create account and workplace(if don't have any account)
Import the Microservice_POC.postman_collection.json(Present in the Repository)
Access all the endpoints.
Steps to Run Zipkin Server: -

Download Zipkin Server in the local system(zipkin.io -> Quickstart -> Under Java section - latest release).
Run the Zipkin Server using Cmd (command --> java -jar zipkin-server-"your zipkin version"-exec.jar).
Access the zipkin server using the uri - " http://127.0.0.1:9411/zipkin/ " in the browser.