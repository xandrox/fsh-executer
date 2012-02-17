## install the plugin

forge source-plugin

## run the plugin

	export FORGE_OPTS="-Dexec.fsh.file=/Users/sso/Documents/dev/adorsys/fsh-executer/src/test/resources/de/adorsys/fshexecuter/test.fsh -Dnewproject.dir=test 		-Dnewproject.topLevelPackage=org.adorsys.test -Dnewproject.name=test"

	forge
 
 output
 
	execute script /Users/sso/Documents/dev/adorsys/fsh-executer/src/test/resources/de/adorsys/fshexecuter/test.fsh
	***SUCCESS*** Created project [test] in new working directory [/Users/sso/Documents/dev/adorsys/test]
	Wrote /Users/sso/Documents/dev/adorsys/test/pom.xml
	finished script 


