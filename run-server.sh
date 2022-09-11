#!/usr/bin/env bash
cd build/libs/ || exit

JAR=$(find . -name "*.jar")
java -jar "$JAR"
