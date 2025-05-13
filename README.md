# NEU Sandbox 2025 - Caterpillar Challenge

## Motivation

A submission for the 2025 Caterpillar Challenge, for the Northeastern Sandbox software development
consultancy group.

# Features

The program takes a JSON file, reads and interprets the data, and breaks it down into three given
categories using classes & objects - users, reviews, and roles. From there, mapping techniques are
used to correctly format the data in the desired manner for export, utilizing new classes and
objects. Finally, the data is sorted, packaged together back into a JSON file, and printed for the
user to see.

# Design Decisions

I decided to go with a Map as it was the most efficient way for the program to sort through 100
different, unique reviews and 25 different roles. Using my knowledge from SQL and Database, I
utilized the IDs of each user, rating, and role as linked keys that formed relationships between the
three data categories.

When the data was first imported into the project from the JSON file, I utilized three initial class
styles to organize the data properly. Before the mapping was done, the data was reorganized from the
original format into a new format, using new classes that aligned with the format desired by the
challenge. Finally, I used JsonObject to package the information together in the manner desired, and
export it to a new file.

# Challenges

As this was my first time working with Gson and APIs, it took a bit of learning at the start to
understand how the data was entering the program. Once I was able to clear that up by creating the
three initial classes to sort the incoming data, I initially decided to use iterative loops to sort
and format the data. I quickly realized that this would be inefficient, and instead switched to
Maps, which I knew were far more efficient as the program would be able to find the desired Object
using the key, rather than contiuously iterating through a long list.

# Key Takeaways

Regardless of whether I am accepted into the next round for applications, I am pleasantly satisfied
with the work I've shown in this program. I showed myself that I was able to work with APIs, foreign
data, and use concepts like Maps to completely transform the data that I was given. This project has
inspired me to explore other data-based software projects - one of my core interests lies in the
realm of transportation, a data-filled haven waiting for me to explore.
Above all, I'm most proud of the fact that I was able to quickly pick up a completely foreign topic,
and with a bit of research and learning, become familiar with the topic in a very short time.

If I had more time to work on this, I'd definitely try to implement a search function that would be
user facing. I'd also want to play around with front-end programs - particularly how this
information that I'm seeing right now could be formatted and displayed to the user. I'd also want to
add in more filtering and sorting options.

# Contributor

Dylan Intwala
intwala.d@northeastern.edu