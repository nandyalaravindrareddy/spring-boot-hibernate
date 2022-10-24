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

  echo "the PWD is : ${PWD}"

  # Display unstaged files
  echo ".........Calling terraform init .......\n"
  terraform init

  echo ".........Calling terraform plan .......\n"
  terraform plan
  result_code=$?
  echo "......plan result_code:$result_code"
 
 if [ $result_code -eq 0 ]; then
  echo ".........Calling terraform apply .......\n"
  terraform apply -auto-approve -json > apply_complete1.json
  sed -i '/Acquiring state lock. This may take a few moments.../d' apply_complete1.json
  cat apply_complete1.json | jq 'select(.type == "apply_complete")' > apply_complete.json
  java -cp /home/india/GCP_RnD/spring-boot-hibernate/target/spring-boot-hibernate-0.0.1-SNAPSHOT.jar -Dloader.main=com.wellsfargo.SendMail org.springframework.boot.loader.PropertiesLauncher

  else 
    echo "Terraform plan failed"
    exit 1
   fi
  
 
  result_code=$?
 echo ".....apply result_code:$result_code"
  if [ $result_code -eq 0 ]; then
    echo "No changes, not applying"
  else  
    echo "Terraform plan failed"
    exit 1
   fi 
else
 echo ".........no such repository exists............"
 exit 1
fi


# End of script
