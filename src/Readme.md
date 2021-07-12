#JunitTest

This is a maven project
##
There are 8 Tests for the sorting algorithm (selection).

Two factor checked to pass every test.
            
            i) If any element is altered during test and
            ii) If sorting was done in right order


##
To run this project you need to add few properties inside your 'pom.xlm' file.
    
            <properties>
                <maven.compiler.source>16</maven.compiler.source>
                <maven.compiler.target>16</maven.compiler.target>
                <junit.jupiter.version>5.7.0</junit.jupiter.version>
            </properties>
and few dependencies described below:
            
            <dependencies>
                <dependency>
                    <groupId>org.junit.jupiter</groupId>
                    <artifactId>junit-jupiter-engine</artifactId>
                    <version>${junit.jupiter.version}</version>
                    <scope>test</scope>
                </dependency>

                <dependency>
                    <groupId>org.junit.jupiter</groupId>
                    <artifactId>junit-jupiter-api</artifactId>
                    <version>${junit.jupiter.version}</version>
                    <scope>test</scope>
                </dependency>
                <dependency>
                    <groupId>junit</groupId>
                    <artifactId>junit</artifactId>
                    <version>RELEASE</version>
                    <scope>compile</scope>
                </dependency>
             </dependencies>



Feel free to ask me any issue here.

Thank you!