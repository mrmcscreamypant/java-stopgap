#!/bin/bash
javac -cp .:lib/* -d out dev/john/mfja/*.java
java -cp out:lib/* ./dev/john/mfja/App.java "$@"