
#!/bin/sh
cd "$(dirname "$0")"
cd ./testcase
nasm -felf64 program.asm
gcc program.o -no-pie 
echo "===============Runing================"
./a.out
echo exitcode$?
