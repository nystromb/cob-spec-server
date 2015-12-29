# Cob Spec Java Server

This is the repo that adheres to the [cob spec acceptance suite](https://github.com/8thlight/cob_spec) . 

## Getting started

1. Clone the repo
  * `git clone https://github.com/nystromb/cob-spec-server.git`
  * `cd cob-spec-server`

2. Initialize and get the latest updated server dependencies by issuing the following commands
  * `git submodule init`
  * `git submodule update`


3. Build the server dependencies by running `gradle build -p lib/http-server/`

4. Now build the cob spec server itself in the root of the project folder by running the `gradle build` command

## Starting the server
Now run `java -jar build/libs/cob-spec-server.jar -p YOUR_PORT` 

## Command line options

By default it runs on port 5000, so you may run the this command without the -p option. The server also serves files from the /public/ directory in the project root. You may also tell the server to serve up a different directory by passing in the directory of your choice when you go to run your server. 

For example: `java -jar build/libs/cob-spec-server.jar -d /your/public/directory/`

Visit the server in your browser at `http://localhost:YOUR_PORT`
