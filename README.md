# OneDistance

Java game that builds graph from an array of given strings (currently this is being fed statically) that each string is connected to other string if and only if they are distincted only by one letter. 
The Graph Interface aloow check if 2 word are connected and also print the path which they are connected with.

for example: 
given "aaa", "aba", "abc", "bbb", "acc" and for the query printPath("aaa" , "acc") 
it will print aaa->aba->abc->acc
for printPath("aaa", "bbb") will print "Nodes are not connected")

* all word have to be in same length.
