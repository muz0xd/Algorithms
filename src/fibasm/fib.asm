%include "asm_io.inc"
;
; initialized data is put in the .data segment
;
segment .data
;
; These labels refer to strings used for output
;
prompt db    "Enter fib position: ", 0
outmsg db    "Fib value: ", 0

;
; uninitialized data is put in the .bss segment
;
segment .bss
;
; These labels refer to double words used to store the inputs
;
input  resd 1 
result resd 1
;
; code is put in the .text segment
;
segment .text
        global  _asm_main
_asm_main:
    enter   0,0
    pusha

    mov     eax, prompt
    call    print_string

    call    read_int         
    mov     [input], eax


    push dword [input]
    call _fibb
    mov [result], eax
    add esp, 4

    mov     eax, outmsg
    call    print_string
    mov     eax, [result]     
    call    print_int
    call    print_nl

    popa
    mov     eax, 0
    leave                     
    ret

_fibb:
    enter 4,0
    mov eax, [ebp+8]
    cmp eax, 0
    je term1_cond
    cmp eax, 1
    je term2_cond
    dec eax
    push eax
    call _fibb
    add esp, 4
    mov dword [ebp-4], eax
	
    mov eax, [ebp+8]
    dec eax
    dec eax
    push eax
    call _fibb  
    add esp, 4
	
    add eax, dword [ebp-4]
	
    jmp short end_fibb
term1_cond:
    mov eax, 0
    jmp end_fibb
term2_cond:
    mov eax, 1
    jmp end_fibb
end_fibb:
    leave
    ret
    