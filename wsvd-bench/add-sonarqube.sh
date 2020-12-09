#!/bin/bash
# 
# CSAM PL11 - Practical Tutorial on Static Code Analysis
# 
# Authors: Nuno Antunes <nmsa@dei.uc.pt>, José Pereira <josep@dei.uc.pt>
# 

mvn package sonar:sonar \
  -Dsonar.projectKey=WSVDBench-YOUR_NUMBER  \
  -Dsonar.host.url=http://10.3.2.190:8080   \
  -Dsonar.login=[place key here] 




