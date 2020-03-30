#!/usr/bin/env bash

heroku config:set PRODUCTION_PROPERTIES="$(cat secrets-heroku.properties)" "$@"
