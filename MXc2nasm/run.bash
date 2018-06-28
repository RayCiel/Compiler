
#!/bin/sh


./c2nasm.sh zz.c
nasm -felf64 zz.asm
gcc zz.o -no-pie
./a.out
