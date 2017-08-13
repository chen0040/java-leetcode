#!/usr/bin/env bash
# link: https://leetcode.com/problems/tenth-line/description/
# Read from the file file.txt and output the tenth line to stdout.
awk "NR == 10" file.txt
