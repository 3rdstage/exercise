

### Principals

* Actors can only be created by other actors—where the top-level actor is provided by the library—and each created actor is supervised by its parent.
* Everything in Akka is designed to work in a distributed setting.
* Dead letters are not propagated over the network, if you want to collect them in one place you will have to subscribe one actor per network node and forward them manually.
* putting Akka on the boot class path will yield `NullPointerException` from strange places
* An `ActorRef` always represents an incarnation (path and UID) not just a given path. Therefore if an actor is stopped and a new one with the same name is created an `ActorRef` of the old incarnation will not point to the new one. An `ActorRef` always represents an incarnation (path and UID) not just a given path. Therefore if an actor is stopped and a new one with the same name is created an `ActorRef` of the old incarnation will not point to the new one.


### Key principles of actor model

* No shared state
* Lightweight processes
* Asynchronous message-passing
* Mailboxes to buffer incoming messages
* Mailbox processing with pattern matching


