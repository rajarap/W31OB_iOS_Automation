#!/bin/bash
ios-deploy --debug --bundle /Users/prabhu/Documents/ipa/SBC\ Test-2.ipa
sleep 10
mvn clean test -PiOS
