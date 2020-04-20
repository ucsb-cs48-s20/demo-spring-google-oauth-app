# cs48 s20 demo-spring-google-oauth-app

This code is intended to be a demo of a minimal web app using:
* Spring Boot as the backend
* Thymeleaf templating and server side rendering
* Only Bootstrap and JQuery as front-end frameworks
* Heroku Postgres as backend db
* Simple user management via Google OAuth
* Admin users defined in `application.properties` and overridable in `secrets-localhost.properties`
  and/or `secrets-heroku.properties`

Starter Code

# Configuration for OAuth on localhost

See instructions at [DOCS/oauth-localhost.md](DOCS/oauth-localhost.md)

# To run on `localhost`

Type:

```
mvn spring-boot:run
```

# Configuration for OAuth on Heroku


You should first create an application on the Heroku Dashboard, or using the Heroku command line tool.   You need your app name already defined before you proceed.  An app name is something such as `cs48-s20-pconrad-lab00`, and it would be the part that comes before `.herokuapp.com` in the app URL.

Once you have an app name, you can set up your app for Heroku.

See instructions at [DOCS/oauth-production.md](DOCS/oauth-production.md)

Note that for Heroku, you will need to login with the `heroku login`
command line tool in order to be able to run the script that setup up
Heroku credentials.


# To deploy to Heroku

To deploy to Heroku
* Login to the Heroku Dashboard and create a new Heroku App
* Link your GitHub repo to the app on the deploy screen
* Copy your client-id and client-secret from `secrets-localhost.properties` to `secrets-heroku.properties`.   For Google OAuth, since you can configure multiple redirect URIs, it should be possible to reuse the same values.
* Be sure that you follow the instructions in [DOCS/oauth-production.md](DOCS/oauth-production.md) to add the redirect URI for heroku to your Google OAuth app.


# Testing

To run tests: `mvn test`




