#!/usr/bin/env bash
# Script for provisioning a new ubuntu server to run this application


function executable_already_exists {
  executable_name=$1
  which $executable_name > /dev/null 2>&1
}

# Install some useful utilities
sudo yum -y install vim-X11 vim-common vim-enhanced vim-minimal
sudo yum -y install git
sudo yum -y install wget
sudo yum -y install zip unzip


# Install java
# http://www.webupd8.org/2012/09/install-oracle-java-8-in-ubuntu-via-ppa.html
# Note: you need to install python-software-properties to install the add-apt-repository plugin

if ! executable_already_exists java ; then
  cd /opt
  sudo wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" \
  "http://download.oracle.com/otn-pub/java/jdk/8u25-b17/jdk-8u25-linux-x64.tar.gz"
  sudo tar xvf jdk-8u25-linux-x64.tar.gz
  sudo chown -R root: jdk1.8.0_25
  sudo alternatives --install /usr/bin/java java /opt/jdk1.8.0_25/bin/java 1
  sudo alternatives --install /usr/bin/javac javac /opt/jdk1.8.0_25/bin/javac 1
  sudo alternatives --install /usr/bin/jar jar /opt/jdk1.8.0_25/bin/jar 1
  sudo rm /opt/jdk-8u25-linux-x64.tar.gz
fi

# Install node for the mock server
# https://github.com/nodejs/node-v0.x-archive/wiki/Installing-Node.js-via-package-manager

if ! executable_already_exists node ; then
  curl --silent --location https://rpm.nodesource.com/setup | bash -
  yum -y install nodejs
  yum -y install gcc-c++ make
fi