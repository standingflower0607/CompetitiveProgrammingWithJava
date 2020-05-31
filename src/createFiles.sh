#!/bin/bash


alphabetA=(A B C D)
alphabetB=(A B C D E F)


for((i=169; i<=180; i++))
do
  if [ $i -ge 100 ]
  then
    dirName="ABC${i}"
  else
    dirName="ABC0${i}"
  fi
  echo $dirName
  mkdir $dirName

  if [ $i -ge 126 ]
  then
     # shellcheck disable=SC2068
     for alphabet in ${alphabetB[@]}
     do
       mkdir $dirName/$alphabet
       touch $dirName/$alphabet/Main.java
       # shellcheck disable=SC1072
       # shellcheck disable=SC1072
       echo "package ${dirName}.${alphabet};" >> $dirName/$alphabet/Main.java
       cat   OriginalLibrary/Main.txt >> $dirName/$alphabet/Main.java
     done
  else
     # shellcheck disable=SC2068
     for alphabet in ${alphabetA[@]}
     do
       mkdir $dirName/$alphabet
       touch $dirName/$alphabet/Main.java
       # shellcheck disable=SC1072
       # shellcheck disable=SC1072
       echo "package ${dirName}.${alphabet};" >> $dirName/$alphabet/Main.java
       cat   OriginalLibrary/Main.txt >> $dirName/$alphabet/Main.java
     done
  fi

done


