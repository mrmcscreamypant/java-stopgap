#!/bin/bash
javac -d out dev/john/mfja/*.java
java -cp out ./dev/john/mfja/App.java