#!/bin/bash

touch ../changed_files.lst

detect_changes() {
   git diff --diff-filter=d --name-only $1 $2 > ../changed_files.lst
}

detect_changes $1 $2

# Derive Module Name

derive_module_name() {
val=$(sed 's!/.*!!' ../changed_files.lst | uniq)
echo $val > ../changed_files.lst
}

derive_module_name