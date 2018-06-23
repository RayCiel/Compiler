





default rel

global main


SECTION .text   

main:
        push    rbp
        mov     rbp, rsp
        mov     dword [rbp-4H], 0
        add     dword [rbp-4H], 1
        mov     eax, 0
        pop     rbp
        ret



SECTION .data   


SECTION .bss    


