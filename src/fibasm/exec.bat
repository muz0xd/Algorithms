@echo off
set PATH=g:\Development\Asm_Labs\_Soft\mingw64\bin\;g:\Development\Asm_Labs\_Soft\masm32\bin\;g:\Development\Asm_Labs\_Soft\NASM\;%PATH%

nasm -fwin32 fib.asm
nasm -fwin32 asm_io.asm
gcc -m32 -c driver.c -o driver.obj
gcc -m32 -o fib fib.obj asm_io.obj driver.obj

cmd