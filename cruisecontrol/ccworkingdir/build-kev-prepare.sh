#!/bin/bash

CURRENTDIR=`pwd`
cd checkout/kev
echo "updating from SVN..."
svn up --username tomcat5 --password edcvgz

echo "cleaning old build..."
rm -rf buildDirectory
mkdir buildDirectory
mkdir buildDirectory/features
mkdir buildDirectory/plugins

echo "creating building dir structure..."
mv *.feature buildDirectory/features/
cp -R * buildDirectory/plugins/
cp -R buildDirectory/*.feature ./

echo "running PDE build..."

cd $CURRENTDIR
