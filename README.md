# goeuro-test
This is a simple exam for goeuro

1) It is a project created with Eclipse.
2) Contains a lib directory that contains the required third party jars.
3) In the root directory, there is an already packaged jar.


Steps to Run:
1) type in the command line in the application root directory:
	java -jar GoEuroTest.jar "Berlin"

2) The application will call the api with city name Berlin
3) Application will create csv file with the city name e.g. Berlin.csv if not exists, if there exists a file with Berlin name, application will delete it and create new one.