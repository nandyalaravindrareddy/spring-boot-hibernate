#!/bin/sh

username='nandyalaravindrareddy'
token='Swethagg@514'
repoName='mygcprnd'

curl "https://github.com/${username}/${repoName}.git"
# If repository exits then
WORKING_DIR=/home/india/GCP_RnD/test
if [ $? -eq 0 ]; then
  cd $WORKING_DIR
  if [ -d "$WORKING_DIR/${repoName}" ]; then
    echo ".......Repository exists.......\n"
    cd $WORKING_DIR/${repoName}
    git push origin
    git checkout -b main
  else
    echo ".........Repository not exists and cloning .......\n"
    git clone git@github.com:${username}/${repoName}.git
    cd $WORKING_DIR/${repoName}
  fi

  # Display unstaged files
  echo ".........Calling resapi to push service account and roles .......\n"
  result=$(curl -X GET --header "Accept: */*" "http://localhost:8082/iam/fetchSAcctRoles")
  git pull origin main
  echo $result
  echo $result > roles.json
  git status
  git add .
  git commit -m "committing new changes"
  git push origin main
  echo "...changes are pushed successfully..."
else
 echo ".........no such repository exists............"
 exit 1
fi


# End of script
