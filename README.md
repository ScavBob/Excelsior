# Excelsior
A Console Application that will take the table in any website and put it to an .xlsx format.

## Table of contents
* [General info](#general-info)
* [Introduction](#introduction)
* [Building](#Building)
* [License](#license)

## General Info
This is project is derived from my need to constantly use a spreadsheet whether it be movies I've watched and would like to rate or the way in which I can min-max a game the most efficently. So, this is basically a console app that will take the table in any website and build into a spreadsheet using .xlsx format.

## Introduction
Excelsior is a console app that creates a spreadsheet out of any table in any website, with a few problems that I plan on handling. It's quite a small app and mostly for my useage but you are free to use it all you like.

This app is under the GNU General Public License.

## Building

To build this project you will need Maven 2. You can get it at:
 
     http://maven.apache.org

 Clean compilation products:
 
     mvn clean
     
 Compile:
 
     mvn compile
     
 Run in a tomcat server:
 
     mvn package
     
 Once packaged into a jar, you can use the app by using your console of choice
  
    java -jar .\Excelsior-0.0.1.jar [Website URL] [File Name]

## License
     Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
    Everyone is permitted to copy and distribute verbatim copies
    of this license document and changing it is allowed.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    any later version.

    For more information, see https://www.gnu.org/licenses/.
