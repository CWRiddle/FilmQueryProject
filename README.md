# Film Query Project

## Overview
This program searches databases for films based on user input.

The program will present the user with a menu and prompt the user to select the method in which they would like the search the database.
There are two options available:
* Search by single film id
    -This method returns a single film based on a numeric input for the film id
* Search by keyword
    -This method returns a collection of all matching film titles that contain the keyword

This program supports input validation.

### Technology Used
* SQL
* Java
* custom toString methods


### How to Run
Compile and run in IDE or Terminal

### Lessons Learned
I learned that there is such thing as a "TooManyConnections" exception in Java.
This error occurred when I tried to open additional connections to the mySQL database inside of the film class itself.
In the end, my reason for doing so proved to be unnecessary as the solution the problem I was trying to tackle with the
additional connections in the film class could have been resolved by being more specific with my SQL query statement.
However, running into this error did tell me that I have to be aware of any excess open connections in the future.

I built a fairly elaborate toString method for the films. I used a combination of dynamic dashed lines and dynamic lines with spaces in them. The dashed lines served as visual separators while the spaced lines filled out the empty space in order to "cap off" the end of the table.
The dashed lines were populated according to the length of the description, which I deemed to be the longest string in the table.
The spaced lines were populated based on the length of the strings in each field for the film. I used a pair of maps to aid in finding these values.
* All in all, while making this toString, it made me wonder how mySQL generates it's toStrings
