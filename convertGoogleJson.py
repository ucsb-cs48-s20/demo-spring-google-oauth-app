#!/usr/bin/env python3

# This file takes the values in heroku.json, and sets those values
# on a remote app.

# You should invoke this with
# ./setHerokuEnv.py --app APPNAME
#
# Any additional arguments passed after ./setHerokuEnv.py are passed to the "heroku config:set" commandn

import json
import os
from pprint import pprint
import sys


if len(sys.argv)!=2:
  print("Converts credentials.json from Google OAuth to format needed")
  print("  for Spring Boot properties files")
  print("Usage: "+sys.argv[0]+" input ")
  print("   where ")
  print("      input is filename of a credentials.json file downloaded from Google OAuth configuration")
  sys.exit(1)

input_filename = sys.argv[1]


try:
  with open(input_filename) as input_file:
     input_dict = json.load(input_file)
except IOError as e:
  print("Error reading from", input_filename)
  print(type(e),e.args)
  sys.exit(2)
except Exception as e:
  print("Error parsing JSON from ",input_filename)
  print(type(e),e.args)
  sys.exit(3)

client_id_key = "spring.security.oauth2.client.registration.google.client-id"
client_secret_key = "spring.security.oauth2.client.registration.google.client-secret"

client_id = input_dict["web"]["client_id"]
client_secret = input_dict["web"]["client_secret"]

print(f"{client_id_key}: {client_id}")
print(f"{client_secret_key}: {client_secret}")
