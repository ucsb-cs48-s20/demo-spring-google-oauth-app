# Configuring OAuth for localhost

To work properly, this application must be configured to use Google OAuth.

This file explains all of these steps.

# The two secrets

This app requires three configuration secrets in order to function properly. Each of these secrets has a _key_ and a _value_:

The two keys are:
* `spring.security.oauth2.client.registration.google.client-id`
* `spring.security.oauth2.client.registration.google.client-secret`

The instructions in this file explain how to obtain these secrets
and store them in the `secrets-localhost.properties` file.

# Create the `secrets-localhost.properties` file:

The `secrets-localhost.properties` file should be created by running:

```
cp secrets-localhost.properties.SAMPLE secrets-localhost.properties
```

This file is only stored in the local repo, not in the file system of the GitHub repo.

The reason that we do not store the secrets in the file system
of the GitHub repo is that if the code is ever made open source
in the future, having these secrets in the code leaks them to the public.

Even if you have no plans to make your code open source, maintaining
these secrets in your source code is a poor practice. One
of the learning goals of CMPSC&nbsp;48 is to train you for real world
software development practices, so we will review your code, and make
deductions if we find secrets hard coded in files committed to GitHub.

For now, the `secrets-localhost.properties` file looks like this, with placeholders for the  secrets. We'll put in the values at a later stage:

```
spring.security.oauth2.client.registration.google.client-id=REPLACE-ME
spring.security.oauth2.client.registration.google.client-secret=REPLACE-ME
```

## Setting up Google OAuth for `localhost`

Instruction for this can be found here:

* <https://ucsb-cs48.github.io/topics/oauth_google_setup/>

For developing on localhost, this is all you have to do; you should
be able to return to the instructions in [README.md](../README.md)
for starting up the application on localhost.
