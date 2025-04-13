 Team
| FirstName     | LastName      | 
| ------------- | ------------- |
| Chloe         | Choi          | 
| Jacelynn      | Doan          | 
| Omar          | Ahmed         | 
| Marcus        | Lieu          | 

Work Process
Forked Repository – The project started by forking denoslab/ensf400-demo for team collaboration.

Feature Branching – Changes were made in separate branches before merging into master.

Containerization – The project was containerized using Docker for easy deployment.

Gradle Build System – Used Gradle 7 for managing dependencies and running the application.

Pull Requests & Reviews – All changes were submitted via Pull Requests (PRs) and reviewed before merging.

How to Run the Project
Ensure You Are Using Java 11

Ensure Using Gradle 7

Build the Docker Image
docker build -t <project-name>:$(date +%Y%m%d%H%M%S) .

Run the Most Recent Tag
docker run -it -p 8080:8080 <project-name>:<Tag> ./gradlew appRun
 
Open the Application
http://localhost:8080/

## Screenshots
![Alt text](<Screenshot 2025-03-17 at 11.56.46 AM.png>)
![Alt text](<Screenshot 2025-03-17 at 12.03.59 PM.png>)
![Alt text](<Screenshot 2025-03-17 at 12.02.49 PM.png>)


test msg !!
