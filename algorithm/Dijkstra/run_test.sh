#!/bin/bash

# current path of run_test.sh
CURRENT_PATH=$(cd $(dirname $0) && pwd)

JUNIT_LIB_PATH=$CURRENT_PATH/../../libs/java/junit-4.12.jar:$CURRENT_PATH/../../libs/java/hamcrest-core-1.3.jar

BUILD_PATH=$CURRENT_PATH/build
SOURCE_PATH=$CURRENT_PATH/src

# source list in file for javac to compile
SOURCE_LIST_PATH=$BUILD_PATH/src.lst

# all of *.class file destination
BUILD_CLASS_PATH=$BUILD_PATH/classes

rm -f $SOURCE_LIST_PATH
rm -rf $BUILD_CLASS_PATH
mkdir $BUILD_CLASS_PATH

# generate the list of all *.java files to compile in $SOURCE_LIST_PATH
find $SOURCE_PATH -name \*.java > $SOURCE_LIST_PATH

javac \
  -d $BUILD_CLASS_PATH \
  -sourcepath src \
  -classpath $JUNIT_LIB_PATH \
  @$SOURCE_LIST_PATH

java \
  -classpath $BUILD_CLASS_PATH:$JUNIT_LIB_PATH \
  org.junit.runner.JUnitCore \
  tests.AllTests
