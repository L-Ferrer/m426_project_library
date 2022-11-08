<h1 align="center">Library Project</h1>
<h3 align="center">BBW project for module 326 & 426</h3>
<p align="center">
  Made with<br>
  <img align="center" src="https://camo.githubusercontent.com/67a01fa7cf337616274f39c070a11638f2e65720e414ef55b8dd3f9c2a803b2a/68747470733a2f2f696d672e736869656c64732e696f2f7374617469632f76313f7374796c653d666f722d7468652d6261646765266d6573736167653d526561637426636f6c6f723d323232323232266c6f676f3d5265616374266c6f676f436f6c6f723d363144414642266c6162656c3d">
  <img align="center" src="https://camo.githubusercontent.com/d96a01edb67770ddc4a8794895b4e2c1fab10e9fab40060b287bcb3448915a01/68747470733a2f2f696d672e736869656c64732e696f2f7374617469632f76313f7374796c653d666f722d7468652d6261646765266d6573736167653d5669746526636f6c6f723d363436434646266c6f676f3d56697465266c6f676f436f6c6f723d464646464646266c6162656c3d">
  <img align="center" src="https://camo.githubusercontent.com/7d798ede2233b56431e6707226c348f5bc3d7a7151ca81db74717eed3f5b53f9/68747470733a2f2f696d672e736869656c64732e696f2f7374617469632f76313f7374796c653d666f722d7468652d6261646765266d6573736167653d537072696e672b426f6f7426636f6c6f723d364442333346266c6f676f3d537072696e672b426f6f74266c6f676f436f6c6f723d464646464646266c6162656c3d">
</p>

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
* Additional information for single media

## How to run
### API
Run [ProjectLibraryApplication.java](https://github.com/L-Ferrer/m426_project_library/tree/main/api/src/main/java/ch/bbw/m326/ProjectLibraryApplication.java) in your preferred IDE. 
### Client
You will need [npm](https://nodejs.org/de/download/) to run the client. 
1. Open cmd or powershell with `Windows + R --> cmd` or `Windows + R --> powershell`
2. Change directory to `m426_project_library/client` with `cd C:/<repository_path>/m426_project_library/client`
3. Execute `npm run dev`
