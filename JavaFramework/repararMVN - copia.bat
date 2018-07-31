cd C:\workspace\JavaFramework
C:\workspace\JavaFramework\src\librerias\apache-maven-3.5.4\bin\mvn.cmd -X clean
C:\workspace\JavaFramework\src\librerias\apache-maven-3.5.4\bin\mvn.cmd -X dependency:list 
C:\workspace\JavaFramework\src\librerias\apache-maven-3.5.4\bin\mvn.cmd -X dependency:copy-dependencies 
C:\workspace\JavaFramework\src\librerias\apache-maven-3.5.4\bin\mvn.cmd -X compile 
C:\workspace\JavaFramework\src\librerias\apache-maven-3.5.4\bin\mvn.cmd -X clean test
 pause