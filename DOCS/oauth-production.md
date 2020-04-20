# Setting up OAuth for deploying on Heroku


In order for Google OAuth to recognize the app running on a production url
running on Heroku, you will need to make a change to your app configuration


Your production url is something of the form

```
https://my-app-name.herokuapp.com
```

For example, for lab00 in CS48, it might be:

```
https://cs48-s20-cgaucho-lab00.herokuapp.com
```

To add in the redirect URI for this app, visit the Google Developers
Console at:

* <https://console.developers.google.com/>

You'll need to locate your application.  In the upper left hand part of the
page, there is a field next to the words "Google APIS" that shows the name of the currently selected app, with a triangle shaped button to the right.

This button shows the name of the currently selected application for the Developer Console.

* If on *your* screen, that button doesn't show the application you want to work with, click the button, to bring up a window where you can select your
  app.
* If your app is not shown, you may need to click the "ALL" tab to locate
  your application.

Once you can see your app, click on the left hand menu where it says "Credentials".

You should then see a screen with section called "OAuth 2.0 Client Ids", and line under that table for "OAuth Client".  Click on this line.

This should take you to a screen where there is a list of URIs.

Under that list you should see your URI for localhost listed, i.e.

* `http://localhost:8080/login/oauth2/code/google`

Click the `+ ADD URI` button to add another URI.

Add this, where `cs48-s20-cgaucho-lab00` is the name of your Heroku app:

* `https://cs48-s20-cgaucho-lab00.com/login/oauth2/code/`

Note that the `localhost` URI starts with `http`, but the one for Heroku starts with `https`.  This is a necessary detail; it won't work otherwise.

Click the "Save" button.  At this point, the same client-id and client-secret
that you used for localhost should also work for Heroku.

Be sure that you copy those values from `secrets-localhost.properties` to `secrets-heroku.properties` and then run `setHerokuEnv.sh --app appname` where `appname` is the name of your heroku app (e.g. `cs48-s20-cgaucho-lab00`).


