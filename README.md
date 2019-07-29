# 4th-year-computing-project-JakeWalsh69

# The Walsh Movie Database allows users to search, review, save and rate their favourite movies.
# This Web Application allows for quick and simple search based on criteria such as genre, name, keyword etc...
# Results for all movies that match the search criteria are returned in a matter of seconds using TheMovieDB API.
# Take a look at TheMovieDB API here: https://api.themoviedb.org/3

# DEVELOPER NOTES AND INSTRUCTIONS TO RUN SERVER LOCALLY
# This is a Spring Boot Server built using Maven.
# This server sends request to the external API: https://api.themoviedb.org/3
# and returns JSON Movie data regarding movie titles, descriptions, release_dates etc...
# This data can then be converted to a JSON Object and displayed over localhost.

# To run the backend Spring boot server: `mvn spring-boot:run` and go to `localhost:8080`
# The database is a h2 database and can be found at `localhost:8080/movie_db` while the server is running locally.
# To run the frontend AngularJS server, navigate to `src\main\resources\static\RestClient` directory and enter `ng serve --open`
