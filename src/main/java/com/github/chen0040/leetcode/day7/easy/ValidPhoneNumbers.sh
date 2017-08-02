#!/usr/bin/env bash
# link: https://leetcode.com/problems/valid-phone-numbers/description/
# Read from the file file.txt and output all valid phone numbers to stdout.
grep -P "^(\d{3}-|\(\d{3}\) )\d{3}-\d{4}$" file.txt
