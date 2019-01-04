#!/bin/bash
cd /home/user/www/belchan/imageboard/;
APP_NAME="org.belchan.ImageBoardApplication";
APP_TITLE="BELCHAN";
DATABASE_NAME=agum131_imageboard
DATABASE_USER=belchan
DATABASE_PASS=Rn758DQQcH7NnbGQ
PID=$(ps -ef | grep "target/imageboard" | grep -v grep | awk '{ print $2 }')
COMMIT=$(git log --pretty=format:'%h' -n 1);
git pull;
COMMIT_NEW=$(git log --pretty=format:'%h' -n 1);

function buildAndStartApplication {
    mvn clean;
    mvn package;
    java -jar target/imageboard-0.2.jar
}

function backupDatabase {
    FILE_NAME=$APP_TITLE"-"$(date +%Y)-$(date +%m)-$(date +%d)_$(date +%H)-$(date +%M)-$(date +%S)".sql";
    mysqldump -u $DATABASE_USER -p$DATABASE_PASS $DATABASE_NAME >> ~/backup/$APP_TITLE/$FILE_NAME
}

if [ -z "$PID" ]
then
    echo "Application is already stopped"
else
    kill $PID
fi

#////////////////
if [ "$COMMIT" == "$COMMIT_NEW" ]; then
   echo "Have not updates! :("
       if [ -z "$PID" ]
       then
       		echo "Application start";
       		buildAndStartApplication;
       else
       		echo "Application already ruining!"
       fi
else
    if [ -z "$PID" ]
    then
        echo "Application is already stopped"
    else
        kill $PID
        echo "Application killed"
    fi

    #backup
    backupDatabase;

	#run
	echo "Application start";
    buildAndStartApplication;
fi