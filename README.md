# century-link-demo
GitHub API demo for interview

To run, simply execute the jar, and target http://localhost:8080/followers with the Http request editor of your choice (presumably Postman?)
The endpoint takes a single request parameter of userId, with the value being the login ID of the user you want to get the followers of.
Returns a User object containing user details, along with a nested list of Followers of that user (3 deep).
