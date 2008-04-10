#!/bin/bash

CURRENTDIR=`pwd`
cd checkout/kev
svn up --user tomcat5 --password edcvgz
rm -rf buildDirectory
mkdir buildDirectory
mkdir buildDirectory/features
mkdir buildDirectory/plugins
  
mv *.feature buildDirectory/features/
cp -R * buildDirectory/plugins/
cp -R buildDirectory/*.feature ./

cd $CURRENTDIR
