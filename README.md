# VolkswagenInsurancePortal

### Assumptions or Prerequisistes for this Project ###

Please install chrome browser in your machine

Please install Java 8 SDK in your machine and set the class path

Please add cucumber for java plugin to your IDE (Intellij/Eclipse etc)

Please add testNG plugin to your IDE (Intellij/Eclipse etc)

### How to compile this project ###

Download the project into your local machine using the below command

```
git clone https://github.com/ramatjob/VolkswagenInsurancePortal.git
```

Now in the command prompt, navigate to the folder (In my case, it is C:\MyProjects\VolkswagenInsurancePortal), where you have cloned this project and run the below command
```
mvn clean compile
```

### How to run the test scripts ###

If you want to run the test scripts in WINDOWS machine, please run the below command in the command prompt
```
mvn verify -Dprofile=runFindVehicleTests -DbrowserType=Chrome -DgridType=Local -DplatformType=WIN32 -DenvironmentType=qa
```

If you want to run the test scripts in MAC machine, please run the below command in the command prompt
```
mvn verify -Dprofile=runFindVehicleTests -DbrowserType=Chrome -DgridType=Local -DplatformType=WIN32 -DenvironmentType=qa
```

### How to check the reports ###

Under the project base folder, you can find the `target` folder (In my case, it is C:\MyProjects\VolkswagenInsurancePortal). So under the `target` folder, please navigate to `/cucumber-reports/advanced-reports/cucumber-html-reports/overview-features.html`

For example, in my local machine, `VolkswagenInsurancePortal` project is kept under `C:\MyProjects\VolkswagenInsurancePortal\`. So the report will be available in the `C:\MyProjects\VolkswagenInsurancePortal\target\cucumber-reports\advanced-reports\cucumber-html-reports\overview-features.html`

So open the `overview-features.html` in any browser, it will show you the full test execution report
