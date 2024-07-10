# This git repository demonstrate some of the important  Design Pattern used in the industry
## Creational Pattern
1. Abstract Factory Pattern
    - has an Abstract Factory, has Abstract Products too and then , the client that uses the factory, can easily switch from one factory to another.
    - We need this factory so that client only know about the things that are to be used together, something like utility, when u have many reated things but come in different flavour. use this pattern.
2. Factory Method Pattern
      - we can have a default implementation in the factory method. Which acts like a hook. 
      - the subclasses have the power to choose which object to create.
3. Adapter Pattern
   - Used to connect 2 interfaces that have difference in their method signatures. But have more or less the same working. 
   - There is something called 2 way adapter , where there is an existing class that we have extended or we have implemented 2 interfaces together., and we also implement the adaptee.
## Behavorial Pattern 
5. Observer Pattern 
   - is a behavioural pattern where in the way 2 classes communicate is shown to be pub-sub model. 
     Observer pattern has a producer which neednt know about the classes that are subscribed to it . 
     but they will be notified once there is a change in the info of the Producer. 
     They can do whatever they want to. 
6. Composite pattern .
   This is also a behavioural pattern, where in structure of classes follow a tree like structure.
   Where some are complex objects made out of components and some objects are like leafs not components. that dont have more children.
   Example a drawing . a drawing is made from various components. which come from lines and arcs, other simpler objects. 
   The book tells about a part-whole relationship.  We can use this pattern when we want to reccurively call something down the component line. 
   
   Other hirarchial structures are . non single cells organisms, having organs, tissue , organizations, File system, Android or html webpage.



This project also covers a combined small gui , combining many patterns together.




from the gang of 4 . 
