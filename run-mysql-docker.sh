#!/usr/bin/env bash
NAME="springbootmysql"
IMAGE="mysql:5.7"

PORT="9306"

USER="boot"
PASS="boot"
DB="boot"
ROOTPW="flusso126a"

docker pull mysql:5.7


RUNNING=`docker ps | grep -c $NAME`
if [ $RUNNING -gt 0 ]
then
   echo "Stopping $NAME"
   docker stop $NAME
fi

EXISTING=`docker ps -a | grep -c $NAME`
if [ $EXISTING -gt 0 ]
then
   echo "Removing $NAME"
  docker rm $NAME
fi

echo "Create new instance $NAME based on $IMAGE"
docker run --name $NAME -e MYSQL_USER=$USER -e MYSQL_PASSWORD=$PASS -e MYSQL_DATABASE=$DB -e MYSQL_ROOT_PASSWORD=$ROOTPW -p $PORT:3306  -d $IMAGE



echo "Tail the logs of the new instance"
sleep 10
docker logs $NAME
