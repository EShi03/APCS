Introduction
----------------------------
This is a program that uses multiple classes and inheritance
to make logical sentences and print them out as a table

Specification
----------------------------
This program does not meet the requirements of the assignment given
as it cannot successfully print out a truth table for a logical sentence.
This is because there are certain methods that do not work. These include:
evaluate, findMatch, truthTable. These methods are mainly not complete because
I couldn't interpret what they were suppose to do and I didn't ask for help.
However, I have made classes with proper inheritance that set the correct boolean values
and proper classes for proposition constant and logical sentence.

Errors
----------------------------
Some error the program has include evaluate and findMatch default to returning true,
truthTable doesn't print out anything, and logical operations don't retain or take note of what operation
it did (so the truth table does not know what operation to print out). There is probably an error in the constructors
in the LogicalSentence class, due to the fact that it takes an object of itself as a attribute.

Overview of Code
----------------------------
The code consists of one main class, one PropostionConstant class.
one LogicalSentence class, two logical operator classes, conjunction and negation,
and one TruthAssignment class. 

The main class creates various instances of the classes
and uses them to create logical sentences, except for the TruthAssignment class which assigns
boolean values to the proposition constant instances. The main class also has class methods
that prints out a truth table and makes sure that all the given values are valid and finds them.

The PropositionConstant class takes name and boolean as a parameter. The boolean
attributes has a getter and a setter, while the name attribute only has a getter

The LogicalSentence class takes a PropositionalConstant and a LogicalSentence as a parameter.
Both have getters and there are three constructors for LogicalSentence (one for taking both attributes and
the other two takes one attribute each).

The Negation class takes a LogicalSentence as a parameter and changes its
propositional constant's boolean to the opposite value, using a class method.

The Conjunction class takes two LogcialSentence as a parameter and changes the first
logical sentence's constant's boolean to the combination of the first
logical sentence's constant's boolean and the the second logical sentence's constant's boolean.

The TruthAssignment class takes no parameters and has no attributes.
It only has an instance method that takes a propositional constant and a boolean
and assigns that boolean to the propositional constant's boolean.

Major Challenges
----------------------------
One major challenged I faced was when I couldn't figure out how to adjust the value
of the boolean of a propositional constant of a logical sentence in the logical operator classes.
I realized that I could just use a class method and give it the given logical sentence as a parameter,
instead of just chaining methods within the constructor.

Another major issue I faced was that I misinterpreted how the logical sentence
and logical operator classes were suppose to work. This lead to the program being unable
to be complete because the program could not recall the operations it did to get the boolean values
and print it out in a table because the program didn't record the operations or the propositional constants/
logical sentences that it used.

Acknowledgements
----------------------------
I would like to thank my teacher who helped explain the assignment in class,
even though I still didn't fully understand it after the lecture.


