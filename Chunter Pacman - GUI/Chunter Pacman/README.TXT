Project: Chunter Pacman- GUI
Authors: Youssef Abouwarda & Hussam Kayed
This project is an improvement of Chunter Pacman Console Project, the game is now transferred into GUI
This project is a simple framework for an adventure game. In this version,
it is about a fridge consisting of 4 Places , and Our Pacman is moving between these 4 places and picking the cheese up.
When the Pacman goes to a place, an Image of the place should be displayed and the cheese count should increase by the amount of cheese peaces in the place.
The player has a time of 1 minute to finish, when the time ends he wins if he has collected a sufficient amount of cheese
the project is working but still needs some improvements for some features.
Modifications from the console version
-new Class GUI with the constructor and its contents was created.
- Command input was modified, OK Button was created
-Command Processing is now transformed from Console to GUI, so it’s now taken and processed on GUI with the method ActionPerformed that I created.
-the method printWelcome was moved from Game Class to GUI Class.
- Image feature was added to the Rooms in the Room Class with the method setImage and by adding instance variable for the Image ,as well in CreateRoom method in Game Class, line to add image for each part was added
-Some methods in the Game class were modified by changing the return type from void and Boolean to string, such as “String goBack()”,”String quit(Command command)”, “String goRoom(Command command)”, String printHelp()
- “showAll” Method was modified in CommandWords Class by changing its return type to String.



