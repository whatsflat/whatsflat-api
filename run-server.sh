#!/usr/bin/env bash
cd build/libs/ || exit

JAR=$(find . -name "*.jar")
screen -AdmS whatsflat-server java -jar "$JAR"
