#!/bin/bash

CURRENTDIR=`pwd`
cd checkout/kev
svn up
mkdir buildDirectory
mkdir buildDirectory/features
mkdir buildDirectory/plugins
cp -R *.feature buildDirectory/features/

cd $CURRENTDIR
