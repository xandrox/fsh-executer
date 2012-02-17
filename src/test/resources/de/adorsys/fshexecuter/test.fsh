@projectDir = System.getProperty("newproject.dir");
@topLevelPackage = System.getProperty("newproject.topLevelPackage");
@name = System.getProperty("newproject.name");

@//echo $_0;

@/* Create a new project in the current directory */;
new-project --named $name --topLevelPackage $topLevelPackage --projectFolder $projectDir;