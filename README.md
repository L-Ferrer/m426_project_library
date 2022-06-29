# m426_project_library
BBW project for module 326 & 426.

## Description
This project contains a SpringBoot REST-API and a React webapp which create a library application.
As it wasn't allowed to use SQL the library and the user database is a json file in the `api/database` directory.

## Features
### Implemented
* Login and registration as user
* Login sessions can be kept over multiple tabs
* Library table
### Work in progress
* Privileged users (Admin)
* Remove and add media to the library
* Reservation and borrow system

## How to run
### API
Run `api/src/main/java/ch/bbw/m326/ProjectLibraryApplication.java` in your prefered IDE.
### Client
You will need [npm](https://nodejs.org/de/download/) to run the client. 
1. Open cmd or powershell with `Windows + R --> cmd` or `Windows + R --> powershell`
2. Change directory to `m426_project_library/client` with `cd C:/<repository_path>/m426_project_library/client`
3. Execute `npm run dev`
