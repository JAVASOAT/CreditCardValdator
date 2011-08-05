#! /bin/bash
for FILENAME in $(find . -name "*.java")
do
touch tmp.txt
cat header.txt > tmp.txt
cat $FILENAME >> tmp.txt
cat tmp.txt > $FILENAME
rm tmp.txt
done;
