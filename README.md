# This git repository demonstrate some of the important  Design Pattern used in the industry
## Creational Pattern
###  1. Abstract Factory Pattern
    - has an Abstract Factory, has Abstract Products too and then , the client that uses the factory, can easily switch from one factory to another.
    - We need this factory so that client only know about the things that are to be used together, something like utility, when u have many reated things but come in different flavour. use this pattern.
### 2.  Factory Method Pattern
      - we can have a default implementation in the factory method. Which acts like a hook. 
      - the subclasses have the power to choose which object to create.
### 3.  Adapter Pattern
   - Used to connect 2 interfaces that have difference in their method signatures. But have more or less the same working. 
   - There is something called 2 way adapter , where there is an existing class that we have extended or we have implemented 2 interfaces together., and we also implement the adaptee.
## Behavorial Pattern 
### 5.  Observer Pattern 
   - is a behavioural pattern where in the way 2 classes communicate is shown to be pub-sub model. 
     Observer pattern has a producer which neednt know about the classes that are subscribed to it . 
     but they will be notified once there is a change in the info of the Producer. 
     They can do whatever they want to.
### 6.  Composite pattern .
   This is also a behavioural pattern, where in structure of classes follow a tree like structure.
   Where some are complex objects made out of components and some objects are like leafs not components. that dont have more children.
   Example a drawing . a drawing is made from various components. which come from lines and arcs, other simpler objects. 
   The book tells about a part-whole relationship.  We can use this pattern when we want to reccurively call something down the component line. 
   
   Other hirarchial structures are . non single cells organisms, having organs, tissue , organizations, File system, Android or html webpage.

### 7.  Stratergy Pattern. 
    - When we have algorithms that dont users can choose from . then better to put them as stratergies. 
    - Example Serveral Encoding Schemes. / Several Message digest schemes. 
    - Here we can create many types of classes without having to create one for each explicity, we can just change the
      algo by swithing to new stratergy. 
    - When we dont want to show the user the data of the algorithms.  
### 8.  Decorator pattern. 
   - Its a pattern used when we want to change the skin of the object and not the guts. 
   - its useful when we can add features unknown to us currently, adding functinallity is easy. 
   - cons, the actual object might be very different from the one we started out with. With additional features.
### 9.  Tempalate Pattern. 
  - the parent knows the algorithm. The children will do the primitive steps.
This project also covers a combined small gui , combining many patterns together.


According to gang of 4, these are the most used patterns in software industry. 




Here are more 
## Behavourial 
### 10.  Chain of Responsibility Pattern,
    Here we the caller doesnt know before hand who needs to handle its request. So we make a chain of handlers. Here the
    handlers implement the iterface which should have handle command. the successor will be given in the constructor.
    if one handler fails to handle the request the, request  will go to the successor if present. 
    ATM , vendor machine, help depending on context are given as some example. Even in logging this is used.

In our example, we have combined Stratergy pattern and the Chain of responsibility Pattern to make the money dispensor
### 11. Command Pattern
       Here we are wrapping the "command" so that the caller / invoker can be anyone and the reciver can be anyone. 
       We also want to do undo / redo and maintain the history of the commands . 
       for example if there is a transaction we need to know exactly what was done and what needs to be 
       un-done . So that transaction protery is maintained. Here Command pattern comes in as a powerful pattern.
       Command knows what exactly is to be done when is called execute and what is to do done when called un-execute.
        Great way to pass messages. Job Scheduling . Logging changes. [re-execute the changes] Transaction mangement as
       mentioned.
      There is a Command interface with execute and unExecute. then we have Invoker and the reciver. in this pattern. 
      Invoker will maintain the set of commands which were called by it.  In our case Application was the invoker
      and ClipBoard was the reciver . both interact only via the CopyCommand


from the gang of 4 . 
