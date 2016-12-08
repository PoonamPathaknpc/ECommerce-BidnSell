# ECommerce-BidnSell
Online ecommerce application for selling and bidding the items online.

1.Run the files on Eclipse, with the necessary dependencies.
(Pom.xml) from the source folder gives these dependencies.

2.Memcached needs to be run on a directory, reachable from the eclipse home directory(JAVA HOME). The Memcached code can be found in Profileserv.java
and Updateprofileserv.java.

3.Create a keystore file using keytool in cmd line.
Put this keystore in the JAVA HOME.
Now change the ports / encoding according for the encryotion and compresion to work.
9080(8443) -- 8080(8445) are the ports(normal and encrypted) on client and server side.
