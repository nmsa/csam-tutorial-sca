#!/bin/bash


docker run --name java-container                \
        -v  "$PWD/wsvd-bench":/wsvd-bench       \
        -v  "$PWD/bookstore":/bookstore         \
        -v  "$PWD/webgoat":/webgoat             \
        --rm -it --entrypoint bash java-container

