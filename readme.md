#RedCrossQuest SBDF Data Exporter

This project connect to RedCrossQuest DB and export the data to the TIBCO Spotfire SBDF format.
The files would then be uploaded to Spotfire Server
Generating a specific file is done by a GET on a specific URL. 
The purpose is to use linux crontab to trigger the file generation.

This tool will stream the data to the file. 
It won't fetch all data in memory and then dump it in the file.

## Installation

1. Checkout the sources, enable maven
2. Download the [TIBCO Spotfire SBDF library](https://community.tibco.com/wiki/tibco-spotfirer-sbdf-library)
3. Install sdbf.jar in your local maven repository

        mvn install:install-file -Dfile=sbdf.jar
                                 -DgroupId=com.tibco.spotfire
                                 -DartifactId=sbdf
                                 -Dversion=6.5
                                 -Dpackaging=jar
                                 -DgeneratePom=true  sbdf 6.5
4. Configure the application.properties
5. Run the project
6. Try to generate files :

        http://localhost:8080/sbdf-generator/1.0/spotfire_access
        http://localhost:8080/sbdf-generator/1.0/tronc_queteur
        http://localhost:8080/sbdf-generator/1.0/named_donation
        http://localhost:8080/sbdf-generator/1.0/yearly_goal
        http://localhost:8080/sbdf-generator/1.0/daily_stats_before_rcq
        http://localhost:8080/sbdf-generator/1.0/ul
 
Note that tronc_queteur will generate table data from tronc_queteur, and before that, the dependencies tables (tronc, queteur, point_quete)