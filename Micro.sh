#!/bin/bash
java org.antlr.v4.Tool Grammar.g4
javac *.java
java Driver < $1
