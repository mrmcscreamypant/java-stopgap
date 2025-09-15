#!/bin/bash
javac -d out dev/john/mfja/*.java
java -cp out:lib ./dev/john/mfja/App.java "$@"