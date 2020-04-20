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

Navigate back to the settings page of the app you created
for Google OAuth

For every field that references `http://localhost:3000`:

- Add a comma-separated entry after the existing entry referencing your new production url.
- It is important you include **both** `localhost` **and** production urls so that both your localhost and production apps will work properly.

For example, if your production url is `https://myapp.herokuapp.com`,
your fields should now look like this:

TODO: UPDATE THIS

