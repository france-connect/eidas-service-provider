
Service Provider Mock Project started from eIDAS Node version 1.1 package and configured for Tomcat Web Server 8 and JDK 7.

This project is related to the eIDAS Node developped and configured for FranceConnect :
[https://gitlab.octo.com/franceconnect/france-connect](https://gitlab.octo.com/franceconnect/france-connect)

Documentation is available at the following link : 
[https://service-public.atlassian.net/wiki/display/FC/ARCHI+%3E+TECH+%3E+Norme+eIDAS](https://service-public.atlassian.net/wiki/display/FC/ARCHI+%3E+TECH+%3E+Norme+eIDAS)


PROJECT Configurations
=====================
Change every occurrence of the default project location (see below) by your own workspace location :

    repository location : <workspace.location>
    replace occurrence  : /home/workspaces/eclipse/eidas-sp


MAVEN Configurations
=====================

**Goals**

    clean source:jar javadoc:jar install

**Profiles**

    coreDependencies

**Parameters**

    additionalparam=-Xdoclint:none
    maven.javadoc.failOnError=false


TOMCAT Server Configurations
=====================

EIDAS-SP
--------------------
**VM arguments**

    -DLOG_HOME="<log.repository.location>/eidas/sp"

**Classpath**

    User Entries > Advanced... > Add External Folders
	Select the following folder : <workspace.location>/EIDAS-Config/

**Ports**

    HTTP Port : 8080
    Tomcat Admin Port : 8005
    AJP : 8009
