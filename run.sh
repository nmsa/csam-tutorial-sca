#!/bin/bash
# 
# CSAM PL11 - Practical Tutorial on Static Code Analysis
# 
# Authors: Nuno Antunes <nmsa@dei.uc.pt>, José Pereira <josep@dei.uc.pt>
# 

docker run --name java-container                \
        -v  "$PWD/wsvd-bench":/wsvd-bench       \
        -v  "$PWD/bookstore":/bookstore         \
        -v  "$PWD/webgoat":/webgoat             \
        --rm -it --entrypoint bash java-container

