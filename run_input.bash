
#!/bin/sh
cd "$(dirname "$0")"
echo "===============Compiling================"
bash __codegen.bash
echo "===============Linking================"
cd ./testcase
nasm -felf64 program.asm
gcc program.o -no-pie 
echo "===============Runing================"
./a.out < program.in
