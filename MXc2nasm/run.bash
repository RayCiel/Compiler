
#!/bin/sh


./c2nasm.sh zz.c
nasm -felf64 output.asm
gcc output.o -no-pie
./a.out
