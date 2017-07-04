# Goal

Track your services.

# Installation

## Start database

    docker run -d --name orientdb -p 2424:2424 -p 2480:2480 -e ORIENTDB_ROOT_PASSWORD=rootpwd orientdb

    CREATE DATABASE code-tracking st password plocal
