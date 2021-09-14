# microservice_poc
Microservice POC

Steps to execute this project: -

1. Clone the Repository in the local system.
2. Import all the maven projects to the Eclipse.
3. At first, Run service-registry as Java Application and access it through browser(eg. Chrome) and the uri - localhost://8761
4. Run cloud-config-server as Java Application.
5. Run  cloud-gateway as Java Application.
6. Run department-service as Java Application.
7. Run student-service as Java Application.

Steps to access the endpoints: -

1. Download Postman in the local system.
2. Create account and workplace(if don't have any account)
3. Import the Microservice_POC.postman_collection.json(Present in the Repository)
4. Access all the endpoints.

Steps to Run Zipkin Server: -

1. Download Zipkin Server in the local system(zipkin.io -> Quickstart -> Under Java section - latest release).
2. Run the Zipkin Server using Cmd (command --> java -jar zipkin-server-"your zipkin version"-exec.jar).
3. Access the zipkin server using the uri - " http://127.0.0.1:9411/zipkin/ " in the browser.
