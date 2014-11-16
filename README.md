Karaf load generator
====

Description:

Utility for generating load in a karaf container.

Building from source:
===

To build, invoke:

 mvn install


To install in Karaf, invoke from console:

 install -s mvn:com.savoirtech.karaf/load-generator


Commands:
===

load:start -t X

  Where x is the number of threads to spin up

load:stopall

  To stop all running threads

load:list

  To list all running threads