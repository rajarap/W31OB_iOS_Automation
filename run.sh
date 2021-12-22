#!/bin/bash
ios-deploy --debug --bundle /Users/prabhu/Documents/ipa/SBC\ Test.ipa
sleep 5
mvn clean test -PiOS
