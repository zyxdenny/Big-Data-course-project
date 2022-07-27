#!/bin/sh

i=0

while [ $i -lt 2 ]
do
    file=$(cat temp.txt | python3 mapper.py | python3 reducer.py)
    printf %s "$file" > temp.txt
    i=`expr $i + 1`
done